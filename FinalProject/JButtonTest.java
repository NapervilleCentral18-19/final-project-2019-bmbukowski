/**
 * Alexandra Kerans
 * 6 May 2019
 * JButton Test
 * Testing the java Jbutton from swing
 */

import javax.swing.*;
import java.awt.event.*;

public class JButtonTest
{
    public static void main(String [] args)
    {
        //COPIED CODE from https://www.javatpoint.com/java-jbutton
        //I made some edits to customize the size and etc.
        /*
        //constructing the 'canvas' frame that the button will be on
        JFrame frame = new JFrame("Button Example");  
        //constructing the actual button
        JButton button =  new JButton("Click Here");  
        
        //size of button x, y,  width, height  (same as making a rectangle
        button.setBounds(50,300,200,90);  
        
        //setting the size of the frame
        frame.setSize(500, 500);
        //adding the button to the frame
        frame.add(button);
        
        //this makes it so that the button doesnt take up the entire screen???
        frame.setLayout(null); 
        
        //im guessing that this makes the frame display
        frame.setVisible(true);  
        */
       
        JFrame f = new JFrame("Button Example");
        JButton b=new JButton("Click Here"); 
        final JTextField tf = new JTextField(); 
        
        tf.setBounds(50,50, 150,20);   
        b.setBounds(50,100,95,30);  
        
        b.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
            tf.setText("You clicked the button");  
        }  
    });  
    f.add(b);f.add(tf);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);   
    }
}
