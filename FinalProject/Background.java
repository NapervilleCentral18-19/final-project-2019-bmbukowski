import java.awt.*;
import javax.swing.*;

//********************************************************************
//  LineUp.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of a graphical object.
//********************************************************************

import java.util.Random;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Background extends Applet 
{
   private final int APPLET_WIDTH = 1000;
   private final int APPLET_HEIGHT = 1000;
   private final int HEIGHT_MIN = 500;
   private final int VARIANCE = 40;
   private Color color;
   private int x = 0; // counter for paint method
   private Random generator = new Random();
   
   private Rectangle choice1, choice2;
   
   //-----------------------------------------------------------------
   //  Creates several building, a cloud, and the ground square
   //-----------------------------------------------------------------
 public void init ()
 {
   choice1 = new Rectangle (100, 500, Color.blue, 350, 100); 
   choice2 = new Rectangle (550, 500, Color.green, 350, 100); 
   
   setBackground (Color.gray);
   setSize (APPLET_WIDTH, APPLET_HEIGHT);
 }
 
   //-----------------------------------------------------------------
   //  Paints the items on the applet.
   //-----------------------------------------------------------------
   
   public void paint (Graphics page)
   {
    setBackground (Color.black);
      
    // buildings are drawn in the color gray
    choice1.setColor(page, Color.blue);
    choice1.draw (page);
    choice2.setColor (page, Color.green);
    choice2.draw (page);
        
    try{
        // pause program for quarter-sec(in miliseconds)
        Thread.sleep(250);
    }
    catch(InterruptedException e){}
    
    //blankArea.addMouseListener(this);
    //addMouseListener(this);
    //component.addMouseListener(new MouseListener());
    //int x = MouseEvent.MOUSE_CLICKED.getXOnScreen();
    //int y = MouseEvent.MOSUE_CLICKED.getYOnScreen();
    //Main.mouseClicked(x, y);
    
    repaint(); // clears screen
 }
}