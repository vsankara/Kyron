package com.technobrain.trips.moduluscheckdigits;
 
  import java.io.Serializable;
  
  public final class Modulus10CheckDigit extends ModulusCheckDigit implements Serializable {
  
      /**Singleton Luhn Check Digit instance.
     */
      public static final CheckDigit INSTANCE = new Modulus10CheckDigit();
  
      /*** weighting given to digits depending on their right position */
      private static final int[] POSITION_WEIGHT = new int[] {2, 1};
  
      public Modulus10CheckDigit() {
          super(10);
      }
  
      protected int weightedValue(int charValue, int leftPos, int rightPos) {
          int weight = POSITION_WEIGHT[rightPos % 2];
          int weightedValue = (charValue * weight);
          return (weightedValue > 9 ? (weightedValue - 9) : weightedValue);
      }
    public static void main(String arg[]) throws Exception{
        Modulus10CheckDigit modulus10CheckDigit=new Modulus10CheckDigit();
        log.debug(modulus10CheckDigit.calculate(arg[0]));
    }
  }

