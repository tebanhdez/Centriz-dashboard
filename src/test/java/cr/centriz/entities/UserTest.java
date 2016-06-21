package cr.centriz.entities;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.*;

public class UserTest {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
	EntityManager em = emf.createEntityManager();
    User adminUser = new User();
    UserRole adminUserRole = new UserRole();
    
    @Before
    public void createTestUser(){

        adminUserRole.setName(DefaultUserRole.ADMIN.getName());
        adminUserRole.setDescription(DefaultUserRole.ADMIN.getDescription());
        
        adminUserRole.setName(DefaultUserRole.ADMIN.getName());
        adminUserRole.setDescription(DefaultUserRole.ADMIN.getDescription());

        adminUser.setFullName("Test user");
        adminUser.setEmail("test@test.cr");
        adminUser.setPassword("test");
        adminUser.setRole(adminUserRole);
        
        em.getTransaction().begin();
    	em.persist(adminUserRole);
    	em.persist(adminUser);
    	em.getTransaction().commit();
    }

    @Test
    public void testCreateCompanyAdminUser() {
    	Assert.assertNotNull("Admin user role not found", adminUserRole);
    	Assert.assertNotNull("Admin user not found", adminUser);

        Assert.assertTrue("Admin user role invalid", adminUser.getRole().getName().compareToIgnoreCase(DefaultUserRole.ADMIN.getName()) == 0);
    }

    @After
    public void deleteTestUsers(){
    	em.getTransaction().begin();
        em.remove(adminUser);
        em.remove(adminUserRole);
        em.getTransaction().commit();
    }
}
