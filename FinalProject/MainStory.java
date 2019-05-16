//********************************************************************
//  LineUp.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of a graphical object.
//********************************************************************

import java.util.Random;
import java.util.*;  
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class MainStory extends Applet implements MouseListener
{
   private final int APPLET_WIDTH = 1000;
   private final int APPLET_HEIGHT = 1000;
   private final int HEIGHT_MIN = 500;
   private final int VARIANCE = 40;
   private Color color;
   private int x = 0; // counter for paint method
   private Random generator = new Random();
   private Rectangle choice1, choice2;
   private Image photo0,photo1,photo2,photo3,photo4,photo5,photo6,photo7,photo8,photo9,photo10,photo11,photo12,photo13,photo14,photo15;
   // private ArrayList<Image> photoList;
   private boolean choice1bool = false;
   private boolean choice2bool = false;
   int count = 0;
   
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
        int[][] vals = { {0, 0},    //0 LOSE(so that there are no out of bounds errors) LOSE
                         {3, 4}, //1
                         {1, 2}, //2
                         {5, 6}, //3
                         {7, 8}, //4
                         {0, 0},    //5
                         {9, 10},//6
                         {9, 10},//7
                         {0, 0},    //8
                         {11, 12},//9
                         {0, 0},    //10
                         {15, 15},   //11
                         {13, 14},//12
                         {0, 0},    //13
                         {15, 15},   //14
                         {15, 15} }; //15 WIN
                         
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
  
   //-----------------------------------------------------------------
   //  Creates choice boxes and stores the photos
   //-----------------------------------------------------------------
   Image choiceImages[] = new Image[16];  
 public void init (){
       // creates two new boxes for choice rectangles and adds a mouselistener so the user can click which box they want to choose
       choice1 = new Rectangle (100, 500, Color.blue, 350, 100); 
       choice2 = new Rectangle (550, 500, Color.green, 350, 100);
       addMouseListener(this);
       
       /*
       ArrayList<Image> photoList = new ArrayList<Image>();
      
       // adds all photos to an arraylist
       photo0 = getImage(getDocumentBase(),"Images\\death.jpg"); photoList.add(photo0);
       photo1 = getImage(getDocumentBase(),"Images\\waterpark.jpg"); photoList.add(photo1); 
       photo2 = getImage(getDocumentBase(),"Images\\stayhome.jpg"); photoList.add(photo2);
       photo3 = getImage(getDocumentBase(),"Images\\uber.jpg"); photoList.add(photo3);
       photo4 = getImage(getDocumentBase(),"Images\\walk.jpg"); photoList.add(photo4);
       photo5 = getImage(getDocumentBase(),"Images\\uberispolice.jpg"); photoList.add(photo5);
       photo6 = getImage(getDocumentBase(),"Images\\mcdonalds.jpg"); photoList.add(photo6);
       photo7 = getImage(getDocumentBase(),"Images\\continuewalking.jpg"); photoList.add(photo7);
       photo8 = getImage(getDocumentBase(),"Images\\kidnapped.jpg"); photoList.add(photo8);
       photo9 = getImage(getDocumentBase(),"Images\\continuetowaterpark.jpg"); photoList.add(photo9);
       photo10 = getImage(getDocumentBase(),"Images\\shake.jpg"); photoList.add(photo10);
       photo11 = getImage(getDocumentBase(),"Images\\takephotos.jpg"); photoList.add(photo11);
       photo12 = getImage(getDocumentBase(),"Images\\goinside.jpg"); photoList.add(photo12);
       photo13 = getImage(getDocumentBase(),"Images\\upstairs.jpg"); photoList.add(photo13);
       photo14 = getImage(getDocumentBase(),"Images\\downstairs.jpg"); photoList.add(photo14);
       photo15 = getImage(getDocumentBase(),"Images\\treasure.jpg"); photoList.add(photo15);
       */
      
       //Images for story
       photo0 = getImage(getDocumentBase(), "Images\\death.jpg");
       photo1 = getImage(getDocumentBase(), "Images\\waterpark.jpg");
       photo2 = getImage(getDocumentBase(), "Images\\stayhome.jpg");
       photo3 = getImage(getDocumentBase(), "Images\\uber.jpg");
       photo4 = getImage(getDocumentBase(), "Images\\walk.jpg");
       photo5 = getImage(getDocumentBase(), "Images\\uberispolice.jpg");
       photo6 = getImage(getDocumentBase(), "Images\\mcdonalds.jpg");
       photo7 = getImage(getDocumentBase(), "Images\\mcdonalds.jpg");
       photo8 = getImage(getDocumentBase(), "Images\\continuewalking.jpg");
       photo9 = getImage(getDocumentBase(), "Images\\continuetowaterpark.jpg");
       photo10 = getImage(getDocumentBase(), "Images\\shake.jpg");
       photo11 = getImage(getDocumentBase(), "Images\\stayoutside.jpg");
       photo12 = getImage(getDocumentBase(), "Images\\goinside.jpg");
       photo13 = getImage(getDocumentBase(), "Images\\upstairs.jpg");
       photo14 = getImage(getDocumentBase(), "Images\\downstairs.jpg");
       photo15 = getImage(getDocumentBase(), "Images\\treasure.jpg");
        
       choiceImages[0] = photo0;
       choiceImages[1] = photo1;
       choiceImages[2] = photo2;
       choiceImages[3] = photo3;
       choiceImages[4] = photo4;
       choiceImages[5] = photo5;
       choiceImages[6] = photo6;
       choiceImages[7] = photo7;
       choiceImages[8] = photo8;
       choiceImages[9] = photo9;
       choiceImages[10] = photo10;
       choiceImages[11] = photo11;
       choiceImages[12] = photo12;
       choiceImages[13] = photo13;
       choiceImages[14] = photo14;
       choiceImages[15] = photo15;
        
       // sets background color and applet size
       setBackground (Color.white);
       setSize (APPLET_WIDTH, APPLET_HEIGHT);
 }
 
 //THIS WORKS :,,,,)
 public void mouseClicked(MouseEvent e) {
     // if the user clicks the left box, that is the choice they made and is now the first choice is true
     if(e.getY() > 500 && e.getY() < 601){
         if(e.getX() > 99 && e.getX() < 451){
                choice1bool = true;
            }
            // if the user clicks the right box, that is the choice they made and is now the second choice is true
            else if (e.getX() > 549 && e.getX() < 901){
                choice2bool = true;
            }
        }
 }

 public void mouseExited(MouseEvent e) {

 }

 public void mouseEntered(MouseEvent e) {

 }

 public void mousePressed(MouseEvent e) {
 }

 public void mouseReleased(MouseEvent e) {
 
 }
 
   //-----------------------------------------------------------------
   //  Paints the items on the applet.
   //-----------------------------------------------------------------

 public void paint (Graphics page){
    setBackground (Color.black);
      
    choice1.setColor(page, Color.blue);
    choice1.draw(page);
    choice2.setColor(page, Color.green);
    choice2.draw(page);
    count++;
    myChoices.setKey(chosenChoice);
    
    //game doesn't end until the player either 1.dies, 2.wins, 3.stays home
    page.drawString("You wake up one morning and want to go have an adventure.\n"+
    "You know of a spooky abandoned waterpark near by, and have been wanting to visit it for a while.\n", 100, 100);
    if(myChoices.getKey() != 0 && myChoices.getKey() != 15)
    {
        if(myChoices.getKeyValues().length > 1)
        {
            page.drawString("Will you:\n"
            +myChoices.getKeyValues()[0]+". "+choicetext[myChoices.getKeyValues()[0]]+"\n"
            +myChoices.getKeyValues()[1]+". "+choicetext[myChoices.getKeyValues()[1]], 100, 100);
            page.drawImage(choiceImages[myChoices.getKeyValues()[0]], 100, 300, this);
            page.drawImage(choiceImages[myChoices.getKeyValues()[1]], 400, 300, this);
            
            // mouselistener sets true whatever one the use clicks
            if (choice1bool == true){
                chosenChoice = myChoices.getKeyValues()[0];
                choice1bool = false; // true is changed to false for the next prompt to go
                page.drawString("left\n", 400, 400);
            }
            else if (choice2bool == true){
                chosenChoice = myChoices.getKeyValues()[1];//uh, some of them only have one index (just 0)
                choice2bool = false; // true is changed to false for the next prompt to go
                page.drawString("right\n", 400, 400);
            }
                
            myChoices.setKey(chosenChoice);
            //System.out.println();
        }
        else{
            myChoices.setKey(myChoices.getKeyValues()[0]);
            chosenChoice = myChoices.getKeyValues()[0];
        }
        
        //text that explains your choice "you did this"
        page.drawString(explaintext[chosenChoice], 300, 100);
        //System.out.println();
        //will the images in an array work?
        
        try{
            //pause the program for quarter second(is in milliseconds)
            Thread.sleep(250);
           }
           catch(InterruptedException e){}//<-- do nothing if exception occurs
        //if the CPU is busy and can't sleep
        
        repaint();
    }
    
    page.drawString("THE END", 400, 100);
    
 }
}