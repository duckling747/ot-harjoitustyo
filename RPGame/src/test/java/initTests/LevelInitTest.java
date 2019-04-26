package initTests;

import javafx.scene.image.Image;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import rpgame.creatures.MonsterIdentities;
import rpgame.creatures.WarriorCharacter;
import rpgame.main.Main;
import rpgame.progression.Game;

public class LevelInitTest {

    private Main main;
    private Game gNorm;
    private Game gLoad;
    private MonsterIdentities mi;

    @Before
    public void initMe() {
        main = new Main();
        mi = new MonsterIdentities();
        mi.initMonsterImages();
        gNorm = new Game(new WarriorCharacter("Constance"));
        gLoad = new Game(new WarriorCharacter("George"), "Introduction");
    }

    @Test
    public void imagesGetInitialized() {
        Image i = gNorm.getLevelImage("Introduction");
        assertTrue(i != null);
        i = gNorm.getLevelImage("More story");
        assertTrue(i != null);
        i = gNorm.getLevelImage("Caves intro");
        assertTrue(i != null);
        i = gNorm.getLevelImage("Final Dialogue");
        assertTrue(i != null);
    }
}
