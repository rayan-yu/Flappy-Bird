//Rayan Yu
//6/11/2018

   import javax.swing.JFrame;
	import javax.swing.JOptionPane;
	
    public class Driver17
   {
       public static void main(String[] args)
      { 
		
		   //message dialog at beginning of game
         JOptionPane.showMessageDialog(null, "Welcome to Flappy Bird");      
			//create the frame for flappypanel
			JFrame frame = new JFrame("EndOfYearProject");
         frame.setSize(800, 800);
         frame.setLocation(0, 0);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         FlappyPanel p = new FlappyPanel();
         frame.setContentPane(p);
         p.requestFocus();
         frame.setVisible(true);
			
      }
		
   }
