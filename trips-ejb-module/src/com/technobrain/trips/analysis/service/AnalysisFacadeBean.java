package com.technobrain.trips.analysis.service;

import com.technobrain.trips.core.service.FacadeBean;
import com.technobrain.trips.entity.service.EntityFacadeLocal;
import com.technobrain.trips.revenueaccount.service.RevenueAccountFacadeLocal;
import com.technobrain.trips.core.message.RegimeAccountType;
import com.technobrain.trips.core.message.ReturnsInputType;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;



@Stateless(name = "AnalysisFacade",mappedName="AnalysisFacade")
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class AnalysisFacadeBean extends FacadeBean implements AnalysisFacadeLocal, AnalysisFacadeRemote {

//    @PersistenceContext(unitName = "trips-ejb-module")
//    private EntityManager em;

    @EJB
    EntityFacadeLocal entityFacade;

    @EJB
    RevenueAccountFacadeLocal revenueFacade;

    public AnalysisFacadeBean() {
    }

    @Override
    public RegimeAccountType[] getImplicitRegimes(String messageType, String legalStatus, boolean rgdRegistration) {

        RegimeAccountType[] accountType = new RegimeAccountType[3];
        byte count = 0;
        List<String> returnList;
        List<String> returnsList = new ArrayList<>();
        ReturnsInputType rip;
        List<ReturnsInputType> returnsInputArray = null;
        Map dataMap = new HashMap();
        dataMap.put("ST-D", returnsList);
        returnsList = new ArrayList<>();
        returnsList.add("CAP-G");
        dataMap.put("CAP-G", returnsList);
        returnsList = new ArrayList<>();
        returnsList.add("GT");
        dataMap.put("GT", returnsList);
        Set set = dataMap.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry<String, ArrayList<String>> me
                    = (Map.Entry<String, ArrayList<String>>) i.next();
            returnList = me.getValue();
            if (returnList != null) {
                returnsInputArray = new ArrayList<>();
                for (int j = 0; j < returnList.size(); j++) {
                    rip = new ReturnsInputType();
                    rip.setReturnTypeCode(returnList.get(j));
                    returnsInputArray.add(rip);
                }

            }
            RegimeAccountType rg = new RegimeAccountType();
            rg.setRevenueType((String) me.getKey());
            rg.getReturnTypes().addAll(returnsInputArray);
            accountType[count++] = rg;
        }
        return accountType;
    }

}
