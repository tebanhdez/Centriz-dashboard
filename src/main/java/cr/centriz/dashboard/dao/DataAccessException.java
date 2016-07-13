package cr.centriz.dashboard.dao;

public class DataAccessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataAccessException(String string, Exception e) {
        super(string, e);
    }

}
