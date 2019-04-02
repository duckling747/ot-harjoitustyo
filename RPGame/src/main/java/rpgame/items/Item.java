package rpgame.items;

import rpgame.creatures.Actor;

public abstract class Item implements Comparable<Item> {

    public abstract String function(Actor target);

    public abstract String getName();

    public abstract String getDescription();

    @Override
    public int compareTo(Item o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + getName() + ", description=" + getDescription() + '}';
    }

}
