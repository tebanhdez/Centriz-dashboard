package cr.centriz.entities.data;

import java.util.ArrayList;
import java.util.List;

public class Level {

    private String name;
    private String header;
    private List<Level> levels = new ArrayList<Level>();

    public Level() {
    }

    public Level(String name, String header) {
        this.name = name;
        this.header = header;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public void addLevel(Level level) {
        this.levels.add(level);
    }
}