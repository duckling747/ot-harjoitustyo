package rpgame.items;

import main.Main;
import rpgame.creatures.Actor;

public class Potion extends Item {

    private final String name;
    private final String description;

    public Potion() {
        this.name = "Potion";
        this.description = "Restores Health";
    }

    @Override
    public void function(Actor target) {
        target.gainHealth(100 + Main.RANDOM_SOURCE.nextInt(300));
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
