package pixLab.classes;
public class IntArrayWorker
{
  /** two dimensional matrix */
  private int[][] matrix = null;
  
  /** set the matrix to the passed one
    * @param theMatrix the one to use
    */
  public void setMatrix(int[][] theMatrix)
  {
    matrix = theMatrix;
  }
  
  /**
   * Method to return the total 
   * @return the total of the values in the array
   */
  public int getTotal() //both row major transversals 
  {
    int total = 0;
    for (int row = 0; row < matrix.length; row++) //count rows by matrix length (row major)
    {
      for (int col = 0; col < matrix[0].length; col++) //count columns in rows (column major)
      {
        total = total + matrix[row][col];
      }
    }
    return total;
  }
  
  /**
   * Method to return the total using a nested for-each loop
   * @return the total of the values in the array
   */
  public int getTotalNested()
  {
    int total = 0; //always array, then item -> must have both separated
    for (int[] rowArray : matrix) //for row in matrix ->an array of type matrix
    {
      for (int item : rowArray)   //for item in row (same thing as columns?) ->get value out of the row
      {
        total = total + item; //for each^^don't need to know the index->can only accumulate not change things
      }
    }
    return total;
  }
  
  /**
   * Method to fill with an increasing count
   */
  public void fillCount()
  {
    int numCols = matrix[0].length;
    int count = 1;
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < numCols; col++)
      {
        matrix[row][col] = count;
        count++;
      }
    }
  }
  
  /**
   * print the values in the array in rows and columns
   */
  public void print()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; col++)
      {
        System.out.print( matrix[row][col] + " " );
      }
      System.out.println();
    }
    System.out.println();
  }
  
  
  /** 
   * fill the array with a pattern
   */
  public void fillPattern1()
  {
    for (int row = 0; row < matrix.length; row++)
    {
      for (int col = 0; col < matrix[0].length; 
           col++)
      {
        if (row < col)
          matrix[row][col] = 1;
        else if (row == col)
          matrix[row][col] = 2;
        else
          matrix[row][col] = 3;
      }
    }
  }
 
  public int getCount(int numberToFind) //count how many of a number are in a column
  {
	  int count = 0;
	  for (int[] row : matrix)
	  {
		  for (int item : row)
		  {
			  if (item == numberToFind) //int is a primitive so it has no .______ methods
			  {
				  count++;
			  }
		  }
	  }
	  return count;
  }
  
  
  public int getLargest()
  {
	  int largest = Integer.MIN_VALUE;
	  			//int Largest = -100000000;//cannot assume zero is the smallest->use a large negative number
	  
	  for (int[] row : matrix)
	  {
		  for (int item: row)
		  {
			  
			  if (item > largest)
			  {
				  largest = item;
			  }
		  }
	  }
	  
	  return largest;
  }
  
  
  
  public int getColTotal(int colNum)
  {
	  int a = 0;
	
	  
	  for (int row = 0; row < matrix.length; row++)
	    {
	      for (int col = 0; col < matrix[0].length; 
	           col++)
	      {
	    	  colNum = col;
	    	  
	    	  
	    	  
	        if (row < col)
	          matrix[row][col] = 1;
	        else if (row == col)
	          matrix[row][col] = 2;
	        else
	          matrix[row][col] = 3;
	      }
	    }
	  
	  return a; 
  }
  
  
}