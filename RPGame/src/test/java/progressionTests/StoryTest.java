package progressionTests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import rpgame.progression.FirstStory;
import rpgame.progression.SecondStory;
import rpgame.progression.StoryInstance;

public class StoryTest {
    
    private StoryInstance si;
    private StoryInstance sii;
    
    @Before
    public void initMe() {
        si = new FirstStory("test", "Jack", "Soldier");
        sii = new SecondStory("I'm a test too", "Gabriella");
    }
    
    @Test
    public void storyInstancesGiveStringsAndThenNull() {
        String s = si.getNextStoryText();
        assertThat(s, instanceOf(String.class));
        assertThat(s, not(equalTo("")));
        assertThat(s, not(nullValue()));
        s = sii.getNextStoryText();
        assertThat(s, instanceOf(String.class));
        assertThat(s, not(equalTo("")));
        assertThat(s, not(nullValue()));
        for (int i = 0; i < 100; i++) {
            si.getNextStoryText();
            sii.getNextStoryText();
        }
        assertThat(si.getNextStoryText(), is(nullValue()));
        assertThat(sii.getNextStoryText(), is(nullValue()));
    }
}
