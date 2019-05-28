//Rayan Yu
//Elijah Turner
//Pd.4
//6/11/2018

   import java.awt.*;
   //a modified version of the polkadot class taken from a lab, it serves as the bird
	
   public class Polkadot
   {
	   //variables used
      private double myX;   
      private double myY;
      private double myDiameter;
      private Color myColor; 
      private double myRadius;
	   private double YMOVE;
		
     // constructors
      public Polkadot()     
      {
         myX = 200;
         myY = 200;
         myDiameter = 25;
         myColor = Color.RED;
         myRadius = myDiameter/2;
         YMOVE = 1.2;
      }
		
		public Polkadot(double x, double y)     
      {
         myX = x;
         myY = y;
         myDiameter = 25;
         myColor = Color.RED;
         myRadius = myDiameter/2;
         YMOVE = 1.2;
      }
		
      public Polkadot(double x, double y, double d, Color c)
      {
         myX = x;
         myY = y;
         myDiameter = d;
         myColor = c;
         myRadius = d/2;
         YMOVE = 1.2;
      }
    // accessor methods
      public double getX() 
      { 
         return myX;
      }
      public double getY()      
      { 
         return myY;
      }
      public double getDiameter() 
      { 
         return myDiameter;
      }
      public Color getColor() 
      { 
         return myColor;
      }
      public double getRadius() 
      { 
         return myRadius;
      }
		
   // modifier methods
      public void setX(double x)
      {
         myX = x;
      } 
      public void setY(double y)
      {
         myY = y;
      } 
      public void setColor(Color c)
      {
         myColor = c;
      }
      public void setDiameter(double d)
      {
         myDiameter = d;
         myRadius = d/2;
      }
      public void setRadius(double r)
      {
         myRadius = r;
         myDiameter = 2*r;
      }
	
      public void setYMOVE(double y)
      {
         YMOVE = y;
      }
		
    //	 instance methods
	 
	 //allows the bird to have a down motion
      public void moveDown(int bottomEdge)
      {
			setY(getY()+ YMOVE);                  
      }
      
    //allows the bird to have an up motion
      public void moveUp(int howFar){
         YMOVE = 1;
         for(int a = 0; a < howFar; a++)     
            setY(getY()- YMOVE);                       
      }
		
    //draws the bird
      public void draw(Graphics myBuffer) 
      {
         myBuffer.setColor(myColor);
         myBuffer.fillOval((int)(getX() - getRadius()), (int)(getY()-getRadius()), (int)getDiameter(), (int)getDiameter());
      }
   }