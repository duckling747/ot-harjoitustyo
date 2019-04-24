package rpgame.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class Io {

    public static boolean saveFileExists() {
        File f = new File("game.sav");
        return f.exists();
    }

    public static void saveGame(String charName, String charType, String levelName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("game.sav"), true))) {
            writer.append(charName).append("/").append(charType).append("/").append(levelName);
            writer.newLine();
        } catch (IOException e) {
        }
    }

    public static ArrayList<String> loadGame() {
        ArrayList<String> saves = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("game.sav"))) {
            String s;
            while((s = reader.readLine()) != null) {
                saves.add(s.trim());
            }
        } catch (IOException e) {
        }
        return saves;
    }
}
