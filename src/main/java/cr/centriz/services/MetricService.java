package cr.centriz.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;

import cr.centriz.entities.data.Data;
import cr.centriz.entities.data.Header;
import cr.centriz.entities.data.Level;
import cr.centriz.entities.data.Metric;
import cr.centriz.entities.data.Tag;
import cr.centriz.entities.data.Value;

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

        Metric metric2 = new Metric("Metric", sdf.parse("20160101"), sdf.parse("20161231"));
        metric2.setAverage(100);
        metric2.setBase(100);
        metric2.addTag(new Tag("Location", "San Jose"));
        metric2.addTag(new Tag("Brand", "Renting"));
        metric2.addValue(new Value(sdf.parse("20160101"), 100));
        metric2.addValue(new Value(sdf.parse("20160102"), 100));
        metric2.addValue(new Value(sdf.parse("20160103"), 100));
        
        Level ebidta2 = new Level("Ebidta BRAC");
        ebidta2.addLevel(metric2);
        Level ebidta = new Level("EBITDA");
        ebidta.addLevel(ebidta2);
        Level financial = new Level("Financiera");
        financial.addLevel(ebidta);
        data.addLevel(financial);


        Metric metric3 = new Metric("Metric", sdf.parse("20160101"), sdf.parse("20161231"));
        metric3.setAverage(100);
        metric3.setBase(100);
        metric3.addTag(new Tag("Location", "San Jose"));
        metric3.addTag(new Tag("Brand", "Renting"));
        metric3.addValue(new Value(sdf.parse("20160101"), 100));
        metric3.addValue(new Value(sdf.parse("20160102"), 100));
        metric3.addValue(new Value(sdf.parse("20160103"), 100));
        
        Level call = new Level("Llamadas exitosas Call Center");
        call.addLevel(metric3);
        Level satisfaction = new Level("Satisfacción de Clientes");
        satisfaction.addLevel(call);
        Level client = new Level("Clientes");
        client.addLevel(satisfaction);
        data.addLevel(client);


        Metric metric4 = new Metric("Metric", sdf.parse("20160101"), sdf.parse("20161231"));
        metric4.setAverage(100);
        metric4.setBase(100);
        metric4.addTag(new Tag("Location", "San Jose"));
        metric4.addTag(new Tag("Brand", "Renting"));
        metric4.addValue(new Value(sdf.parse("20160101"), 100));
        metric4.addValue(new Value(sdf.parse("20160102"), 100));
        metric4.addValue(new Value(sdf.parse("20160103"), 100));
        
        Level execution = new Level("Cumplimiento de la induccion");
        execution.addLevel(metric4);
        Level promote = new Level("Promover una cultura enfocada en valores");
        promote.addLevel(execution);
        Level increase = new Level("Crecimiento y Aprendizaje");
        increase.addLevel(promote);
        data.addLevel(increase);
        
        return new Gson().toJson(data);
    }
}