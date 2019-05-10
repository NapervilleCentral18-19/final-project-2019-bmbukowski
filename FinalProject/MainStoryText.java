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

//THIS TEXT STORY WORKS
//But, the user can just enter whatever he wants,
// so need to restrict choices to only the ones currently available
// can do this through graphics (only allowing 2 buttons to press)

public class MainStoryText
{
     
    public void main(String[] args)
    {
        //all the choice keys
        int[] keys = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //0=DIE
        //100=WIN
        //1=waterpark, 2=sleep, 3=uber, 4=walk, 5=straight uber, 
        //6=mcdonalds uber, 7=mcdonalds walk, 8=kidnap, 9=nextdoor to waterpark,
        //10=shake die, 11=stay outside the park but take pictures,
        //12=venture inside the park, 13=go upstairs unstable die,
        //14=go downstairs find money
        //15=WIN
        
        //all the possible choices associated with the keys
        int[][] vals = { {0},    //0 LOSE(so that there are no out of bounds errors) LOSE
                         {3, 4}, //1
                         {1, 2}, //2
                         {5, 6}, //3
                         {7, 8}, //4
                         {0},    //5
                         {9, 10},//6
                         {9, 10},//7
                         {0},    //8
                         {11, 12},//9
                         {0},    //10
                         {15},   //11
                         {13, 14},//12
                         {0},    //13
                         {15},   //14
                         {15} }; //15 WIN
                         
        //text associated with choices
        String[] choicetext = {"DIE", "Go to the abandoned waterpark", "Stay home",
            "Get an Uber", "Walk to the waterpark", "Uber straight to the waterpark",
            "Uber to the McDonald's next door", "Walk to the McDonald's next door",
            "Walk straight to the waterpark", "Now walk to the waterpark",
            "Have a milkshake", "Stay outside the waterpark and take pictures",
            "Climb the fence and go inside the waterpark", "Go upstairs",
            "Go downstairs", "WIN"};
            
        String[] explaintext = {"You made the wrong choice!",
            "You decided to go to the abandoned waterpark", "You stayed home like a wuss.",
            "You called an Uber.", "You start to walk to the waterpark.",
            "You told your Uber driver to take you straight to the waterpark."+
            "\nBut it turns out that your Uber driver is an undercover cop!\nHe arrests you for going to an illegal place.",
            
            "You told your Uber driver to drop you off at McDonald's.",
            "You walked to the McDonald's next door.",
            "You walked straight to the waterpark.\nBut there is a kidnapper waiting there and he kidnaps you!",
            "You walked to the waterpark after waiting a little while in McDonald's",
            "You drank a milkshake.\nBut the McDonald's worker accidentally poisoned your milkshake and you die!",
            "You stayed outside the waterpark, a safe choice, but not very adventurous.",
            "You climbed the fence around the waterpark and enter an abandoned ticket booth.",
            "You went upstairs, but the floor is unstable!\nYou fall through the floor and break your leg.",
            "You went downstairs, and found a buried chest! It contained $500!",
            "You made the right choices!"};
            
        //choice the player has currently chosen 
        //starts off as 2 (stay home) so that it starts with correct choices (1 and 2)
        int chosenChoice = 2;   
        
    
        Scanner inputer = new Scanner(System.in);
        ChoiceMap myChoices = new ChoiceMap(keys, vals);
        myChoices.setKey(chosenChoice);
        
        //game doesn't end until the player either 1.dies, 2.wins, 3.stays home
        System.out.println("You wake up one morning and want to go have an adventure.\n"+
        "You know of a spooky abandoned waterpark near by, and have been wanting to visit it for a while.\n");
        while(myChoices.getKey() != 0 && myChoices.getKey() != 15)
        {
            if(myChoices.getKeyValues().length > 1)
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
