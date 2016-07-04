package cr.centriz.services;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.jetty.util.StringUtil;

import com.google.common.io.BaseEncoding;

import cr.centriz.entities.User;

public class AuthenticationService {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
	EntityManager em = emf.createEntityManager();

	public boolean authenticate(String authCredentials) {

		if (null == authCredentials)
			return false;

		final String encodedUserPassword = authCredentials.replaceFirst("Basic" + " ", "");
		String usernameAndPassword = null;
		try {

			byte[] decodedBytes = BaseEncoding.base64().decode(encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
		final String email = tokenizer.nextToken();
		final String password = tokenizer.nextToken();

		if (StringUtil.isBlank(email) || StringUtil.isBlank(password))
			return false;
		User userObject = findUserByEmail(email);

		boolean authenticationStatus = false;

		if (userObject != null) {
			return checkPassword(userObject.getPassword(), password);
		}
		return authenticationStatus;
	}

	public User findUserByEmail(final String email) {
		em.getTransaction().begin();
		User userObject = (User) em.createQuery("select u from User u where u.email = ?1").setParameter(1, email)
				.getSingleResult();
		em.getTransaction().commit();
		return userObject;
	}

	private boolean checkPassword(String password, String password2) {
		return password.equals(password2);
	}
}