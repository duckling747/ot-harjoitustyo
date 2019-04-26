package rpgame.progression;

public class FourthStory extends StoryInstance {

    public FourthStory(String levelName, String name) {
        super(levelName);
        storyTexts.add("Finally, " + name
                + " found and confronted the evil dragon in the caves.");
        storyTexts.add("The dragon said something cliché to " + name + " before the final battle ensued...");
        iter = storyTexts.iterator();
    }
}
