package rpgame.creatures;

import rpgame.items.Item;
import rpgame.items.ItemBag;

public abstract class Actor {

    private static final int MAXIMUM_ATTR = 10;

    private int currHealth;
    private int currMana;
    private int currStamina;

    private int maxhealth;
    private int maxmana;
    private int maxstamina;

    private int strength;
    private int defense;
    private int agility;
    private int wisdom;
    private int intelligence;
    private int luck;

    private final ItemBag itemBag;

    Actor(int maxhealth, int maxmana, int maxstamina,
            int strength, int defense, int agility,
            int wisdom, int intelligence, int luck) {
        this.maxhealth = maxhealth;
        this.maxmana = maxmana;
        this.maxstamina = maxstamina;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.wisdom = wisdom;
        this.intelligence = intelligence;
        this.luck = luck;
        this.itemBag = new ItemBag();
    }

    public void loseHealth(int amount) {
        if (currHealth - amount < 0) {
            currHealth = 0;
        } else {
            currHealth -= amount;
        }
    }

    public void gainHealth(int amount) {
        if (currHealth + amount > maxhealth) {
            currHealth = maxhealth;
        } else {
            currHealth += amount;
        }
    }

    public void loseMana(int amount) {
        if (currMana - amount < 0) {
            currMana = 0;
        } else {
            currMana -= amount;
        }
    }

    public void gainMana(int amount) {
        if (currMana + amount > maxmana) {
            currMana = maxmana;
        } else {
            currMana += amount;
        }
    }

    public void loseStamina(int amount) {
        if (currStamina - amount < 0) {
            currStamina = 0;
        } else {
            currStamina -= amount;
        }
    }

    public void gainStamina(int amount) {
        if (currStamina + amount > maxstamina) {
            currStamina = maxstamina;
        } else {
            currStamina += amount;
        }
    }

    public boolean dies() {
        return currHealth == 0;
    }

    public abstract void attack(Actor target);

    public abstract void defend();

    public abstract void skill();

    public abstract void useItem(Item item);

    public abstract void flee();

}
