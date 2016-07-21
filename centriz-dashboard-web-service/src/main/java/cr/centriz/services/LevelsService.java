package cr.centriz.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cr.centriz.dashboard.dao.levels.LevelsDaoHandler;

public class LevelsService {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();
    private static LevelsDaoHandler levelsDao;

    public LevelsService() {
        levelsDao = new LevelsDaoHandler();
    }

    public List<String[]> findAll() {
        em.getTransaction().begin();
        List<String[]> levels = levelsDao.findAll();
        em.getTransaction().commit();
        em.close();
        return levels;
    }

    public LevelsDaoHandler levelsDao() {
        return levelsDao;
    }
}