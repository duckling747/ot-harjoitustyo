package rpgame.items;

import rpgame.creatures.Actor;

public class ForestMushroom extends Item {

    private final String name, description;

    public ForestMushroom() {
        this.name = "Magical mushroom";
        this.description = "A mushroom from the magic forest";
    }

    @Override
    public String function(Actor target) {
        target.gainMana(60);
        return target.getName() + " uses a " + name + " and gains 60 mana.";
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
