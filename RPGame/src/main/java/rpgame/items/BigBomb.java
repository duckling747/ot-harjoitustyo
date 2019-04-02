package rpgame.items;

import rpgame.creatures.Actor;

public class BigBomb extends Item {

    private final String name, description;

    public BigBomb() {
        this.name = "Big Bomb";
        this.description = "Explodes horribly and damages things";
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
