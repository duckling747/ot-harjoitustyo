package rpgame.items;

import java.util.ArrayList;
import java.util.List;
import rpgame.main.Main;

public class ItemRandomGetter {

    private static final List<Item> DROPPABLE_ITEMS = new ArrayList<>();

    public static void setUpItemRandomGetter() {
        DROPPABLE_ITEMS.add(new Bomb());
        DROPPABLE_ITEMS.add(new Potion());
        DROPPABLE_ITEMS.add(new ManaDrink());
        DROPPABLE_ITEMS.add(new Bomb());
        DROPPABLE_ITEMS.add(new Potion());
        DROPPABLE_ITEMS.add(new ManaDrink());
        DROPPABLE_ITEMS.add(new Bomb());
        DROPPABLE_ITEMS.add(new Potion());
        DROPPABLE_ITEMS.add(new ManaDrink());
        DROPPABLE_ITEMS.add(new BigBomb());
        DROPPABLE_ITEMS.add(new ForestMushroom());
        DROPPABLE_ITEMS.add(new BloodTransfusion());
    }

    public static Item getRandomItem() {
        return DROPPABLE_ITEMS.get(Main.RANDOM_SOURCE.nextInt(DROPPABLE_ITEMS.size()));
    }
}