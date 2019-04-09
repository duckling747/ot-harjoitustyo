package rpgame.progression;

import java.util.Iterator;
import rpgame.creatures.Actor;
import rpgame.creatures.ThiefCharacter;
import rpgame.creatures.WarriorCharacter;
import rpgame.creatures.WizardCharacter;

public class FirstStory extends StoryInstance {

    private Iterator<String> iter;

    public FirstStory(String levelName, Actor character) {
        super(levelName);
        String type, charName = character.getName();
        if (character instanceof WarriorCharacter) {
            type = "warrior";
        } else if (character instanceof ThiefCharacter) {
            type = "thief";
        } else if (character instanceof WizardCharacter) {
            type = "wizard";
        } else {
            throw new IllegalArgumentException();
        }
        storyTexts.add("Once upon a time there was a magical place with dragons and things. "
                + "There also was a hero, named aptly " + charName);
        storyTexts.add("This hero was terrible. (S)he name was a " + type + ".");
        storyTexts.add("The hero left to dispatch the dragon and to save the damsel.");
        iter = storyTexts.iterator();
    }

    @Override
    public String getNextStoryText() {
        return iter.next();
    }

}
