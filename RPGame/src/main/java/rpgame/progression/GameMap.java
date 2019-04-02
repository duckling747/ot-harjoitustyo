package rpgame.progression;

import java.util.HashMap;

public class GameMap {

    private Level currentLevel;

    private final HashMap<String, Level> levelMap;

    public GameMap() {
        // set up levels
        // update UI
        levelMap = new HashMap<>();
        initLevels();
        currentLevel = new FirstLevel();
    }

    public GameMap(String name) {
        levelMap = new HashMap<>();
        initLevels();
        currentLevel = levelMap.get(name);
    }

    private void initLevels() {
        // set up levels
        
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
