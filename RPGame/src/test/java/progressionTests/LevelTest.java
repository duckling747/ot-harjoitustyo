package progressionTests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import rpgame.battle.Battle;
import rpgame.creatures.MonsterIdentities;
import rpgame.creatures.WarriorCharacter;
import rpgame.main.Main;
import rpgame.progression.BasicLevel;
import rpgame.progression.BossLevel;
import rpgame.progression.FirstStory;
import rpgame.progression.Game;
import rpgame.progression.Level;

/**
 * Testing mostly for whether the level progression is as intended for 9 "hard
 * coded" levels
 */
public class LevelTest {

    private Level l1, l2, l3, l4;
    private Game g;
    private Main m;
    MonsterIdentities mi;

    @Before
    public void initMe() {
        m = new Main();
        mi = new MonsterIdentities();
        mi.initMonsterImages();
        l1 = new FirstStory("\"watashi wa gakusei desu\"", "Gordon", "Chef");
        l2 = new BasicLevel("\"Hontouni kanshashiteimasu\"", 5);
        l3 = new BossLevel();
        l4 = new BasicLevel("\"Hontouni kanshashiteimasu\"", 6);
        g = new Game(new WarriorCharacter("Jack"));
    }

    @Test
    public void sameNameMeansEqual() {
        assertTrue(!l1.equals(l2));
        assertTrue(l2.equals(l4));
        assertTrue(!l1.equals(l3));
    }

    @Test
    public void storyLevelsCorrect() {
        assertTrue(l1.getIsStory());
        assertTrue(!l2.getIsStory());
        assertTrue(!l3.getIsStory());
    }

    @Test
    public void finalAdvancementFalse() {
        for (int i = 0; i < 8; i++) {
            assertTrue(g.advanceLevel());
        }
        assertTrue(!g.advanceLevel());
    }

    @Test
    public void newGameStoryCorrectlyAlternates() {
        boolean b = true;
        for (int i = 0; i < 8; i++) {
            assertTrue(g.currentLevelIsStoryInstance() == b);
            g.advanceLevel();
            b = !b;
        }
    }

    @Test(expected = NullPointerException.class)
    public void pastFinalAdvancementFails() {
        for (int i = 0; i < 10; i++) {
            g.advanceLevel();
        }
        fail();
    }

    @Test(expected = NullPointerException.class)
    public void advancementPastFinalLevelFailsStoryCheck() {
        for (int i = 0; i < 9; i++) {
            g.advanceLevel();
        }
        g.currentLevelIsStoryInstance();
        fail();
    }

    @Test(expected = NullPointerException.class)
    public void advancementPastFinalLevelFailsNameCheck() {
        for (int i = 0; i < 9; i++) {
            g.advanceLevel();
        }
        g.getCurrentLevelName();
        fail();
    }

    @Test
    public void nextBattleReturnsNullIfStory() {
        assertTrue(g.getNextBattle() == null);
        g.advanceLevel();
        assertThat(g.getNextBattle(), is(instanceOf(Battle.class)));
    }

    @Test
    public void onlyStoryInstanceGivesStoryTexts() {
        String s1 = g.getNextStoryText();
        assertThat(s1, is(not(nullValue())));
        g.advanceLevel();
        s1 = g.getNextStoryText();
        assertThat(s1, is(nullValue()));
    }

    @Test
    public void getNameCorrect() {
        assertThat(g.getCharacterName(), is(equalTo("Jack")));
    }

    @Test
    public void getTypeCorrect() {
        assertThat(g.getCharacterType(), is(equalTo("warrior")));
    }

    @Test
    public void getLevelBeginningCorrect() {
        assertThat(g.getCurrentLevelName(), is(equalTo("Introduction")));
    }

    @Test
    public void getBattleMaximumBetweenSaneBounds() {
        g.advanceLevel();
        int i = g.getCurrentLevelBattleMaximum();
        assertTrue(i > 1 && i < 8);
    }
}
