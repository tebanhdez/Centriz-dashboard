package cr.centriz.entities;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BaseTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();
    Base base = new Base();

    @Before
    public void createTestMetric() throws ParseException {

        base.setName("test");
        base.setValue(100);

        em.getTransaction().begin();
        em.persist(base);
        em.getTransaction().commit();
    }

    @Test
    public void testMetric() {
        Assert.assertNotNull("Metric not found", base);
    }

    @After
    public void deleteTestMetric() {
        em.getTransaction().begin();
        em.remove(base);
        em.getTransaction().commit();
    }
}
