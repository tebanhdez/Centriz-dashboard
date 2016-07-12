package cr.centriz.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;

import cr.centriz.entities.Data;
import cr.centriz.entities.Header;
import cr.centriz.entities.Level;
import cr.centriz.entities.Metric;
import cr.centriz.entities.Tag;
import cr.centriz.entities.Value;

public class MetricService {
    private static final Log logger = LogFactory.getLog(MetricService.class);

    public String getMetricsByDate(String sd, String ed) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Data data = new Data("Centriz");
        data.addHeader(new Header("Unidad de negocios"));
        data.addHeader(new Header("KPI Primario"));
        data.addHeader(new Header("KPI Secundario"));

        Metric metric = new Metric("Renting", sdf.parse("20160101"), sdf.parse("20161231"));
        metric.setAverage(100);
        metric.setBase(100);
        metric.addTag(new Tag("Location", "San Jose"));
        metric.addTag(new Tag("Brand", "Renting"));
        metric.addValue(new Value(sdf.parse("20160101"), 100));
        metric.addValue(new Value(sdf.parse("20160102"), 100));
        metric.addValue(new Value(sdf.parse("20160103"), 100));
        
        Level renting = new Level("Renting");
        renting.addLevel(metric);
        Level inventory = new Level("Inventarios");
        inventory.addLevel(renting);
        Level process = new Level("Procesos");
        process.addLevel(inventory);
        
        data.addLevel(process);

        return new Gson().toJson(data);
    }
}