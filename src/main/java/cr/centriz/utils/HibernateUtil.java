package cr.centriz.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HibernateUtil {

    //private static final Log LOGGER = LogFactory.getLog(HibernateUtil.class);

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        System.out.println("Entering..");
        Configuration configuration = new Configuration();
        configuration.configure();
        return configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory.isClosed())
            sessionFactory.openSession();
        return sessionFactory;
    }

    public static void closeSession(Session session){
        try{
            if(session.isOpen())
                session.close();
        }catch(HibernateException exception){
            //LOGGER.error(exception);
        }
    }
}
