package rpgame.progression;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;
import rpgame.battle.Battle;
import rpgame.creatures.PlayerCharacter;

/**
 * A higher-than-battle-level abstraction for the events of the game;
 * provides the progression and events of the game for the UI
 */
public class Game {

    private Level currentLevel;
    private final PlayerCharacter character;
    private final Map<String, Level> levelMap;
    private final Map<String, Image> levelImages;

    /**
     * Basic constructor for a new game
     * @param character Player character used during the game
     */
    public Game(PlayerCharacter character) {
        levelMap = new HashMap<>();
        levelImages = new HashMap<>();
        this.character = character;
        initLevels();
        initImages();
        currentLevel = levelMap.get("Introduction");
    }

    /**
     * An alternative constructor for load/save functionality
     * @param character Player character used during the game
     * @param name Level name during which the game was saved
     */
    public Game(PlayerCharacter character, String name) {
        levelMap = new HashMap<>();
        levelImages = new HashMap<>();
        this.character = character;
        initLevels();
        initImages();
        currentLevel = levelMap.get(name);
    }

    /**
     * Constructs and sets up the levels in the game
     */
    private void initLevels() {
        Level l1 = new FirstStory("Introduction", character.getName(), character.getType()),
                l2 = new BasicLevel("Magic Forest", 1),
                l3 = new SecondStory("More story", character.getName()),
                l4 = new BasicLevel("Mystical Swamp", 5),
                l5 = new ThirdStory("Caves intro", character.getName()),
                l6 = new BasicLevel("Crystal Caves", 8),
                l7 = new FourthStory("Final Dialogue", character.getName()),
                l8 = new BossLevel(),
                l9 = new Epilogue("Epilogue", character.getName());
        levelMap.put("Introduction", l1);
        levelMap.put("Magic Forest", l2);
        levelMap.put("More story", l3);
        levelMap.put("Mystical swamp", l4);
        levelMap.put("Caves intro", l5);
        levelMap.put("Crystal Caves", l6);
        levelMap.put("Final Dialogue", l7);
        levelMap.put("Dragon Battle", l8);
        levelMap.put("Epilogue", l9);
        l1.setNextLevel(l2);
        l2.setNextLevel(l3);
        l3.setNextLevel(l4);
        l4.setNextLevel(l5);
        l5.setNextLevel(l6);
        l6.setNextLevel(l7);
        l7.setNextLevel(l8);
        l8.setNextLevel(l9);
        l9.setNextLevel(null);
    }

    /**
     * Loads the level specific images from resources and stores them in a map for use
     */
    private void initImages() {
        levelImages.put("Introduction", new Image(getClass().getResourceAsStream("/scenery/stock_forest.jpeg")));
        levelImages.put("More story", new Image(getClass().getResourceAsStream("/scenery/stock_swamp.jpeg")));
        levelImages.put("Caves intro", new Image(getClass().getResourceAsStream("/scenery/stock_caves.jpeg")));
        levelImages.put("Final Dialogue", new Image(getClass().getResourceAsStream("/dragons/dragon_gold.jpg")));
    }

    public Image getLevelImage(String name) {
        return levelImages.get(name);
    }

    public String getCurrentLevelName() {
        return currentLevel.getName();
    }

    /**
     * Check whether current level is a story level
     * @see rpgame.progression.StoryInstance
     * @return Is current level a story type of level
     */
    public boolean currentLevelIsStoryInstance() {
        return currentLevel.getIsStory();
    }

    /**
     * Stores the level's next level pointer to the current level pointer and
     * so progresses forward
     * @return boolean whether level progression was successful
     */
    public boolean advanceLevel() {
        return (currentLevel = currentLevel.getNextLevel()) != null;
    }

    /**
     * Return a level specific battle object
     * @return A battle object specific to the current level
     */
    public Battle getNextBattle() {
        if (currentLevelIsStoryInstance()) {
            return null;
        }
        return new Battle(character, ((BasicLevel) currentLevel).getMonster());
    }

    /**
     * If current level is a story level, then progress in the narrative and
     * return the text next in line for the current level
     * @return Next String representation for the narrative
     */
    public String getNextStoryText() {
        if (!currentLevelIsStoryInstance()) {
            return null;
        }
        return ((StoryInstance) currentLevel).getNextStoryText();
    }

    public String getCharacterName() {
        return character.getName();
    }

    public String getCharacterType() {
        return character.getType();
    }

    /**
     * A utility type method to return the maximum amount of battles possible for the current level
     * @return int primitive for how many battles can occur during current level
     */
    public int getCurrentLevelBattleMaximum() {
        if (currentLevel.getIsStory()) {
            return 0;
        }
        return ((BasicLevel) currentLevel).getHowManyConsecutiveBattles();
    }

}
