package cr.centriz.entities.data;

public class Level {

    private String name;
    private Object level;

    public Level() {}
    
    public Level(String name, Object level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getlevel() {
        return level;
    }

    public void setlevel(Object level) {
        this.level = level;
    }
}