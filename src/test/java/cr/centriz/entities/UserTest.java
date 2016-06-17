package cr.centriz.entities;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import cr.centriz.utils.HibernateUtil;

public class UserTest {

	@Test
	public void createUser() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = session.beginTransaction();
		User user = new User();
		user.setCreationDate(new Date());
		user.setFullName("Test User");
		user.setEmail("test@test.com");
		user.setPassword("Pernix1.");
		session.save(user);
		transaction.commit();
	}
}
