package rpgame.progression;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;
import rpgame.battle.Battle;
import rpgame.creatures.PlayerCharacter;

public class Game {

    private Level currentLevel;
    private final PlayerCharacter character;
    private final Map<String, Level> levelMap;
    private final Map<String, Image> levelImages;

    public Game(PlayerCharacter character) {
        levelMap = new HashMap<>();
        levelImages = new HashMap<>();
        this.character = character;
        initLevels();
        initImages();
        currentLevel = levelMap.get("Introduction");
    }

    public Game(PlayerCharacter character, String name) {
        levelMap = new HashMap<>();
        levelImages = new HashMap<>();
        this.character = character;
        initLevels();
        initImages();
        currentLevel = levelMap.get(name);
    }

    private void initLevels() {
        // set up levels
        Level l1 = new FirstStory("Introduction", character.getName(), character.getType()),
                l2 = new BasicLevel("Magic Forest", 1),
                l3 = new SecondStory("More story", character.getName()),
                l4 = new BasicLevel("Mystical Swamp", 5),
                l5 = new ThirdStory("The Dragon", character.getName()),
                l6 = new BasicLevel("Magic Tower", 8),
                l7 = new FourthStory("Final Dialogue", character.getName()),
                l8 = new BossLevel();
        levelMap.put("Introduction", l1);
        levelMap.put("Magic Forest", l2);
        levelMap.put("More story", l3);
        levelMap.put("Mystical swamp", l4);
        levelMap.put("The Dragon", l5);
        levelMap.put("Magic Tower", l6);
        levelMap.put("Final Dialogue", l7);
        levelMap.put("Boss", l8);
        l1.setNextLevel(l2);
        l2.setNextLevel(l3);
        l3.setNextLevel(l4);
        l4.setNextLevel(l5);
        l5.setNextLevel(l6);
        l6.setNextLevel(l7);
        l7.setNextLevel(l8);
    }

    private void initImages() {
        levelImages.put("Introduction", new Image(getClass().getResourceAsStream("/scenery/stock_forest.jpeg")));
        levelImages.put("More story", new Image(getClass().getResourceAsStream("/scenery/stock_forest.jpeg")));
        levelImages.put("The Dragon", new Image(getClass().getResourceAsStream("/scenery/stock_forest.jpeg")));
        levelImages.put("Final Dialogue", new Image(getClass().getResourceAsStream("/scenery/stock_forest.jpeg")));
    }

    public Image getLevelImage(String name) {
        return levelImages.get(name);
    }

    public String getCurrentLevelName() {
        return currentLevel.getName();
    }

    public boolean currentLevelIsStoryInstance() {
        return currentLevel.getIsStory();
    }

    public boolean advanceLevel() {
        return (currentLevel = currentLevel.getNextLevel()) != null;
    }

    public Battle getNextBattle() {
        if (currentLevelIsStoryInstance()) {
            return null;
        }
        return new Battle(character, ((BasicLevel) currentLevel).getMonster());
    }

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

    public int getCurrentLevelBattleMaximum() {
        if (currentLevel.getIsStory()) {
            return 0;
        }
        return ((BasicLevel) currentLevel).getHowManyConsecutiveBattles();
    }

}
