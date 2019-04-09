package rpgame.creatures;

import rpgame.items.Item;

public final class ThiefCharacter extends Actor implements LevelUp, ItemUser {

    private int level;

    public ThiefCharacter(String name) {
        // maxhealth, maxmana, strength, defense, agility, wisdom, intelligence, luck
        super(name, 75, 75, 0.1, 0.1, 0.5, 0.1, 0.1, 0.5);
        this.level = 1;
    }

    @Override
    public void useItem(Item item, Actor target) {
        item.function(target);
    }

    @Override
    public void skill() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void levelUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
