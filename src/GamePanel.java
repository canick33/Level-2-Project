import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
	int x = 100;
	int y = 100;
	BufferedImage image;
	BufferedImage image2;
	BufferedImage currentImage;
	BufferedImage background;
	byte count;
	Timer t;
	ImageObject i;
	ImageObject b;

	public void paintComponent(Graphics g)
	{
		g.drawImage(background, 0, 0, 2000, 500, null);
		i.draw(g);
		b.draw(g);

	}
	public GamePanel()
	{
		try {
			image = ImageIO.read(this.getClass().getResourceAsStream("dino.png"));
			image2 = ImageIO.read(this.getClass().getResourceAsStream("cactus.png"));
			background = ImageIO.read(this.getClass().getResourceAsStream("mirrorImage.png"));

			i= new ImageObject(100,100,-50,-50,image);
			currentImage = image;
			b = new ImageObject(5,10,35,40,image2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timer t = new Timer(1000/60,this);
		t.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (currentImage == image)
		{
			currentImage = image2;
		}
		else
		{
			currentImage = image;
		}
		i = new ImageObject(i.getX(),i.getY(),-50,-50,currentImage);

		i.update();

		b.update();
		
		repaint();
		
	}

}
