package rpgame.creatures;

import rpgame.main.Main;
import rpgame.items.Item;
import rpgame.items.ItemRandomGetter;

/**
 * The class provides a way to create the principal opponents of the game: the
 * monsters
 */
public class Monster extends Actor {

    private final int level;

    public Monster(int level, String name) {
        // double maxhealth, double maxmana, int strength, int defense, int agility, int wisdom, int intelligence, int luck
        super(name, "monster", 20 + Main.RANDOM_SOURCE.nextInt(level * 3 + 1),
                20 + Main.RANDOM_SOURCE.nextInt(level * 3 + 1),
                getMonsterAttrBasedOnLevel(level),
                getMonsterAttrBasedOnLevel(level),
                getMonsterAttrBasedOnLevel(level),
                getMonsterAttrBasedOnLevel(level),
                getMonsterAttrBasedOnLevel(level),
                getMonsterAttrBasedOnLevel(level));
        this.level = level;
    }

    /**
     * A simple private utility method for generating the monster's attribute values based on level
     * @param level
     * @return double value for an attribute
     */
    private static double getMonsterAttrBasedOnLevel(int level) {
        return Main.RANDOM_SOURCE.nextInt(10 * level + 1) / 100.0;
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
     *
     * @return A random item
     */
    public Item dropRandomItem() {
        return ItemRandomGetter.getRandomItem();
    }

}
