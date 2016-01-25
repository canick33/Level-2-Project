import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JPanel;

public class Animation extends JPanel implements ActionListener {
	private int x, y, w, h;
	GameObject dinosaur;
	GameObject cactus;
	int s = 4;
	int count = 0;
	int speedCount = 0;

	ArrayList<GameObject> cactusList;
	Timer t;

	public Animation() {
		cactusList = new ArrayList<GameObject>();
		x = 1000;
		y = 390;
		w = 25;
		h = 100;
		dinosaur = new GameObject(100, 390, 50, 100, 0);

		t = new Timer(1000 / 60, this);
		t.start();

	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			dinosaur.setisJumping(true);
		}
	}

	public void paint(Graphics g) {
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
				if (dinosaur.getY() > 350) {
					System.out.println("Game OVER");
					System.exit(0);
					;
				}
			}
		}
		Random r = new Random();
		x = r.nextInt(200);
		if (count >= 100+x) {
			count = 0;
			addCactus();

		}
		if (speedCount ==250) {
			s=s+1;
			speedCount =0;
		}
		repaint();
	}

	private void addCactus() {
		cactusList.add(new GameObject(2000, 390, 25, 100, s));

		{

		}
	}

}