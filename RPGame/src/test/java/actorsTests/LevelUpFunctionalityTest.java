package actorsTests;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import rpgame.creatures.PlayerCharacter;
import rpgame.creatures.WarriorCharacter;

public class LevelUpFunctionalityTest {

    private PlayerCharacter c;

    @Before
    public void initMe() {
        c = new WarriorCharacter("Margaret");
    }

    @Test
    public void getsExp() {
        int e = c.getExp();
        c.increaseExp();
        assertTrue(c.getExp() > e);
    }

    @Test
    public void levelsUp() {
        double stren = c.getStrength();
        double def = c.getDefense();
        double ag = c.getAgility();
        double lu = c.getLuck();

        c.levelUp();
        assertTrue(c.getStrength() > stren
                && c.getDefense() > def
                && c.getAgility() > ag
                && c.getLuck() > lu);
    }
}
