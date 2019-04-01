package rpgame.creatures;

import main.Main;
import rpgame.items.Item;

public class WarriorCharacter extends Actor implements LevelUp {

    private int level;

    public WarriorCharacter() {
        // maxhealth, maxmana, strength, defense, agility, wisdom, intelligence, luck
        super(200, 10, 50, 20, 0, 0, 0, 5);
        this.level = 1;
    }

    @Override
    public void attack(Actor target) {
        double amount = this.getStrength() * 1.5;
        double criticalRand = Main.RANDOM_SOURCE.nextDouble();
        if (super.getLuck() * 0.01 < criticalRand) {
            amount *= 2;
        }
        if (target.defend) {
            target.defend = false;
            target.loseHealth(amount - amount * 0.01 * target.getDefense());
        } else {
            target.loseHealth(amount);
        }
    }

    @Override
    public void defend() {
        super.defend = true;
    }

    @Override
    public void skill() {

    }

    @Override
    public void useItem(Item item, Actor target) {
        item.function(target);
    }

    @Override
    public void flee() {
        if (Main.RANDOM_SOURCE.nextDouble() < 0.75) {
            super.flee = true;
        }
    }

    @Override
    public void levelUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
