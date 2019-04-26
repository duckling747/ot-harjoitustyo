package rpgame.creatures;

public abstract class Actor {

    private final String name;
    private final String type;

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

    /**
     * The class is an abstract representation of an acting entity during battles 
     * in the game with different attributes that influence what he can do
     * @param name
     * @param type
     * @param maxhealth
     * @param maxmana
     * @param strength
     * @param defense
     * @param agility
     * @param wisdom
     * @param intelligence
     * @param luck 
     */
    Actor(String name, String type, double maxhealth, double maxmana, double strength,
            double defense, double agility, double wisdom,
            double intelligence, double luck) {
        this.name = name;
        this.type = type;
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
    }

    /**
     * Provides health loss functionality
     * @param amount Amount of health lost
     */
    public void loseHealth(double amount) {
        if (currHealth - amount < 0) {
            currHealth = 0;
        } else {
            currHealth -= amount;
        }
    }

    /**
     * Provides health gain functionality
     * @param amount Amount of health gained
     */
    public void gainHealth(double amount) {
        if (currHealth + amount > maxhealth) {
            currHealth = maxhealth;
        } else {
            currHealth += amount;
        }
    }

    /**
     * Provides mana loss functionality
     * @param amount Amount of mana lost
     */
    public void loseMana(double amount) {
        if (currMana - amount < 0) {
            currMana = 0;
        } else {
            currMana -= amount;
        }
    }

    /**
     * Provides mana gain functionality
     * @param amount Amount of mana gained
     */
    public void gainMana(double amount) {
        if (currMana + amount > maxmana) {
            currMana = maxmana;
        } else {
            currMana += amount;
        }
    }

    /**
     * Check to see if this actor is dead
     * @return boolean value of whether actor has 0 health
     */
    public boolean dies() {
        return currHealth == 0;
    }

    /**
     * Provides attack functionality 
     * @param criticalRand A double value between 0.0 and 1.0 (inclusive) that together with luck influences a chance to perform a critical hit with an attack
     * @return Amount of damage the attack does
     */
    public double attack(double criticalRand) {
        double amount = this.strength * 10;
        if (this.luck > criticalRand) {
            amount *= 2;
        }
        return amount;
    }

    /**
     * Provides defend functionality
     */
    public void defend() {
        this.defend = true;
    }

    /**
     * Provides skill usage functionality. Needs to be overridden for each different character type
     */
    public abstract void skill();

    /**
     * Provides fleeing functionality
     * @param fleeRand A double value between 0.0 and 1.0 (inclusive) that influences the chance to succesfully flee
     */
    public void flee(double fleeRand) {
        this.flee = fleeRand < 0.5;
    }

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

    public void setDefend(boolean defend) {
        this.defend = defend;
    }

    public void setFlee(boolean flee) {
        this.flee = flee;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public void setAgility(double agility) {
        this.agility = agility;
    }

    public void setWisdom(double wisdom) {
        this.wisdom = wisdom;
    }

    public void setIntelligence(double intelligence) {
        this.intelligence = intelligence;
    }

    public void setLuck(double luck) {
        this.luck = luck;
    }

}
