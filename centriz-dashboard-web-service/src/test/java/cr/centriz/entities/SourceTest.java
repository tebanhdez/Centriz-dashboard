package cr.centriz.entities;

import java.text.ParseException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import cr.centriz.util.EntityManagerHelper;

public class SourceTest {

    Source source = new Source(100);

    @Before
    public void createTestKPI() throws ParseException {
        
        source.setName("Centriz");
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(source);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Test
    public void testKPI() {
        Assert.assertNotNull("Source not found", source);
    }

    @After
    public void deleteTestKPI() {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(EntityManagerHelper.getEntityManager().contains(source) ? source : EntityManagerHelper.getEntityManager().merge(source));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }
}
