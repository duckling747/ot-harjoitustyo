package rpgame.creatures;

import rpgame.main.Main;
import rpgame.items.Item;
import rpgame.items.ItemRandomGetter;

/**
 * The class provides a way to create the principal opponents of the game: the monsters
 */
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

    /**
     * Provides skill usage functionality
     */
    @Override
    public void skill() {
        // TODO Create a Skill class and different skills to be used by monsters
    }

    /**
     * Method implements a random item drop functionality for monsters
     * @return A random item
     */
    public Item dropRandomItem() {
        return ItemRandomGetter.getRandomItem();
    }

}
