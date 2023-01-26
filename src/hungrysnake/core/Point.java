package hungrysnake.core;

public class Point {
	
	public static final Point 
	zero=new Point(0,0),
	one=new Point(1,1),
	up	=new Point(0,1),
	down=new Point(0,-1),
	left=new Point(-1,0),
	right=new Point(1,0);
	
	private int x,y;
	public Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	public Point(Point other)
	{
		if(other==null) {System.out.println("other is null");other=zero;}
		
		x=other.x;
		y=other.y;
		
		int size=10;
		if(x<0)x=size-1;
		else x=x%size;
		if(y<0)y=size-1;
		else y=y%size;
		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
        public Point add(Point other)
        {
        	if(other==null) {
    			System.out.println("other is null");
    			return this;
    		}
            return new Point(this.x+other.x,this.y+other.y);
        }
	public boolean equals(Point other)
	{
		if(other==null) {
			System.out.println("other is null");
			return false;
		}
		if(x!=other.x||y!=other.y)return false;
		return true;
	}
	
}
