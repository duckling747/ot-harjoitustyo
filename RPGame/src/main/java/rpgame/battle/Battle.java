package rpgame.battle;

import rpgame.main.Main;
import rpgame.creatures.Actor;
import rpgame.creatures.Monster;
import rpgame.creatures.PlayerCharacter;
import rpgame.items.Item;


/**
 * The class describes a battle and it's events as they play out
 * 
 */
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
        this.player.gainHealth(player.getMaxhealth());
        this.player.gainMana(player.getMaxmana());
        this.player.setFlee(false);
        this.player.setDefend(false);
    }

    public boolean getPlayerTurn() {
        return playerTurn;
    }

    /**
     * The method implements an attack functionality to a battle
     * @param isPlayer Whether it is the player's turn
     */
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

    /**
     * The method implements a defend functionality to a battle; what happens when an actor defends
     * @param isPlayer Whether it is the player's turn
     */
    public void defends(boolean isPlayer) {
        Actor defender = (isPlayer) ? player : opponent;
        defender.defend();
        turnout = String.format("%s defends.", defender.getName());
    }

    /**
     * The method implements a fleeing functionality; what happens when an actor decides to try to flee
     * @param isPlayer Whether it is the players turn
     */
    public void flees(boolean isPlayer) {
        Actor fleer = (isPlayer) ? player : opponent;
        fleer.flee(Main.RANDOM_SOURCE.nextDouble());
        if (fleer.isFlee()) {
            turnout = String.format("%s flees.", fleer.getName());
        } else {
            turnout = String.format("%s tries to flee but fails miserably.", fleer.getName());
        }
    }

    /**
     * Implements an item usage situation in a battle
     * @param item Item to be used
     */
    public void playerUseItem(Item item) {
        turnout = String.format("%s uses a %s.", player.getName(), item.getName());
    }

    /**
     * Implements a skill usage situation in a battle
     * @param isPlayer Whether it is the players turn
     */
    public void usesSkill(boolean isPlayer) {
        Actor skillUser = (isPlayer) ? player : opponent;
        skillUser.skill();
        turnout = String.format("%s uses a skill.", skillUser.getName());
    }

    /**
     * Checks whether battle can end during the current turn
     * @return If the battle ends or not
     */
    public boolean endBattle() {
        if (player.dies()) {
            turnout = String.format("%s dies.", player.getName());
            return true;
        }
        if (opponent.dies()) {
            turnout = String.format("%s dies.", opponent.getName());
            return true;
        }
        if (player.isFlee()) {
            turnout = String.format("%s flees.", player.getName());
            return true;
        }
        if (opponent.isFlee()) {
            turnout = String.format("%s flees.", opponent.getName());
            return true;
        }
        return false;
    }

    /**
     * Implements the opponents action during a turn in battle
     * @see rpgame.battle.AI#selectAction() 
     */
    public void opponentTurn() {
        if (playerTurn) {
            return;
        }
        Actions action = AI.selectAction();
        switch (action) {
            case ATTACK:
                attacks(false);
                break;
            case SKILL:
                usesSkill(false);
                break;
            case DEFEND:
                defends(false);
                break;
            case FLEE:
                flees(false);
                break;
        }
    }

    /**
     * Changes the turn
     */
    public void changeTurn() {
        if (playerTurn) {
            opponent.setDefend(false);
            opponent.setFlee(false);
        } else {
            player.setDefend(false);
            player.setFlee(false);
        }
        playerTurn = !playerTurn;
    }

    /**
     * Returns a String representation of whatever happened during the last turn
     * @return A String representation of the turnout
     */
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
