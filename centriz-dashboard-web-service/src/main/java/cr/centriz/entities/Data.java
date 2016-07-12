package cr.centriz.entities;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private String name;
    private List<Header> headers = new ArrayList<Header>();
    private List<Level> levels = new ArrayList<Level>();

    public Data() {}
    
    public Data(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    public void addHeader(Header header) {
        this.headers.add(header);
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