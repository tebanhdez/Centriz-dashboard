package cr.centriz.entities.data.local;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SourceTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    KPI kpi = new KPI();
    Source source = new Source();

    @Before
    public void createTestKPI() throws ParseException {
        kpi.setName("Source Test");
        kpi.setExpected(100);
        kpi.setReal(100);
        kpi.setStartDate(sdf.parse("20160101"));
        kpi.setEndDate(sdf.parse("20160101"));

        em.getTransaction().begin();
        em.persist(kpi);
        em.getTransaction().commit();

        source.setLevel1(1);
        source.setLevel2(1);
        source.setKpi(kpi.getName());
        source.setLocation("service");
        source.setSource("http://localhost:9999/centriz-dashboard-web-service/rest/v1/metric/20160101/20161231");

        em.getTransaction().begin();
        em.persist(source);
        em.getTransaction().commit();
    }

    @Test
    public void testKPI() {
        Assert.assertNotNull("KPI not found", kpi);
        Assert.assertNotNull("Source not found", source);
    }

    @After
    public void deleteTestKPI() {
        em.getTransaction().begin();
        em.remove(source);
        em.remove(kpi);
        em.getTransaction().commit();
    }
}
