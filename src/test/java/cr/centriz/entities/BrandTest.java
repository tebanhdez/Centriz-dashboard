package cr.centriz.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BrandTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();
    Brand budgetBrand = new Brand();
    Brand apexBrand = new Brand();
    Brand ceroStressBrand = new Brand();
    Brand rentingBrand = new Brand();
    
    @Before
    public void createTestBrand(){
        budgetBrand.setName("Budget");
        apexBrand.setName("Apex");
        ceroStressBrand.setName("Cero Stress");
        rentingBrand.setName("Renting");
        
        em.getTransaction().begin();
        em.persist(budgetBrand);
        em.persist(apexBrand);
        em.persist(ceroStressBrand);
        em.persist(rentingBrand);
        em.getTransaction().commit();
    }

    @Test
    public void testCreateCompanyAdminUser() {
        Assert.assertNotNull("Brand not found", budgetBrand);
        Assert.assertNotNull("Brand not found", apexBrand);
        Assert.assertNotNull("Brand not found", ceroStressBrand);
        Assert.assertNotNull("Brand not found", rentingBrand);
    }

    @After
    public void deleteTestUsers(){
        em.getTransaction().begin();
        em.remove(budgetBrand);
        em.remove(apexBrand);
        em.remove(ceroStressBrand);
        em.remove(rentingBrand);
        em.getTransaction().commit();
    }
}
