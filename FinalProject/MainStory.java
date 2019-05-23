//********************************************************************
//  LineUp.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of a graphical object.
//********************************************************************

import java.util.Random;
import java.util.*;  
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.Color;

public class MainStory extends Applet implements MouseListener
{
   private final int APPLET_WIDTH = 1000;
   private final int APPLET_HEIGHT = 1000;
   private final int HEIGHT_MIN = 500;
   private final int VARIANCE = 40;
   private Color color;
   private int x = 0; // counter for paint method
   private Random generator = new Random();
   private Rectangle choice1, choice2, choice1background, choice2background, startRec, startBackground;
   private Image photo0,photo1,photo2,photo3,photo4,photo5,photo6,photo7,photo8,photo9,photo10,photo11,photo12,photo13,photo14,photo15,background;
   // private ArrayList<Image> photoList;
   private boolean choice1bool = false;
   private boolean choice2bool = false;
   private boolean choice1lightup = false;
   private boolean choice2lightup = false;
   private int count = 0;
   private boolean start, restart;
   private Color customColor = new Color(255,163,106);
   private Color buttonColor = new Color(85,138,204);
   
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
            "\nBut it turns out that",
            
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
  
        boolean firstchoice = false;
   //-----------------------------------------------------------------
   //  Creates choice boxes and stores the photos
   //-----------------------------------------------------------------
   Image choiceImages[] = new Image[16];  
 public void init (){
       // creates two new boxes for choice rectangles and adds a mouselistener so the user can click which box they want to choose
       choice1 = new Rectangle (100, 500, Color.white, 350, 100); 
       choice2 = new Rectangle (550, 500, Color.white, 350, 100);
       choice1background = new Rectangle (90, 490, Color.blue, 370, 120); 
       choice2background = new Rectangle (540, 490, Color.blue, 370, 120);
       startRec = new Rectangle (290, 280, Color.white, 370, 120);
       startBackground = new Rectangle (280, 270, Color.blue, 390, 140);
       addMouseListener(this);
       start = false;
       restart = false;
      
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
    if (start){
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
    else{
        if(e.getY() > 289 && e.getY() < 401){
            if(e.getX() > 279 && e.getX() < 661){
                start = true;
            }
        }
    } 
    /*if (myChoices.getKeyValues()[0] == 0 || myChoices.getKeyValues()[0] == 15){
        restart = true;
    }*/
 }


 public void mouseExited(MouseEvent e) {
 }

 public void mouseEntered(MouseEvent e) {
     
 }

 public void mousePressed(MouseEvent e) {
 }

 public void mouseReleased(MouseEvent e) {
    if (start){
        if(e.getY() > 500 && e.getY() < 601){
            if(e.getX() > 99 && e.getX() < 451){
                   choice1lightup = true;
            }
            // if the user clicks the right box, that is the choice they made and is now the second choice is true
            else if (e.getX() > 549 && e.getX() < 901){
                   choice2lightup = true;
            }
        }
    }
 }
 
 
   //-----------------------------------------------------------------
   //  Paints the items on the applet.
   //-----------------------------------------------------------------
   
 public void paint (Graphics page){
    if (start == true){
       setBackground (Color.white);
       Color buttonClick = new Color(230,198,142); 

       background = getImage(getDocumentBase(), "Images\\background.jpg");
       page.drawImage(background, 0, 0, this);

       myChoices.setKey(chosenChoice);

       //game doesn't end until the player either 1.dies, 2.wins, 3.stays home


       if(myChoices.getKey() != 0 && myChoices.getKey() != 15)
       {
           if(myChoices.getKeyValues().length > 1)
           {
               if (myChoices.getKeyValues()[0] == 1){
                  page.setColor(customColor);
                  page.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
                  page.drawString("You wake up one morning and want to go have an adventure.", 100, 100);
                  page.drawString("You know of a spooky abandoned waterpark near by, and have been wanting to visit it for a while.", 100, 120);
               }

               //page.drawString("Will you:\n"
               //+myChoices.getKeyValues()[0]+". "+choicetext[myChoices.getKeyValues()[0]]+"\n"
               //+myChoices.getKeyValues()[1]+". "+choicetext[myChoices.getKeyValues()[1]], 100, 100);
               //page.drawImage(choiceImages[myChoices.getKeyValues()[0]], 400, 400, this);
               //page.drawImage(choiceImages[myChoices.getKeyValues()[1]], 400, 400, this);

               if (myChoices.getKeyValues()[0] != 0 && myChoices.getKeyValues()[0] != 15){
                   page.setColor(customColor);
                   //choice1background.setColor(page, customColor);
                   choice1background.draw(page);
                   //choice2background.setColor(page, customColor);
                   choice2background.draw(page);

                   choice1.setColor(page, Color.white);
                   choice1.draw(page);
                   choice2.setColor(page, Color.white);
                   choice2.draw(page);
                   count++;


                   page.setColor(customColor);
                   page.setFont(new Font("Bookman Old Style", Font.BOLD, 16));
                   page.drawString("Will you", 450, 190);
                   page.drawLine(450 , 192 , 450+getFontMetrics(new Font("Bookman Old Style", Font.BOLD, 16)).stringWidth("Will you"), 192);
                   page.drawString(myChoices.getKeyValues()[0]+". "+choicetext[myChoices.getKeyValues()[0]], 100, 220);
                   page.drawString(myChoices.getKeyValues()[1]+". "+choicetext[myChoices.getKeyValues()[1]], 540, 220);

                   page.drawImage(choiceImages[myChoices.getKeyValues()[0]], 160, 280, this);
                   page.drawImage(choiceImages[myChoices.getKeyValues()[1]], 620, 280, this);
                   page.setFont(new Font("Bookman Old Style", Font.BOLD, 30));

                   /*page.drawImage(choiceImages[myChoices.getKeyValues()[0]], 160, 280, this);
                   page.drawImage(choiceImages[myChoices.getKeyValues()[1]], 620, 280, this);
                   page.setFont(new Font("Bookman Old Style", Font.PLAIN, 40));
                   
                   page.drawImage(choiceImages[myChoices.getKeyValues()[0]], 160, 280, this);
                   page.drawImage(choiceImages[myChoices.getKeyValues()[1]], 620, 280, this);
                   page.setFont(new Font("Bookman Old Style", Font.PLAIN, 50));
                   */

                   page.drawString(""+myChoices.getKeyValues()[0], 255, 570);
                   page.drawString(""+myChoices.getKeyValues()[1], 715, 570);
               }
               else{
                   page.setFont(new Font("Bookman Old Style", Font.BOLD, 40));

                   page.setColor(customColor);
                   page.setFont(new Font("Bookman Old Style", Font.BOLD, 20));
                   page.drawString("THE END", 350, 350);
                    
                   //work on this later
                   /*if (restart){
                       myChoices.setKey(2);
                       start = false;
                   }*/
               }

               if (choice1lightup == true){
                   //makes the border of the rectangle orange
                   choice1background = new Rectangle (90, 490, buttonClick, 370, 120); 
                   choice1background.draw(page);
                   choice1.draw(page);

                   page.setColor(buttonClick);
                   page.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
                   page.drawString(""+myChoices.getKeyValues()[0], 255, 570);

                   page.setColor(Color.blue);
                   //reseting the rectangle to be blue
                   choice1background = new Rectangle (90, 490, Color.blue, 370, 120); 
                   choice1lightup = false; // true is changed to false for the next prompt to go
               }
               else if (choice2lightup == true){
                   //makes the border of the rectangle orange
                   choice2background = new Rectangle (540, 490, buttonClick, 370, 120);
                   choice2background.draw(page);
                   choice2.draw(page);

                   page.setColor(buttonClick);
                   page.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
                   page.drawString(""+myChoices.getKeyValues()[1], 715, 570);

                   page.setColor(Color.blue);
                   //reseting the rectangle to be blue
                   choice2background = new Rectangle (540, 490, Color.blue, 370, 120);
                   choice2lightup = false; // true is changed to false for the next prompt to go
               }


               // mouselistener sets true whatever one the user clicks
               if (choice1bool == true){
                   chosenChoice = myChoices.getKeyValues()[0];
                   choice1bool = false; // true is changed to false for the next prompt to go
               }
               else if (choice2bool == true){
                   chosenChoice = myChoices.getKeyValues()[1];//uh, some of them only have one index (just 0)
                   choice2bool = false; // true is changed to false for the next prompt to go
               }

               myChoices.setKey(chosenChoice);
               //System.out.println();
               
           }
           else{
               myChoices.setKey(myChoices.getKeyValues()[0]);
               chosenChoice = myChoices.getKeyValues()[0];
           }

           //text that explains your choice "you did this"
           page.setColor(customColor);
           page.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
           if (myChoices.getKey() == 5)  page.drawString("your Uber driver is an undercover cop! He arrests you for going to an illegal place.", 100, 140);
           //System.out.println();

           if(myChoices.getKeyValues()[0] != 1){
               //text that explains your choice "you did this"
               page.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
               page.drawString(explaintext[chosenChoice], 100, 120);
            }
           //will the images in an array work?
           
           try{
               //pause the program for quarter second(is in milliseconds)
               Thread.sleep(350);
           }
           catch(InterruptedException e){}//<-- do nothing if exception occurs
              
           //if the CPU is busy and can't sleep
       }
       /*if (restart){
           myChoices.setKey(2);
           start = false;
       }*/
    }
    else{
        setBackground (Color.black);
        startBackground.draw(page); 
        startRec.draw(page);
        
        page.setColor(Color.black);
        page.setFont(new Font("Bookman Old Style", Font.BOLD, 40));
        page.drawString("Press to start", 350, 350);
        //restart = false;
        //page.setColor(Color.white);
    }
    
    repaint();
 }
}
