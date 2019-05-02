//********************************************************************
//  Building.java       Author: Lewis/Loftus/Cocking
//
//  Represents a graphical rectangle.
//********************************************************************

import java.awt.*;

public class Rectangle
{
   private int baseX;     // center of rectangle
   private int baseY;     // base of rectangle
   private Color color;   // color of rectangle
   private int height;    // height of rectangle
   private int width;

   //-----------------------------------------------------------------
   //  Sets up the rectangle's primary attributes.
   //-----------------------------------------------------------------
   public Rectangle (int center, int bottom, Color shade, int size, int enterwidth)
   {
      baseX = center;
      baseY = bottom;
      color = shade;
      height = size;
      width = enterwidth;
   }
   
   /**
    * setHeight - changes height value
    * @param new height value
    */
   public void setHeight(int size)
   {
       height = size;
   }
   
   /**
    * setColor - changes color value
    * @param new color value
    */
   public void setColor(Graphics page, Color shade)
   {
       page.setColor(shade);
   }
   
   //-----------------------------------------------------------------
   //  Draws this figure relative to baseX, baseY, and height.
   //-----------------------------------------------------------------
   public void draw (Graphics page)
   {
      page.setColor(color); // colors rectangle
      page.fillRect(baseX, baseY, height, width); // rectangle
   }
}
