package cr.centriz.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import cr.centriz.dashboard.dao.levels.Levels;

public class LevelsServiceTest {
    LevelsService levelsService = new LevelsService();

    @Test
    public void levelsTest() {
        List<Levels> levels = levelsService.findAll();
        for (Levels level : levels) {
            Assert.assertNotNull(level);
        }
    }

}
