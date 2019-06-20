//Rayan Yu
//6/11/2018
  
   import java.awt.*;
   
	//this is a subclass of the original bumper that allows for it to move
	
    public class MovingBumper extends Bumper
   {
	 private int XMOVE;
	 private int YMOVE;
      
     //constructors
       public MovingBumper()         
      { 
		  super(0, 0, 100, 100, Color.GREEN);
         XMOVE = 1;          
         YMOVE = 1; 	 
      }
		
		public MovingBumper(int x, int y, int xWidth, int yWidth)
      { 
		  myX = x;
		  myY = y;
		  myXWidth = xWidth;
		  myYWidth = yWidth;
		  XMOVE = 1;          
        YMOVE = 1;
      }
		
      // modifier methods
   
	   public void setXMOVE(int x)
      {
         XMOVE = x;
      } 
      public void setYMOVE(int y)
      {
         YMOVE = y;
      }   
		
		public void setMovingBumper(int x, int y, int xWidth, int yWidth)
      { 
		  myX = x;
		  myY = y;
		  myXWidth = xWidth;
		  myYWidth = yWidth;
		  XMOVE = 1;          
        YMOVE = 1;
      }
		
     // accessor methods
	  
     public int getXMOVE() 
      { 
         return XMOVE;
      }

      public int getYMOVE()      
      { 
         return YMOVE;
      }
        
		
	//instance methods
	//the method that allows the bumper to move horizontally
        public void move(int rightEdge, int leftEdge, int bottomEdge)
      {
          setX(getX()- XMOVE);                       
      }
   }
