import java.applet.*;
import java.awt.event.*;
import java.awt.*;
import java.net.*; 
import java.util.ArrayList;
public class Main extends Applet implements Runnable  {
	//Image variables and image stuff
	URL base;
	MediaTracker mt;
	private Image dbImage;
	private Graphics dbg;
	Image backgroundImage;
	Image marioStand;
	Image marioStandLeft;
	Image marioStand2;
	Image marioRunning;
	Image marioRunningLeft;
	Image marioJump;
	Image marioJumpLeft;
	Image questionBlock;
	Image goomba;
	Image koopa;
	Image squishedGoomba;
	boolean drawRectangles=false;
	int numColl=2;
	int x1;
	int y;
	int width;
	int height;
	int runCount=0;
	//background image width and height
	int backgroundImageHeight=(int)(203*2);
	int backgroundImageWidth=(int)(3392*2);
	int backgroundImageXPos=0;
	boolean spaceKeyUp=true;
	boolean jumpFromObject=false;
	int counter=0;
	boolean collided=false;
	boolean menuScreen=true;
	String keyPressed=""; //can be either "left" "right" or "" and keeps track of whether player is moving right left or still
	Player mario = new Player(249,backgroundImageHeight-85,30,40);

	Pipe pipe1 = new Pipe(896,305,63,58);
	Pipe pipe2 = new Pipe(1216,274,63,89);
	Pipe pipe3 = new Pipe(1472,247,63,116);
	Pipe pipe4 = new Pipe(1824,247,63,116);
	Pipe pipe5 = new Pipe(5216,305,63,57);
	Pipe pipe6 = new Pipe(5728,305,63,57);

	QuestionBlock questionBlock1=new QuestionBlock(511,245);
	QuestionBlock questionBlock2=new QuestionBlock(670,245);
	QuestionBlock questionBlock3=new QuestionBlock(735,245);
	QuestionBlock questionBlock4=new QuestionBlock(703,130);
	QuestionBlock questionBlock5=new QuestionBlock(2495,245);
	QuestionBlock questionBlock6=new QuestionBlock(3006,128);
	QuestionBlock questionBlock7=new QuestionBlock(3486,128);
	QuestionBlock questionBlock8=new QuestionBlock(3392,245);
	QuestionBlock questionBlock9=new QuestionBlock(3487,245);
	QuestionBlock questionBlock10=new QuestionBlock(3582,245);
	QuestionBlock questionBlock11=new QuestionBlock(4124,129);
	QuestionBlock questionBlock12=new QuestionBlock(4157,129);
	QuestionBlock questionBlock13=new QuestionBlock(5440,245);

	Brick brick1=new Brick(637,245);
	Brick brick2=new Brick (637+66,245);
	Brick brick3=new Brick(637+66+66,245);
	Brick brick4=new Brick(2495-33,245);
	Brick brick5=new Brick(2495+33,245);
	Brick brick6=new Brick(2495+66,128);
	Brick brick7=new Brick(2495+66+33,128);
	Brick brick8=new Brick(2495+66+66,128);
	Brick brick9=new Brick(2495+66+66+33,128);
	Brick brick10=new Brick(2495+66+66+66,128);
	Brick brick11=new Brick(2495+66+66+66+33,128);
	Brick brick12=new Brick(2495+66+66+66+66,128);
	Brick brick13=new Brick(2495+66+66+66+66+33,128);
	Brick brick14=new Brick(2910,128);
	Brick brick15=new Brick(2943,128);
	Brick brick16=new Brick(2943+33,128);
	Brick brick17=new Brick(2943+64,244);
	Brick brick18=new Brick(2943+64,244);
	Brick brick19=new Brick(2943+64+66+66+33+29,244);
	Brick brick20=new Brick(2943+64+66+66+33+29+33,244);

	Goomba goomba1 = new Goomba(960,331);
	Goomba goomba2 = new Goomba(700,331);
	Goomba goomba3 = new Goomba(1400,331);
	Goomba goomba4 = new Goomba(1700,331);
	Goomba goomba5 = new Goomba(1600,331);
	
	Koopa koopa1 = new Koopa(400,315);
	Koopa koopa2 = new Koopa (500,315);
	GameObject collidedObject;


	public void init()
	{
		resize(600,backgroundImageHeight);
		mt=new MediaTracker(this);
		try { 

			base = getDocumentBase(); 
		} 
		catch (Exception e) {}

		backgroundImage = getImage(base,"/C:/Users/Amita/workspace/CoolGame/src/Resources/backgroundImage.png"); 
		marioStand = getImage(base,"/C:/Users/Amita/workspace/CoolGame/src/Resources/marioStand.png"); 
		marioStandLeft = getImage(base,"/C:/Users/Amita/workspace/CoolGame/src/Resources/marioStandLeft.png");
		marioStand2 = getImage(base,"/C:/Users/Amita/workspace/CoolGame/bin/Resources/marioStand2.png"); 
		marioRunning=getImage(base,"/C:/Users/Amita/workspace/CoolGame/src/Resources/marioRunning.gif"); 
		marioRunningLeft=getImage(base,"/C:/Users/Amita/workspace/CoolGame/src/Resources/marioRunningLeft.gif"); 
		marioJump=getImage(base,"/C:/Users/Amita/workspace/CoolGame/src/Resources/marioJump.png"); 
		marioJumpLeft=getImage(base,"/C:/Users/Amita/workspace/CoolGame/src/Resources/marioJumpLeft.png");
		questionBlock=getImage(base,"/C:/Users/Amita/workspace/CoolGame/bin/Resources/questionBlock.png"); 
		goomba=getImage(base,"/C:/Users/Amita/workspace/CoolGame/src/Resources/goomba.gif"); 
		koopa=getImage(base,"/C:/Users/Amita/workspace/CoolGame/src/Resources/koopa.gif"); 
		squishedGoomba=getImage(base,"/C:/Users/Amita/workspace/CoolGame/src/Resources/squishedGoomba.gif");
		mt.addImage(backgroundImage,1);
		mt.addImage(marioStand,2);
		mt.addImage(marioStand2,3);
		mt.addImage(marioRunning,4);
		mt.addImage(marioRunningLeft,5);
		mt.addImage(marioStandLeft,6);
		mt.addImage(marioJump,7);
		mt.addImage(marioJumpLeft,8);
		mt.addImage(questionBlock,9);
		mt.addImage(goomba,10);
		mt.addImage(koopa, 11);
		mt.addImage(squishedGoomba,12);
		try { 
			mt.waitForAll(); 
		} 
		catch (InterruptedException  e) {} 


	}
	public void start ()
	{

		// define a new thread
		Thread th = new Thread (this);
		// start this thread
		th.start ();

	}
	public void stop ()
	{
		//nothing right now
	}
	public void destroy ()
	{
		//nothing right now
	}


	public void run() {
		Thread.currentThread ().setPriority (Thread.MIN_PRIORITY);
		while(true)
		{
			collidedObject=null;
			for (int counter2=0;counter2<Enemy.getEnemies().size();counter2++)
			{
				Enemy.getEnemies().get(counter2).setCollidedObject(null);
			}
			for (int counter=0;counter<GameObject.getGameObjects().size();counter++)
			{
				if (mario.getRectangle().intersects(GameObject.getGameObjects().get(counter).getRectangle()))
				{
					collidedObject=GameObject.getGameObjects().get(counter);
				}
				for (int counter2=0;counter2<Enemy.getEnemies().size();counter2++)
				{
					if (Enemy.getEnemies().get(counter2).getRectangle().intersects(QuestionBlock.getGameObjects().get(counter).getRectangle()))
					{
						Enemy.getEnemies().get(counter2).setCollidedObject(GameObject.getGameObjects().get(counter));

					}
				}
			}
			System.out.println(collidedObject);
			



			if (runCount%4==0)
			{
				for (int counter=0;counter<Enemy.getEnemies().size();counter++)
				{
					if(Enemy.getEnemies().get(counter).getCollidedObject()==null && Enemy.getEnemies().get(counter).getNumColl()%2==0)
					{
						//System.out.println("heya");
						Enemy.getEnemies().get(counter).increaseXPos(-1);
					}
					else if (Enemy.getEnemies().get(counter).getCollidedObject()!=null && Enemy.getEnemies().get(counter).getNumColl()%2==0)
					{
						Enemy.getEnemies().get(counter).increaseNumColl(1);
						Enemy.getEnemies().get(counter).increaseXPos(1);
						//System.out.println("turning around");
					}
					else if (Enemy.getEnemies().get(counter).getCollidedObject()==null && Enemy.getEnemies().get(counter).getNumColl()%2!=0)
					{
						Enemy.getEnemies().get(counter).increaseXPos(1);
					}
					else if (Enemy.getEnemies().get(counter).getCollidedObject()!=null && Enemy.getEnemies().get(counter).getNumColl()%2!=0)
					{
						//System.out.print(numColl%2);
						//System.out.println(numColl);
						Enemy.getEnemies().get(counter).increaseNumColl(1);
						Enemy.getEnemies().get(counter).increaseXPos(-1);
						//System.out.print("wowzers ");


					}
				}
			}

			if ((keyPressed.equals("right")))
			{
				if (collidedObject==null || mario.isRight(collidedObject)  || mario.isActuallyAbove(collidedObject))
				{
					if (mario.xPos()<249)
					{
						mario.increaseXPos(1);
					}
					else if (mario.xPos()==249)
					{
						backgroundImageXPos-=1;
						for (int counter=0;counter<BackgroundObject.getBackgroundObjects().size();counter++)
						{
							BackgroundObject.getBackgroundObjects().get(counter).increaseXPos(-1);
						}
						for (int counter=0;counter<Enemy.getEnemies().size();counter++)
						{
							Enemy.getEnemies().get(counter).increaseXPos(-1);
						}
					}
				}
			}

			else if (keyPressed.equals("left"))
			{
				if (collidedObject==null || mario.isLeft(collidedObject) || mario.isActuallyAbove(collidedObject))
				{
					if(mario.xPos()>0)
					{
						mario.increaseXPos(-1);

					}
				}
			}

			if (collidedObject==null && mario.isInAir())
			{
				mario.setIsJumping(true);
				//System.out.println("somethings cool");
			}

			if (mario.isJumping()==true)
			{

				if (counter%mario.jumpArchLength()==0)
				{
					mario.increaseYPos(-mario.ySpeed());
					mario.increaseYSpeed(-mario.jumpSpeed());
				}
				if (collidedObject!=null && mario.isBelow(collidedObject))
				{
					mario.setYSpeed(0); 
					mario.setYPos(collidedObject.yPos()+collidedObject.getHeight());
				}

				if (mario.yPos()>=mario.groundYPos() || jumpFromObject == true || (collidedObject!= null && mario.isAbove(collidedObject)))
				{
					mario.setIsJumping(false);
					jumpFromObject=false;
					if (collidedObject!=null && mario.isAbove(collidedObject))
					{
						mario.setYPos(collidedObject.yPos()-mario.height()+1);
					}
					else 
					{
						mario.setYPos(mario.groundYPos());
						mario.setYSpeed(mario.initialYSpeed());
					}
				}
				counter++;
			}
			repaint ();
			runCount++;
			try
			{
				// Stop thread for 20 milliseconds
				Thread.sleep (5);
			}
			catch (InterruptedException ex)
			{
				// do nothing
			}

			// set ThreadPriority to maximum value
			Thread.currentThread ().setPriority (Thread.MAX_PRIORITY);
		}

	}

	public boolean keyDown (Event e, int key)
	{
		if (key==Event.RIGHT && (mario.isJumping()==false || mario.dirFacing().equals("right")))
		{
			keyPressed="right";
			mario.setDirFacing("right");
		}
		else if (key==Event.LEFT&& (mario.isJumping()==false || mario.dirFacing().equals("left")))
		{
			keyPressed="left";
			mario.setDirFacing("left");
		}
		else if (key==32 && (mario.isJumping()==false /*|| keyPressed.equals("")*/) && spaceKeyUp == true)
		{
			mario.setIsJumping(true);
			counter=0;
			mario.increaseYPos(-1);
			mario.setYSpeed(mario.initialYSpeed());
			spaceKeyUp=false;

		}

		return true;
	}

	public boolean keyUp (Event e, int key)
	{
		if (key == Event.LEFT || key == Event.RIGHT || key == Event.UP || key == Event.DOWN )
		{
			keyPressed = ""; 	

		}
		if (key == 32)
		{
			spaceKeyUp=true;
		}
		return true;
	}
	public void update (Graphics g)
	{

		// initialize buffer
		if (dbImage == null)
		{
			dbImage = createImage (this.getSize ().width, this.getSize ().height);
			dbg = dbImage.getGraphics ();
		}

		// clear screen in background
		dbg.setColor (getBackground ());
		dbg.fillRect (0, 0, this.getSize ().width, this.getSize ().height);

		// draw elements in background
		dbg.setColor (getForeground ());
		paint (dbg);

		// draw image on the screen
		g.drawImage (dbImage, 0, 0, this);

	}
	public void paint(Graphics g)
	{

		if (menuScreen == true)
		{
			g.drawImage(backgroundImage,backgroundImageXPos,0,backgroundImageWidth,backgroundImageHeight, this);
			g.drawImage(goomba,goomba1.getX(),goomba1.getY(),this);
			g.drawImage(goomba,goomba2.getX(),goomba2.getY(),this);
			g.drawImage(goomba,goomba3.getX(),goomba3.getY(),this);
			g.drawImage(goomba,goomba4.getX(),goomba3.getY(),this);
			g.drawImage(goomba,goomba5.getX(),goomba3.getY(),this);
			g.drawImage(koopa,koopa1.getX(),koopa1.getY(),this);
			//g.drawRect(goomba1.getX(), goomba1.getY(), goomba1.getWidth(), goomba1.getHeight());
			if (drawRectangles==true)
			{
				for (int counter=0;counter<GameObject.getGameObjects().size();counter++)
				{
					g.drawRect((int)GameObject.getGameObjects().get(counter).getRectangle().getX(),(int)QuestionBlock.getGameObjects().get(counter).getRectangle().getY(),(int)GameObject.getGameObjects().get(counter).getRectangle().getWidth(),(int)GameObject.getGameObjects().get(counter).getRectangle().getHeight());
				}

				g.drawRect((int)mario.getRectangle().getX(),(int)mario.getRectangle().getY(),(int)mario.getRectangle().getWidth(),(int)mario.getRectangle().getHeight());
			}
			if (keyPressed.equals("right")&& mario.isJumping()==false)
			{
				g.drawImage(marioRunning,mario.xPos(),mario.yPos(),mario.width(),mario.height(), this); 

			}
			else if (keyPressed.equals("left")&&mario.isJumping()==false)
			{
				g.drawImage(marioRunningLeft,mario.xPos(),mario.yPos(),mario.width(),mario.height(), this); 
			}
			else if (keyPressed.equals("")&&mario.isJumping()==false)
			{

				mario.setWidth(mario.initialWidth());
				mario.setHeight(mario.initialHeight());
				if (mario.dirFacing().equals("right"))
				{

					g.drawImage(marioStand,mario.xPos(),mario.yPos(),mario.width(),mario.height(), this); 
				}
				else
				{
					g.drawImage(marioStandLeft,mario.xPos(),mario.yPos(),mario.width(),mario.height(), this); 	
				}
			}
			else if (mario.isJumping()==true)
			{
				if (mario.dirFacing().equals("right"))
				{
					g.drawImage(marioJump,mario.xPos(),mario.yPos(),mario.width()+2,mario.height(), this); 
				}
				else
				{
					g.drawImage(marioJumpLeft,mario.xPos(),mario.yPos(),mario.width(),mario.height(), this); 
				}
			}

		}
	}


}
