package rpgame.progression;

import java.util.HashMap;
import java.util.Map;
import rpgame.creatures.Actor;

public class GameMap {

    private Level currentLevel;
    private final Actor character;
    private final Map<String, Level> levelMap;

    public GameMap(Actor character) {
        levelMap = new HashMap<>();
        this.character = character;
        initLevels();
        currentLevel = levelMap.get("");
    }

    public GameMap(Actor character, String name) {
        levelMap = new HashMap<>();
        this.character = character;
        initLevels();
        currentLevel = levelMap.get(name);
    }

    private void initLevels() {
        // set up levels
        Level l1 = new FirstStory("Introduction", character);
        Level l2 = new BasicLevel("Magic Forest", 1);
        Level l3 = new SecondStory("", character);
        
    }

    public String getCurrentLevelName() {
        return currentLevel.getName();
    }

    public boolean advanceLevel(String nextLevelName) {
        if (currentLevel.getChildren().isEmpty()) {
            return false;
        } else if (!currentLevel.getChildren().containsKey(nextLevelName)) {
            throw new IllegalArgumentException();
        }
        currentLevel = currentLevel.getChild(nextLevelName);
        return true;
    }

}
