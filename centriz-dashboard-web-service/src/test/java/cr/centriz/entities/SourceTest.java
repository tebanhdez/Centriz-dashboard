package cr.centriz.entities;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cr.centriz.entities.Source;

public class SourceTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();
    Source source = new Source(100);

    @Before
    public void createTestKPI() throws ParseException {
        
        source.setName("Centriz");

        em.getTransaction().begin();
        em.persist(source);
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void testKPI() {
        Assert.assertNotNull("Source not found", source);
    }

    @After
    public void deleteTestKPI() {
        em.getTransaction().begin();
        em.remove(source);
        em.getTransaction().commit();
        em.close();
    }
}
