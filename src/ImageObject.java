import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ImageObject extends GObject {
	BufferedImage image;
	public ImageObject(int x,int y, int w,int h,BufferedImage Image)
	{
		super(x,y,w,h);

		image = Image;
	}
	public void draw(Graphics g)
	{
		g.drawImage(image,x, y, w, h,  null);
	}

}
