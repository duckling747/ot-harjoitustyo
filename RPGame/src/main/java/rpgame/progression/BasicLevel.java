package rpgame.progression;

import java.util.ArrayList;
import java.util.List;
import rpgame.main.Main;
import rpgame.creatures.Monster;
import rpgame.creatures.MonsterIndentities;

public class BasicLevel extends Level {

    private final List<Monster> monsters;
    private final int level;

    public BasicLevel(String name, int level) {
        super(name);
        this.level = level;
        monsters = new ArrayList<>();
        // get monsters in level range for list
        for (int i = 0; i < 10; i++) {
            level = level - 1 + Main.RANDOM_SOURCE.nextInt(3);
            monsters.add(new Monster(level, MonsterIndentities.getMonsterName(level)));
        }
    }

    public Monster getMonster() {
        // return to the relevant UI method to get battle view with the monster selected
        return monsters.get(Main.RANDOM_SOURCE.nextInt(monsters.size()));
    }

}
