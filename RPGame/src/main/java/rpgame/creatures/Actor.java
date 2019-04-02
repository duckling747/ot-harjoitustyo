package rpgame.creatures;

import rpgame.items.Item;
import rpgame.items.ItemBag;

public abstract class Actor {

    private final String name;

    private final double maxhealth;
    private final double maxmana;

    private double currHealth;
    private double currMana;

    private double strength;
    private double defense;
    private double agility;
    private double wisdom;
    private double intelligence;
    private double luck;

    private boolean defend = false;
    private boolean flee = false;

    private final ItemBag itemBag;

    Actor(String name, double maxhealth, double maxmana, double strength,
            double defense, double agility, double wisdom,
            double intelligence, double luck) {
        this.name = name;
        this.maxhealth = maxhealth;
        this.maxmana = maxmana;
        this.currHealth = maxhealth;
        this.currMana = maxmana;
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

    public abstract double attack();

    public abstract void defend();

    public abstract void skill();

    public abstract void useItem(Item item, Actor target);

    public abstract void flee();

    public double getCurrHealth() {
        return currHealth;
    }

    public double getCurrMana() {
        return currMana;
    }

    public double getMaxhealth() {
        return maxhealth;
    }

    public double getMaxmana() {
        return maxmana;
    }

    public double getStrength() {
        return strength;
    }

    public double getDefense() {
        return defense;
    }

    public double getAgility() {
        return agility;
    }

    public double getWisdom() {
        return wisdom;
    }

    public double getIntelligence() {
        return intelligence;
    }

    public double getLuck() {
        return luck;
    }

    public boolean isDefend() {
        return defend;
    }

    public boolean isFlee() {
        return flee;
    }

    public ItemBag getItemBag() {
        return itemBag;
    }

    public void setDefend(boolean defend) {
        this.defend = defend;
    }

    public void setFlee(boolean flee) {
        this.flee = flee;
    }

    public String getName() {
        return name;
    }

}
