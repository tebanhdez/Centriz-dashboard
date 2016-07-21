/**
 * 
 */
package cr.centriz.dashboard.dao.clients;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Miguel Rodriguez
 * @param <T>
 */
public class ClientsDaoHandlerTest<T> {

    private ClientsDaoHandler<T> clientsDao;

    @Before
    public void setUp() {
        clientsDao = new ClientsDaoHandler<>();
    }

    @Test
    public void testQuery() {
        clientsDao.run();
        Assert.assertEquals(2313.0, clientsDao.getMetric().getAverage(), 0);
    }

    @After
    public void tearDown() {
        clientsDao.clear();
    }

}
