package cr.centriz.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ZoneTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();
    Brand sanJose = new Brand();
    Brand liberia = new Brand();

    @Before
    public void createTestBrand() {
        sanJose.setName("San Jose");
        liberia.setName("Liberia");

        em.getTransaction().begin();
        em.persist(sanJose);
        em.persist(liberia);
        em.getTransaction().commit();
    }

    @Test
    public void testCreateCompanyAdminUser() {
        Assert.assertNotNull("Brand not found", sanJose);
        Assert.assertNotNull("Brand not found", liberia);
    }

    @After
    public void deleteTestUsers() {
        em.getTransaction().begin();
        em.remove(sanJose);
        em.remove(liberia);
        em.getTransaction().commit();
    }
}
