package com.technobrain.trips.rules.manager;


import com.technobrain.trips.common.constants.Constants;


import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import oracle.rules.rl.RuleSession;
import oracle.rules.rl.exceptions.RLException;
import oracle.rules.sdk.dictionary.RuleDictionary;
import oracle.rules.sdk.exception.RepositoryException;
import oracle.rules.sdk.exception.RuleSetException;
import oracle.rules.sdk.repository.*;
import org.apache.log4j.Logger;

/**
 * @Crown Agents 2009
 * <br>
 * 
 * @since $Date: 9/1/2009 3:10:21 AM$
 * @version $Revision: 15$
 * @author $Author: Howard Hill$
 * 
 * $Log[1]
 * 
 */
public class RulesManager {
    static final Logger log = Logger.getLogger(RulesManager.class);
    private static RuleRepository repository = null;
    private static Object repositoryLock = new Object();
    public static final String WEBDAVURL = "http://trips-rules/trips_rules/";
    public static final String USERNAME = "trips";
    public static final String PASSWORD = "trips";
    public static Calendar previousModifiedTime = null;

    private RulesManager() {
    }

    /*
     * Load the repo in memory for better performance
     */
    static {
        try {
            repository = loadRepository(null, WEBDAVURL, USERNAME, PASSWORD);

        } catch (Exception exp) {
            log.error(exp.getLocalizedMessage(), exp);
        }
    }

    /**
     * Loads the WebDav or Jar repository
     * @param repositoryPath
     * @param webDev
     * @param user
     * @param password
     * @return
     * @throws RepositoryException
     */
    private static RuleRepository loadRepository(String repositoryPath, 
                                                 String webDev, String user, 
                                                 String password) throws RepositoryException {
        if (webDev != null) {
            //            return getWebDAVRepository(WEBDAVURL,USERNAME,PASSWORD);
            return null;
        } else {

            return loadRepository(repositoryPath);
        }
    }

    /**
     * Loads the jar repository
     * @param repositoryPath
     * @return
     * @throws RepositoryException
     */
    private static RuleRepository loadRepository(String repositoryPath) throws RepositoryException {
        RepositoryType rt = 
            RepositoryManager.getRegisteredRepositoryType(Constants.RuleManagerConstants.RULES_FILE_STORE);
        repository = RepositoryManager.createRuleRepositoryInstance(rt);
        RepositoryContext context;
        context = new RepositoryContext();
        context.setLocale(Locale.getDefault());
        context.setProperty(repositoryPath, repositoryPath);
        repository.init(context);
        return repository;
    }

    /**
     * Load the webDav repository
     * @param urlPath
     * @param user
     * @param password
     * @return
     * @throws RepositoryException
     */
    //    static public RuleRepository getWebDAVRepository( String urlPath, String user, String password ) throws RepositoryException
    //     {
    //         RepositoryType webdavType = RepositoryManager.getRegisteredRepositoryType( oracle.rules.sdk.store.webdav.Keys.CONNECTION );
    //          RuleRepository webdavInstance = RepositoryManager.createRuleRepositoryInstance( webdavType );
    //             
    //         //fill in init property values ... we assume no proxy here
    //         RepositoryContext webdavCtx = new RepositoryContext();
    //         webdavCtx.setProperty( oracle.rules.sdk.store.webdav.Keys.URL, urlPath );
    //         webdavCtx.setProperty( oracle.rules.sdk.store.webdav.Keys.USER, user );
    //         webdavCtx.setProperty( oracle.rules.sdk.store.webdav.Keys.PASSWORD, password );
    //         //init the repository instance.  If the init is successful, 
    //         //we shall get a useable repository instance
    //         webdavInstance.init( webdavCtx );
    //
    //         return webdavInstance;
    //     }

//    /**
//     * Loads the validation rule session
//     * @return
//     * @throws RLException
//     * @throws RuleSetException
//     * @throws RepositoryException
//     */
//    public static RuleSession getValidationRuleSession() throws RLException, 
//                                                                RuleSetException, 
//                                                                RepositoryException {
//        return getSession(null,  // can not be null !!!
//                          Constants.RuleManagerConstants.VALIDATION_DICTIONARY);
//    }

    /**
     * Loads the Validation rule session
     * @return
     * @throws RLException
     * @throws RuleSetException
     * @throws RepositoryException
     */
    public static RuleSession getValidationRuleSession(String[] rulesets) throws RLException, 
                                                                                 RuleSetException, 
                                                                                 RepositoryException {
        return getSession(rulesets, 
                          Constants.RuleManagerConstants.VALIDATION_DICTIONARY);
    }

    /**
     * Loads the Analysis rule session
     * @return
     * @throws RLException
     * @throws RuleSetException
     * @throws RepositoryException
     */
    public static RuleSession getAnalysisRuleSession(String[] rulesets) throws RLException, 
                                                                               RuleSetException, 
                                                                               RepositoryException {
        return getSession(rulesets, 
                          Constants.RuleManagerConstants.ANALYSIS_DICTIONARY);
    }

    /**
     * Loads the Compute rule session
     * @return
     * @throws RLException
     * @throws RuleSetException
     * @throws RepositoryException
     */
    public static RuleSession getComputeRuleSession(String[] rulesets) throws RLException, 
                                                                              RuleSetException, 
                                                                              RepositoryException {
        return getSession(rulesets, 
                          Constants.RuleManagerConstants.COMPUTE_DICTIONARY);
    }

    /**
     * 
     * @param rulesets
     * @param dictionary
     * @return
     * @throws RLException
     * @throws RuleSetException
     * @throws RepositoryException
     */
    private static RuleSession getSession(String[] rulesets, 
                                          String dictionary) throws RLException, 
                                                                    RuleSetException, 
                                                                    RepositoryException {
        RuleSession result;
        synchronized (repositoryLock) {
            result = new RuleSession();
            RuleDictionary ruleDictionary = 
                loadDictionary(dictionary, Constants.RuleManagerConstants.DEFAULT_DICTIONARY_VERSION);
            result.executeRuleset(ruleDictionary.dataModelRL());
            result.callFunction(Constants.RuleManagerConstants.CMD_RESET);
            result.callFunction(Constants.RuleManagerConstants.CMD_CLEARRULESETSTACK);
            for (int i = 0; i < rulesets.length; i++) {
                result.executeRuleset(ruleDictionary.ruleSetRL(rulesets[i]));
                result.callFunctionWithArgument(Constants.RuleManagerConstants.CMD_PUSHRULESET, 
                                                rulesets[i]);
            }
        }
        return result;
    }

    /**
     * Loads the dictionary based on the last modified date
     * @param dictionary
     * @param VERSION
     * @return
     * @throws RepositoryException
     */
    private static RuleDictionary loadDictionary(String dictionary, 
                                                 String VERSION) throws RepositoryException {
        Date lastModifiedDate = null;
//            repository.getLastModificationTime(dictionary, VERSION);
        Calendar lastModifiedTime = Calendar.getInstance();
       // lastModifiedDate.setTime(lastModifiedDate.getTime());

        if (null == previousModifiedTime) {
            previousModifiedTime = lastModifiedTime;
        } else if (lastModifiedTime.compareTo(previousModifiedTime) > 0) {
            previousModifiedTime = lastModifiedTime;
            loadRepository(null, WEBDAVURL, USERNAME, PASSWORD);
        }

        return repository.loadDictionary(dictionary, VERSION);
    }
}
