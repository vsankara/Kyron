package com.technobrain.trips.rules.helper;

//package com.crownagents.trips.rules.helper;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//import oracle.rules.rl.RLObject;
//import oracle.rules.rl.RuleSession;
//import oracle.rules.rl.exceptions.RLException;
//import org.apache.log4j.Logger;
//
//public abstract class RuleHelper {
//    static final Logger log = Logger.getLogger(RuleHelper.class);
//   
//    /**
//     * Get the criteria for Duplicate Organization or Indiviudal.
//     * @param session
//     * @return
//     */
//    public static HashMap getCriteriaQueries(RuleSession session, final String functionName){
//    
//        ArrayList<String> queries = null;
//        oracle.rules.rl.RLObject obj = null;
//        HashMap hm = null;
//         try {
//             
//            obj = (RLObject)session.callFunction(functionName);
//            if(null != obj){
//                Short s = (short)10;
//               queries = new ArrayList<String>(s);
//                oracle.rules.rl.RLProperty temp = null;
//                for(int i=1; i<=s; i++){
//                   temp =  obj.getRLClass().getDeclaredProperty("criteria" + i);
//                    
//                   if(temp == null){
//                       break;
//                   }else{
//                      Object value = temp.get(obj);
//                      if(null != value){
//                        queries.add(String.valueOf(value));
//                      }
//                   }
//                }
//            }
//            
//             
//             hm = new HashMap();
//             hm.put("criterias",queries.toArray(new String[queries.size()]));
//             Short matchThreshold = (Short) obj.getRLClass().getDeclaredProperty("matchThreshold").get(obj);
//             hm.put("matchThreshold",matchThreshold);
//             
//         } catch (RLException e) {
//             log.error(e.getLocalizedMessage(), e);
//         }
//        
//        
//        
//       return hm;
//    
//    }
//}
