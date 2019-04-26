package battleTests;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import rpgame.battle.AI;
import rpgame.battle.Actions;
import rpgame.battle.Battle;
import rpgame.creatures.Monster;
import rpgame.creatures.WarriorCharacter;

public class AITest {

    private Battle b;

    @Before
    public void initMe() {
        b = new Battle(new WarriorCharacter("Muncher"), new Monster(2, "Britney"));
    }

    @Test
    public void AISelectsProperActions() {
        for (int i = 0; i < 10000; i++) {
            Actions a = AI.selectAction();
            assertTrue(a == Actions.ATTACK || a == Actions.DEFEND || a == Actions.FLEE || a == Actions.SKILL);
        }
    }
}
