package rpgame.progression;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class Level {

    private final Map<String, Level> children;
    private final String name;
    private final boolean isStory;

    public Level(String name, boolean isStory) {
        this.children = new HashMap<>();
        this.name = name;
        this.isStory = isStory;
    }

    public String getName() {
        return name;
    }

    public void addChild(Level child) {
        this.children.put(child.name, child);
    }

    public Map<String, Level> getChildren() {
        return children;
    }

    public Level getChild(String name) {
        return children.get(name);
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
