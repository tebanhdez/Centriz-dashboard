package cr.centriz.dashboard.dao.levels;

public class Levels {

    private String level1;
    private String level2;
    private String level3;
    private String level4;

    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }

    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }

    public String getLevel3() {
        return level3;
    }

    public void setLevel3(String level3) {
        this.level3 = level3;
    }

    public String getLevel4() {
        return level4;
    }

    public void setLevel4(String level4) {
        this.level4 = level4;
    }
    
    @Override
    public String toString() {
        return "Levels [level1=" + level1 + ", level2=" + level2 + ", level3=" + level3 + ", level4=" + level4 + "]";
    }

}
