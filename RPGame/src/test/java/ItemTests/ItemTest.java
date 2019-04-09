package ItemTests;


import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import rpgame.creatures.Actor;
import rpgame.creatures.ItemUser;
import rpgame.creatures.WarriorCharacter;
import rpgame.items.Bomb;
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
}
