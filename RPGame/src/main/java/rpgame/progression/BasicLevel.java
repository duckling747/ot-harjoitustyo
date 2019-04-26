package rpgame.progression;

import java.util.ArrayList;
import java.util.List;
import rpgame.main.Main;
import rpgame.creatures.Monster;
import rpgame.creatures.MonsterIdentities;

public class BasicLevel extends Level {

    private final List<Monster> monsters;
    private final int level;
    private final int howManyConsequentBattles;

    public BasicLevel(String name, int level) {
        super(name, false);
        this.level = level;
        monsters = new ArrayList<>();
        // get monsters in level range for list
        for (int i = 0; i < 10; i++) {
            monsters.add(new Monster(level - 1 + Main.RANDOM_SOURCE.nextInt(3),
                    MonsterIdentities.getMonsterName(level)));
        }
        howManyConsequentBattles = 3 + Main.RANDOM_SOURCE.nextInt(2);
    }

    public Monster getMonster() {
        return monsters.get(Main.RANDOM_SOURCE.nextInt(monsters.size()));
    }

    public int getLevel() {
        return level;
    }
    
    public int getHowManyConsecutiveBattles() {
        return howManyConsequentBattles;
    }

}
