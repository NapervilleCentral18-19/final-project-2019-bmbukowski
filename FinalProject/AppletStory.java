/**
 * Alexandra Kerans
 * 10 May 2019
 * AppletStory
 * Main story in the applet with pictures hopefully
 */

import java.awt.*;
import javax.swing.*;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class AppletStory extends JApplet
{
    //all the images that correspond with a choice
    Image c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15;

    //Text story stuff
    //all the choice keys
    int[] keys = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    //0=DIE
    //100=WIN
    //1=waterpark, 2=sleep, 3=uber, 4=walk, 5=straight uber, 
    //6=mcdonalds uber, 7=mcdonalds walk, 8= continue walk-kidnap, 9=nextdoor to waterpark,
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
        
        
    Image choiceImages[] = new Image[16];     
    public void init()
    {
        //Images for story
        c0 = getImage(getDocumentBase(), "Images\\death.jpg");
        c1 = getImage(getDocumentBase(), "Images\\waterpark.jpg");
        c2 = getImage(getDocumentBase(), "Images\\stayhome.jpg");
        c3 = getImage(getDocumentBase(), "Images\\uber.jpg");
        c4 = getImage(getDocumentBase(), "Images\\walk.jpg");
        c5 = getImage(getDocumentBase(), "Images\\uberispolice.jpg");
        c6 = getImage(getDocumentBase(), "Images\\mcdonalds.jpg");
        c7 = getImage(getDocumentBase(), "Images\\mcdonalds.jpg");
        c8 = getImage(getDocumentBase(), "Images\\continuewalking.jpg");
        c9 = getImage(getDocumentBase(), "Images\\continuetowaterpark.jpg");
        c10 = getImage(getDocumentBase(), "Images\\shake.jpg");
        c11 = getImage(getDocumentBase(), "Images\\stayoutside.jpg");
        c12 = getImage(getDocumentBase(), "Images\\goinside.jpg");
        c13 = getImage(getDocumentBase(), "Images\\upstairs.jpg");
        c14 = getImage(getDocumentBase(), "Images\\downstairs.jpg");
        c15 = getImage(getDocumentBase(), "Images\\treasure.jpg");
        
        choiceImages[0] = c0;
        choiceImages[1] = c1;
        choiceImages[2] = c2;
        choiceImages[3] = c3;
        choiceImages[4] = c4;
        choiceImages[5] = c5;
        choiceImages[6] = c6;
        choiceImages[7] = c7;
        choiceImages[8] = c8;
        choiceImages[9] = c9;
        choiceImages[10] = c10;
        choiceImages[11] = c11;
        choiceImages[12] = c12;
        choiceImages[13] = c13;
        choiceImages[14] = c14;
        choiceImages[15] = c15;
        
    }
    
    public void paint(Graphics g)
    {
        /*
        myChoices.setKey(chosenChoice);
        
        //game doesn't end until the player either 1.dies, 2.wins, 3.stays home
        g.drawString("You wake up one morning and want to go have an adventure.\n"+
        "You know of a spooky abandoned waterpark near by, and have been wanting to visit it for a while.\n", 100, 100);
        while(myChoices.getKey() != 0 && myChoices.getKey() != 15)
        {
            if(myChoices.getKeyValues().length > 1)
            {
                g.drawString("Will you:\n"
                +myChoices.getKeyValues()[0]+". "+choicetext[myChoices.getKeyValues()[0]]+"\n"
                +myChoices.getKeyValues()[1]+". "+choicetext[myChoices.getKeyValues()[1]], 100, 100);
                
                g.drawString("\nEnter your choice (integer): ", 200, 100);
                chosenChoice = inputer.nextInt();
                
                myChoices.setKey(chosenChoice);
                //System.out.println();
            }
            else{
                myChoices.setKey(myChoices.getKeyValues()[0]);
                chosenChoice = myChoices.getKeyValues()[0];
            }
            
            //text that explains your choice "you did this"
            g.drawString(explaintext[chosenChoice], 300, 100);
            //System.out.println();
            //will the images in an array work?
            g.drawImage(choiceImages[chosenChoice], 30, 30, this);
            
            try{
                //pause the program for quarter second(is in milliseconds)
                Thread.sleep(250);
               }
               catch(InterruptedException e){}//<-- do nothing if exception occurs
            //if the CPU is busy and can't sleep
            
            repaint();
        }
        
        g.drawString("THE END", 400, 100);
        */
    }
}
