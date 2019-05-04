package rpgame.items;

import java.util.ArrayList;
import java.util.List;

/**
 * A pseudo-utility class for the items a player character has available
 */
public class ItemBag {

    private List<Item> items;

    public ItemBag() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item takeRandomItem(int randInt) {
        int index = randInt % items.size();
        return items.remove(index);
    }

    public List<Item> getItems() {
        return items;
    }
}
