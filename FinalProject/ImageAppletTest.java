import java.awt.*;
import javax.swing.*;

/**
 * Alexandra Kerans
 * 9 May 2019
 * Image Applet Test
 * testing how to display an image in an applet
 */
//maybe put all the pictures needed into an arraylist,
// and depending on what the current choice (index) is,
// it will display the image at that index
// (need to match image choices with choice indexes)

//graphics tutorial http://www.ntu.edu.sg/home/ehchua/programming/java/J4b_CustomGraphics.html
public class ImageAppletTest extends JApplet
{
    //THIS IS COPIED CODE
    //FROM https://www.javatpoint.com/Displaying-image-in-applet
    Image picture1;  
    Image picture2;
    
    int count = 0;
  
    public void init() {  
        picture1 = getImage(getDocumentBase(),"shake.jpg");  
        picture2 = getImage(getDocumentBase(), "uber.jpg");
    }  
    
    public void paint(Graphics g) {  
        if(count%2 == 0){
            g.drawImage(picture1, 30, 30, this);  
            g.drawString("shake", 300, 30);
        }
        else{
            g.drawImage(picture2, 30, 30, this); 
            g.drawString("uber", 200, 30);
        }
        
        try{
          //pause the program for quarter second(is in milliseconds)
          Thread.sleep(250);
        }
        catch(InterruptedException e){}//<-- do nothing if exception occurs
        //if the CPU is busy and can't sleep
      
        count+= 1;
        
        repaint();
    }  
}
