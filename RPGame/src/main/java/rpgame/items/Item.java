package rpgame.items;

import rpgame.creatures.Actor;

/**
 * Abstract Item class for shared functionality between different items
 */
public abstract class Item implements Comparable<Item> {

    public abstract String function(Actor target);

    public abstract String getName();

    public abstract String getDescription();

    @Override
    public int compareTo(Item o) {
        return this.getName().compareTo(o.getName());
    }

}
