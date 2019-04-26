package rpgame.creatures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.scene.image.Image;
import rpgame.main.Main;

/**
 * Utility type class to pre-construct the different monsters for the game
 */
public final class MonsterIdentities {

    private static List<String> lv1to3Monsters;
    private static List<String> lv4to7Monsters;
    private static List<String> lv8to10Monsters;
    private static HashMap<String, Image> monsterImages;

    public MonsterIdentities() {
        lv1to3Monsters = new ArrayList<>();
        lv4to7Monsters = new ArrayList<>();
        lv8to10Monsters = new ArrayList<>();
        lv1to3Monsters.add("Wolf");
        lv1to3Monsters.add("Rat");
        lv1to3Monsters.add("Amoeba");
        lv4to7Monsters.add("Eagle");
        lv4to7Monsters.add("Bear");
        lv4to7Monsters.add("Angry Bear");
        lv8to10Monsters.add("White Gorilla Creature");
        lv8to10Monsters.add("Garuda");
        lv8to10Monsters.add("Saturday Night Drunkard");
    }

    /**
     * Loads the monster images from resources and stores them in a map for use
     */
    public void initMonsterImages() {
        monsterImages = new HashMap<>(lv1to3Monsters.size() + lv4to7Monsters.size() + lv8to10Monsters.size());
        monsterImages.put("Rat", new Image(getClass().getResourceAsStream("/monsters/monster_rat.jpeg")));
        monsterImages.put("Wolf", new Image(getClass().getResourceAsStream("/monsters/monster_wolf.jpeg")));
        monsterImages.put("Amoeba", new Image(getClass().getResourceAsStream("/monsters/monster_amoeba.jpeg")));
        monsterImages.put("Eagle", new Image(getClass().getResourceAsStream("/monsters/monster_bird.jpeg")));
        monsterImages.put("Bear", new Image(getClass().getResourceAsStream("/monsters/monster_bear.jpeg")));
        monsterImages.put("Angry Bear", new Image(getClass().getResourceAsStream("/monsters/monster_bear_angry.jpeg")));
        monsterImages.put("Garuda", new Image(getClass().getResourceAsStream("/monsters/monster_garuda.jpeg")));
        monsterImages.put("Saturday Night Drunkard", new Image(getClass().getResourceAsStream("/monsters/monster_scary.jpeg")));
        monsterImages.put("White Gorilla Creature", new Image(getClass().getResourceAsStream("/monsters/monster_gorillaish.jpeg")));
        monsterImages.put("Evil Dragon", new Image(getClass().getResourceAsStream("/dragons/dragon_face.jpeg")));
    }

    /**
     * Returns a randomized monster name from a collection of predefined names based on monster level
     * @param level Level of monster
     * @return Random monster name based on level
     */
    public static String getMonsterName(int level) {
        if (level < 4) {
            return lv1to3Monsters.get(Main.RANDOM_SOURCE.nextInt(lv1to3Monsters.size()));
        } else if (level < 8) {
            return lv4to7Monsters.get(Main.RANDOM_SOURCE.nextInt(lv4to7Monsters.size()));
        } else {
            return lv8to10Monsters.get(Main.RANDOM_SOURCE.nextInt(lv8to10Monsters.size()));
        }
    }

    public static List<String> getLv1to3Monsters() {
        return lv1to3Monsters;
    }

    public static List<String> getLv4to7Monsters() {
        return lv4to7Monsters;
    }

    public static List<String> getLv8to10Monsters() {
        return lv8to10Monsters;
    }

    public static Image getMonsterImage(String name) {
        return monsterImages.get(name);
    }

}
