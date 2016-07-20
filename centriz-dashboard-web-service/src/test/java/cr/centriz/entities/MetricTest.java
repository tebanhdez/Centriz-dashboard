package cr.centriz.entities;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MetricTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();
    Metric metric = new Metric();

    @Before
    public void createTestMetric() throws ParseException {
        
        metric.setName("test");
        metric.setValue(100);
        metric.setDate(new Date());

        em.getTransaction().begin();
        em.persist(metric);
        em.getTransaction().commit();
    }

    @Test
    public void testMetric() {
        Assert.assertNotNull("Metric not found", metric);
    }

    @After
    public void deleteTestMetric() {
        em.getTransaction().begin();
        em.remove(metric);
        em.getTransaction().commit();
    }
}
