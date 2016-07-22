package cr.centriz.dashboard.dao.levels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cr.centriz.dashboard.dao.HibernateDaoInterface;
import cr.centriz.util.EntityManagerHelper;

public class LevelsDaoHandler implements HibernateDaoInterface<Levels> {

    @SuppressWarnings("unchecked")
    public List<String[]> findAll() {
        EntityManagerHelper.beginTransaction();
        List<Object> objectList = EntityManagerHelper.getEntityManager().createNativeQuery(buildQuery()).getResultList();
        EntityManagerHelper.commit();
        List<String[]> levels = new ArrayList<String[]>();

        for (Object o : objectList) {
            Object[] objectArray = (Object[]) o;
            String[] stringArray = Arrays.copyOf(objectArray, objectArray.length, String[].class);

            levels.add(stringArray);
        }
        return levels;
    }

    private String buildQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT l1.name AS level1, l2.name as level2, l3.name as");
        sb.append("level3, l4.name as level4 FROM source AS l1 LEFT JOIN ");
        sb.append("source AS l2 ON l2.parent = l1.id LEFT JOIN ");
        sb.append("source AS l3 ON l3.parent = l2.id LEFT JOIN ");
        sb.append("source AS l4 ON l4.parent = l3.id WHERE l1.name = 'Centriz';");
        return sb.toString();
    }

}
