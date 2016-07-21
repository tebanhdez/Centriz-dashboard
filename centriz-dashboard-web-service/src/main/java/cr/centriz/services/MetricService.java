package cr.centriz.services;

import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;

import cr.centriz.dashboard.dao.levels.LevelsDaoHandler;
import cr.centriz.entities.data.Level;

public class MetricService {
    private static final Log logger = LogFactory.getLog(MetricService.class);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();
    private static LevelsDaoHandler levelsDao = new LevelsDaoHandler();

    public String getMetricsByDate(String sd, String ed) throws ParseException {
        
        em.getTransaction().begin();
        List<String[]> levels = levelsDao.findAll();
        em.getTransaction().commit();
        em.close();
        emf.close();
        String[] previous = new String[] { "", "", "", "" };
        Level root = new Level("", "Organizacion");
        Level current = root;
        for (String[] level : levels) {
            for (int i = 0; i < level.length; i++) {
                String description = level[i];
                if (!previous[i].equalsIgnoreCase(description)) {
                    switch (i) {
                        case 4:
                            break;
                        default:
                            Level subLevel = new Level(description, "");
                            current.addLevel(subLevel);
                            current = subLevel;
                            break;
                    }
                    previous[i] = description;
                }
            }
        }
        return new Gson().toJson(root);
    }
}