import java.awt.Rectangle;
import java.util.ArrayList;


public class GameObject {
	int xPos;
    int yPos;
    int width;
    int height;
    Rectangle rectangle;
    static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	public GameObject(int x,int y,int w,int h) {
		// TODO Auto-generated constructor stub
		xPos=x;
		yPos=y;
		width=w;
		height=h;
		rectangle = new Rectangle (xPos,yPos,width,height);
		gameObjects.add(this);
	}
	
	public int getHeight()
	{
		return height;
	}
	public int getWidth()
	{
		return width;
	}
	public Rectangle getRectangle()
	{
		return rectangle;
	}
	public int xPos ()
	{
		return xPos;
	}
	public int yPos()
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
	public static ArrayList<GameObject> getGameObjects()
	{
		return gameObjects;
	}

}
