package actorsTests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import rpgame.battle.Actions;
import rpgame.creatures.Actor;
import rpgame.creatures.ThiefCharacter;

public class ThiefTest {

    private Actor thief;

    @Before
    public void setUp() {
        thief = new ThiefCharacter("Jonathan");
    }

    @Test
    public void thiefGetsName() {
        assertThat(thief.getName(), equalTo("Jonathan"));
    }

    @Test
    public void thiefInstanceOfActor() {
        assertThat(thief, instanceOf(Actor.class));
    }

    @Test
    public void thiefStartingHealth() {
        assertThat(thief.getCurrHealth(), is(equalTo(thief.getMaxhealth())));
    }

    @Test
    public void thiefStartingMana() {
        assertThat(thief.getCurrMana(), is(equalTo(thief.getMaxmana())));
    }

    @Test
    public void thiefAgilityCorrect() {
        assertTrue(thief.getAgility() >= 0.0 && thief.getAgility() <= 1.0);
    }

    @Test
    public void thiefStrengthCorrect() {
        assertTrue(thief.getStrength() >= 0.0 && thief.getStrength() <= 1.0);
    }

    @Test
    public void thiefDefenseCorrect() {
        assertTrue(thief.getDefense() >= 0.0 && thief.getDefense() <= 1.0);
    }

    @Test
    public void thiefIntelligenceCorrect() {
        assertTrue(thief.getIntelligence() >= 0.0 && thief.getIntelligence() <= 1.0);
    }

    @Test
    public void thiefWisdomCorrect() {
        assertTrue(thief.getWisdom() >= 0.0 && thief.getWisdom() <= 1.0);
    }

    @Test
    public void thiefLuckCorrect() {
        assertTrue(thief.getWisdom() >= 0.0 && thief.getWisdom() <= 1.0);
    }

    @Test
    public void thiefHealthCorrect() {
        assertTrue(thief.getMaxhealth() >= 0.0 && thief.getMaxhealth() <= 100.0);
    }

    @Test
    public void thiefManaCorrect() {
        assertTrue(thief.getMaxmana() >= 0.0 && thief.getMaxmana() <= 100.0);
    }

    @Test
    public void thiefTakesDamage() {
        double hpBegin = thief.getCurrHealth();
        double damage = 10.0;
        thief.loseHealth(damage);
        assertThat(thief.getCurrHealth(), is(equalTo(hpBegin - damage)));
    }

    @Test
    public void thiefNotDead() {
        assertThat(thief.dies(), is(false));
    }

    @Test
    public void thiefCanDie() {
        double hpBegin = thief.getCurrHealth();
        double damage = hpBegin;
        thief.loseHealth(damage);
        assertThat(thief.dies(), is(true));
    }

    @Test
    public void thiefHealthNotNegative() {
        double hpBegin = thief.getCurrHealth();
        double damage = hpBegin + 100;
        thief.loseHealth(damage);
        assertThat(thief.getCurrHealth(), is(0.0));
    }

    @Test
    public void thiefAttackDamageCorrect() {
        double atk = thief.attack(0.5);
        if (thief.getLuck() > 0.5) {
            assertTrue(atk == thief.getStrength() * 20);
        } else {
            assertTrue(atk == thief.getStrength() * 10);
        }
        assertTrue(thief.attack(1) == thief.getStrength() * 10
                && thief.attack(0) == thief.getStrength() * 20);
    }

    @Test
    public void thiefHealthGain() {
        thief.loseHealth(30.0);
        assertTrue(thief.getCurrHealth() == thief.getMaxhealth() - 30.0);
        thief.gainHealth(5.0);
        assertTrue(thief.getCurrHealth() == thief.getMaxhealth() - 30.0 + 5.0);
        thief.gainHealth(5.0);
        assertTrue(thief.getCurrHealth() == thief.getMaxhealth() - 30.0 + 5.0 + 5.0);
        thief.gainHealth(0.5);
        assertTrue(thief.getCurrHealth() == thief.getMaxhealth() - 30.0 + 5.0 + 5.0 + 0.5);
    }

    @Test
    public void thiefHealthGainNotOverMaximum() {
        thief.gainHealth(1000);
        assertTrue(thief.getCurrHealth() == thief.getMaxhealth());
    }

    @Test
    public void thiefManaGain() {
        double mp = thief.getMaxmana();
        mp /= 2;
        thief.loseMana(mp);
        assertTrue(thief.getCurrMana() == mp);
        thief.gainMana(1);
        assertTrue(thief.getCurrMana() == mp + 1);
        thief.gainMana(1);
        assertTrue(thief.getCurrMana() == mp + 2);
    }

    @Test
    public void thiefManaGainNotOverMaximum() {
        thief.gainMana(1000);
        assertTrue(thief.getCurrMana() == thief.getMaxmana());
    }

    @Test
    public void manaLossNotUnderMinimum() {
        thief.loseMana(1000);
        assertTrue(thief.getCurrMana() == 0);
    }

    @Test
    public void fleeIsCorrect1() {
        assertThat(thief.isFlee(), is(false));
    }

    @Test
    public void fleeIsCorrect2() {
        thief.flee(0.5);
        assertThat(thief.isFlee(), is(false));
    }

    @Test
    public void fleeIsCorrect3() {
        thief.flee(0.4);
        assertThat(thief.isFlee(), is(true));
    }

    @Test
    public void fleeIsCorrect4() {
        thief.flee(1);
        assertThat(thief.isFlee(), is(false));
    }

    @Test
    public void fleeIsCorrect5() {
        thief.flee(0);
        assertThat(thief.isFlee(), is(true));
    }

    @Test
    public void setFleeIsCorrect() {
        assertThat(thief.isFlee(), is(false));
        thief.setFlee(true);
        assertThat(thief.isFlee(), is(true));
        thief.setFlee(false);
        assertThat(thief.isFlee(), is(false));
    }

    @Test
    public void defendIsCorrect1() {
        thief.defend();
        assertThat(thief.isDefend(), is(true));
    }

    @Test
    public void defendIsCorrect2() {
        thief.defend();
        thief.defend();
        assertThat(thief.isDefend(), is(true));
    }

    @Test
    public void defendIsCorrect3() {
        thief.setDefend(true);
        assertThat(thief.isDefend(), is(true));
        thief.setDefend(false);
        assertThat(thief.isDefend(), is(false));
        thief.setDefend(true);
        assertThat(thief.isDefend(), is(true));
    }
}
