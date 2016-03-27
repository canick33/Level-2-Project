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
	Timer t;
	ImageObject i = new ImageObject(100,150,100,100,image);

	public void paintComponent(Graphics g)
	{

		i.draw(g);

	}
	public GamePanel()
	{
		try {
			image = ImageIO.read(this.getClass().getResourceAsStream("dino.png"));
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
		i.update();
		
		repaint();
		
	}

}
