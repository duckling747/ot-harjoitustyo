package rpgame.creatures;

import rpgame.items.Item;

public class WizardCharacter extends Actor implements LevelUp {

    private int level;

    public WizardCharacter(String name) {
        // maxhealth, maxmana, strength, defense, agility, wisdom, intelligence, luck
        super(name, 50, 100, 0.2, 0.2, 0.3, 0.5, 0.5, 0.05);
        this.level = 1;
    }

    @Override
    public double attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void defend() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void skill() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void useItem(Item item, Actor target) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void flee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void levelUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
