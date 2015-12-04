package com.technobrain.trips.moduluscheckdigits;
import java.io.Serializable;

 public final class Modulus13CheckDigit extends ModulusCheckDigit implements Serializable {
  
      public static final CheckDigit INSTANCE = new Modulus13CheckDigit();
  
      private static final int[] POSITION_WEIGHT = new int[] {3, 1};
  
      public Modulus13CheckDigit() {
          super(10);
      }
  
      protected int weightedValue(int charValue, int leftPos, int rightPos) {
          int weight = POSITION_WEIGHT[rightPos % 2];
          return (charValue * weight);
      }
  }
