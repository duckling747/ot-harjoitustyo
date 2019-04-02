package rpgame.creatures;

import rpgame.items.Item;

public class ThiefCharacter extends Actor implements LevelUp {

    public ThiefCharacter(String name, double maxhealth, double maxmana, int strength, int defense, int agility, int wisdom, int intelligence, int luck) {
        super(name, maxhealth, maxmana, strength, defense, agility, wisdom, intelligence, luck);
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
