package cr.centriz.services;

import java.util.List;

import org.junit.Test;

import cr.centriz.dashboard.dao.levels.Levels;

public class LevelsServiceTest {
    LevelsService levelsService = new LevelsService();

    @Test
    public void levelsTest() {
        List<Levels> levels = levelsService.findAll();
        System.out.println(levels.size());
        for (Levels level : levels) {
            System.out.println(level.getLevel1());
        }
    }

}
