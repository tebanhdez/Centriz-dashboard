package cr.centriz.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserRoleTest {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();
    UserRole adminUserRole = new UserRole();
    UserRole readUserRole = new UserRole();
    UserRole writeUserRole = new UserRole();

    @Before
    public void createTestUser() {

        adminUserRole.setName(DefaultUserRole.ADMIN.getName());
        adminUserRole.setDescription(DefaultUserRole.ADMIN.getDescription());
        
        readUserRole.setName(DefaultUserRole.READ.getName());
        readUserRole.setDescription(DefaultUserRole.READ.getDescription());
        
        writeUserRole.setName(DefaultUserRole.WRITE.getName());
        adminUserRole.setDescription(DefaultUserRole.WRITE.getDescription());

        em.getTransaction().begin();
        em.persist(adminUserRole);
        em.persist(readUserRole);
        em.persist(writeUserRole);
        em.getTransaction().commit();
    }

    @Test
    public void testCreateCompanyAdminUser() {
        Assert.assertNotNull("Admin user role not found", adminUserRole);
        Assert.assertNotNull("Read user role not found", readUserRole);
        Assert.assertNotNull("Write user role not found", writeUserRole);
    }

    @After
    public void deleteTestUsers() {
        em.getTransaction().begin();
        em.persist(adminUserRole);
        em.persist(readUserRole);
        em.persist(writeUserRole);
        em.getTransaction().commit();
    }
}
