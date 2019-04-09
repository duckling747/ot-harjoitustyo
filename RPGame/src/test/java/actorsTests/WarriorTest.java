package actorsTests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import rpgame.creatures.Actor;
import rpgame.creatures.WarriorCharacter;

public class WarriorTest {

    private Actor warrior;

    @Before
    public void setUp() {
        warrior = new WarriorCharacter("James");
    }

    @Test
    public void warriorGetsName() {
        assertThat(warrior.getName(), equalTo("James"));
    }

    @Test
    public void warriorInstanceOfActor() {
        assertThat(warrior, instanceOf(Actor.class));
    }

    @Test
    public void warriorStartingHealth() {
        assertThat(warrior.getCurrHealth(), is(equalTo(warrior.getMaxhealth())));
    }

    @Test
    public void warriorStartingMana() {
        assertThat(warrior.getCurrMana(), is(equalTo(warrior.getMaxmana())));
    }

    @Test
    public void warriorAgilityCorrect() {
        assertTrue(warrior.getAgility() >= 0.0 && warrior.getAgility() <= 1.0);
    }

    @Test
    public void warriorStrengthCorrect() {
        assertTrue(warrior.getStrength() >= 0.0 && warrior.getStrength() <= 1.0);
    }

    @Test
    public void warriorDefenseCorrect() {
        assertTrue(warrior.getDefense() >= 0.0 && warrior.getDefense() <= 1.0);
    }

    @Test
    public void warriorIntelligenceCorrect() {
        assertTrue(warrior.getIntelligence() >= 0.0 && warrior.getIntelligence() <= 1.0);
    }

    @Test
    public void warriorWisdomCorrect() {
        assertTrue(warrior.getWisdom() >= 0.0 && warrior.getWisdom() <= 1.0);
    }

    @Test
    public void warriorLuckCorrect() {
        assertTrue(warrior.getWisdom() >= 0.0 && warrior.getWisdom() <= 1.0);
    }

    @Test
    public void warriorHealthCorrect() {
        assertTrue(warrior.getMaxhealth() >= 0.0 && warrior.getMaxhealth() <= 100.0);
    }

    @Test
    public void warriorManaCorrect() {
        assertTrue(warrior.getMaxmana() >= 0.0 && warrior.getMaxmana() <= 100.0);
    }

    @Test
    public void warriorTakesDamage() {
        double hpBegin = warrior.getCurrHealth();
        double damage = 10.0;
        warrior.loseHealth(damage);
        assertThat(warrior.getCurrHealth(), is(equalTo(hpBegin - damage)));
    }

    @Test
    public void warriorNotDead() {
        assertThat(warrior.dies(), is(false));
    }

    @Test
    public void warriorCanDie() {
        double hpBegin = warrior.getCurrHealth();
        double damage = hpBegin;
        warrior.loseHealth(damage);
        assertThat(warrior.dies(), is(true));
    }

    @Test
    public void warriorHealthNotNegative() {
        double hpBegin = warrior.getCurrHealth();
        double damage = hpBegin + 100;
        warrior.loseHealth(damage);
        assertThat(warrior.getCurrHealth(), is(0.0));
    }

    @Test
    public void warriorAttackDamageCorrect() {
        double atk = warrior.attack(0.5);
        if (warrior.getLuck() > 0.5) {
            assertTrue(atk == warrior.getStrength() * 20);
        } else {
            assertTrue(atk == warrior.getStrength() * 10);
        }
        assertTrue(warrior.attack(1) == warrior.getStrength() * 10
                && warrior.attack(0) == warrior.getStrength() * 20);
    }

    @Test
    public void warriorHealthGain() {
        warrior.loseHealth(30.0);
        assertTrue(warrior.getCurrHealth() == warrior.getMaxhealth() - 30.0);
        warrior.gainHealth(5.0);
        assertTrue(warrior.getCurrHealth() == warrior.getMaxhealth() - 30.0 + 5.0);
        warrior.gainHealth(5.0);
        assertTrue(warrior.getCurrHealth() == warrior.getMaxhealth() - 30.0 + 5.0 + 5.0);
        warrior.gainHealth(0.5);
        assertTrue(warrior.getCurrHealth() == warrior.getMaxhealth() - 30.0 + 5.0 + 5.0 + 0.5);
    }

    @Test
    public void warriorHealthGainNotOverMaximum() {
        warrior.gainHealth(1000);
        assertTrue(warrior.getCurrHealth() == warrior.getMaxhealth());
    }

    @Test
    public void warriorManaGain() {
        double mp = warrior.getMaxmana();
        mp /= 2;
        warrior.loseMana(mp);
        assertTrue(warrior.getCurrMana() == mp);
        warrior.gainMana(1);
        assertTrue(warrior.getCurrMana() == mp + 1);
        warrior.gainMana(1);
        assertTrue(warrior.getCurrMana() == mp + 2);
    }

    @Test
    public void warriorManaGainNotOverMaximum() {
        warrior.gainMana(1000);
        assertTrue(warrior.getCurrMana() == warrior.getMaxmana());
    }

    @Test
    public void manaLossNotUnderMinimum() {
        warrior.loseMana(1000);
        assertTrue(warrior.getCurrMana() == 0);
    }

    @Test
    public void fleeIsCorrect1() {
        assertThat(warrior.isFlee(), is(false));
    }

    @Test
    public void fleeIsCorrect2() {
        warrior.flee(0.5);
        assertThat(warrior.isFlee(), is(false));
    }

    @Test
    public void fleeIsCorrect3() {
        warrior.flee(0.4);
        assertThat(warrior.isFlee(), is(true));
    }

    @Test
    public void fleeIsCorrect4() {
        warrior.flee(1);
        assertThat(warrior.isFlee(), is(false));
    }

    @Test
    public void fleeIsCorrect5() {
        warrior.flee(0);
        assertThat(warrior.isFlee(), is(true));
    }

    @Test
    public void setFleeIsCorrect() {
        assertThat(warrior.isFlee(), is(false));
        warrior.setFlee(true);
        assertThat(warrior.isFlee(), is(true));
        warrior.setFlee(false);
        assertThat(warrior.isFlee(), is(false));
    }

    @Test
    public void defendIsCorrect1() {
        warrior.defend();
        assertThat(warrior.isDefend(), is(true));
    }

    @Test
    public void defendIsCorrect2() {
        warrior.defend();
        warrior.defend();
        assertThat(warrior.isDefend(), is(true));
    }

    @Test
    public void defendIsCorrect3() {
        warrior.setDefend(true);
        assertThat(warrior.isDefend(), is(true));
        warrior.setDefend(false);
        assertThat(warrior.isDefend(), is(false));
        warrior.setDefend(true);
        assertThat(warrior.isDefend(), is(true));
    }
}
