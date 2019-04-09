package actorsTests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import rpgame.creatures.Actor;
import rpgame.creatures.Monster;
import rpgame.items.Item;
import rpgame.items.ItemBag;
import rpgame.items.ItemRandomGetter;

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

    @Test
    public void monsterAttackDamageCorrect() {
        double atk = monster.attack(0.5);
        if (monster.getLuck() > 0.5) {
            assertTrue(atk == monster.getStrength() * 20);
        } else {
            assertTrue(atk == monster.getStrength() * 10);
        }
        assertTrue(monster.attack(1) == monster.getStrength() * 10
                && monster.attack(0) == monster.getStrength() * 20);
    }

    @Test
    public void monsterHealthGain() {
        double hp = monster.getMaxhealth();
        hp /= 2;
        monster.loseHealth(hp);
        assertTrue(monster.getCurrHealth() == hp);
        monster.gainHealth(1);
        assertTrue(monster.getCurrHealth() == hp + 1);
        monster.gainHealth(1);
        assertTrue(monster.getCurrHealth() == hp + 2);
    }

    @Test
    public void monsterHealthGainNotOverMaximum() {
        monster.gainHealth(1000);
        assertTrue(monster.getCurrHealth() == monster.getMaxhealth());
    }

    @Test
    public void monsterManaGain() {
        double mp = monster.getMaxmana();
        mp /= 2;
        monster.loseMana(mp);
        assertTrue(monster.getCurrMana() == mp);
        monster.gainMana(1);
        assertTrue(monster.getCurrMana() == mp + 1);
        monster.gainMana(1);
        assertTrue(monster.getCurrMana() == mp + 2);
    }

    @Test
    public void monsterManaGainNotOverMaximum() {
        monster.gainMana(1000);
        assertTrue(monster.getCurrMana() == monster.getMaxmana());
    }

    @Test
    public void manaLossNotUnderMinimum() {
        monster.loseMana(1000);
        assertTrue(monster.getCurrMana() == 0);
    }

    @Test
    public void fleeIsCorrect1() {
        assertThat(monster.isFlee(), is(false));
    }

    @Test
    public void fleeIsCorrect2() {
        monster.flee(0.5);
        assertThat(monster.isFlee(), is(false));
    }

    @Test
    public void fleeIsCorrect3() {
        monster.flee(0.4);
        assertThat(monster.isFlee(), is(true));
    }

    @Test
    public void fleeIsCorrect4() {
        monster.flee(1);
        assertThat(monster.isFlee(), is(false));
    }

    @Test
    public void fleeIsCorrect5() {
        monster.flee(0);
        assertThat(monster.isFlee(), is(true));
    }

    @Test
    public void setFleeIsCorrect() {
        assertThat(monster.isFlee(), is(false));
        monster.setFlee(true);
        assertThat(monster.isFlee(), is(true));
        monster.setFlee(false);
        assertThat(monster.isFlee(), is(false));
    }

    @Test
    public void defendIsCorrect1() {
        monster.defend();
        assertThat(monster.isDefend(), is(true));
    }

    @Test
    public void defendIsCorrect2() {
        monster.defend();
        monster.defend();
        assertThat(monster.isDefend(), is(true));
    }

    @Test
    public void defendIsCorrect3() {
        monster.setDefend(true);
        assertThat(monster.isDefend(), is(true));
        monster.setDefend(false);
        assertThat(monster.isDefend(), is(false));
        monster.setDefend(true);
        assertThat(monster.isDefend(), is(true));
    }

    @Test
    public void getItemBagReturnsItemBag() {
        ItemBag b = monster.getItemBag();
        assertThat(b, instanceOf(ItemBag.class));
    }

    @Test
    public void dropRandomItemReturnsItem() {
        ItemRandomGetter.initItemRandomGetter();
        Item i = ((Monster) monster).dropRandomItem();
        assertThat(i, instanceOf(Item.class));
    }
}
