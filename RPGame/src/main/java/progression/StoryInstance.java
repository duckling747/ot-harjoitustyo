package progression;

import java.util.ArrayList;
import java.util.List;

public abstract class StoryInstance extends Level {

    protected List<String> storyTexts;

    public StoryInstance(String name) {
        super(name);
        storyTexts = new ArrayList<>();
    }

    public abstract String getNextStoryText();

}
