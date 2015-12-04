package com.technobrain.trips.core;

//package com.crownagents.trips.core;
//
//import com.crownagents.trips.security.UserAccount;
//
//import java.util.Iterator;
//import java.util.Locale;
//
//import javax.faces.application.ViewHandler;
//import javax.faces.context.FacesContext;
//
//import org.apache.myfaces.trinidadinternal.application.ViewHandlerImpl;
//
////import oracle.adfinternal.view.faces.application.ViewHandlerImpl;
//
//
///**
// * Custom View Handler used to set the default local of the application
// * @author hhill
// */
//public class CustomViewHandler extends ViewHandlerImpl {
//    protected ViewHandler baseViewHandler;
//    
//    public CustomViewHandler(ViewHandler baseViewHandler){
//        super(baseViewHandler);
//    }
//    public Locale calculateLocale(FacesContext facesContext) {
//        Iterator iterator = facesContext.getApplication().getSupportedLocales();
//        String tripsWebCountry = getConfiguredLocale(facesContext);
//        Locale supportedLocale = null;
//        while(iterator.hasNext()){
//            supportedLocale = (Locale)iterator.next();
//            if(null != supportedLocale.getCountry() && supportedLocale.getCountry()
//                .equalsIgnoreCase(tripsWebCountry)){
//                return supportedLocale;
//            }
//        }
//        return facesContext.getApplication().getDefaultLocale();
//    }
//
//    private String getConfiguredLocale(FacesContext facesContext) {
//        String userLocale = null;
//        UserAccount userAccount = (UserAccount)facesContext.getExternalContext().
//            getSessionMap().get(UserAccount.class);
//       
//        /*
//         * TODO: get user locale from LDAP or Database which will be set on
//         *  the useraccount
//         */
//        userLocale = "GB"; 
//        return userLocale;
//    }
//}
