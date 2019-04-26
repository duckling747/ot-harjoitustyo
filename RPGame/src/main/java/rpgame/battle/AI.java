package rpgame.battle;

import rpgame.main.Main;


/**
 * Class provides functionality for the AI
 * 
 */
public class AI {

    /**
     * 
     * @return Which action the AI performs next
     */
    public static Actions selectAction() {
        double actionChancer = Main.RANDOM_SOURCE.nextDouble();
        if (actionChancer < 0.5) {
            return Actions.ATTACK;
        } else if (actionChancer < 0.7) {
            return Actions.DEFEND;
        } else if (actionChancer < 0.75) {
            return Actions.FLEE;
        } else {
            return Actions.SKILL;
        }
    }
}
