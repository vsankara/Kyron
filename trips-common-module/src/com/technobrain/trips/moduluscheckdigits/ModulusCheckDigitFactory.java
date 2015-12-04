package com.technobrain.trips.moduluscheckdigits;

import com.technobrain.trips.common.constants.Constants;
import com.technobrain.trips.common.helpers.StringHelper;


public class ModulusCheckDigitFactory {
    public static CheckDigit getModulusCheckDigitInstance(String modulusType) {
        if (StringHelper.returnBlankIfNull(modulusType).equals(Constants.MODULUS_10)) {
            return new Modulus10CheckDigit();
        } else if (StringHelper.returnBlankIfNull(modulusType).equals(Constants.MODULUS_11)) {
            return new Modulus11CheckDigit();
        } else if (StringHelper.returnBlankIfNull(modulusType).equals(Constants.MODULUS_13)) {
            return new Modulus13CheckDigit();
        }
        else {
            return null;
        }
    }
}
