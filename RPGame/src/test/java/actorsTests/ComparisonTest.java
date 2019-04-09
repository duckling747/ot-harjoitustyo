package actorsTests;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import rpgame.creatures.Actor;
import rpgame.creatures.ThiefCharacter;
import rpgame.creatures.WarriorCharacter;
import rpgame.creatures.WizardCharacter;

public class ComparisonTest {

    private Actor warrior;
    private Actor wizard;
    private Actor thief;

    @Before
    public void setUp() {
        warrior = new WarriorCharacter("Maxwell");
        wizard = new WizardCharacter("Barbara");
        thief = new ThiefCharacter("Alice");
    }

    @Test
    public void newWarriorHasMostStrength() {
        assertTrue(warrior.getStrength() > wizard.getStrength()
                && warrior.getStrength() > thief.getStrength());
    }

    @Test
    public void newWarriorHasMostDefense() {
        assertTrue(warrior.getDefense() > wizard.getDefense()
                && warrior.getDefense() > thief.getDefense());
    }

    @Test
    public void newThiefHasMostAgility() {
        assertTrue(thief.getAgility() > wizard.getAgility()
                && thief.getAgility() > warrior.getAgility());

    }

    @Test
    public void newThiefHasMostLuck() {
        assertTrue(thief.getLuck() > wizard.getLuck()
                && thief.getLuck() > warrior.getLuck());
    }

    @Test
    public void newWizardHasMostIntelligence() {
        assertTrue(wizard.getIntelligence() > warrior.getIntelligence()
                && wizard.getIntelligence() > thief.getIntelligence());
    }

    @Test
    public void newWizardHasMostWisdom() {
        assertTrue(wizard.getWisdom() > warrior.getWisdom()
                && wizard.getWisdom() > thief.getWisdom());
    }

    @Test
    public void newWarriorHasLeastIntelligence() {
        assertTrue(warrior.getIntelligence() < thief.getIntelligence()
                && warrior.getIntelligence() < wizard.getIntelligence());
    }

    @Test
    public void newWarriorHasLeastWisdom() {
        assertTrue(warrior.getWisdom() < thief.getWisdom()
                && warrior.getWisdom() < wizard.getWisdom());
    }

    @Test
    public void newWizardHasLeastStrength() {
        assertTrue(wizard.getStrength() < warrior.getStrength()
                && wizard.getStrength() < thief.getStrength());
    }

    @Test
    public void newWizardHasLeastDefense() {
        assertTrue(wizard.getDefense() < warrior.getDefense()
                && wizard.getDefense() < thief.getDefense());
    }

    @Test
    public void warriorHasMostHealth() {
        assertTrue(warrior.getMaxhealth() > thief.getMaxhealth()
                && warrior.getMaxhealth() > wizard.getMaxhealth());
    }

    @Test
    public void wizardHasMostMana() {
        assertTrue(wizard.getMaxmana() > warrior.getMaxmana()
                && wizard.getMaxmana() > thief.getMaxmana());
    }

    @Test
    public void thiefHasMidHealth() {
        assertTrue(thief.getMaxhealth() > wizard.getMaxhealth()
                && thief.getMaxhealth() < warrior.getMaxhealth());
    }

    @Test
    public void thiefHasMidMana() {
        assertTrue(thief.getMaxmana() < wizard.getMaxmana()
                && thief.getMaxmana() > warrior.getMaxmana());
    }

}
