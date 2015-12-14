import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Animation extends JPanel{
	private int x,y,w,h;
	GameObject dinosaur;
	GameObject cactus;
	public Animation()
	{
		x = 100;
		y = 390;
		w = 50;
		h = 100;
		dinosaur = new GameObject(x,y,w,h);
		cactus = new GameObject(1000,390,25,100);

	}
	
	public void paint(Graphics g)
	{
		dinosaur.paint(g);
		cactus.paint(g);
	}
	

}
