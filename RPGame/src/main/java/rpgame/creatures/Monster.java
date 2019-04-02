package rpgame.creatures;

import rpgame.main.Main;
import rpgame.items.Item;
import rpgame.items.ItemRandomGetter;

public class Monster extends Actor {

    private final int level;

    public Monster(int level, String name) {
        // double maxhealth, double maxmana, int strength, int defense, int agility, int wisdom, int intelligence, int luck
        super(name, 20 + Main.RANDOM_SOURCE.nextInt(level * 3 + 1),
                20 + Main.RANDOM_SOURCE.nextInt(level * 3 + 1),
                Main.RANDOM_SOURCE.nextInt(10 * level + 1) / 100.0,
                Main.RANDOM_SOURCE.nextInt(10 * level + 1) / 100.0,
                Main.RANDOM_SOURCE.nextInt(10 * level + 1) / 100.0,
                Main.RANDOM_SOURCE.nextInt(10 * level + 1) / 100.0,
                Main.RANDOM_SOURCE.nextInt(10 * level + 1) / 100.0,
                Main.RANDOM_SOURCE.nextInt(10 * level + 1) / 100.0);
        this.level = level;
    }

    @Override
    public double attack() {
        double amount = this.getStrength();
        double criticalRand = Main.RANDOM_SOURCE.nextDouble();
        if (super.getLuck() * 0.01 < criticalRand) {
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
        if (super.getCurrHealth() < super.getMaxhealth() * 0.05 || Main.RANDOM_SOURCE.nextDouble() < 0.75) {
            super.setFlee(true);
        }
    }

    public Item dropRandomItem() {
        return ItemRandomGetter.getRandomItem();
    }

}
