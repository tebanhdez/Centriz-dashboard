package cr.centriz.dashboard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

public abstract class MetricSetHandler<T> implements ResultSetHandler<T> {

    private BeanProcessor bp = new BeanProcessor();

    @Override
    public T handle(ResultSet rs) {
        T bean = null;
        try {
            while (rs.next()) {
                process(rs);
            }
            rs.close();
        } catch (SQLException e) {
            throw new DataAccessException("Bad data", e);
        }
        end();
        return bean;
    }

    public void run() {
        try {
            new QueryRunner(getDataSource()).query(buildQuery(), this);
        } catch (SQLException e) {
            throw new DataAccessException("Bad data", e);
        }
    }

    protected BeanProcessor getBeanProcessor() {
        return bp;
    }

    protected abstract DataSource getDataSource();

    protected abstract String buildQuery();

    protected abstract void process(ResultSet rs) throws SQLException;

    protected abstract void end();
}
