package cr.centriz.services;

import java.util.List;

import cr.centriz.dashboard.dao.levels.Levels;
import cr.centriz.dashboard.dao.levels.LevelsDaoHandler;

public class LevelsService {

    private static LevelsDaoHandler levelsDao;

    public LevelsService() {
        levelsDao = new LevelsDaoHandler();
    }

    public void persist(Levels entity) {
        levelsDao.openTransaction();
        levelsDao.persist(entity);
        levelsDao.commitCloseTransaction();
    }

    public void update(Levels entity) {
        levelsDao.openTransaction();
        levelsDao.update(entity);
        levelsDao.commitCloseTransaction();
    }

    public void delete(Levels levels) {
        levelsDao.openTransaction();
        levelsDao.delete(levels);
        levelsDao.commitCloseTransaction();
    }

    public List<Levels> findAll() {
        levelsDao.openTransaction();
        List<Levels> levels = levelsDao.findAll();
        levelsDao.closeTransaction();
        return levels;
    }

    public void deleteAll() {
        levelsDao.openTransaction();
        levelsDao.deleteAll();
        levelsDao.commitCloseTransaction();
    }

    public LevelsDaoHandler levelsDao() {
        return levelsDao;
    }
}