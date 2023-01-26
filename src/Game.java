package hungrysnake;
import hungrysnake.core.*;
public class Game {
	//Tile tile= new Tile(10,10);
	SnakeBody body=new SnakeBody(1);
	
	public static void main(String args[])
	{
		new Game().Print();
	}
	void Print()
	{
		
		for(int i=0;i<body.tile.tile.length;i++)
		{	
			for(int j=0;j<body.tile.tile[i].length;j++)
			{	
				
				if(body.tile.tile[i][j]>0) {
		
					System.out.print("*\t");
				}
				else 
					System.out.print("-\t");
			}
			System.out.println();
		}
		if(body.isDead())
			System.out.println("gameOver");
	}
	
	
}
