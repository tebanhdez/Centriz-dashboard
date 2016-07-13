package cr.centriz.dashboard.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cr.centriz.dashboard.dao.clients.ClientsDaoHandler;

public class PropertyHandler {

    private static final Log logger = LogFactory.getLog(ClientsDaoHandler.class);
    private static final String CONFIG_PROPERTIES = "config.properties";
    private static final String MISSING_FILE_ERROR = "Missing '" + CONFIG_PROPERTIES + "' file in the classpath";
    private Properties properties = new Properties();

    public PropertyHandler() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(CONFIG_PROPERTIES);
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            notifyError(e);
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            notifyError(e);
        }
    }

    private void notifyError(IOException e) {
        logger.error(MISSING_FILE_ERROR + e.getMessage());
        throw new DataAccessException(MISSING_FILE_ERROR, e);
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }

}