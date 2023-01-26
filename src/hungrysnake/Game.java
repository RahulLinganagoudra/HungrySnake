package hungrysnake;

import hungrysnake.core.*;

public class Game  {
	//Tile tile= new Tile(10,10);
	SnakeBody body=new SnakeBody(1);
        static Point up,down,left,right;
	public static void main(String args[])
	{
            Game game=new Game();
            game.Print();
            Move(up);
		UpdateHead(1,1);
		UpdateHead(2,1);
                foodPos=new Point(2,2);
		UpdateHead(2,2);
		UpdateHead(2,3);
                foodPos=new Point(1,2);
		UpdateHead(1,3);
		UpdateHead(1,2);
		UpdateHead(1,1);
		
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
        public void Move(Point input)
        {
            if(movingBack(input))return;
            body.UpdateHead(input.add(body.head.pos));
            
        }
        private boolean movingBack(Point input)
        {
            if(body.head.getPos().add()X()&&
                    body.head.getY()+input.getY()==body.head.getNext().getY())
                return true;
            return false;
        }

    
	
}
