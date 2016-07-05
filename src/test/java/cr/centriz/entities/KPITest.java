package cr.centriz.entities;

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
    KPI ebidtaBRAC = new KPI();

    @Before
    public void createTestBrand() {

        ebidtaBRAC.setZone("San Jose");
        ebidtaBRAC.setBrand("Budget");
        ebidtaBRAC.setScope("Financiera");
        ebidtaBRAC.setPrimaryKPI("EBIDTA");
        ebidtaBRAC.setSecondaryKPI("Ebidta BRAC");
        ebidtaBRAC.setUser(em.find(User.class, 1));

        em.getTransaction().begin();
        em.persist(ebidtaBRAC);
        em.getTransaction().commit();
    }

    @Test
    public void testCreateCompanyAdminUser() {
        Assert.assertNotNull("KPI not found", ebidtaBRAC);
    }

    @After
    public void deleteTestUsers() {
        em.getTransaction().begin();
        em.remove(ebidtaBRAC);
        em.getTransaction().commit();
    }
}
