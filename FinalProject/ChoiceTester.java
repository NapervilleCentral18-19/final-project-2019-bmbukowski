/**
 * Alexandra Kerans and Brianna Bukowski
 * 2 May 2019
 * ChoiceTester Main
 * Testing the methods in the choicemap class
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class ChoiceTester
{
    /**
     * Default constructor for objects of class ChoiceTester
     */
    public static void main(String[] args)
    {
        Scanner inputer = new Scanner(System.in);
        
        int[] keys = {1, 2, 3, 4, 5, 6, 7};
        
        int[][] vals = { {2, 3},
                         {4, 5},
                         {6, 7},
                         {6, 7},
                         {6, 7},
                         {0},
                         {0} };
                         
        //choice map obj
        ChoiceMap myChoices = new ChoiceMap(keys, vals);
        myChoices.setKey(1);
        int choice;
        while(myChoices.getKey() != 0)
        {
            System.out.println("Your current choice is "+myChoices.getKey());
            System.out.println("Possible Choices: "+myChoices.getKeyValues()[0]+" and "+myChoices.getKeyValues()[myChoices.getKeyValues().length-1]);
            System.out.print("\nEnter your choice: ");
            choice = inputer.nextInt();
            myChoices.setKey(choice);
            System.out.println();
        }

        //test story
        //starting choice is 1, then the enter the number 2 or 3
        //new choice becomes 2 or 3, then show the options for the chosen choice
        
    }
}
