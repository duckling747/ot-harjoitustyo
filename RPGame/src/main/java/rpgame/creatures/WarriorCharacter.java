package rpgame.creatures;

import rpgame.items.Item;

public final class WarriorCharacter extends Actor implements LevelUp, ItemUser {

    private int level;

    public WarriorCharacter(String name) {
        // maxhealth, maxmana, strength, defense, agility, wisdom, intelligence, luck
        super(name, 100, 50, 0.5, 0.5, 0.2, 0.0, 0.0, 0.2);
        this.level = 1;
    }

    @Override
    public void skill() {

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
