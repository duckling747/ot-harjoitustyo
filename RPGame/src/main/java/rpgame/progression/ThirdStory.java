package rpgame.progression;

public class ThirdStory extends StoryInstance {

    public ThirdStory(String levelName, String name) {
        super(levelName);
        storyTexts.add("After the horrible swamp, next " + name
                + " had to crawl through the Crystal Caves.");
        storyTexts.add("The princess was just right over there probably.");
        iter = storyTexts.iterator();
    }
}
