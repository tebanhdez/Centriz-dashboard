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

public class KPITest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    KPI kpi = new KPI();

    @Before
    public void createTestKPI() throws ParseException {
        kpi.setName("Test");
        kpi.setExpected(100);
        kpi.setReal(100);
        kpi.setStartDate(sdf.parse("20160101"));
        kpi.setEndDate(sdf.parse("20160101"));

        em.getTransaction().begin();
        em.persist(kpi);
        em.getTransaction().commit();
    }

    @Test
    public void testKPI() {
        Assert.assertNotNull("KPI not found", kpi);
    }

    @After
    public void deleteTestKPI() {
        em.getTransaction().begin();
        em.remove(kpi);
        em.getTransaction().commit();
    }
}
