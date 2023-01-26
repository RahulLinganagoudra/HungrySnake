package hungrysnake.core;

import java.util.Random;

public class SnakeBody {
	
	public Node head;
	Node currentNode;
        Node last = null;
        Point foodPos=null;
	public Tile tile=new Tile(10,10);
	int c=0;
	Random r=new Random();
	
	public SnakeBody(int defaultLength)
	{	
		head=new Node(0,0,null);
		tile.tile[0][0]++;
		currentNode=head;
		placeFood(new Point(r.nextInt(10),r.nextInt(10)));
		for(int i=0;i<defaultLength;i++)
		{
			tile.tile[0][1+i]++;
			currentNode.append(new Node(0,1+i,null));
			currentNode=currentNode.getNext();
		}
		
		
		
	}
	public boolean isDead()
	{
            Point hP=new Point(head.getPos());
            c=0;
            currentNode=head.getNext();
            while(currentNode!=null)
            {
                if(hP.equals(currentNode.getPos()))
                {
                    c++;
		}
                currentNode=currentNode.getNext();
            }
		return c>0;
	}
	public void UpdateHead(Point newPos)
        {
            UpdateHead(newPos.getX(),newPos.getY());
        }
	private void UpdateHead(int x,int y)
	{
			if(x<0)x=tile.tile.length-1;
			else x=x%tile.tile.length;
			if(y<0)y=tile.tile.length-1;
			else y=y%tile.tile.length;
			
		//reset tile values
		for(int i=0;i<tile.tile.length;i++)
			for(int j=0;j<tile.tile[i].length;j++)
				tile.tile[i][j]=0;
		
		c=0;
		
		Point previous=null, current;
		currentNode=head;
		
		
		
		current=new Point(currentNode.getPos());
		currentNode.setPos(new Point(x,y));
		currentNode=currentNode.getNext();
		tile.tile[x][y]++;
		currentNode=head.getNext();
		while(currentNode!=null) {
			
			previous=current;
			current=new Point(currentNode.getPos());
			currentNode.setPos(previous);
			tile.tile[currentNode.getX()][currentNode.getY()]++;
			if(currentNode.getNext()==null)
				last=currentNode;
                        /*if(hP.getX()==current.getX()
                        &&hP.getX()==current.getY())
                        {
                        c++;
                        }*/	
			currentNode=currentNode.getNext();
			
		}
		eat(previous);
	
        }
	public boolean isMovingBack(Point input)
    {
        if(head.getPos().add(input).equals(head.getNext().getPos()))
            return true;
        return false;
    }
        private void eat(Point previous)
        {
            if(foodPos==null)return;
            if(head.getPos().equals(foodPos))
            {
            	
                last.append(new Node(previous));
                placeFood(new Point(r.nextInt(10),r.nextInt(10)));
            }
        }
        public void placeFood(Point food)
        {
            foodPos=food;
        }
        public Point getFoodPos()
        {
        	return new Point(foodPos);
        }
        
}
