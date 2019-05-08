/**
 * Alexandra Kerans and Brianna Bukowski
 * 7 May 2019
 * Main Story Test
 * Trying to run an entire story with choices as a test (no graphics)
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class MainStoryTest
{
     
    public static void main(String[] args)
    {
        //all the choice keys
        int[] keys = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //0=DIE
        //100=WIN
        //1=waterpark, 2=sleep, 3=uber, 4=walk, 5=straight uber, 
        //6=mcdonalds uber, 7=mcdonalds walk, 8=kidnap, 9=nextdoor,
        //10=shake
        
        //all the possible choices associated with the keys
        int[][] vals = { {0},    //0 (so that there are no out of bounds errors)
                         {3, 4}, //1
                         {1, 2}, //2
                         {5, 6}, //3
                         {7, 8}, //4
                         {0},    //5
                         {9, 10},//6
                         {9, 10},//7
                         {0},    //8
                         {100},  //9
                         {0} };  //10
                         
        //text associated with choices
        String[] choicetext = {"DIE", "Go to the abandoned waterpark", "Stay home",
            "Get an Uber", "Walk to the waterpark", "Uber straight to the waterpark",
            "Uber to the McDonald's next door", "Walk to the McDonald's next door",
            "Walk straight to the waterpark", "Now walk to the waterpark",
            "Have a milkshake"};
            
        String[] explaintext = {"You made the wrong choice!",
            "You decided to go to the abandoned waterpark", "You stayed home like a wuss.",
            "You called an Uber.", "You start to walk to the waterpark.",
            "You told your Uber driver to take you straight to the waterpark."+
            "\nBut it turns out that your Uber driver is an undercover cop!\nHe arrests you for going to an illegal place.",
            
            "You told your Uber driver to drop you off at McDonald's.",
            "You walked to the McDonald's next door.",
            "You walked straight to the waterpark.\nBut there is a kidnapper waiting there and he kidnaps you!",
            "You drank a milkshake. But the McDonald's worker accidentally poisoned your milkshake!", "test"};
            
        //choice the player has currently chosen 
        //starts off as 2 (stay home) so that it starts with correct choices (1 and 2)
        int chosenChoice = 2;   
        
    
        Scanner inputer = new Scanner(System.in);
        ChoiceMap myChoices = new ChoiceMap(keys, vals);
        myChoices.setKey(chosenChoice);
        
        //game doesn't end until the player either 1.dies, 2.wins, 3.stays home
        System.out.println("You wake up one morning and want to go have an adventure.\n"+
        "You know of a spooky abandoned waterpark near by, and have been wanting to visit it for a while.\n");
        while(myChoices.getKey() != 0 && myChoices.getKey() != 100)
        {
            if(myChoices.getKeyValues().length - 1 > 0)
            {
                System.out.println("Will you:\n"
                +myChoices.getKeyValues()[0]+". "+choicetext[myChoices.getKeyValues()[0]]+"\n"
                +myChoices.getKeyValues()[1]+". "+choicetext[myChoices.getKeyValues()[1]]);
                
                System.out.print("\nEnter your choice (integer): ");
                chosenChoice = inputer.nextInt();
                
                myChoices.setKey(chosenChoice);
                System.out.println();
            }
            else{
                myChoices.setKey(myChoices.getKeyValues()[0]);
                chosenChoice = myChoices.getKeyValues()[0];
            }
            
            //text that explains your choice "you did this"
            System.out.println(explaintext[chosenChoice]);
            System.out.println();
        }
        
        System.out.println("THE END");
    }      
}
