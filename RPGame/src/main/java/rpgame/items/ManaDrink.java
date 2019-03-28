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
    public void function(Actor target) {
        target.gainMana(30);
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
