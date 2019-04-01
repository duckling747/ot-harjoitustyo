package progression;

import java.util.ArrayList;
import java.util.List;
import main.Main;
import rpgame.creatures.Monster;

public class BasicLevel extends Level {

    private final List<Monster> monsters;
    private final int minLevel,
            maxLevel;

    public BasicLevel(String name, int min, int max) {
        super(name);
        this.minLevel = min;
        this.maxLevel = max;
        monsters = new ArrayList<>();
        // get monsters in level range for list
        for (int i = 0; i < 10; i++) {
            monsters.add(new Monster(Main.RANDOM_SOURCE.nextInt((max - min) + 1) + min));
        }
    }

    public Monster getMonster() {
        // return to the relevant UI method to get battle view with the monster selected
        return monsters.get(Main.RANDOM_SOURCE.nextInt(monsters.size()));
    }

}
