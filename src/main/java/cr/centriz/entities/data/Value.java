package cr.centriz.entities.data;

import java.util.Date;

public class Value {

    private Date date;
    private float value;

    public Value() {}
    
    public Value(Date date, float value) {
        this.date = date;
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}