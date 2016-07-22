package cr.centriz.services;

import java.util.List;

import cr.centriz.dashboard.dao.levels.LevelsDaoHandler;

public class LevelsService {

    private static LevelsDaoHandler levelsDao;

    public LevelsService() {
        levelsDao = new LevelsDaoHandler();
    }

    public List<String[]> findAll() {
        List<String[]> levels = levelsDao.findAll();
        return levels;
    }
}