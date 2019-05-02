/**
 * Alexandra Kerans and Brianna Bukowski
 * 2 May 2019
 * ChoiceTester Main
 * Testing the methods in the choicemap class
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ChoiceTester
{
    /**
     * Default constructor for objects of class ChoiceTester
     */
    public static void main(String[] args)
    {
        ArrayList<Integer> keys = new ArrayList<Integer>();
        keys.add(1);
        keys.add(2);
        keys.add(3);
        
        ArrayList<int[]> keyVals = new ArrayList<int[]>();
        int[] v1 = {10, 11};
        int[] v2 = {20, 22};
        int[] v3 = {30, 33};       
        keyVals.add(v1);
        keyVals.add(v2);
        keyVals.add(v3);
        
        System.out.println(keys);
        System.out.println(keyVals);
        //choice map obj
        //ChoiceMap myChoices = new ChoiceMap(keys, keyVals);
        
        //myChoices.setKey(1);
       // System.out.println(myChoices.getKey());
        //System.out.println(myChoices.getKeyValues());
        
        Map <Integer, int[]> test = new HashMap<>();
        
        test.put(1, v1);
        System.out.println(test.get(1));
        
        
        
        
        
        
    }
}
