package pixLab.classes;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.awt.Color;

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  
  public void chromakey(Picture replacement, Color changeColor)
  {
	  Pixel[][] mainPixels= this.getPixels2D();
	  Pixel[][] replacementPixels = replacement.getPixels2D();
	  
	  for (int row = 0; row < mainPixels.length; row++)
	  {
		  for (int col = 0; col < mainPixels[0].length; col++)
		  {
			  if (mainPixels[row][col].colorDistance(changeColor) < 10)
			  {
				  mainPixels[row][col].setColor(replacementPixels[row][col].getColor());
				  
			  }
		  }
		  
	  }
  }
  
  public void shiftLeftRight(int amount)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Picture temp = new Picture(this);
	  Pixel[][] copied = temp.getPixels2D();
	  
	  int shiftedValue = amount;
	  int width = pixels[0].length;
	  int height = pixels.length;
	  
	  Pixel copyPixel = null;
	  Pixel pastePixel = null;
	  
	  
	  for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < pixels[0].length ; col++)
	      {
	        shiftedValue = (col + amount) % width;
	        copied[row][col].setColor(pixels[row][shiftedValue].getColor());
	      }
	    } 
	  
	  for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < pixels[0].length ; col++)
	      {
	        pixels[row][col].setColor(copied[row][col].getColor());
	        
	      }
	    } 
	  
	  //TO REFLECT WITH 1/2 OPACITY
	  for(int row = 0; row < height; row++)
	  {
		  for(int col = 0; col < width; col++)
		  {
			  copyPixel = pixels[row][col];
			  pastePixel = pixels[row][width - 1 - col];
			  pastePixel.setBlue((pastePixel.getBlue() + copyPixel.getBlue()) / 2);
			  pastePixel.setGreen((pastePixel.getGreen() + copyPixel.getGreen()) / 2);
			  pastePixel.setRed((pastePixel.getRed() + copyPixel.getRed()) / 2);
			  
		  }
	  }
	  	  
  }
  
  public void shiftUpDown(int amount)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Picture temp = new Picture(this);
	  Pixel[][] copied = temp.getPixels2D();
	  
	  int shiftedValue = amount;
	  int width = pixels[0].length;
	  int height = pixels.length;
	  
	  Pixel copyPixel = null;
	  Pixel pastePixel = null;
	  
	  
	  for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < pixels[0].length ; col++)
	      {
	        shiftedValue = (row + amount) % height;
	        copied[row][col].setColor(pixels[shiftedValue][col].getColor());
	      }
	    } 
	  
	  for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < pixels[0].length ; col++)
	      {
	        pixels[row][col].setColor(copied[row][col].getColor());
	        
	        copyPixel = pixels[row][col];
	        pixels[row][col].setBlue((pixels[row][col].getBlue() + copyPixel.getBlue()) / 2);
	        pixels[row][col].setGreen((pixels[row][col].getGreen() + copyPixel.getGreen()) / 2);
	        pixels[row][col].setRed((pixels[row][col].getRed() + copyPixel.getRed()) / 2);
	      }
	    } 
	  
	  
	  
	  
	  //TO REFLECT WITH 1/2 OPACITY
	  for(int row = 0; row < height; row++)
	  {
		  for(int col = 0; col < width; col++)
		  {
			  copyPixel = pixels[row][col];
			  pastePixel = pixels[row][width - 1 - col];
			  pastePixel.setBlue((pastePixel.getBlue() + copyPixel.getBlue()) / 2);
			  pastePixel.setGreen((pastePixel.getGreen() + copyPixel.getGreen()) / 2);
			  pastePixel.setRed((pastePixel.getRed() + copyPixel.getRed()) / 2);
			  
		  }
	  }
	  	  
  }
  
  
  
  
  public void glitchy()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  int height = pixels.length;
	  int width = pixels[0].length;
	  Pixel copyPixel = null;
	  Pixel pastePixel = null;
	  
	  int random1 = (int)(Math.random() * (height - 20));
	  int random2 = (int)(Math.random() * (width - 40));
	  
	  int mirrorPoint = (int)(Math.random() * width);
	  int mirrorPoint2 = (int)(Math.random() * width);
	  
	  int random3 = (int)(Math.random() * height);
	  int random4 = (int)(Math.random() * width);
	  
	  //TO REFLECT AND MAKE IT MAGENTA
//	  for(int row = 0; row < height; row++)
//	  {
//		  for(int col = 0; col < width; col++)
//		  {
//			  copyPixel = pixels[row][col];
//			  pastePixel = pixels[row][width - 1 - col];
//			  pastePixel.setColor(copyPixel.getColor());
//			  pastePixel.setBlue(100);
//			  pastePixel.setGreen(pastePixel.getRed() / 2);
//			  
//		  }
//	  }
	  
	  //TO REFLECT WITH 1/2 OPACITY
	  for(int row = 0; row < height; row++)
	  {
		  for(int col = 0; col < width; col++)
		  {
			  copyPixel = pixels[row][col];
			  pastePixel = pixels[row][width - 1 - col];
			  pastePixel.setBlue((pastePixel.getBlue() + copyPixel.getBlue()) / 2);
			  pastePixel.setGreen((pastePixel.getGreen() + copyPixel.getGreen()) / 2);
			  pastePixel.setRed((pastePixel.getRed() + copyPixel.getRed()) / 2);
			  
		  }
	  }
	  
	  //TO COPY PASTE RANDOMLY WITH ZERO BLUE
//	  for(int row = random1; row < random1 + 20; row++)
//	  {
//		  for(int col = random2; col < random2 + 40; col++)
//		  {
//			  copyPixel = pixels[row][col];
//			  copyPixel.setBlue(0);
//			  pastePixel = pixels[row][mirrorPoint2 - col + mirrorPoint2];
//			  pastePixel.setColor(copyPixel.getColor());
//			  
//		  }
//		  
//	  }
	  
	  //TO REFLECT A SECTION WITH ZERO GREEN
//	  for(int row = 36; row < 300; row++)
//	  {
//		  for(int col = 56; col < 239; col++)
//		  {
//			  copyPixel = pixels[row][col];
//			  copyPixel.setGreen(0);
//			  pastePixel = pixels[row][mirrorPoint - col + mirrorPoint];
//			  pastePixel.setColor(copyPixel.getColor());
//			  
//		  }
//		  
//	  }
//	  
  }
  
  
  
  
  public void banana()
  {
	  Pixel[][] pixels = this.getPixels2D(); //set it into thirds? each one has one color gone? but it is not an int?
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setBlue(0);
	      }
	    }
  }
  
  public void zeroRed()
  {
	  Pixel [] [] pixels = this.getPixels2D();
	  for(Pixel [] row : pixels)
	  {
		  for (Pixel pix : row)
		  {
			  pix.setRed(0);
		  }
	  }
  }
  
  public void zeroGreen()
  {
	  Pixel [] [] pixels = this.getPixels2D();
	  for(Pixel [] row : pixels)
	  {
		  for (Pixel pix : row)
		  {
			  pix.setGreen(0);
		  }
	  }
  }
  
  
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
        //to change how it reflects-> 
        //leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRtoL()
  {
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int width = pixels[0].length;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = 0; col < width / 2; col++)
	      {
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[row][width - 1 - col];
	        //to change how it reflects-> 
	        leftPixel.setColor(rightPixel.getColor());
	      }
	    } 
  }
  
  public void mirrorHorizontal()
  {
	Pixel[][] pixels = this.getPixels2D();
	Pixel topPixel = null;
	Pixel bottomPixel = null;
	int width = pixels[0].length;
	int height = pixels.length;
	
	for (int row = 0; row < pixels.length / 2; row++)
	{
		for (int col = 0; col < width; col ++)
		{
			topPixel = pixels[row][col];
			bottomPixel = pixels[height - 1 - row][col];
			bottomPixel.setColor(topPixel.getColor());
		}
	}
  }
  
  public void mirrorHorizontal2()
  {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int width = pixels[0].length;
		int height = pixels.length;
		
		for (int row = pixels.length / 2; row < pixels.length; row++)
		{
			for (int col = 0; col < width; col ++)
			{
				bottomPixel = pixels[row][col];
				topPixel = pixels[height - 1 - row][col];
				topPixel.setColor(bottomPixel.getColor());
			}
		} 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple() //executes (276-13)(97-27) = 18410 times
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  
  public void mirrorGull()
  {
	  //226, 224
	  //328, 350
	  
	  int mirrorPoint = 350;
	  int mirrorPoint2 = 224;
	  int mirrorPoint3 = 476;
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel upPixel = null;
	  Pixel bottomPixel = null;
	  int count = 0;
	  Pixel[][] pixels = this.getPixels2D();
	  
	  for (int row = 226; row < 328; row ++)
	  {
		  for (int col = 224; col < mirrorPoint; col++)
		  {
			  leftPixel = pixels[row][col];
		      rightPixel = pixels[row]                       
                        [mirrorPoint - col + mirrorPoint];
       rightPixel.setColor(leftPixel.getColor());
		  }
	  }
	  
	  for (int row = 226; row < 328; row ++)
	  {
		  for (int col = 224; col < mirrorPoint; col++)
		  {
			  leftPixel = pixels[row][col]; //102, 126
		      rightPixel = pixels[row][602];                     
                       // [mirrorPoint3 - col + mirrorPoint3];
       rightPixel.setColor(leftPixel.getColor());
		  }
	  }
	  
	  for (int row = 22; row <328; row++)
	  {
		  for (int col = 224; col < mirrorPoint; col++)
		  {
			  leftPixel = pixels[row][col];
		      rightPixel = pixels[row]                       
                        [mirrorPoint2 - col + mirrorPoint2];
       rightPixel.setColor(leftPixel.getColor());
		  }
	  }
	  
//	  for (int row = 22; row <328; row++)
//	  {
//		  for (int col = 224; col < mirrorPoint; col++)
//		  {
//			 
//			  
//			  upPixel = pixels[row][col];
//		      bottomPixel = pixels[row]                       
//                        [mirrorPoint2 - col + mirrorPoint2];
//       bottomPixel.setColor(upPixel.getColor());
//		  }
//	  }
	  
	  
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("kitten2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
    
    
  }
  
} // this } is the end of class Picture, put all new methods before this
