package actorsTests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import rpgame.creatures.Actor;
import rpgame.creatures.WizardCharacter;

public class WizardTest {

    private Actor wizard;

    @Before
    public void setUp() {
        wizard = new WizardCharacter("Clark");
    }

    @Test
    public void wizardGetsName() {
        assertThat(wizard.getName(), equalTo("Clark"));
    }

    @Test
    public void wizardInstanceOfActor() {
        assertThat(wizard, instanceOf(Actor.class));
    }

    @Test
    public void wizardStartingHealth() {
        assertThat(wizard.getCurrHealth(), is(equalTo(wizard.getMaxhealth())));
    }

    @Test
    public void wizardStartingMana() {
        assertThat(wizard.getCurrMana(), is(equalTo(wizard.getMaxmana())));
    }

    @Test
    public void wizardAgilityCorrect() {
        assertTrue(wizard.getAgility() >= 0.0 && wizard.getAgility() <= 1.0);
    }

    @Test
    public void wizardStrengthCorrect() {
        assertTrue(wizard.getStrength() >= 0.0 && wizard.getStrength() <= 1.0);
    }

    @Test
    public void wizardDefenseCorrect() {
        assertTrue(wizard.getDefense() >= 0.0 && wizard.getDefense() <= 1.0);
    }

    @Test
    public void wizardIntelligenceCorrect() {
        assertTrue(wizard.getIntelligence() >= 0.0 && wizard.getIntelligence() <= 1.0);
    }

    @Test
    public void wizardWisdomCorrect() {
        assertTrue(wizard.getWisdom() >= 0.0 && wizard.getWisdom() <= 1.0);
    }

    @Test
    public void wizardLuckCorrect() {
        assertTrue(wizard.getWisdom() >= 0.0 && wizard.getWisdom() <= 1.0);
    }

    @Test
    public void wizardHealthCorrect() {
        assertTrue(wizard.getMaxhealth() >= 0.0 && wizard.getMaxhealth() <= 100.0);
    }

    @Test
    public void wizardManaCorrect() {
        assertTrue(wizard.getMaxmana() >= 0.0 && wizard.getMaxmana() <= 100.0);
    }

    @Test
    public void wizardTakesDamage() {
        double hpBegin = wizard.getCurrHealth();
        double damage = 10.0;
        wizard.loseHealth(damage);
        assertThat(wizard.getCurrHealth(), is(equalTo(hpBegin - damage)));
    }

    @Test
    public void wizardNotDead() {
        assertThat(wizard.dies(), is(false));
    }

    @Test
    public void wizardCanDie() {
        double hpBegin = wizard.getCurrHealth();
        double damage = hpBegin;
        wizard.loseHealth(damage);
        assertThat(wizard.dies(), is(true));
    }

    @Test
    public void wizardHealthNotNegative() {
        double hpBegin = wizard.getCurrHealth();
        double damage = hpBegin + 100;
        wizard.loseHealth(damage);
        assertThat(wizard.getCurrHealth(), is(0.0));
    }

    @Test
    public void wizardAttackDamageCorrect() {
        double atk = wizard.attack(0.5);
        if (wizard.getLuck() > 0.5) {
            assertTrue(atk == wizard.getStrength() * 20);
        } else {
            assertTrue(atk == wizard.getStrength() * 10);
        }
        assertTrue(wizard.attack(1) == wizard.getStrength() * 10
                && wizard.attack(0) == wizard.getStrength() * 20);
    }

    @Test
    public void wizardHealthGain() {
        wizard.loseHealth(30.0);
        assertTrue(wizard.getCurrHealth() == wizard.getMaxhealth() - 30.0);
        wizard.gainHealth(5.0);
        assertTrue(wizard.getCurrHealth() == wizard.getMaxhealth() - 30.0 + 5.0);
        wizard.gainHealth(5.0);
        assertTrue(wizard.getCurrHealth() == wizard.getMaxhealth() - 30.0 + 5.0 + 5.0);
        wizard.gainHealth(0.5);
        assertTrue(wizard.getCurrHealth() == wizard.getMaxhealth() - 30.0 + 5.0 + 5.0 + 0.5);
    }

    @Test
    public void wizardHealthGainNotOverMaximum() {
        wizard.gainHealth(1000);
        assertTrue(wizard.getCurrHealth() == wizard.getMaxhealth());
    }

    @Test
    public void wizardManaGain() {
        double mp = wizard.getMaxmana();
        mp /= 2;
        wizard.loseMana(mp);
        assertTrue(wizard.getCurrMana() == mp);
        wizard.gainMana(1);
        assertTrue(wizard.getCurrMana() == mp + 1);
        wizard.gainMana(1);
        assertTrue(wizard.getCurrMana() == mp + 2);
    }

    @Test
    public void wizardManaGainNotOverMaximum() {
        wizard.gainMana(1000);
        assertTrue(wizard.getCurrMana() == wizard.getMaxmana());
    }

    @Test
    public void manaLossNotUnderMinimum() {
        wizard.loseMana(1000);
        assertTrue(wizard.getCurrMana() == 0);
    }

    @Test
    public void fleeIsCorrect1() {
        assertThat(wizard.isFlee(), is(false));
    }

    @Test
    public void fleeIsCorrect2() {
        wizard.flee(0.5);
        assertThat(wizard.isFlee(), is(false));
    }

    @Test
    public void fleeIsCorrect3() {
        wizard.flee(0.4);
        assertThat(wizard.isFlee(), is(true));
    }

    @Test
    public void fleeIsCorrect4() {
        wizard.flee(1);
        assertThat(wizard.isFlee(), is(false));
    }

    @Test
    public void fleeIsCorrect5() {
        wizard.flee(0);
        assertThat(wizard.isFlee(), is(true));
    }

    @Test
    public void setFleeIsCorrect() {
        assertThat(wizard.isFlee(), is(false));
        wizard.setFlee(true);
        assertThat(wizard.isFlee(), is(true));
        wizard.setFlee(false);
        assertThat(wizard.isFlee(), is(false));
    }

    @Test
    public void defendIsCorrect1() {
        wizard.defend();
        assertThat(wizard.isDefend(), is(true));
    }

    @Test
    public void defendIsCorrect2() {
        wizard.defend();
        wizard.defend();
        assertThat(wizard.isDefend(), is(true));
    }

    @Test
    public void defendIsCorrect3() {
        wizard.setDefend(true);
        assertThat(wizard.isDefend(), is(true));
        wizard.setDefend(false);
        assertThat(wizard.isDefend(), is(false));
        wizard.setDefend(true);
        assertThat(wizard.isDefend(), is(true));
    }
}
