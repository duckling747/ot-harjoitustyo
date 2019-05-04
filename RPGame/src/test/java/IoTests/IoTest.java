package IoTests;

import java.io.File;
import java.util.List;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.AfterClass;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import rpgame.creatures.PlayerCharacter;
import rpgame.creatures.ThiefCharacter;
import rpgame.creatures.WarriorCharacter;
import rpgame.creatures.WizardCharacter;
import rpgame.io.Io;
import rpgame.progression.Game;

public class IoTest {

    private Game g;
    private PlayerCharacter pc;

    @BeforeClass
    public static void fileCheckWorks() {
        assertTrue(!Io.saveFileExists());
    }

    @Before
    public void initMe() {
        pc = new ThiefCharacter("Daniel");
        Io.saveGame(pc.getName(), pc.getType(), "Forest");
        pc = new WarriorCharacter("Gabriella");
        Io.saveGame(pc.getName(), pc.getType(), "Marsh");
        pc = new WizardCharacter("Gregory");
        Io.saveGame(pc.getName(), pc.getType(), "Sea");
    }

    @AfterClass
    public static void cleanUp() {
        assertTrue(Io.saveFileExists());
        File save = new File("game.sav");
        save.delete();
    }

    @Test
    public void loadFunctionalityCorrect() {
        List<String> l = Io.loadGame();
        assertThat(l.size(), is(3));
        String[] s = l.get(0).split("/");
        assertThat(s.length, is(3));
        assertThat(s[0], is(equalTo("Daniel")));
        assertThat(s[1], is(equalTo("thief")));
        assertThat(s[2], is(equalTo("Forest")));
        s = l.get(1).split("/");
        assertThat(s.length, is(3));
        assertThat(s[0], is(equalTo("Gabriella")));
        assertThat(s[1], is(equalTo("warrior")));
        assertThat(s[2], is(equalTo("Marsh")));
        s = l.get(2).split("/");
        assertThat(s.length, is(3));
        assertThat(s[0], is(equalTo("Gregory")));
        assertThat(s[1], is(equalTo("wizard")));
        assertThat(s[2], is(equalTo("Sea")));
    }
}
