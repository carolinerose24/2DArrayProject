package pixLab.classes;

import java.awt.Color;

/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
	public static void testChromakey() 
	{
		Picture source = new Picture("thumbsup.png");
		Picture background = new Picture("SharkRiding1.jpg");
		source.explore();
		background.explore();
		source.chromakey(background, Color.WHITE);
		source.explore();
		
	}
	
	
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  public static void testZeroRed()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.zeroRed();
	  beach.explore();
  }
  
  public static void testZeroGreen()
  {
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.zeroGreen();
	  beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  public static void testMirrorVerticalRtoL()
  {
    Picture koala = new Picture("koala.jpg");
    koala.explore();
    koala.mirrorVerticalRtoL();
    koala.explore();
  }
  public static void testMirrorVertical2()
  {
    Picture koala = new Picture("koala.jpg");
    koala.explore();
    koala.mirrorVertical();
    koala.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  { Picture banana = new Picture("kitten2.jpg");
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
    
    banana.edgeDetection(10);
    banana.explore();
  }
  
  
  public static void testMirrorHorizontal()
  {
	  Picture bike = new Picture ("redMotorcycle.jpg");
	  bike.explore();
	  bike.mirrorHorizontal();
	  bike.explore();
  }
  
  public static void testMirrorHorizontal2()
  {
	  Picture bike = new Picture ("redMotorcycle.jpg");
	  bike.explore();
	  bike.mirrorHorizontal2();
	  bike.explore();
  }
  
  public static void testMirrorGull()
  {
	  Picture seagull = new Picture ("seagull.jpg");
	  seagull.explore();
	  seagull.mirrorGull();
	  seagull.explore();
  }
  
  public static void testGlitchy()
  {
	  Picture pic = new Picture("blueMotorcycle.jpg");
	  pic.glitchy();
	  pic.explore();
  }
  
  public static void testShiftLeftRight()
  {
	  Picture sleeping = new Picture("sleeping.JPG");
//	  sleeping.explore();
	  sleeping.shiftLeftRight(100);
	  sleeping.explore();
	  
  }
  
  public static void testShiftUpDown()
  {
	  Picture sleeping = new Picture("sleeping.JPG");
//	  sleeping.explore();
	  sleeping.shiftUpDown(10);
	  sleeping.explore();
	  
  }
  
  public static void testALLtheTHINGS()
  {
	  Picture sleeping = new Picture("sleeping.JPG");
	  sleeping.explore();
	  sleeping.ALLtheTHINGS(7);
	  sleeping.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
	  
	  testALLtheTHINGS();
	  
//	  testShiftLeftRight();
	 // testShiftUpDown();
	  
	  
//    testZeroBlue();
//	testZeroRed(); 
//	testZeroGreen();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
  //testMirrorVertical();
//	testMirrorVertical2();
//	testMirrorVerticalRtoL();
	
//	testMirrorHorizontal();
//	testMirrorHorizontal2();
	//  testMirrorGull();
	
//    testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
 //   testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
 //   testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}