package cr.centriz.dashboard.dao;

import java.util.List;

public interface HibernateDaoInterface<T> {
    
    public List<String[]> findAll();

}
