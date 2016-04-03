import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Animation extends JPanel implements ActionListener {
	private int x, y, w, h;
	GameObject dinosaur;
	BufferedImage cactusImage;
	int s = 4;
	int count = 0;
	int speedCount = 0;
	String color;
	BufferedImage background;
	BufferedImage background1;
	BufferedImage dino;
	BufferedImage cactus;

	ArrayList<GameObject> cactusList;
	Timer t;

	public Animation() {
		try {
			background = ImageIO.read(this.getClass().getResourceAsStream("mirrorimage.png"));
			background1 = ImageIO.read(this.getClass().getResourceAsStream("mirrorimage.png"));
			dino = ImageIO.read(this.getClass().getResourceAsStream("dino.png"));
			cactusImage = ImageIO.read(this.getClass().getResourceAsStream("cactus.png"));
		
		} catch (Exception e) {

		}
		cactusList = new ArrayList<GameObject>();
		x = 1000;
		y = 390;
		w = 25;
		h = 100;
		dinosaur = new GameObject(100, 390, 50, 100, 0, dino);

		t = new Timer(1000 / 60, this);
		t.start();

	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			dinosaur.setisJumping(true);
		}
	}

	int v = 0;
	int p = 1999;

	public void paint(Graphics g) {
		g.drawImage(background, v = v - (s - 2), 0, 2000, 500, null);
		g.drawImage(background1, p = p - (s - 2), 0, 2000, 500, null);
		if (v <= -2000) {
			v = 2000;
		}
		if (p <= -2000) {
			p = 2000;
		}
		dinosaur.paint(g);
		for (int i = 0; i < cactusList.size(); i++) {
			GameObject go = cactusList.get(i);
			go.paint(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dinosaur.Dinoupdate();
		count++;
		speedCount++;
		for (int i = 0; i < cactusList.size(); i++) {
			GameObject go = cactusList.get(i);
			go.Cactusupdate(s);
		}
		for (GameObject go : cactusList) {

			if (go.getX() > 100 && go.getX() < 150) {
				if (dinosaur.getY() > 290) {
					System.out.println("Game OVER");
					System.exit(0);
					;
				}
			}
		}
		Random r = new Random();
		x = r.nextInt(250) * 2;
		if (count >= 100 + x) {
			count = 0;
			addCactus();

		}
		if (speedCount == 250) {
			s = s + 1;
			speedCount = 0;
		}
		repaint();
	}

	private void addCactus() {
		 cactusList.add(new GameObject(2000, 390, 25, 100, s,cactusImage ));

		{

		}
	}

}