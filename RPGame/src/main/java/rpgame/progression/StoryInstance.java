package rpgame.progression;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class StoryInstance extends Level {

    protected List<String> storyTexts;
    protected Iterator<String> iter;

    public StoryInstance(String name) {
        super(name, true);
        storyTexts = new ArrayList<>();
    }

    public String getNextStoryText() {
        if (!iter.hasNext()) {
            return null;
        }
        return iter.next();
    }

}
