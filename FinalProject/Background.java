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

public class Background extends Applet implements MouseListener
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
   private ArrayList<Image> photoList;
   int count = 0;
   

  
   //-----------------------------------------------------------------
   //  Creates several building, a cloud, and the ground square
   //-----------------------------------------------------------------
   Image choiceImages[] = new Image[16];  
 public void init (){
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
        
   
       setBackground (Color.gray);
       setSize (APPLET_WIDTH, APPLET_HEIGHT);
 }
 
 public void mouseClicked(MouseEvent e) {
     if (e.getX() >= 50 && e.getX() <= 150 && e.getY() >= 350 && e.getY() <= 500){
         choice1 = new Rectangle (100, 800, Color.blue, 350, 100); 
     }
     else if (e.getX() >= 500 && e.getX() <= 600 && e.getY() >= 350 && e.getY() <= 500){
         choice2 = new Rectangle (550, 800, Color.blue, 350, 100); 
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
    //page.drawImage(photo1, 30, 30, this);
    page.drawImage(choiceImages[count], 30, 30, this);
        
    try{
        // pause program for quarter-sec(in miliseconds)
        Thread.sleep(100);
    }
    catch(InterruptedException e){}
    
    count++;
    
    repaint(); // clears screen
 }
}