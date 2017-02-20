import java.util.ArrayList;


public class BackgroundObject extends GameObject{
	static ArrayList<BackgroundObject> backgroundObjects = new ArrayList<BackgroundObject>();
	public BackgroundObject(int x, int y, int w, int h) {
		super(x,y,w,h);
		backgroundObjects.add(this);
	}
	public static ArrayList<BackgroundObject> getBackgroundObjects()
	{
		return backgroundObjects;
	}

}
