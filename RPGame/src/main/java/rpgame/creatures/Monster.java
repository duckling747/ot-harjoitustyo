package rpgame.creatures;

import main.Main;
import rpgame.items.Item;
import rpgame.items.ItemRandomGetter;

public class Monster extends Actor {

    private final int level;

    public Monster(int level) {
        // double maxhealth, double maxmana, int strength, int defense, int agility, int wisdom, int intelligence, int luck
        super(300 + Main.RANDOM_SOURCE.nextInt(100 * level + 1),
                300 + Main.RANDOM_SOURCE.nextInt(100 * level + 1),
                5 * level + Main.RANDOM_SOURCE.nextInt(21),
                5 * level + Main.RANDOM_SOURCE.nextInt(21),
                5 * level + Main.RANDOM_SOURCE.nextInt(21),
                5 * level + Main.RANDOM_SOURCE.nextInt(21),
                5 * level + Main.RANDOM_SOURCE.nextInt(21),
                5 * level + Main.RANDOM_SOURCE.nextInt(21));
        this.level = level;
    }

    @Override
    public void attack(Actor target) {
        double amount = this.getStrength();
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
        if (super.getCurrHealth() < super.getMaxhealth() * 0.05) {
            super.flee = true;
        } else if (Main.RANDOM_SOURCE.nextDouble() < 0.75) {
            super.flee = true;
        }
    }

    public Item dropRandomItem() {
        return ItemRandomGetter.getRandomItem();
    }

}
