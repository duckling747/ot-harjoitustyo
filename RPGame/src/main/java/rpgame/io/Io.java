package rpgame.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple class for saving and loading the game state.
 */
public final class Io {
    
    private final static String FILENAME = "game.sav";

    /**
     * Check whether save file exists or not
     * @return boolean value for whether save file exists in game executable directory
     */
    public static boolean saveFileExists() {
        File f = new File(FILENAME);
        return f.exists();
    }

    /**
     * A simple game-saving functionality: stores the character name, type and the name of
     * the current level in a text file in the running directory separated by slashes (/)
     * @param charName
     * @param charType
     * @param levelName 
     */
    public static void saveGame(String charName, String charType, String levelName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(FILENAME), true))) {
            writer.append(charName).append("/").append(charType).append("/").append(levelName);
            writer.newLine();
        } catch (IOException e) {
        }
    }

    /**
     * A simple game-loading functionality: reads a text file from the default location and
     * constructs a list of each line of the file, trimming newline characters
     * @return List of Strings of the lines in the file representing different saves
     */
    public static List<String> loadGame() {
        List<String> saves = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String s;
            while ((s = reader.readLine()) != null) {
                saves.add(s.trim());
            }
        } catch (IOException e) {
        }
        return saves;
    }
}
