package rpgame.progression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * An abstract class for the shared functionality of the different types of
 * story levels
 */
public abstract class StoryInstance extends Level {

    protected List<String> storyTexts;
    protected Iterator<String> iter;

    public StoryInstance(String name) {
        super(name, true);
        storyTexts = new ArrayList<>();
    }

    /**
     * Return the next part of the current level narrative
     * @return String text containing story. Returns null if no story left for this level
     */
    public String getNextStoryText() {
        if (!iter.hasNext()) {
            return null;
        }
        return iter.next();
    }

}
