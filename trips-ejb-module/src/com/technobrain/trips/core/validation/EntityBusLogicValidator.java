package com.technobrain.trips.core.validation;

import com.technobrain.trips.common.helpers.DateHelper;
import com.technobrain.trips.common.helpers.StringHelper;
import com.technobrain.trips.core.message.IdentificationType;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class EntityBusLogicValidator extends BusinessLogicValidator {
    protected EntityBusLogicValidator() {
    }

    /**
     * validates the dates
     * @param idType
     * @return errors
     */
    public List<String> checkErrorsForIdentificationDates(IdentificationType idType) {
        List<String> errors = new ArrayList<String>();
        if (idType != null) {
            // check whether the expiry date is after the effective date
            if (idType.getEffectiveDate() != null && 
                idType.getExpiryDate() != null && 
                idType.getEffectiveDate().compareTo(idType.getExpiryDate()) > 
                0) {
                errors.add("Identification.errorMessage.ExpiryDateSmaller");
            } else {
                // do nothing
            }


            if (idType.getExpiryDate() != null && 
                DateHelper.compareDates(idType.getExpiryDate(), 
                                        Calendar.getInstance()) != 0) {
                // check whether the expiry date is after the current date
                if (DateHelper.compareDates(idType.getExpiryDate(), 
                                            Calendar.getInstance()) < 0) {
                    errors.add("Identification.errorMessage.IdentificationExpiryDate");
                }
                // check whether the effective date is before the current date
                //                else if (DateHelper.compareDates(idType.getEffectiveDate(), 
                //                                            Calendar.getInstance()) > 0) {
                //                    errors.add("Identification.errorMessage.IdentificationEffectiveDate");
                //                } 
                else {
                    // do nothing
                }
            } else {
                // do nothing
            }
            // check whether the date of signature is before the effective date (date of issue)
            if (idType.getEffectiveDate() != null && 
                idType.getDateOfSignature() != null && 
                idType.getDateOfSignature().compareTo(idType.getEffectiveDate()) > 
                0) {
                errors.add("Identification.errorMessage.IdentificationDateOfSignature");
            } else {
                // do nothing
            }
			            // check whether the effective date is before the current date
            if (idType.getEffectiveDate() != null && 
                DateHelper.compareDates(idType.getEffectiveDate(), 
                                        Calendar.getInstance()) > 0) {
                errors.add("Identification.errorMessage.IdentificationEffectiveDate");
            }
        } else {
            // do nothing;
        }
        return errors;

    }
}
