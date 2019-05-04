package ItemTests;

import java.util.List;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import rpgame.items.Item;
import rpgame.items.ItemBag;
import rpgame.items.Potion;

public class ItemBagTest {

    private ItemBag ib;

    @Before
    public void initMe() {
        ib = new ItemBag();
    }

    @Test(expected = ArithmeticException.class)
    public void itemBagInitializedEmpty() {
        ib.takeRandomItem(0);
        fail();
    }

    @Test
    public void addedItemCorrect() {
        ib.addItem(new Potion());
        Item i = ib.takeRandomItem(0);
        assertThat(i, is(instanceOf(Potion.class)));
    }
    
    @Test
    public void itemBagExistsAndRemovalIsCorrect() {
        List<Item> l = ib.getItems();
        assertThat(l.size(), is(0));
        ib.addItem(new Potion());
        assertThat(l.size(), is(1));
        ib.takeRandomItem(0);
        assertThat(l.size(), is(0));
    }
}
