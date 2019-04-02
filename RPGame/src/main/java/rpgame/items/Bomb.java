package rpgame.items;

import rpgame.creatures.Actor;

public class Bomb extends Item {

    private final String name;
    private final String description;

    public Bomb() {
        this.name = "Bomb";
        this.description = "A bomb that explodes and causes damage";
    }

    @Override
    public String function(Actor target) {
        target.loseHealth(60);
        return "A vicious opponent uses a " + name + " and " + target.getName() + " loses 60 health.";
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
