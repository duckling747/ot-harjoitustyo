package rpgame.battle;

import rpgame.main.Main;
import rpgame.creatures.Actor;
import rpgame.creatures.Monster;
import rpgame.items.Item;

public class Battle {

    private Actor player;
    private Monster opponent;
    private boolean playerTurn;
    private String turnout;

    public Battle(Actor player, Monster opponent) {
        this.player = player;
        this.opponent = opponent;
        this.playerTurn = Main.RANDOM_SOURCE.nextBoolean();
    }

    public boolean getPlayerTurn() {
        return playerTurn;
    }

    public void attacks(Actor attacker, Actor attackee) {
        double damage = attacker.attack(Main.RANDOM_SOURCE.nextDouble());
        if (attackee.isDefend()) {
            attackee.setDefend(false);
            damage = (1 - attackee.getDefense()) * damage;
        }
        if (Main.RANDOM_SOURCE.nextDouble() < attackee.getAgility()) {
            damage = 0;
        }
        attackee.loseHealth(damage);
        if (damage == 0) {
            turnout = String.format("Dodge! %s dodges beautifully.", attackee.getName());
        } else {
            turnout = String.format("%s deals %.2f damage to %s.", attacker.getName(), damage, attackee.getName());
        }
    }

    public void defends(Actor defender) {
        defender.defend();
        turnout = String.format("%s defends.", defender.getName());
    }

    public void flees(Actor fleer) {
        fleer.flee(Main.RANDOM_SOURCE.nextDouble());
        if (fleer.isFlee()) {
            turnout = String.format("%s flees.", fleer.getName());
        } else {
            turnout = String.format("%s tries to flee but fails miserably.", fleer.getName());
        }
    }

    public void playerUseItem(Item item) {
        turnout = String.format("%s uses a %s.", player.getName(), item.getName());
    }

    /**
     *
     */
    public boolean deathHappens() {
        if (player.dies()) {
            turnout = String.format("%s dies.", player.getName());
            return true;
        }
        if (opponent.dies()) {
            turnout = String.format("%s dies.", opponent.getName());
            return true;
        }
        return false;
    }

    public void opponentTurn() {
        if (!playerTurn) {
            Actions action = AI.selectAction();
            switch (action) {
                case ATTACK:
                    attacks(opponent, player);
                    break;
                case DEFEND:
                    defends(opponent);
                    break;
                case FLEE:
                    flees(opponent);
                    break;
            }
        }
        playerTurn = !playerTurn;
    }

    public String getTurnout() {
        return turnout;
    }
}
