package rpgame.items;

import rpgame.creatures.Actor;

public class Potion extends Item {

    private final String name;
    private final String description;

    public Potion() {
        this.name = "Potion";
        this.description = "Restores Health";
    }

    @Override
    public String function(Actor target) {
        target.gainHealth(30);
        return target.getName() + " uses a " + name + " and gains 30 health.";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
