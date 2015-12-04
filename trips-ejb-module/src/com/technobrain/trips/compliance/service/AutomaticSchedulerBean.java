package com.technobrain.trips.compliance.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;

import com.technobrain.trips.locator.ServiceLocator;
import com.technobrain.trips.reference.service.ReferenceFacadeLocal;
import com.technobrain.trips.reporting.service.AbstractTRIPSJob;

//@Stateless(name = "AutomaticSchedulerService")
public class AutomaticSchedulerBean extends AbstractTRIPSJob implements AutomaticSchedulerLocal {
    public static final Logger log = Logger.getLogger(AutomaticSchedulerBean.class);
    
    public AutomaticSchedulerBean() {
    }


	@Override
	public String executeJob(JobExecutionContext jobExecutionContext) throws Exception {
		ReferenceFacadeLocal referenceFacade =  (ReferenceFacadeLocal) ServiceLocator.getInstance().getLocalEJB("ReferenceFacade");
        
        CallableStatement cstmt = null;
        Connection con=null;
        try {
//            con = referenceFacade.getDataSource().getConnection();
//            cstmt =  con.prepareCall("call schedule_compliance_pkg. schedule_compliance_prc()");
//            cstmt.execute();  
        }catch(Exception exc) {
            log.error(exc.getLocalizedMessage(), exc);
            return "ERROR " + exc.getMessage();
        } finally {
            try {
                if (cstmt != null) cstmt.close();
                if (con != null) con.close();
            } catch(SQLException exc) {
                log.error(exc.getLocalizedMessage(), exc);
            }
        }
        return "SUCCESS";
	}

    public boolean isRunning() {
        return false;
    }

    public void execute(JobExecutionContext jobExecutionContext) {
    }
}
