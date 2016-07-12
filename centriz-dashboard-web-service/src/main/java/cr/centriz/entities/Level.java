package cr.centriz.entities;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private String name;
    private List<Object> levels = new ArrayList<Object>();

    public Level() {}
    
    public Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object> getLevels() {
        return levels;
    }

    public void setLevels(List<Object> levels) {
        this.levels = levels;
    }
    
    public void addLevel(Object level) {
        this.levels.add(level);
    }
}