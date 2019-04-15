package rpgame.progression;

public class SecondStory extends StoryInstance {

    public SecondStory(String levelName, String name) {
        super(levelName);
        storyTexts.add("The magical forest was a dangerous place but " + name
                + " managed to get through it.");
        storyTexts.add("Next out hero had to trudge through the murky swamp to get to the princess.");
        iter = storyTexts.iterator();
    }
}
