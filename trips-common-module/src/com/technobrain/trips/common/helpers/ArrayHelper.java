package com.technobrain.trips.common.helpers;

import com.technobrain.trips.core.message.AdditionalField;

import java.lang.reflect.Array;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class ArrayHelper {
    static final Logger log = Logger.getLogger(ArrayHelper.class);
    private ArrayHelper() {
    }
    
    public static <T> List<T> convertToList(T[] items) {
        List<T> list = new ArrayList<T>();
        if(items == null)
            return list;
        for (int i = 0; i < items.length; i++)  {
            T item = items[i];
            list.add(item);
        }
        return list;
    }
    
    public static <T> T[] addItemToArray(T[] items, T item) {
        T[] newArray = null;
        if(items == null) {
            newArray = (T[])java.lang.reflect.Array.
		newInstance(item.getClass(), 1);
        }
        else {
            // the size of the array will be 1 more than the original array.
            newArray = (T[])java.lang.reflect.Array.
		newInstance(items.getClass().getComponentType(), items.length + 1);
        }
        // copy the existing items.
        for (int i = 0; i < newArray.length - 1; i++)  {
            newArray[i] = items[i];
        }
        
        // add the array item.
        newArray[newArray.length - 1] = item;
        return newArray;
    }

    public static <T> T[] addItemsToArray(T[] existingItems, T[] newItems) {
        
        if(existingItems == null &&  newItems == null) {
            return null;
        }else if(existingItems == null){
            return newItems;
        }else if(newItems == null){
            return existingItems;
        }else{
            T[] newArray = null;

            // the size of the array will be 1 more than the original array.
            newArray = (T[])java.lang.reflect.Array.
                    newInstance(existingItems.getClass().getComponentType(), existingItems.length + newItems.length);
            // copy the existing items.
            for (int i = 0; i < existingItems.length; i++)  {
                newArray[i] = existingItems[i];
            }
            
            // copy the new items.
             for (int i = existingItems.length; i < newArray.length; i++)  {
                 newArray[i] = newItems[i-existingItems.length];
             }
             
            return newArray;
        }
    }
    
    public static  <T> T[] deleteItemFromArray(T[] items, T item) {
        if(items == null || items.length == 0)
            return null;
        if(item == null)
            return items;
        T[] newArray = (T[])Array.newInstance(item.getClass(), items.length - 1);
        int j = 0;
        for (int i = 0; i < items.length; i++)  {
            T existingItem = items[i];
            if(existingItem.equals(item)) {
                continue;
            }
            newArray[j] = existingItem;
            j++;
        }
        return newArray;
    }
    
    public static void main(String[] args) {
        String[] strs =new String[2];
        strs[0] = "kemal";
        strs[1] = "ediz";

        String[] strs2 =new String[2];
        strs2[0] = "test1";
        strs2[1] = "test2";
        
        Object[] newArry = ArrayHelper.addItemToArray(strs, null);
        //newStrs.add("alexei");
        for (int i = 0; i < newArry.length; i++)  {
            log.debug(newArry[i]);
        }
        
    }
    
    
    public static AdditionalField getAdditionalFieldFromList(AdditionalField[] listOfFields, String key) {
           
           for(AdditionalField temp: listOfFields){
               if(temp.getFieldName().equals(key)) {
                   return temp;
               }
           }
           return null;
       }
       
    public static boolean contains(Object[] array, Object comparable) {
        for(Object item:array) {
            if(item.equals(comparable)) {
                return true;
            }
        }
        return false;
    }
      
}
