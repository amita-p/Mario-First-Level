import java.awt.Rectangle;
import java.awt.image.*;
import java.util.ArrayList;

public class Enemy {
    int width;
    int height;
    int xPos;
    int yPos;
    Rectangle rectangle;
    GameObject collidedObject=null;
    static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private int numColl=2;
	public Enemy(int x, int y,int w,int h)  {
		
		xPos=x;
		yPos=y;
		width=w;
		height=h;
		rectangle = new Rectangle (xPos,yPos,width,height);
		enemies.add(this);
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeight()
	{
		return height;
	}
	public GameObject getCollidedObject()
	{
		return collidedObject;
	}
	public void setCollidedObject(GameObject collided)
	{
		collidedObject=collided;
	}
	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}
	public void changeXPos(int pos)
	{
		xPos=pos;
		rectangle = new Rectangle (xPos,yPos,width,height);
	}
	public void changeYPos(int pos)
	{
		yPos=pos;
		rectangle = new Rectangle (xPos,yPos,width,height);
	}
	public void increaseXPos(int increase)
	{
		xPos+=increase;
		rectangle = new Rectangle (xPos,yPos,width,height);
	}
	public void increaseYPos(int increase)
	{
		yPos+=increase;
		rectangle = new Rectangle (xPos,yPos,width,height);
	}
	public Rectangle getRectangle()
	{
		return rectangle;
	}
	public static ArrayList<Enemy> getEnemies()
	{
		return enemies;
	}
	public int getNumColl()
	{
		return numColl;
	}
	public void increaseNumColl(int increase)
	{
		numColl+=increase;
		
	}
	
	

}
