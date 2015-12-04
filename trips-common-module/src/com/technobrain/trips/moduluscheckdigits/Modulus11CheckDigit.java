package com.technobrain.trips.moduluscheckdigits;
 
  import java.io.Serializable;
  public final class Modulus11CheckDigit extends ModulusCheckDigit implements Serializable {
  
      /**Singleton Luhn Check Digit instance.
     */
      public static final CheckDigit INSTANCE = new Modulus11CheckDigit();
  
      /*** weighting given to digits depending on their right position */
      private static final int[] POSITION_WEIGHT = new int[] {10,9,8,7,6,5,4,3,2};
  
      public Modulus11CheckDigit() {
          super(11);
      }
  
      protected int weightedValue(int charValue, int leftPos, int rightPos) {
          int weight = POSITION_WEIGHT[9 - rightPos + 1];
          int weightedValue = (charValue * weight);
          // In ghana requirement, we should directly use the calculated weightedValue.
          //return (weightedValue > 9 ? (weightedValue - 9) : weightedValue);
          return weightedValue;
      }
    public static void main(String arg[]) throws Exception{
        Modulus11CheckDigit modulus11CheckDigit=new Modulus11CheckDigit();
        log.debug(modulus11CheckDigit.calculate(arg[0]));
    }
  }

