package ItemTests;

import java.util.Arrays;
import static java.util.Collections.list;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import rpgame.creatures.Actor;
import rpgame.creatures.ItemUser;
import rpgame.creatures.WarriorCharacter;
import rpgame.items.Bomb;
import rpgame.items.Item;
import rpgame.items.ManaDrink;
import rpgame.items.Potion;

public class ItemTest {

    private Potion potion;
    private Bomb bomb;
    private ItemUser user;

    @Before
    public void setUp() {
        potion = new Potion();
        bomb = new Bomb();
        user = new WarriorCharacter("Nicholas");
    }

    @Test
    public void potionHeals() {
        ((Actor) user).loseHealth(30);
        user.useItem(potion, (Actor) user);
        assertTrue(((Actor) user).getCurrHealth() == ((Actor) user).getMaxhealth());
    }

    @Test
    public void bombDamages() {
        user.useItem(bomb, (Actor) user);
        assertTrue(((Actor) user).getCurrHealth() == ((Actor) user).getMaxhealth() - 30);
    }

    @Test
    public void bombFunctionMethodCorrect() {
        String s = bomb.function((Actor) user);
        assertTrue(s.equals("A vicious opponent uses a Bomb and Nicholas loses 30 health."));
    }

    @Test
    public void potionFunctionMethodCorrect() {
        String s = potion.function((Actor) user);
        assertTrue(s.equals("Nicholas uses a Potion and gains 30 health."));
    }

    @Test
    public void itemNameGetterReturnsString() {
        assertThat(potion.getName(), instanceOf(String.class));
    }

    @Test
    public void itemDescGetterReturnsString() {
        assertThat(potion.getDescription(), instanceOf(String.class));
    }

    @Test
    public void itemsOrderCorrect() {
        Item a = new Potion(),
                b = new Bomb(),
                c = new Potion(),
                d = new ManaDrink();
        Item[] items = new Item[]{a, b, c, d};
        assertThat(items[0].getName(), is(equalTo("Potion")));
        assertThat(items[1].getName(), is(equalTo("Bomb")));
        assertThat(items[2].getName(), is(equalTo("Potion")));
        assertThat(items[3].getName(), is(equalTo("Mana Drink")));
        Arrays.sort(items);
        assertThat(items[0].getName(), is(equalTo("Bomb")));
        assertThat(items[1].getName(), is(equalTo("Mana Drink")));
        assertThat(items[2].getName(), is(equalTo("Potion")));
        assertThat(items[3].getName(), is(equalTo("Potion")));
    }
}
