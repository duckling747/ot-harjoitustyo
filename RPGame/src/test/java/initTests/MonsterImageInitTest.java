package initTests;

import javafx.scene.image.Image;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import rpgame.creatures.MonsterIdentities;
import rpgame.main.Main;

public class MonsterImageInitTest {
    
    private Main main;
    private MonsterIdentities mi;
    
    @Before
    public void InitSomeBasicStuff() {
        main = new Main();
        mi = new MonsterIdentities();
    }
    
    @Test
    public void monsterImagesLoad() {
        mi.initMonsterImages();
        Image i = MonsterIdentities.getMonsterImage("Rat");
        assertTrue(i != null);
    }
}
