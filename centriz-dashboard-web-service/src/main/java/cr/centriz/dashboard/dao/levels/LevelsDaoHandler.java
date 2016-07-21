package cr.centriz.dashboard.dao.levels;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cr.centriz.dashboard.dao.HibernateDaoInterface;

public class LevelsDaoHandler implements HibernateDaoInterface<Levels> {
    private EntityManager em = getEntityManagerFactory().createEntityManager();

    public EntityManager getEntityManager() {
        return em;
    }

    public void openTransaction() {
        getEntityManager().getTransaction().begin();
    }

    public void closeTransaction() {
        getEntityManager().close();
    }

    public void commitCloseTransaction() {
        getEntityManager().getTransaction().commit();
        getEntityManager().close();
    }

    private static EntityManagerFactory getEntityManagerFactory() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
        return emf;
    }

    public void persist(Levels entity) {
        getEntityManager().persist(entity);
    }

    public void update(Levels entity) {
        getEntityManager().refresh(entity);
    }

    public void delete(Levels entity) {
        getEntityManager().remove(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Levels> findAll() {
        List<Object> objectList = getEntityManager().createNativeQuery(buildQuery()).getResultList();
        List<Levels> levels = new ArrayList<Levels>();
        for (Object o : objectList) {
            Object[] cols = (Object[]) o;
            Levels tmpLevel = new Levels();
            tmpLevel.setLevel1(cols[0].toString());
            tmpLevel.setLevel2(cols[1].toString());
            tmpLevel.setLevel3(cols[2].toString());
            tmpLevel.setLevel4(cols[3].toString());
            levels.add(tmpLevel);
        }
        return levels;
    }

    public void deleteAll() {
        List<Levels> entityList = findAll();
        for (Levels entity : entityList) {
            delete(entity);
        }
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
