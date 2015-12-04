package com.technobrain.trips.core.backing;

import java.util.HashMap;


/**
 * Crown Agents 2007 
 * <p>
 * Supports the main access to sessionable accessable 
 * reference codes.
 * <p>
 * For data displayed in tables this class acts as the lookup
 * for the reference code for that code being displayed in the table.
 * <p>Also this class reduces maintenace of reference data for a user session.
 * @since $Date: 2/1/2010 9:17:49 AM$
 * @version $Revision: 41$
 * @author $Author: Vythilingam Pirabaharan$
 * 
 * $Log[1]:
 *  41   TRIPS2 etis.bir.gov.ph1.33.1.6    2/1/2010 9:17:49 AM    Vythilingam
 *       Pirabaharan Updated to display proper payment status.
 * $
 */
public class BackingReferenceCode extends BackingBase{

    private HashMap revenueAcctStatusMap;
    
    public BackingReferenceCode() {             
    }
    public HashMap getRevenueAcctStatusMap() {
        if(revenueAcctStatusMap == null){
            revenueAcctStatusMap = 
                new HashMap(1){
                    public Object get(Object key) {
                      this.put(key,getRefDelegate().findAllRevenueAccountStatus(key));
                      return super.get(key);
                    }
                };
        }
        return revenueAcctStatusMap;
    }

   
}
