package rpgame.progression;

import java.util.Iterator;

public class FirstLevel extends StoryInstance {

    private Iterator<String> iter = super.storyTexts.iterator();

    public FirstLevel() {
        super("start");
        storyTexts.add("Olipa kerran kaukaisessa maailmassa tarina, jossa oli lohikäärmeitä. Siinä oli myös sankari, nimeltä...");
        storyTexts.add("Tämä sankari oli hurja. Sankarilla oli ammatti. Hän oli...");
        storyTexts.add("Sankari lähti pelastamaan neitoa ja kukistamaan lohikäärmeen.");
    }

    @Override
    public String getNextStoryText() {
        return iter.next();
    }

}
