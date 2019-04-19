package rpgame.creatures;

import rpgame.items.Item;
import rpgame.items.ItemBag;

public abstract class PlayerCharacter extends Actor implements LevelUp, ItemUser {

    private static final double MAX_ATTR = 1.0;
    private static final int MAX_LV = 10;

    private final ItemBag itemBag;

    private int level = 1;
    private int exp = 0;

    public PlayerCharacter(String name, String type, double maxhealth, double maxmana, double strength, double defense, double agility, double wisdom, double intelligence, double luck) {
        super(name, type, maxhealth, maxmana, strength, defense, agility, wisdom, intelligence, luck);
        this.itemBag = new ItemBag();

    }

    public void increaseExp() {
        exp++;
    }

    public int getExp() {
        return exp;
    }

    @Override
    public void levelUp() {
        if (level >= MAX_LV) {
            return;
        }
        level++;
        exp = 0;
        if (getStrength() + 0.1 < MAX_ATTR) {
            setStrength(getStrength() + 0.1);
        }
        if (getDefense() + 0.1 < MAX_ATTR) {
            setDefense(getDefense() + 0.1);
        }
        if (getAgility() + 0.1 < MAX_ATTR) {
            setAgility(getAgility() + 0.1);
        }
        if (getWisdom() + 0.1 < MAX_ATTR) {
            setWisdom(getWisdom() + 0.1);
        }
        if (getIntelligence() + 0.1 < MAX_ATTR) {
            setIntelligence(getIntelligence() + 0.1);
        }
        if (getLuck() + 0.1 < MAX_ATTR) {
            setLuck(getLuck() + 0.1);
        }
    }

    @Override
    public void useItem(Item item, Actor target) {
        //TODO: check if in item bag
        item.function(target);
    }

    public ItemBag getItemBag() {
        return itemBag;
    }

}
