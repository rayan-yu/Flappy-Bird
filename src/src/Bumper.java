//Rayan Yu
//Elijah Turner
//Pd.4
//6/11/2018

   import java.awt.*;
   
    public class Bumper
   {
	
    //instantiate the variables used in this class 
	 public Color myColor;
	 public int myX;
	 public int myXWidth; 
	 public int myY;
	 public int myYWidth;
      
  //contructors for the pipe/bumper
       public Bumper()         
      { 
		  myX = 0;
		  myXWidth = 100;
		  myY = 0;
		  myYWidth = 100; 	
		  myColor = Color.GREEN; 	 
      }
		
		
		public Bumper(int x, int y, int xWidth, int yWidth)
      { 
		  myX = x;
		  myXWidth = xWidth;
		  myY = y;
		  myYWidth = yWidth;
      }
		
       public Bumper(int x, int y, int xWidth, int yWidth, Color c)
      { 
		  myX = x;
		  myXWidth = xWidth;
		  myY = y;
		  myYWidth = yWidth;
		  myColor = c;	
      }
      
     //accessor methods for the pipe
	  
     public int getX() 
      { 
         return myX;
      }
		
	  public int getXWidth() 
      { 
         return myXWidth;
      }

      public int getY()      
      { 
         return myY;
      }
		
		public int getYWidth() 
      { 
         return myYWidth;
      }
		
      public Color getColor() 
      { 
         return myColor;
      }

     //modifier methods for bumper
   
	   public void setX(int x)
      {
         myX = x;
      } 
      public void setY(int y)
      {
         myY = y;
      } 
		
		public void setXWidth(int xWidth)
      {
         myXWidth = xWidth;
      } 
      public void setYWidth(int yWidth)
      {
         myYWidth = yWidth;
      }
		
      public void setColor(Color c)
      {
         myColor = c;
      }
      
	
     // instance methods 
	  
	  //draws the bumper     
       public void draw(Graphics myBuffer) 
      {
         myBuffer.setColor(getColor());
         myBuffer.fillRect((int)getX(), getY(), getXWidth(), getYWidth());
      }   

      //measures a distance
      private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }
		
   	//calculates if any part of the bird is inside the pipe (taken from a lab)
       public boolean inBumper(Polkadot dot)
      {
         for(int x = getX(); x <= getX() + getXWidth(); x++){      
			   for(int y = getY(); y <= getY() + getYWidth(); y++){ 
               if(distance(x, y, dot.getX(), dot.getY()) <= dot.getRadius())
                  return true;   
				  }
			 }       
         return false;
      }  
		
       	
   }
