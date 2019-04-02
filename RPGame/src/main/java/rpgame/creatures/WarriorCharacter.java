package rpgame.creatures;

import rpgame.main.Main;
import rpgame.items.Item;

public class WarriorCharacter extends Actor implements LevelUp {

    private int level;

    public WarriorCharacter(String name) {
        // maxhealth, maxmana, strength, defense, agility, wisdom, intelligence, luck
        super(name, 100, 50, 0.5, 0.2, 0, 0, 0, 0.05);
        this.level = 1;
    }

    @Override
    public double attack() {
        double amount = this.getStrength() * 10;
        double criticalRand = Main.RANDOM_SOURCE.nextDouble();
        if (super.getLuck() > criticalRand) {
            amount *= 2;
        }
        return amount;
    }

    @Override
    public void defend() {
        super.setDefend(true);
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
            super.setFlee(true);
        }
    }

    @Override
    public void levelUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
