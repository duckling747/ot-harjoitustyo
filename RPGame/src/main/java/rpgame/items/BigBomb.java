package rpgame.items;

import main.Main;
import rpgame.creatures.Actor;

public class BigBomb extends Item {

    private final String name, description;

    public BigBomb() {
        this.name = "An extremely large bomb";
        this.description = "Explodes horribly and damages things";
    }

    @Override
    public void function(Actor target) {
        target.loseHealth(300 + Main.RANDOM_SOURCE.nextInt(500));
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
