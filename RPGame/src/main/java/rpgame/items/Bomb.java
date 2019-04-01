package rpgame.items;

import main.Main;
import rpgame.creatures.Actor;

public class Bomb extends Item {

    private final String name;
    private final String description;

    public Bomb() {
        this.name = "Bomb";
        this.description = "A bomb that explodes and causes damage";
    }

    @Override
    public void function(Actor target) {
        target.loseHealth(100 + Main.RANDOM_SOURCE.nextInt(300));
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
