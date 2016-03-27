import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GObject {
	 int x,y,w,h;
	
	public GObject(int X, int Y, int W, int H)
	{
		x = X;
		y = Y;
		w= W;
		h = H;

	}
	public void update()
	{
		x = x+5;
	}
	public void draw(Graphics g)
	{
		
		g.fillRect(x, y, w, h);
 

	}
}
