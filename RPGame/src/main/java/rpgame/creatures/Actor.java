package rpgame.creatures;

import rpgame.items.Item;
import rpgame.items.ItemBag;

public abstract class Actor {

    private double currHealth;
    private double currMana;

    private double maxhealth;
    private double maxmana;

    private int strength;
    private int defense;
    private int agility;
    private int wisdom;
    private int intelligence;
    private int luck;

    protected boolean defend = false;
    protected boolean flee = false;

    private final ItemBag itemBag;

    Actor(double maxhealth, double maxmana, int strength,
            int defense, int agility, int wisdom,
            int intelligence, int luck) {
        this.maxhealth = maxhealth;
        this.maxmana = maxmana;
        this.strength = strength;
        this.defense = defense;
        this.agility = agility;
        this.wisdom = wisdom;
        this.intelligence = intelligence;
        this.luck = luck;
        this.itemBag = new ItemBag();
    }

    public void loseHealth(double amount) {
        if (currHealth - amount < 0) {
            currHealth = 0;
        } else {
            currHealth -= amount;
        }
    }

    public void gainHealth(double amount) {
        if (currHealth + amount > maxhealth) {
            currHealth = maxhealth;
        } else {
            currHealth += amount;
        }
    }

    public void loseMana(double amount) {
        if (currMana - amount < 0) {
            currMana = 0;
        } else {
            currMana -= amount;
        }
    }

    public void gainMana(double amount) {
        if (currMana + amount > maxmana) {
            currMana = maxmana;
        } else {
            currMana += amount;
        }
    }

    public boolean dies() {
        return currHealth == 0;
    }

    public abstract void attack(Actor target);

    public abstract void defend();

    public abstract void skill();

    public abstract void useItem(Item item, Actor target);

    public abstract void flee();

    public double getCurrHealth() {
        return currHealth;
    }

    public void setCurrHealth(double currHealth) {
        this.currHealth = currHealth;
    }

    public double getCurrMana() {
        return currMana;
    }

    public void setCurrMana(double currMana) {
        this.currMana = currMana;
    }

    public double getMaxhealth() {
        return maxhealth;
    }

    public void setMaxhealth(double maxhealth) {
        this.maxhealth = maxhealth;
    }

    public double getMaxmana() {
        return maxmana;
    }

    public void setMaxmana(double maxmana) {
        this.maxmana = maxmana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public boolean isDefend() {
        return defend;
    }

    public void setDefend(boolean defend) {
        this.defend = defend;
    }

}
