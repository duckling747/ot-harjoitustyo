package rpgame.creatures;

import java.util.ArrayList;
import rpgame.main.Main;

public class MonsterIndentities {

    private static ArrayList<String> lv1to3Monsters;
    private static ArrayList<String> lv4to7Monsters;
    private static ArrayList<String> lv8to10Monsters;

    public static void initMonsterNames() {
        lv1to3Monsters.add("Garuda");
        lv1to3Monsters.add("Rat");
        lv1to3Monsters.add("Beast");
    }

    public static String getMonsterName(int level) {
        if (level < 4) {
            return lv1to3Monsters.get(Main.RANDOM_SOURCE.nextInt(lv1to3Monsters.size()));
        } else if (level < 8) {
            return lv4to7Monsters.get(Main.RANDOM_SOURCE.nextInt(lv4to7Monsters.size()));
        } else {
            return lv8to10Monsters.get(Main.RANDOM_SOURCE.nextInt(lv8to10Monsters.size()));
        }
    }

}
