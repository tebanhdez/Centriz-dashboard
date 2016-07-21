package cr.centriz.services;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

import cr.centriz.dashboard.dao.levels.LevelsDaoHandler;
import cr.centriz.entities.data.Data;
import cr.centriz.entities.data.Level;

public class LevelsServiceTest {
    private static LevelsDaoHandler levelsDao = new LevelsDaoHandler();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();
    @Test
    public void levelsTest() {
        em.getTransaction().begin();
        List<String[]> levels = levelsDao.findAll();
        em.getTransaction().commit();
        em.close();
        System.out.println(levels.size());
        String[] previous = new String[] { "", "", "", "" };
        Level root = new Level("", "Organizacion");
        Level current=root;
        for (String[] level : levels) {
            System.out.println(Arrays.toString(level));
            for (int i = 0; i < level.length; i++) {
                String description = level[i];
                if (!previous[i].equalsIgnoreCase(description)) {
                    switch (i) {
                        case 4:
                            
                            break;                        
                        default:
                            Level subLevel = new Level(description, "");
                            current.addLevel(subLevel);
                            current=subLevel;
                            break;
                    }

                    previous[i] = description;
                }
            }
            
            Assert.assertNotNull(level);
        }
        System.out.println(new Gson().toJson(root));
    }
}
