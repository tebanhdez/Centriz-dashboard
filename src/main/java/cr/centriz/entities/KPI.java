package cr.centriz.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "KPI", schema = "public")
@XmlRootElement
public class KPI {

    public KPI() {
    }

    public KPI(int id) {
        setId(id);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "scope")
    private String scope;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Column(name = "primary_kpi")
    private String primaryKPI;

    public String getPrimaryKPI() {
        return primaryKPI;
    }

    public void setPrimaryKPI(String primaryKPI) {
        this.primaryKPI = primaryKPI;
    }

    @Column(name = "secondary_kpi")
    private String secondaryKPI;

    public String getSecondaryKPI() {
        return secondaryKPI;
    }

    public void setSecondaryKPI(String secondaryKPI) {
        this.secondaryKPI = secondaryKPI;
    }

    @Column(name = "brand")
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "zone")
    private String zone;

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        KPI primaryKPI = (KPI) o;
        if (id != primaryKPI.id)
            return false;
        return true;
    }
}