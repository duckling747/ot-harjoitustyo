package rpgame.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator<Item> ite = items.iterator();
        Item e = ite.next();
        builder.append(e.toString()).append(' ');
        while (ite.hasNext()) {
            builder.append('\n');
            e = ite.next();
            builder.append(e.toString()).append(' ');
        }
        return builder.toString();
    }

}
