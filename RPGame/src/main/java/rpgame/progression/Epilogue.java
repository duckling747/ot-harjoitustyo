package rpgame.progression;

public class Epilogue extends StoryInstance {

    public Epilogue(String levelName, String name) {
        super(levelName);
        storyTexts.add("Yes! " + name
                + " managed to save the day and defeat the Evil Dragon. "
                + "So the world was saved, the princess was saved and everything was fine and dandy.");
        iter = storyTexts.iterator();
    }
}
