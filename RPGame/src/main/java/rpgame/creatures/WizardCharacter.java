package rpgame.creatures;

import rpgame.items.Item;

public final class WizardCharacter extends Actor implements LevelUp, ItemUser {

    private int level;

    public WizardCharacter(String name) {
        // maxhealth, maxmana, strength, defense, agility, wisdom, intelligence, luck
        super(name, 50, 100, 0.0, 0.0, 0.2, 0.5, 0.5, 0.2);
        this.level = 1;
    }

    @Override
    public void skill() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void levelUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void useItem(Item item, Actor target) {
        item.function(target);
    }

}
