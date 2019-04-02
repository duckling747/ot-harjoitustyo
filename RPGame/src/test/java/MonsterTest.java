
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import rpgame.creatures.Actor;
import rpgame.creatures.Monster;

public class MonsterTest {

    private Actor monster;

    @Before
    public void setUp() {
        monster = new Monster(1, "Rat");
    }

    @Test
    public void monsterInstanceOfActor() {
        assertThat(monster, instanceOf(Actor.class));
    }

    @Test
    public void monsterGetsName() {
        assertThat(monster.getName(), equalTo("Rat"));
    }

    @Test
    public void monsterStartingHealth() {
        assertThat(monster.getCurrHealth(), is(equalTo(monster.getMaxhealth())));
    }

    @Test
    public void monsterStartingMana() {
        assertThat(monster.getCurrMana(), is(equalTo(monster.getMaxmana())));
    }

    @Test
    public void monsterAgilityCorrect() {
        assertTrue(monster.getAgility() >= 0.0 && monster.getAgility() <= 1.0);
    }

    @Test
    public void monsterStrengthCorrect() {
        assertTrue(monster.getStrength() >= 0.0 && monster.getStrength() <= 1.0);
    }

    @Test
    public void monsterDefenseCorrect() {
        assertTrue(monster.getDefense() >= 0.0 && monster.getDefense() <= 1.0);
    }

    @Test
    public void monsterIntelligenceCorrect() {
        assertTrue(monster.getIntelligence() >= 0.0 && monster.getIntelligence() <= 1.0);
    }

    @Test
    public void monsterWisdomCorrect() {
        assertTrue(monster.getWisdom() >= 0.0 && monster.getWisdom() <= 1.0);
    }

    @Test
    public void monsterLuckCorrect() {
        assertTrue(monster.getWisdom() >= 0.0 && monster.getWisdom() <= 1.0);
    }

    @Test
    public void monsterHealthCorrect() {
        assertTrue(monster.getMaxhealth() >= 0.0 && monster.getMaxhealth() <= 200.0);
    }

    @Test
    public void monsterManaCorrect() {
        assertTrue(monster.getMaxmana() >= 0.0 && monster.getMaxmana() <= 200.0);
    }

    @Test
    public void monsterTakesDamage() {
        double hpBegin = monster.getCurrHealth();
        double damage = 10.0;
        monster.loseHealth(damage);
        assertThat(monster.getCurrHealth(), is(equalTo(hpBegin - damage)));
    }

    @Test
    public void monsterNotDead() {
        assertThat(monster.dies(), is(false));
    }

    @Test
    public void monsterCanDie() {
        double hpBegin = monster.getCurrHealth();
        double damage = hpBegin;
        monster.loseHealth(damage);
        assertThat(monster.dies(), is(true));
    }

    @Test
    public void monsterHealthNotNegative() {
        double hpBegin = monster.getCurrHealth();
        double damage = hpBegin + 100;
        monster.loseHealth(damage);
        assertThat(monster.getCurrHealth(), is(0.0));
    }
}
