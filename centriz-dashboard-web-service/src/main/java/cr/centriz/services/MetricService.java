package cr.centriz.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;

import cr.centriz.dashboard.dao.clients.ClientsDaoHandler;
import cr.centriz.entities.data.Data;
import cr.centriz.entities.data.Header;
import cr.centriz.entities.data.Level;
import cr.centriz.entities.data.Metric;

public class MetricService<T> {
    private static final Log logger = LogFactory.getLog(MetricService.class);
    private ClientsDaoHandler<T> clientsDao;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();

    public String getMetricsByDate(String sd, String ed) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Data data = new Data("Centriz");
        data.addHeader(new Header("Unidad de negocios"));
        data.addHeader(new Header("KPI Primario"));
        data.addHeader(new Header("KPI Secundario"));

        // Financiera
        Level financiera = new Level("Financiera");

        // KPI Primario
        Level ebitda = new Level("Ebitda");
        financiera.addLevel(ebitda);
        // KPI Secundarios
        Metric ebitdaBRAC = new Metric("Ebitda BRAC", sdf.parse("20160101"), sdf.parse("20161231"));
        ebitda.addLevel(ebitdaBRAC);
        Metric ebitdaRENT = new Metric("Ebitda RENT", sdf.parse("20160101"), sdf.parse("20161231"));
        ebitda.addLevel(ebitdaRENT);

        // KPI Primario
        Level SF = new Level("Salud financiera");
        financiera.addLevel(SF);
        // KPI Secundarios
        Metric costoFinanciero = new Metric("Costo financiero", sdf.parse("20160101"), sdf.parse("20161231"));
        SF.addLevel(costoFinanciero);
        Metric patrimonioNeto = new Metric("Patrimonio neto tangible", sdf.parse("20160101"), sdf.parse("20161231"));
        SF.addLevel(patrimonioNeto);

        // KPI Primario
        Level RVV = new Level("Rendimiento de vehiculos vendidos");
        financiera.addLevel(RVV);
        // KPI Secundario
        Metric precioCeroStress = new Metric("Precio cero stress", sdf.parse("20160101"), sdf.parse("20161231"));
        RVV.addLevel(precioCeroStress);
        Metric precioDealer = new Metric("Precio dealer", sdf.parse("20160101"), sdf.parse("20161231"));
        RVV.addLevel(precioDealer);

        // Clientes
        Level clientes = new Level("Clientes");

        // KPI Primario
        Level satisfaccionClientes = new Level("Satisfaccion de clientes");
        clientes.addLevel(satisfaccionClientes);
        // KPI Secundarios
        // test
        clientsDao = new ClientsDaoHandler<>();
        clientsDao.run();
        Metric satisfaccionGeneral = clientsDao.getMetric();// new
                                                            // Metric("Satisfaccion
                                                            // general budget",
                                                            // sdf.parse("20160101"),
                                                            // sdf.parse("20161231"));
        clientsDao.clear();
        satisfaccionClientes.addLevel(satisfaccionGeneral);
        Metric satisfaccionRenting = new Metric("Satisfaccion de cliente de Renting", sdf.parse("20160101"),
                sdf.parse("20161231"));
        satisfaccionClientes.addLevel(satisfaccionRenting);

        // KPI Primario
        Level CPC = new Level("Cumplir con plan de clientes");
        clientes.addLevel(CPC);
        // KPI Secundarios
        Metric CPM = new Metric("Cumplimiento de presupuesto Mayorista", sdf.parse("20160101"), sdf.parse("20161231"));
        CPC.addLevel(CPM);
        Metric CAC = new Metric("Clientes Activos Corporativos", sdf.parse("20160101"), sdf.parse("20161231"));
        CPC.addLevel(CAC);

        // Procesos
        Level procesos = new Level("Procesos");

        // KPI Primario
        Level IVS = new Level("Inventario de vehiculo por segmento");
        procesos.addLevel(IVS);
        // KPI Secundarios
        Metric BRAC = new Metric("BRAC", sdf.parse("20160101"), sdf.parse("20161231"));
        IVS.addLevel(BRAC);
        Metric RENTING = new Metric("RENTING", sdf.parse("20160101"), sdf.parse("20161231"));
        IVS.addLevel(RENTING);

        // KPI Primario
        Level RPUOperativo = new Level("RPU Operativo");
        procesos.addLevel(RPUOperativo);
        // KPI Secundarios
        Metric ocupacion = new Metric("Ocupacion", sdf.parse("20160101"), sdf.parse("20161231"));
        RPUOperativo.addLevel(ocupacion);
        Metric TPBRAC = new Metric("Tarifa Promedio BRAC", sdf.parse("20160101"), sdf.parse("20161231"));
        RPUOperativo.addLevel(TPBRAC);

        // Crecimiento y aprendizaje
        Level crecimientoAprendizaje = new Level("Crecimiento y aprendizaje");

        // KPI Primario
        Level KAIZEN = new Level("KAIZEN");
        crecimientoAprendizaje.addLevel(KAIZEN);
        // KPI Secundarios
        Metric ISO = new Metric("Programa de ISO", sdf.parse("20160101"), sdf.parse("20161231"));
        KAIZEN.addLevel(ISO);
        Metric avances = new Metric("Avances de Sururaku", sdf.parse("20160101"), sdf.parse("20161231"));
        KAIZEN.addLevel(avances);

        // KPI Primario
        Level cultura = new Level("Promover una cultura enfocada en valores");
        crecimientoAprendizaje.addLevel(RPUOperativo);
        // KPI Secundarios
        Metric cumplimientoInduccion = new Metric("Cumplimiento de la induccion", sdf.parse("20160101"),
                sdf.parse("20161231"));
        cultura.addLevel(cumplimientoInduccion);
        Metric cumplimientoCultura = new Metric("Cumplimiento plan de Cultura Organizacional Anual",
                sdf.parse("20160101"), sdf.parse("20161231"));
        cultura.addLevel(cumplimientoCultura);

        data.addLevel(financiera);
        data.addLevel(clientes);
        data.addLevel(procesos);
        data.addLevel(crecimientoAprendizaje);

        return new Gson().toJson(data);
    }

}