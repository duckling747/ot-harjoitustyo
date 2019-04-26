package rpgame.creatures;

public final class ThiefCharacter extends PlayerCharacter {

    public ThiefCharacter(String name) {
        // maxhealth, maxmana, strength, defense, agility, wisdom, intelligence, luck
        super(name, "thief", 75, 75, 0.1, 0.1, 0.5, 0.1, 0.1, 0.5);
    }

    @Override
    public void skill() {
        // TODO Thief specific skill implementation
    }

}
