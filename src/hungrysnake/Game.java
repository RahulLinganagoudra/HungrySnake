package hungrysnake;

import java.awt.*;
import java.util.Random;

import hungrysnake.core.*;
import hungrysnake.core.Point;
/**
 * 
 * @author Rahul
 *	<p>Using Delay class for testing and all the code  inside it relevant for making full game
 *it shows how to use the existing code as LEGO bricks
 *
 */
class Delay extends Thread
{

	public void run()
	{
		Game game=new Game();
		int time=00;
		
		game.window.setVisible(true);
		while(time<60)
		{

            try {
				sleep(1000);
				time++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.err.println("Delay.run.catchBlock\nUnhandled exeption");
			}
           
            Paint(game,time);
            game.window.repaint();
			System.out.println(time);
		}
		game.window.setVisible(false);
		game.window.dispose();
	}
	void Paint(Game game,int time)
	{
		if(time%4!=0)
		{
			game.Move(null);
			game.Print();
			return;
		}
		Random r=new Random();
		
		int rand=r.nextInt(4);
		Point p;
		
		if(rand==0)p=Point.up;
		else if(rand==1)p=Point.down;
		else if(rand==2)p=Point.left;
		else p=Point.right;
		
		game.Move(p);
		game.Print();
	}
	
}
public class Game  {
	//Tile tile= new Tile(10,10);
	
		
		SnakeBody body=new SnakeBody(1);
        Frame window=new Frame();
        TextArea textArea=new TextArea();
        Point direction=Point.down;
        Game()
        {
        	window.add(textArea);
        	window.setMinimumSize(new Dimension(500,250));
        	textArea.setBounds(100,100,500,500);
        }
        public static void main(String args[])
        {
        	Delay d=new Delay();
        	d.start();
        }
        
        
        /**
         * this function is relevant only in the console application 
         * can reuse the code anyways
         */
        void Print()
        {
		
        	String textContent="";
		  
        	for(int i=0;i<body.tile.tile.length;i++)
        	{	
        		for(int j=0;j<body.tile.tile[i].length;j++)
        		{	
        			Point currentPoint=new Point(i,j);
        			if(currentPoint.equals(body.head.getPos()))textContent+="@\t";
        			else if(body.tile.tile[i][j]>0) {
		
					//System.out.print("*\t");
					textContent+="*\t";
				}
				else if(currentPoint.equals(body.getFoodPos()))
					textContent+="0\t";
				else 
					//System.out.print("-\t");
					textContent+="-\t";
        		}
        		textContent+="\n";
			//System.out.println();
			
			
        	}
        	textArea.setText(textContent);
		
        	if(body.isDead())
        	{	
        		System.out.println("gameOver");
        		window.setVisible(false);
			
        	}
        }
        public void Move(Point input)
        {
            if(input!=null&&!body.isMovingBack(input))
            	direction=input;
            body.UpdateHead(direction.add(body.head.pos));
            
        }
        
}
