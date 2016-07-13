package cr.centriz.dashboard.dao.clients;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import cr.centriz.dashboard.dao.MetricSetHandler;
import cr.centriz.dashboard.dao.PropertyHandler;
import cr.centriz.entities.data.Metric;
import net.sourceforge.jtds.jdbcx.JtdsDataSource;

public class ClientsDaoHandler<T> extends MetricSetHandler<T> {
    private static final Log logger = LogFactory.getLog(ClientsDaoHandler.class);
    private PropertyHandler properties = new PropertyHandler();
    private Multiset<String> multiset = HashMultiset.create();

    @Override
    protected void process(ResultSet rs) throws SQLException {
        Rental bean = getBeanProcessor().toBean(rs, Rental.class);
        multiset.add(bean.getLastName() + "-" + bean.getFirstName());
    }

    @Override
    protected void end() {
        logger.info("multiset.size() " + multiset.size());
    }

    public Metric getMetric() {
        Metric metric = new Metric("Clients", new Date(),new Date());
        metric.setAverage(multiset.elementSet().size());
        metric.setBase(2180);
        return metric;
    }
    
    public void clear() {
        multiset.clear();
        logger.info("Close!");
    }

    protected JtdsDataSource getDataSource() {
        JtdsDataSource ds = new JtdsDataSource();
        ds.setUser(properties.getValue("user"));
        ds.setPassword(properties.getValue("password"));
        ds.setServerName(properties.getValue("server"));
        int port = Integer.parseInt(properties.getValue("port"));
        ds.setPortNumber(port);
        ds.setDatabaseName(properties.getValue("db"));
        return ds;
    }

    protected String buildQuery() {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from ");
        sb.append("( ");
        sb.append("select ");
        sb.append("EL_RENTAL_AGREEMENT_NUMBER as Id, ");
        sb.append("SUBSTRING(EL_FLT_OSL, 0, charindex(',',EL_FLT_OSL)) as LastName, ");
        sb.append("SUBSTRING(EL_FLT_OSL, charindex(',', EL_FLT_OSL)+1, len(EL_FLT_OSL)) as FirstName, ");
        sb.append("CheckouTime = CAST(EL_CHECKOUT_DATE  AS DATETIME)+CAST(EL_CHECKOUT_TIME AS DATETIME), ");
        sb.append("CheckinTime = CAST(EL_CHECKIN_DATE AS DATETIME)+CAST(EL_CHECKIN_TIME AS DATETIME), ");
        sb.append(
                "DATEDIFF (s, CAST(EL_CHECKOUT_DATE AS DATETIME)+CAST(EL_CHECKOUT_TIME AS DATETIME), CAST(EL_CHECKIN_DATE AS DATETIME)+CAST(EL_CHECKIN_TIME AS DATETIME)) as Usage, ");
        sb.append("EL_FLT_VEH_IDENT_NUMBER as Vehicle, ");
        sb.append("EL_VEH_MAKE_MODEL_DESC as MakeModel, ");
        sb.append("EL_VEH_EXTERIOR_COLOR_CODE as Color, ");
        sb.append("EL_VEHICLE_LICESE_PLATE_NUMBER as Plate, ");
        sb.append("EL_WIZ_CO_STA_MNEM_CD as CheckOutStation, ");
        sb.append("EL_WIZ_CI_STA_MNEM_CD as CheckInStation, ");
        sb.append("EL_WIZ_PREV_CO_STA_MNEM_CD as PreviousCheckOutStation, ");
        sb.append("EL_WIZ_PREV_CI_STA_MNEM_CD as PreviousCheckInStation, ");
        sb.append(
                "row_number() over (partition by EL_RENTAL_AGREEMENT_NUMBER order by EL_RUN_DATE_TIME desc) as Sequence ");
        sb.append(
                "from [Fleet_File] WHERE not EL_FLT_OSL LIKE 'RMT%' and not datalength(EL_FLT_OSL)=0 and EL_CHECKOUT_DATE >= DATEADD(month,-1,GETDATE()) ");
        sb.append(") as duplicates ");
        sb.append("where Sequence = 1 and Usage > 60 ");
        sb.append("order by Id,LastName, FirstName ");
        return sb.toString();
    }

}
