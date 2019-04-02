package rpgame.progression;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public abstract class Level {

    private final Map<String, Level> children;
    private final String name;

    public Level(String name) {
        this.children = new HashMap<>();
        this.name = name;
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