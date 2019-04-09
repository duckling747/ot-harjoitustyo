package initTests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import rpgame.creatures.MonsterIdentities;

public class MonsterInitializerTest {

    @Test
    public void initNamesDoesInitNames() {
        MonsterIdentities.initMonsterNames();
        assertTrue(MonsterIdentities.getLv1to3Monsters() != null
                && !MonsterIdentities.getLv1to3Monsters().isEmpty()
                && MonsterIdentities.getLv4to7Monsters() != null
                && !MonsterIdentities.getLv4to7Monsters().isEmpty()
                && MonsterIdentities.getLv8to10Monsters() != null
                && !MonsterIdentities.getLv8to10Monsters().isEmpty());
    }

    @Test
    public void lowLevelGetterFunctional() {
        MonsterIdentities.initMonsterNames();
        String name = MonsterIdentities.getMonsterName(1);
        assertTrue(name.equals("Wolf")
                || name.equals("Rat")
                || name.equals("Amoeba"));
    }

    @Test
    public void midLevelGetterFunctional() {
        MonsterIdentities.initMonsterNames();
        String name = MonsterIdentities.getMonsterName(4);
        assertTrue(name.equals("Eagle")
                || name.equals("Bear")
                || name.equals("Angry Bear"));
    }

    @Test
    public void highLevelGetterFunctional() {
        MonsterIdentities.initMonsterNames();
        String name = MonsterIdentities.getMonsterName(8);
        assertTrue(name.equals("White Gorilla Creature")
                || name.equals("Garuda")
                || name.equals("Saturday Night Drunkard"));
    }

}
