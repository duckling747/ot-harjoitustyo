package rpgame.battle;

import rpgame.main.Main;
import rpgame.creatures.Actor;
import rpgame.creatures.Monster;
import rpgame.creatures.PlayerCharacter;
import rpgame.items.Item;

public final class Battle {

    private final PlayerCharacter player;
    private final Monster opponent;

    private boolean playerTurn;
    private String turnout;

    public Battle(PlayerCharacter player, Monster opponent) {
        this.player = player;
        this.opponent = opponent;
        this.playerTurn = Main.RANDOM_SOURCE.nextBoolean();
        this.turnout = "A(n) " + opponent.getName() + " approaches! ";
    }

    public boolean getPlayerTurn() {
        return playerTurn;
    }

    public void attacks(boolean isPlayer) {
        Actor attacker = (isPlayer) ? player : opponent,
                attackee = (isPlayer) ? opponent : player;
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

    public void defends(boolean isPlayer) {
        Actor defender = (isPlayer) ? player : opponent;
        defender.defend();
        turnout = String.format("%s defends.", defender.getName());
    }

    public void flees(boolean isPlayer) {
        Actor fleer = (isPlayer) ? player : opponent;
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
                    attacks(false);
                    break;
                case DEFEND:
                    defends(false);
                    break;
                case FLEE:
                    flees(false);
                    break;
            }
        }
        playerTurn = !playerTurn;
    }

    public String getTurnout() {
        return turnout;
    }

    public String getMonsterName() {
        return opponent.getName();
    }
    
    public double getMonsterManaRatio() {
        return opponent.getCurrMana() / opponent.getMaxmana();
    }
    
    public double getMonsterHealthRatio() {
        return opponent.getCurrHealth() / opponent.getMaxhealth();
    }
    
    public double getPlayerHealthRatio() {
        return player.getCurrHealth() / player.getMaxhealth();
    }
    
    public double getPlayerManaRatio() {
        return player.getCurrMana() / player.getMaxmana();
    }
}
