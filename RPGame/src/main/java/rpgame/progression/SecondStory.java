package rpgame.progression;

import java.util.Iterator;
import rpgame.creatures.Actor;

public class SecondStory extends StoryInstance {

    private Iterator<String> iter;

    public SecondStory(String levelName, Actor character) {
        super(levelName);
        storyTexts.add("The magical forest was a dangerous place but " + character.getName()
                + " managed to get through it.");
        storyTexts.add("Next out hero had to trudge through the murky swamp to get to the princess.");
        iter = storyTexts.iterator();
    }

    @Override
    public String getNextStoryText() {
        return iter.next();
    }

}
