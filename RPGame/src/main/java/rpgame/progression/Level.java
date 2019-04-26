package rpgame.progression;

import java.util.Objects;

/**
 * An abstract method for the shared functionality of the different types of levels
 */
public abstract class Level {

    private Level nextLevel;

    private final String name;
    private final boolean isStory;

    public Level(String name, boolean isStory) {
        this.name = name;
        this.isStory = isStory;
    }

    public String getName() {
        return name;
    }

    public Level getNextLevel() {
        return nextLevel;
    }

    public void setNextLevel(Level nextLevel) {
        this.nextLevel = nextLevel;
    }

    public boolean getIsStory() {
        return isStory;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Level other = (Level) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

}
