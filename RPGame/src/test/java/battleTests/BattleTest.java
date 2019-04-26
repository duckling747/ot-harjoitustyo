package battleTests;

import java.util.Random;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import rpgame.battle.Battle;
import rpgame.creatures.Monster;
import rpgame.creatures.PlayerCharacter;
import rpgame.creatures.WarriorCharacter;
import rpgame.items.Potion;

public class BattleTest {

    private Battle battle;
    private PlayerCharacter player;
    private Monster opponent;

    @Before
    public void setUp() {
        player = new WarriorCharacter("George");
        opponent = new Monster(2, "Steve");
        battle = new Battle(player, opponent);
    }

    @Test
    public void battleStartingHealthCorrect() {
        assertThat(player.getCurrHealth(), is(player.getMaxhealth()));
        assertThat(opponent.getCurrHealth(), is(opponent.getMaxhealth()));
    }

    @Test
    public void battleStartingManaCorrect() {
        assertThat(player.getCurrMana(), is(player.getMaxmana()));
        assertThat(opponent.getCurrMana(), is(opponent.getMaxmana()));
    }

    @Test
    public void battleTurnoutChangesWithActions() {
        String t = battle.getTurnout();
        battle.attacks(true);
        String t2 = battle.getTurnout();
        assertTrue(!t.equals(t2));
        battle.defends(false);
        t = battle.getTurnout();
        assertTrue(!t.equals(t2));
        battle.flees(true);
        t2 = battle.getTurnout();
        assertTrue(!t.equals(t2));
        player.loseHealth(player.getMaxhealth());
        battle.endBattle();
        t = battle.getTurnout();
        assertTrue(!t.equals(t2));
        battle.usesSkill(false);
        t2 = battle.getTurnout();
        assertTrue(!t.equals(t2));
        battle.playerUseItem(new Potion());
        t = battle.getTurnout();
        assertTrue(!t.equals(t2));
    }

    @Test
    public void monsterNameCorrect() {
        String s = battle.getMonsterName();
        assertTrue(s.equals("Steve"));
    }

    @Test
    public void battleEndsWithPlayerDeath() {
        player.loseHealth(player.getMaxhealth());
        assertTrue(battle.endBattle());
    }

    @Test
    public void battleEndsWithOpponentDeath() {
        opponent.loseHealth(opponent.getMaxhealth());
        assertTrue(battle.endBattle());
    }

    @Test
    public void battleEndsWithPlayerFlee() {
        player.setFlee(true);
        assertTrue(battle.endBattle());
    }

    @Test
    public void battleEndsWithOpponentFlee() {
        opponent.setFlee(true);
        assertTrue(battle.endBattle());
    }
    
    @Test
    public void battleDoesNotEndWithoutDeathOrFlee() {
        assertTrue(!battle.endBattle());
    }
    
    @Test
    public void battleEndsWithBothDead() {
        player.loseHealth(player.getMaxhealth());
        opponent.loseHealth(opponent.getMaxhealth());
        assertTrue(battle.endBattle());
    }
    
    @Test
    public void battleEndsWithBothFlee() {
        player.setFlee(true);
        opponent.setFlee(true);
        assertTrue(battle.endBattle());
    }

    @Test
    public void healthAndManaRatiosAreBetweenLimits() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            player.loseHealth(r.nextInt((int) player.getMaxhealth()));
            player.gainHealth(r.nextInt((int) player.getMaxhealth()));
            double rat = battle.getPlayerHealthRatio();
            assertTrue(rat >= 0.0 && rat <= 1.0);
        }
        for (int i = 0; i < 10; i++) {
            opponent.loseHealth(r.nextInt((int) opponent.getMaxhealth()));
            opponent.gainHealth(r.nextInt((int) opponent.getMaxhealth()));
            double rat = battle.getMonsterHealthRatio();
            assertTrue(rat >= 0.0 && rat <= 1.0);
        }
        for (int i = 0; i < 10; i++) {
            opponent.loseMana(r.nextInt((int) opponent.getMaxmana()));
            opponent.gainMana(r.nextInt((int) opponent.getMaxmana()));
            double rat = battle.getMonsterManaRatio();
            assertTrue(rat >= 0.0 && rat <= 1.0);
        }
        for (int i = 0; i < 10; i++) {
            player.loseMana(r.nextInt((int) player.getMaxmana()));
            player.gainMana(r.nextInt((int) player.getMaxmana()));
            double rat = battle.getPlayerManaRatio();
            assertTrue(rat >= 0.0 && rat <= 1.0);
        }
    }

}
