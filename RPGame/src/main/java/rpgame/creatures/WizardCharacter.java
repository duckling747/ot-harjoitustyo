package rpgame.creatures;

public final class WizardCharacter extends PlayerCharacter {

    public WizardCharacter(String name) {
        // maxhealth, maxmana, strength, defense, agility, wisdom, intelligence, luck
        super(name, "wizard", 50, 100, 0.0, 0.0, 0.2, 0.5, 0.5, 0.2);
    }

    @Override
    public void skill() {
        // TODO Wizard specific skill implementation
    }

}
