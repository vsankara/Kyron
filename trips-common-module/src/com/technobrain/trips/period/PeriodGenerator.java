package com.technobrain.trips.period;

import com.technobrain.trips.common.constants.Constants;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * This class auto generates Periods for a Calendar year only.
 */
public class PeriodGenerator {
       
    public PeriodGenerator() {
    }
    
    /**
     * Generate the period based on the unit of time
     */
    public ArrayList<Period> generatePeriod(PeriodConfiguration config) {
        ArrayList<Period> periods = null;
        if(config.getFrequency().equals(Constants.PeriodCycleFrequency.MONTHLY)) {
            periods = generateMonthlyPeriod(config);
        }
        else if(config.getFrequency().equals(Constants.PeriodCycleFrequency.QUARTERLY)) {
            periods = generateQuarterlyPeriod(config);
        }
        else if(config.getFrequency().equals(Constants.PeriodCycleFrequency.ANNUALLY)) {
            periods = generateAnnualPeriod(config);
        }
        else if(config.getFrequency().equals(Constants.PeriodCycleFrequency.INDEFINITE)) {
            periods = generateIndefinitePeriod(config);
        }
        else if(config.getFrequency().equals(Constants.PeriodCycleFrequency.TRANSACTIONAL)) {
            periods = generateTransactionalPeriod(config);
        }
//        //Multiple frequency includes only Monthly, Quarterly and annually
//        else if(config.getFrequency().equals(Constants.PeriodCycleFrequency.MULTIPLE)) {
//            periods = generateMultiplePeriod(config);
//        }
        return periods;
    }
    
    public ArrayList<Period> generateMultiplePeriod(PeriodConfiguration config){
        ArrayList<Period> periods = null;
        if(config != null){
            String subFrequency = config.getSubFrequency();
            if(subFrequency != null){
                if(subFrequency.equals(Constants.PeriodCycleFrequency.MONTHLY)) {
                    periods = generateMonthlyPeriod(config);
                }
                else if(subFrequency.equals(Constants.PeriodCycleFrequency.QUARTERLY)) {
                    periods = generateQuarterlyPeriod(config);
                }
                else if(subFrequency.equals(Constants.PeriodCycleFrequency.ANNUALLY)) {
                    periods = generateAnnualPeriod(config);
                }      
            }
        }
        return periods;
    }
       

    
    public ArrayList<Period> generateMonthlyPeriod( PeriodConfiguration config){
        ArrayList<Period> periods = new ArrayList<Period>();
      
        GregorianCalendar startCalendar = new GregorianCalendar(); 
        startCalendar.setTime( config.getGenerationStartDate() );
        
                
      
        int endMonth = config.getAccountEndMonth();
        GregorianCalendar regisCal = new GregorianCalendar();
        regisCal.setTime(config.getGenerationStartDate());
        int startMonth =regisCal.get(Calendar.MONTH);
        int quantity =0;
        if(endMonth>startMonth){
            if(config.getAccountEndDay()>=regisCal.get(Calendar.DATE)){
                quantity=(endMonth-startMonth)+1;
            }else{
                quantity=(endMonth-startMonth);
            }
            
        } else  if(endMonth == startMonth){
            if(config.getAccountEndDay()>=regisCal.get(Calendar.DATE)){
                quantity=(endMonth-startMonth)+1;
            }else{
               quantity=12;
            }
            
        } else{
            quantity=(endMonth+13)-startMonth;
        }
        
        for(int i=0; i < quantity; i++){
            if(i>0){
                startCalendar.add(Calendar.MONTH, 1);
            }
            
            Period period = new Period();
            period.setPeriodStart(startCalendar.getTime());           

            GregorianCalendar endCalendar = new GregorianCalendar();
            endCalendar.setTime(startCalendar.getTime());
            endCalendar.add(Calendar.MONTH, 1); // adding 1 months
            endCalendar.add(Calendar.DATE, -1); // this will give us the last day of the previous month.        
            
            period.setPeriodEnd(endCalendar.getTime());
            period.setPeriodYear(endCalendar.get(Calendar.YEAR));
            period.setPeriodNumber( (config.getQuantity() - quantity)+i + 1 );
            period.setPeriodLabel(  (this.formatDate(endCalendar.getTime(), "MMM")) + " " + period.getPeriodYear()  );
            period.setPeriodType(Constants.PeriodCycleFrequency.MONTHLY);
            period.setTaxReturnType(config.getTaxReturnType());
            periods.add(period);
             
        }
        return periods;
    }
    
    public int getQuarterNumberBasedOnRegMonth (int accEndMonth, int regMonth){
        Integer qtr = null;
        for (int quarter =1; quarter <=4; quarter++){
            int startMonthOfPeriod = accEndMonth + 3*quarter - 2;
            if(startMonthOfPeriod > 12) {
                startMonthOfPeriod = startMonthOfPeriod -12;
            }
            
            int endMonthOfPeriod = accEndMonth + 3*quarter;
            if(endMonthOfPeriod > 12){
                endMonthOfPeriod = endMonthOfPeriod -12;
            }    
                
            if (startMonthOfPeriod <= regMonth && regMonth <= endMonthOfPeriod ){
                qtr= quarter;
                break;
            }
        }
        return qtr;
    } 

    public int getQuarterNumberBasedOnEndMonth (int accEndMonth, int forMonth){
        int qtr = 0;
        for (int quarter =1; quarter <=4; quarter++){
            int endMonthOfPeriod = accEndMonth + 3*quarter;
            if(endMonthOfPeriod > 12){
                endMonthOfPeriod = endMonthOfPeriod -12;
            }    
            if (endMonthOfPeriod == forMonth){
                qtr= quarter;
                break;
            }
        }
        return qtr;
    } 

    
    public ArrayList<Period> generateQuarterlyPeriod(PeriodConfiguration config){
    
        Calendar  cycleEndDate = getGenerationEndDate(config);
        ArrayList<Period> periods = new ArrayList<Period>();
        Calendar generationStartDate = Calendar.getInstance();
        generationStartDate.setTime(config.getGenerationStartDate());
        
        int taxYear = cycleEndDate.get(Calendar.YEAR);
        for(int i=4;i>=1;i--){
        
            
            Calendar  periodEndDate= Calendar.getInstance();
            periodEndDate.setTime(cycleEndDate.getTime());
            
            int maximumDaysonLastPeriodEnd = cycleEndDate.getActualMaximum(Calendar.DATE);
            int lastPeriodEndDate = cycleEndDate.get(Calendar.DATE);
            
            cycleEndDate.add(Calendar.MONTH,-3);
            
            if(maximumDaysonLastPeriodEnd==lastPeriodEndDate){
                cycleEndDate.set(Calendar.DATE,cycleEndDate.getActualMaximum(Calendar.DATE)) ;
            }
                       
            
            Period period = new Period();
            
            Calendar  periodStartDate= Calendar.getInstance();
            periodStartDate.setTime(cycleEndDate.getTime());
            periodStartDate.add(Calendar.DATE,1);
           
            period.setPeriodStart(periodStartDate.getTime());
            period.setPeriodEnd(periodEndDate.getTime());
            period.setPeriodYear(periodStartDate.get(Calendar.YEAR)); 
            //period.setPeriodYear(taxYear);
            period.setPeriodNumber(i);
            period.setPeriodQuarter(i);
            period.setPeriodLabel(Constants.PERIOD_QUARTER_LABEL + i + Constants.PERIOD_LABEL_SEPARATOR + "" +taxYear);
            period.setPeriodType(Constants.PeriodCycleFrequency.QUARTERLY);
            period.setTaxReturnType(config.getTaxReturnType());
                       
            periods.add(period);
                        
            if(generationStartDate.after(cycleEndDate)){
                break;
            }
        }
        
        return periods;
    }
    
   
    public ArrayList<Period> generateAnnualPeriod(PeriodConfiguration config){
            ArrayList<Period> periods = new ArrayList<Period>();
           
            GregorianCalendar startCalendar = new GregorianCalendar(); 
            startCalendar.setTime( config.getGenerationStartDate() );
        
            Period period = new Period();
           

            GregorianCalendar endCalendar = new GregorianCalendar();
            if(config.isFiscalYearIndicator()){
                Calendar  generatedEndDate = getGenerationEndDate(config);
                endCalendar.setTime(generatedEndDate.getTime());
                
                Calendar  startTime = Calendar.getInstance();
                    startTime.setTime(generatedEndDate.getTime());
                startTime.add(Calendar.YEAR,-1);
                startTime.add(Calendar.DATE, 1);
                period.setPeriodStart(startTime.getTime());
                
            }else{
                endCalendar.setTime(startCalendar.getTime());
                endCalendar.add(Calendar.YEAR, +1); // ading another year
                endCalendar.add(Calendar.DATE, -1); // this will give us the last day of the previous month.
                 period.setPeriodStart(startCalendar.getTime());
            }
//            
            period.setPeriodEnd(endCalendar.getTime());
            period.setPeriodYear(endCalendar.get(Calendar.YEAR));
            period.setPeriodNumber(1);

            period.setPeriodLabel(Constants.PERIOD_ANNUAL_LABEL + " " + (this.formatDate(endCalendar.getTime(), "yyyy")));
            period.setPeriodType(Constants.PeriodCycleFrequency.ANNUALLY);  
            period.setTaxReturnType(config.getTaxReturnType());
           

            periods.add( period );
      //  }

        return periods;
    }
    
    public ArrayList<Period> generateIndefinitePeriod(PeriodConfiguration config){
        ArrayList<Period> periods = new ArrayList<Period>();
        //Create a calendar for monthly period start date
        GregorianCalendar startCalendar = new GregorianCalendar(); 
        startCalendar.setTime(config.getGenerationStartDate());
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);

        GregorianCalendar registrationCalendar = new GregorianCalendar();
        registrationCalendar.setTime(config.getGenerationStartDate());
        
        for(int i=0; i<config.getQuantity(); i++){
            //Add one month to the start and end calendar
            if(i>0){
                startCalendar.add(Calendar.YEAR, 1);
            }
            
            Period period = new Period();
            period.setPeriodStart(startCalendar.getTime());
            period.setPeriodYear(startCalendar.get(Calendar.YEAR));
            period.setPeriodNumber( startCalendar.get(Calendar.MONTH) + 1 );
//            period.setPeriodLabel(Constants.PERIOD_ANNUAL_LABEL + " " + (this.formatDate(endCalendar.getTime(), "yyyy")));
            period.setPeriodType(Constants.PeriodCycleFrequency.INDEFINITE);
            period.setTaxReturnType(config.getTaxReturnType());
            periods.add(period);
        }
        return periods;
    }
    
    public ArrayList<Period> generateTransactionalPeriod(PeriodConfiguration config){
        ArrayList<Period> periods = new ArrayList<Period>();
        //Create a calendar for monthly period start date
        GregorianCalendar startCalendar = new GregorianCalendar(); 
        startCalendar.setTime(config.getGenerationStartDate());
//      startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        GregorianCalendar registrationCalendar = new GregorianCalendar();
        registrationCalendar.setTime(config.getGenerationStartDate());
//        for(int i=0; i<config.getQuantity(); i++){
//        //Add one month to the start and end calendar
//        if(i>0){
//            startCalendar.add(Calendar.MONTH, 1);
//            log.debug(dateformatter.format(startCalendar.getTime()));
//        }
        Period period = new Period();
        period.setPeriodStart(startCalendar.getTime());
        period.setPeriodEnd(startCalendar.getTime());
        period.setPeriodYear(startCalendar.get(Calendar.YEAR));
        period.setPeriodNumber( startCalendar.get(Calendar.MONTH) + 1 );
//      period.setPeriodLabel(Constants.PERIOD_ANNUAL_LABEL + " " + (this.formatDate(endCalendar.getTime(), "yyyy")));
        period.setPeriodType(Constants.PeriodCycleFrequency.TRANSACTIONAL);
        period.setTaxReturnType(config.getTaxReturnType());
        periods.add(period);
//        }
        return periods;
    }
    
    /**
     * Returns a String date based on a specific format.
     * @param date
     * @param format
     * @return
     */
    public String formatDate(Date date, String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }
    
    /**
     * This method determines the quarter in a Calendar year
     * @param   date    The date to base the quarter in.
     * @return  An Integer representing the quarter.
     */
    public Integer determineQuarter(Date date){
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
       
        if(month >= Calendar.JANUARY && month <= Calendar.MARCH){
            return 1;
        }
        else if(month >= Calendar.APRIL && month <= Calendar.JUNE){
            return 2;
        }
        else if(month >= Calendar.JULY && month <= Calendar.SEPTEMBER){
            return 3;
        }
        else{
            return 4;
        }
    }
    
    /**
     * Checks if the given date is a last month in a quarter of a Calendar year.
     * @param date
     * @return
     */
    public boolean isLastMonthOfQuarter(Date date){
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        if(month == Calendar.MARCH || month == Calendar.JUNE || month == Calendar.SEPTEMBER || month == Calendar.DECEMBER){
            return true;
        }
        return false;
    }
    
    /**
     * Checks if the given date is the end of a Calendar year.
     * @param date
     * @return
     */
    public boolean isLastMonthOfYear(Date date){
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        if(month == Calendar.DECEMBER){
            return true;
        }
        return false;
    }
    
        
    private Calendar getGenerationEndDate(PeriodConfiguration periodConfig){
        Calendar todayDate =Calendar.getInstance();
                
        Calendar derivedPeriodEndDate = Calendar.getInstance();
        derivedPeriodEndDate.set(Calendar.MONTH,periodConfig.getAccountEndMonth());
        derivedPeriodEndDate.set(Calendar.DATE,periodConfig.getAccountEndDay());
        if(periodConfig.getAccountEndMonth()<todayDate.get(Calendar.MONTH)){
            derivedPeriodEndDate.set(Calendar.YEAR,todayDate.get(Calendar.YEAR)+1);
        }else  if(periodConfig.getAccountEndMonth()==todayDate.get(Calendar.MONTH) && 
                periodConfig.getAccountEndDay()<todayDate.get(Calendar.DATE)){
            derivedPeriodEndDate.set(Calendar.YEAR,todayDate.get(Calendar.YEAR)+1);
        }
        
        return derivedPeriodEndDate;
    }  
        

}
