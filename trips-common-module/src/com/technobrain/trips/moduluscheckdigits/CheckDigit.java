package com.technobrain.trips.moduluscheckdigits;

import com.technobrain.trips.common.exceptions.CheckDigitException;

public interface CheckDigit {
  
      public String calculate(String code) throws CheckDigitException;
      public boolean isValid(String code);
  
  }
