package hungrysnake.core;

public class SnakeBody {
	
	public Node head;
	Node currentNode;
        Node last = null;
        Point foodPos=null;
	public Tile tile=new Tile(10,10);
	int c=0;
	public SnakeBody(int defaultLength)
	{	
		head=new Node(0,0,null);
		tile.tile[0][0]++;
		currentNode=head;
		
		for(int i=0;i<defaultLength;i++)
		{
			tile.tile[0][1+i]++;
			currentNode.append(new Node(0,1+i,null));
			currentNode=currentNode.getNext();
		}
		
		
		
	}
	public boolean isDead()
	{
            Point hP=new Point(head.getX(),head.getY());
            c=0;
            currentNode=head;
            while(currentNode!=null)
            {
                if(hP.getX()==currentNode.getX()&&hP.getX()==currentNode.getY())
                {
                    c++;
		}
                currentNode=currentNode.getNext();
            }
		return c>1;
	}
	public void UpdateHead(Point newPos)
        {
            UpdateHead(newPos.getX(),newPos.getY());
        }
	private void UpdateHead(int x,int y)
	{
            x=x%tile.tile.length;
            y=y%tile.tile.length;
		//reset tile values
		for(int i=0;i<tile.tile.length;i++)
			for(int j=0;j<tile.tile[i].length;j++)
				tile.tile[i][j]=0;
		
		c=0;
		
		Point previous, current;
		currentNode=head;
		
		
		
		current=new Point(currentNode.getX(),currentNode.getY());
		currentNode.setPos(x,y);
		currentNode=currentNode.getNext();
		tile.tile[x][y]++;
		currentNode=head.getNext();
		Point hP=new Point(head.getX(),head.getY());
		
		
		while(currentNode!=null) {
			
			previous=current;
			current=new Point(currentNode.getX(),currentNode.getY());
			currentNode.setPos(previous.getX(),previous.getY());
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
		eat();
	
        }
        public void eat()
        {
            if(foodPos==null)return;
            if(head.getX()==foodPos.getX()&&
                    head.getY()==foodPos.getY())
            {
                last.append();
            }
        }
        public void placeFood(Point food)
        {
            foodPos=food;
        }
        
        
}
