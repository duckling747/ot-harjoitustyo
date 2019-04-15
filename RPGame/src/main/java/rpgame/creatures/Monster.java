package rpgame.creatures;

import rpgame.main.Main;
import rpgame.items.Item;
import rpgame.items.ItemRandomGetter;

public class Monster extends Actor {

    private final int level;

    public Monster(int level, String name) {
        // double maxhealth, double maxmana, int strength, int defense, int agility, int wisdom, int intelligence, int luck
        super(name, "monster", 20 + Main.RANDOM_SOURCE.nextInt(level * 3 + 1),
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
    public void skill() {

    }

    public Item dropRandomItem() {
        return ItemRandomGetter.getRandomItem();
    }

}
