package hungrysnake.core;

public class Node {
	public Point pos;
	private Node next;
	Node(int x,int y,Node next)
	{
		setPos(x,y);
		append(next);
	}
	public Node(Point previous) {
		setPos(previous);
		append(null);
	}
	public void append()
	{
		this.next=new Node(pos.getX(),pos.getY(),null);
	}
	public void append(Node node)
	{
		this.next=node;
	}
	public Node getNext() 
	{
		return next;
	}
	public void setPos(int x,int y)
	{
		setPos(new Point(x,y));
	}
	public void  setPos(Point pos)
	{
		this.pos=new Point(pos.getX(),pos.getY());
	}
	public Point getPos()
	{
		return new Point(pos);
	}

	public int getX() 
	{
		return pos.getX();
	}
	public int getY() 
	{
		return pos.getY();
	}

}
