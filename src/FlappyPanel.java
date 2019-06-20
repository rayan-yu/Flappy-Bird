//Rayan Yu
//6/11/2018
	
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   
   public class FlappyPanel extends JPanel {
	
		//instantiate all the variables necassary for the game
		private static final int FRAME = 800;
		private static final Color BACKGROUND = new Color(204, 204, 204);	
		private BufferedImage myImage;
		private Graphics myBuffer;
		
		//the bird
		private Polkadot pd;
		
		//the pipes
		private MovingBumper bumper = null;
		private MovingBumper bumper2 = null;
		private Timer timer;   
		//pictures
		private ImageIcon background = new ImageIcon("C:\\Users\\Rayan\\IdeaProjects\\FlappyBird\\src\\flappybirdbackground.png");
		private ImageIcon nightbackground = new ImageIcon("C:\\Users\\Rayan\\IdeaProjects\\FlappyBird\\src\\nightbackground.png");
		private ImageIcon bird = new ImageIcon("C:\\Users\\Rayan\\IdeaProjects\\FlappyBird\\src\\flappybird.png");
		private ImageIcon bluebird = new ImageIcon("C:\\Users\\Rayan\\IdeaProjects\\FlappyBird\\src\\flappybirdblue.png");
		//score
		public int score = 0;
      public int highScore = 0;
      //options for background and bird
		public int backgroundOption;
		public int birdOption;
      
		public FlappyPanel() {
		      //picking the background
		      Object[] options = {"Day Background", "Night Background"};
            int n = JOptionPane.showOptionDialog(null,
            "Day or Night background?",
            "Background Choice",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,    
            options,  
            options[0]); 
					  
				if(n == JOptionPane.YES_OPTION)
					backgroundOption = 0;
				else if(n == JOptionPane.NO_OPTION)
					backgroundOption = 1;
				else
				 	System.exit(0);
					
			   //picking the color of the bird
			   Object[] options2 = {"Normal Bird", "Blue Bird"};		  
            int m = JOptionPane.showOptionDialog(null,
               "What color bird would you like?",
               "Bird Choice",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE,
               null,    
               options2,  
               options2[0]); 
					  
				if(m == JOptionPane.YES_OPTION)
					birdOption = 0;
				else if(m == JOptionPane.NO_OPTION)
					birdOption = 1;
				else
				 	System.exit(0);
					
			//drawing the objects
			myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
			myBuffer = myImage.getGraphics();
			myBuffer.setColor(BACKGROUND);
			myBuffer.fillRect(0, 0, FRAME,FRAME);
			pd = new Polkadot(50, 400);
			addKeyListener(new Key());
			addKeyListener(new Key());
			setFocusable(true);
			//creating the pipes, with a random variation
			resetBumper();
         
			timer = new Timer(5, new Listener());
			timer.start(); 
		}
		
		//the key press that allows the bird to "bounce" upwards
		private class Key extends KeyAdapter {
			public void keyPressed(KeyEvent e) {
			   if(e.getKeyCode() == KeyEvent.VK_UP && pd.getRadius() < pd.getY())		
               pd.moveUp(30);
			}
		}
		
		//drawing the images
		public void paintComponent(Graphics g) {
			g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
		}
          
		private class Listener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				myBuffer.setColor(BACKGROUND);
				myBuffer.fillRect(0,0,FRAME,FRAME); 
				myBuffer.drawImage(background.getImage(), 0, 0, 800, 800, null);   
				
				//if user selected a night background
				if(backgroundOption == 1)
					myBuffer.drawImage(nightbackground.getImage(), 0, 0, 800, 800, null); 
				//if user selected a day background
				else if(backgroundOption == 0)
					myBuffer.drawImage(background.getImage(), 0, 0, 800, 800, null);
				else
					System.exit(0);
				
				pd.draw(myBuffer);
				
				//if user selected a normal bird
				if(birdOption == 0)
					myBuffer.drawImage(bird.getImage(), 
						(int)(pd.getX() - 17), (int)(pd.getY() - 20), 35, 35, null);   
			    //if user selected a blue bird 
				else if(birdOption == 1)
						myBuffer.drawImage(bluebird.getImage(), 
						(int)(pd.getX() - 18), (int)(pd.getY() - 17), 35, 35, null);
				else
					System.exit(0);
				 
				//code for the objects to move
				pd.moveDown(FRAME);
				bumper.draw(myBuffer);
				bumper2.draw(myBuffer);
				bumper.move(FRAME, 0, FRAME);
				bumper2.move(FRAME, 0, FRAME);
				repaint();	
            
				//what happens when you lose the game
				if((pd.getY() > (FRAME - pd.getDiameter())) || bumper.inBumper(pd) || bumper2.inBumper(pd)) {
					timer.stop();
					//gives you an option dialog that you lost, shows you your score, gives you option to quit or play again
					int reply = JOptionPane.showConfirmDialog(null, 
					 "You Lost. Your Score is " + score + " \n"  +
                "Your High Score is " + highScore + " \n" + "Continue?", "Game Over", JOptionPane.YES_NO_OPTION);
			  
					//if you play again
					if(reply == JOptionPane.YES_OPTION) {
						//reset bumper
						resetBumper(); 		
						//resets the bird position and the score
						pd.setX(50);
						pd.setY(400);
						score = 0;  
						
						timer.start();
					} else { 
                  //if you choose not to play
						System.exit(0);
					}		
				} else if(bumper.getX() <= 0) { //if you get past a pipe
					timer.stop();
					//increases score
					score++;
               if(score > highScore)
                  highScore = score;
					resetBumper();
					timer.start();
				}
				//if the user picked a day background, the text is set to black so it can be read easier
				if(backgroundOption == 0)
					myBuffer.setColor(Color.BLACK);
				//if the user picked a night background, the text is set to white so it can be read easier
				else if(backgroundOption == 1)
					myBuffer.setColor(Color.WHITE);
				//draw the score
				myBuffer.setFont(new Font("Monospaced", Font.BOLD, 24));
				myBuffer.drawString("Score: " + score, FRAME - 150, 25);
            myBuffer.drawString("High Score: " + highScore, FRAME - 220, 50);
				repaint();	
			} 
		}
        private void resetBumper() { 
			//clear the bumpers
			bumper = null;
			bumper2 = null;
 
         //instantiates new ones in random positions
			int number = (int)(Math.random() * 7);
				 
			switch(number) {
				case 0:
					bumper = new MovingBumper(725, 0, 75, 25);
					bumper2 = new MovingBumper(725, 125, 75, 675);
					break;
					
				case 1:
					bumper = new MovingBumper(725, 0, 75, 100);
					bumper2 = new MovingBumper(725, 200, 75, 600);
					break;
			
				case 2:
					bumper = new MovingBumper(725, 0, 75, 200);
					bumper2 = new MovingBumper(725, 300, 75, 500);
					break;
			
				case 3:
					bumper = new MovingBumper(725, 0, 75, 350);
					bumper2 = new MovingBumper(725, 450, 75, 350);
					break;
			
				case 4:
					bumper = new MovingBumper(725, 0, 75, 500);
					bumper2 = new MovingBumper(725, 600, 75, 200);
					break;
			
				case 5:
					bumper = new MovingBumper(725, 0, 75, 600);
					bumper2 = new MovingBumper(725, 700, 75, 100);
					break;
					
				case 6:
					bumper = new MovingBumper(725, 0, 75, 675);
					bumper2 = new MovingBumper(725, 775, 75, 25);
					break;
			} 
      }
	}
	