package rpgame.items;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ItemBag {

    private static final int CAPACITY = 99;

    private Map<Item, Integer> items;

    public ItemBag() {
        this.items = new LinkedHashMap<>();
    }

    public boolean addItem(Item item) {
        Integer i;
        if ((i = items.get(item)) == null) {
            items.put(item, 1);
            return true;
        } else if (i < CAPACITY) {
            items.put(item, i + 1);
            return true;
        } else {
            return false;
        }
    }

    public boolean takeItem(Item item) {
        Integer i;
        if ((i = items.get(item)) > 1) {
            items.put(item, i - 1);
            return true;
        } else if (i == 1) {
            items.remove(item);
            return true;
        } else {
            return false;
        }
    }

    public void sortByName() {
        items = items.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));
    }

    public void sortByAmount() {
        items = items.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (x, y) -> {
                            throw new AssertionError();
                        },
                        LinkedHashMap::new));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator<Map.Entry<Item, Integer>> ite = items.entrySet().iterator();
        Map.Entry<Item, Integer> e = ite.next();
        builder.append(e.getKey().toString()).append(' ').append(e.getValue());
        while (ite.hasNext()) {
            builder.append('\n');
            e = ite.next();
            builder.append(e.getKey().toString()).append(' ').append(e.getValue());
        }
        return builder.toString();
    }

}
