import java.awt.Rectangle;


public class Player {
	private int yPos;
	private int xPos;
	int groundYPos; //y coordinate in which player is on ground
	private int width; 
	private int height;
	private int initialWidth; //initial width (width during standing position)
	private int initialHeight; //initial height (height during standing position)
	private Rectangle rectangle; //rectangle object which player fits in
	private int initialYSpeed; //starting speed in y direction
	private int ySpeed; //speed while jumping (changes throughout jump due to acceleration)
	private int jumpArchLength; //variable which adjusts how wide the jump is
	private boolean isJumping; //keeps track of whether player is jumping or not
	private String dirFacing="right"; //keeps track of which direction the player is facing
	private int jumpSpeed; //how fast the jump is...pretty much the acceleration
	private int xSpeed=1;
	public Player(int x,int y,int widthPlayer,int heightPlayer) {
		yPos=y;
		xPos=x;
		width=widthPlayer;
		height=heightPlayer;
		rectangle = new Rectangle(xPos,yPos,width,height);
		initialYSpeed=25;
		ySpeed=initialYSpeed;
		jumpArchLength=7;
		groundYPos=yPos;
		isJumping=false;
		jumpSpeed=3;
		initialWidth=width;
		initialHeight=height;
	}
	public boolean isInAir()
	{
		if (yPos<groundYPos)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isAbove(GameObject block)
	{
		if (yPos+height<=block.yPos()+(int)block.getHeight())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isActuallyAbove(GameObject object)
	{
		if (yPos+height<=object.yPos()+1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isRight(GameObject block)
	{
		if (xPos>=block.xPos+(int)block.getWidth()/2)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean isLeft(GameObject block)
	{
		if (xPos<block.xPos+(int)block.getWidth()/2)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public boolean isBelow(GameObject block)
	{
		if (yPos+height>block.yPos() + block.getWidth())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int jumpSpeed()
	{
		return jumpSpeed;
	}
	public void increaseXPos(int x)
	{
		xPos+=x;
		rectangle = new Rectangle(xPos,yPos,width,height);
	}
	public void increaseYPos(int y)
	{
		yPos+=y;
		rectangle = new Rectangle(xPos,yPos,width,height);
	}
	public int xPos()
	{
		return xPos;
	}
	public int yPos()
	{
		return yPos;
	}

	public Rectangle getRectangle()
	{
		return rectangle;
	}
	public void setWidth(int widthh)
	{
		width=widthh;
		rectangle = new Rectangle(xPos,yPos,width,height);
	}
	public void setHeight(int heightt)
	{
		height=heightt;
		rectangle = new Rectangle(xPos,yPos,width,height);
	}
	public void setXPos(int x)
	{
		xPos=x;
		rectangle = new Rectangle(xPos,yPos,width,height);
	}
	public void setYPos(int y)
	{
		yPos=y;
		rectangle = new Rectangle(xPos,yPos,width,height);
	}
	public int groundYPos()
	{
		return groundYPos;
	}
	public int width()
	{
		return width;
	}
	public int height()
	{
		return height;
	}
	public int ySpeed()
	{
		return ySpeed;
	}
	public int initialYSpeed()
	{
		return initialYSpeed;
	}
	public void increaseYSpeed(int x)
	{
		ySpeed+=x;

	}
	public void setYSpeed(int speed)
	{
		ySpeed=speed;
	}
	public boolean isJumping()
	{
		return isJumping;
	}
	public void setIsJumping(boolean jumping)
	{
		isJumping=jumping;
	}
	public int jumpArchLength()
	{
		return jumpArchLength;
	}
	public String dirFacing()
	{
		return dirFacing;
	}
	public void setDirFacing(String dir)
	{
		dirFacing=dir;
	}
	public int initialHeight()
	{
		return initialHeight;
	}
	public int initialWidth()
	{
		return initialWidth;
	}
	public int getXSpeed()
	{
		return xSpeed;
	}
}
