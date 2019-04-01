package rpgame.items;

import main.Main;
import rpgame.creatures.Actor;

public class BloodTransfusion extends Item {
    
    private final String name, description;

    public BloodTransfusion() {
        this.name = "Blood transfusion";
        this.description = "Gain a lot of health";
    }

    @Override
    public void function(Actor target) {
        target.gainHealth(300 + Main.RANDOM_SOURCE.nextInt(500));
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
