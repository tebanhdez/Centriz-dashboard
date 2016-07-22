package cr.centriz.services;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

import cr.centriz.entities.data.Level;

public class LevelsServiceTest {
    LevelsService levelsService = new LevelsService();
    
    @Test
    public void levelsTest() {
        
        List<String[]> levels = levelsService.findAll();
        
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
