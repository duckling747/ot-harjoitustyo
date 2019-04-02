package rpgame.battle;

import rpgame.main.Main;

public class AI {

    public static Actions selectAction() {
        double actionChancer = Main.RANDOM_SOURCE.nextDouble();
        if (actionChancer < 0.35) {
            return Actions.ATTACK;
        } else if (actionChancer < 0.7) {
            return Actions.DEFEND;
        } else if (actionChancer < 0.8) {
            return Actions.FLEE;
        } else {
            return Actions.USEITEM;
        }
    }
}
