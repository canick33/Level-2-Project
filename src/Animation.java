
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animation extends JPanel implements ActionListener {
	private int x, y, w, h;
	GameObject dinosaur;
	BufferedImage cactusImage;
	int t1 = 300;
	String time;
	int menuState = 0;
	int gameState = 1;
	int endState = 2;
	int gameOverScreen = 0;
	int currentState = 0;
	int s = 4;
	int count = 0;
	int speedCount = 0;
	boolean Start = false;
	String color;
	BufferedImage background;
	BufferedImage start;

	BufferedImage gameOver;
	BufferedImage background1;
	BufferedImage dino;
	BufferedImage cactus;
	JLabel score;
	int score1;
	boolean win = true;

	ArrayList<GameObject> cactusList;
	Timer t;

	public Animation() {
		score = new JLabel();
		score.setBounds(500, 50, 100, 50);
		add(score);

		try {
			background = ImageIO.read(this.getClass().getResourceAsStream("mirrorimage.png"));
			background1 = ImageIO.read(this.getClass().getResourceAsStream("mirrorimage.png"));
			dino = ImageIO.read(this.getClass().getResourceAsStream("dino.png"));
			cactusImage = ImageIO.read(this.getClass().getResourceAsStream("cactus.png"));
			gameOver = ImageIO.read(this.getClass().getResourceAsStream("images.png"));
			start = ImageIO.read(this.getClass().getResourceAsStream("start.jpg"));

		} catch (Exception e) {

		}
		cactusList = new ArrayList<GameObject>();
		dinosaur = new GameObject(250, 390, 50, 100, 0, dino);

		t = new Timer(1000 / 60, this);
		t.start();

	}

	public void setStart(boolean s) {
		Start = s;
	}

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (!dinosaur.getisJumping()) {
				dinosaur.jump();
				dinosaur.setisJumping(true);

			}

		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Start = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_R)
		{
			Start = false;
			win = true;
			currentState = menuState;
			cactusList.clear();
			gameOverScreen = 0;
			repaint();
		}
	}

	int v = 0;
	int p = 1999;

	public void paintComponent(Graphics g) {
		if (currentState == menuState) {
			drawMenuState(g);
		}
		if (currentState == gameState) {
			DrawGameState(g);
		}
		if (!win) {
			gameOverScreen = 2;
			DrawEndState(g);
		}
	}

	public void DrawGameState(Graphics g) {

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

	public void drawMenuState(Graphics g) {
		time = ("PRESS ENTER TO BEGIN");
		g.drawImage(start, 0, 0, 1500, 500, null);
		g.drawString(time, 30, 10);
		if (Start) {
			currentState = gameState;
			score1 = 0;
			s = 3;
		}

	}

	public void DrawEndState(Graphics g) {
		g.drawImage(gameOver, 0, 0, 1500, 500, null);
		time= ("press R to Restart");
		g.drawString(time, 30, 10);


	}

	public void setCurrentState(int x) {
		currentState = x;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		t1 -= 1;
		// TODO Auto-generated method stub
		dinosaur.Dinoupdate();
		if (gameOverScreen !=2)
		{
		score1 += 1;
		}
		score.setText("SCORE: " + score1);
		count++;
		speedCount++;
		for (int i = 0; i < cactusList.size(); i++) {
			GameObject go = cactusList.get(i);
			go.Cactusupdate(s);
		}
		for (GameObject go : cactusList) {

			if (go.getX() > 225 && go.getX() < 275) {
				if (dinosaur.getY() > 290) {
					if (win) {
						System.out.println("Game OVER");
						// Where I should add Restart stuff...
						win = false;
					}
				}
			}
		}
		Random r = new Random();
		x = r.nextInt(500);
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
		cactusList.add(new GameObject(2000, 390, 50, 100, s, cactusImage));

	}

	public boolean WinStatus() {
		return win;
	}

}