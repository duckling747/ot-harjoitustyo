package rpgame.items;

import rpgame.creatures.Actor;

public class ManaDrink extends Item {

    private final String name;
    private final String description;

    public ManaDrink() {
        this.name = "Mana Drink";
        this.description = "Restores Mana";
    }

    @Override
    public String function(Actor target) {
        target.gainMana(30);
        return target.getName() + " uses a " + name + " and gains 30 mana.";
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
