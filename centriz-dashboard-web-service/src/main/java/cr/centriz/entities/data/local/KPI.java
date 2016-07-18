package cr.centriz.entities.data.local;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "KPI", schema = "public")
@XmlRootElement
public class KPI {

    public KPI() {
    }

    public KPI(String id) {
        setName(id);
    }

    @Id
    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "start_date")
    private Date startDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    private Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column(name = "expected")
    private float expected;

    public float getExpected() {
        return expected;
    }

    public void setExpected(float expected) {
        this.expected = expected;
    }

    @Column(name = "real")
    private float real;

    public float getReal() {
        return real;
    }

    public void setReal(float real) {
        this.real = real;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        KPI kpi = (KPI) o;
        if (name != kpi.name)
            return false;
        return true;
    }
}