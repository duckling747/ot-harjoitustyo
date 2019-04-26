package rpgame.progression;

import rpgame.creatures.Dragon;
import rpgame.creatures.Monster;

public class BossLevel extends BasicLevel {

    public BossLevel() {
        super("Dragon Battle", 10);
    }

    @Override
    public Monster getMonster() {
        return new Dragon();
    }

    @Override
    public int getLevel() {
        return 10;
    }

    @Override
    public int getHowManyConsecutiveBattles() {
        return 1;
    }

}
