package rpgame.items;

import rpgame.creatures.Actor;

public class BloodTransfusion extends Item {

    private final String name, description;

    public BloodTransfusion() {
        this.name = "Blood Transfusion";
        this.description = "Gain a lot of health";
    }

    @Override
    public String function(Actor target) {
        target.gainHealth(60);
        return target.getName() + " uses a " + name + " and gains 60 health.";
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDescription() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
