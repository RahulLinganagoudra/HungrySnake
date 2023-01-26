package hungrysnake.core;

public class Node {
	public Point pos;
	private Node next;
	Node(int x,int y,Node next)
	{
		setPos(x,y);
		append(next);
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
	public void  setPos(int x,int y)
	{
		pos=new Point(x,y);
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
