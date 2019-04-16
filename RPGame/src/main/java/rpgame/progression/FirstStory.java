package rpgame.progression;

public class FirstStory extends StoryInstance {

    public FirstStory(String levelName, String name, String type) {
        super(levelName);
        storyTexts.add("Once upon a time there was a magical place with dragons and things. "
                + "There also was a hero, named aptly " + name + ".");
        storyTexts.add("This hero was terrible. S/he was a " + type + ".");
        storyTexts.add("The hero left to dispatch the dragon and to save the damsel.");
        storyTexts.add("The adventure begins as the hero wades through the Magical forest.");
        iter = storyTexts.iterator();
    }
}
