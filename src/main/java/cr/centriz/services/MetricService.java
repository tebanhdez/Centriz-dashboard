package cr.centriz.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MetricService {
    private static final Log LOGGER = LogFactory.getLog(MetricService.class);

    public String getMetricsByDate(String sd, String ed) {
        return "{ \"@name\": \"Centriz\", \"headers\": [ { \"@name\": \"Unidad de Negocios\" }, { \"@name\": \"KPI Primario\" }, { \"@name\": \"KPI Secundario\" } ], \"levels\": [ { \"@name\": \"Procesos\", \"level\": { \"@name\": \"Inventariso\", \"level\": { \"@name\": \"Renting\", \"@contact\": \"\", \"metrics\": [ { \"@name\": \"renting\", \"@sd\": \"12\", \"@ed\": \"12\", \"@average\": \"100\", \"@base\": \"100\", \"tags\": [ { \"@name\": \"location\", \"@value\": \"SJ\" }, { \"@name\": \"brand\", \"@value\": \"renting\" } ], \"values\": [ { \"@date\": \"20160506\", \"@value\": \"100\" }, { \"@date\": \"20160507\", \"@value\": \"100\" }, { \"@date\": \"20160508\", \"@value\": \"100\" } ] } ] } } } ] }";
    }
}