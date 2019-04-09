package rpgame.main;

import rpgame.creatures.Actor;
import rpgame.creatures.MonsterIdentities;
import rpgame.items.ItemRandomGetter;
import rpgame.progression.GameMap;

public class Game {

    private final Actor character;
    private final GameMap map;

    public Game(Actor character) {
        this.character = character;
        this.map = new GameMap(character);
        MonsterIdentities.initMonsterNames();
        ItemRandomGetter.initItemRandomGetter();
    }

    public Game(Actor character, String levelName) {
        this.character = character;
        this.map = new GameMap(character, levelName);
        MonsterIdentities.initMonsterNames();
        ItemRandomGetter.initItemRandomGetter();
    }

    public Actor getCharacter() {
        return character;
    }

    public GameMap getMap() {
        return map;
    }

}
