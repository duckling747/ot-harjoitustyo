package rpgame.progression;

public class FourthStory extends StoryInstance {

    public FourthStory(String levelName, String name) {
        super(levelName);
        storyTexts.add("After the horrible swamp, next " + name
                + " had to crawl through the Crystal Caves.");
        storyTexts.add("The princess was just right over there probably.");
        iter = storyTexts.iterator();
    }
}
