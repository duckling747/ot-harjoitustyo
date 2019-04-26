package rpgame.creatures;

public final class WarriorCharacter extends PlayerCharacter {

    public WarriorCharacter(String name) {
        // maxhealth, maxmana, strength, defense, agility, wisdom, intelligence, luck
        super(name, "warrior", 100, 50, 0.5, 0.5, 0.2, 0.0, 0.0, 0.2);
    }

    @Override
    public void skill() {
        // TODO Warrior specific skill implementation
    }

}
