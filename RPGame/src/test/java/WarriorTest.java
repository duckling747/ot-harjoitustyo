
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
        assertTrue(warrior.getMaxhealth() >= 0.0 && warrior.getMaxhealth() <= 200.0);
    }

    @Test
    public void warriorManaCorrect() {
        assertTrue(warrior.getMaxmana() >= 0.0 && warrior.getMaxmana() <= 200.0);
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
    public void warriorDealsDamageCorrect() {
        assertTrue(warrior.attack() > 0
                && (warrior.attack() == warrior.getStrength() * 10
                || warrior.attack() == warrior.getStrength() * 20));
    }
}
