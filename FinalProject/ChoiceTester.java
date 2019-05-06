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
        int[] keys = {1, 2, 3};
        
        int[][] vals = { {10, 11},
                         {20, 22},
                         {30, 33} };
                         
        //choice map obj
        ChoiceMap myChoices = new ChoiceMap(keys, vals);
        
        myChoices.setKey(1);
        System.out.println(myChoices.getKey());
        System.out.println(myChoices.getKeyValues());

        //test story
        //starting choice is 1, then the enter the number 2 or 3
        //new choice becomes 2 or 3, then show the options for the chosen choice
        
    }
}
