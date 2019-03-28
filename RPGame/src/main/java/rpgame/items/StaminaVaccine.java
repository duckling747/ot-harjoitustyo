package rpgame.items;

import rpgame.creatures.Actor;

public class StaminaVaccine extends Item {

    private final String name;
    private final String description;

    public StaminaVaccine(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void function(Actor target) {
        target.gainStamina(30);
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
