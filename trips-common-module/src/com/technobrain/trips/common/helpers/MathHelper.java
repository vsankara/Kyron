package com.technobrain.trips.common.helpers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathHelper {
    private MathHelper() {
        
    }

    public static BigDecimal trim(BigDecimal bd, int decimallength) {
        return bd.divide(new BigDecimal(1), decimallength, RoundingMode.HALF_UP);
    }
}
