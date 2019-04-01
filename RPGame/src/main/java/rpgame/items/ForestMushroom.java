package rpgame.items;

import main.Main;
import rpgame.creatures.Actor;

public class ForestMushroom extends Item {

    private final String name, description;

    public ForestMushroom() {
        this.name = "Magical mushroom";
        this.description = "A mushroom from the magic forest";
    }

    @Override
    public void function(Actor target) {
        target.gainMana(300 + Main.RANDOM_SOURCE.nextInt(900));
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
