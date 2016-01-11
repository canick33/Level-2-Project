import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;
import javax.swing.JPanel;

public class Animation extends JPanel implements ActionListener{
	private int x,y,w,h;
	GameObject dinosaur;
	GameObject cactus;
	Timer t;
	boolean isJumping = false;
	public Animation()
	{
		x = 1000;
		y = 390;
		w = 25;
		h = 100;
		dinosaur = new GameObject(100,390,50,100);
		
		cactus = new GameObject(x,y,w,h);
		t = new Timer(1000/60,this);
		t.start();

	}
	public void keyPressed(KeyEvent e) {

		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			isJumping = true;
		}
	}
	
	public void paint(Graphics g)
	{
		dinosaur.paint(g);
		cactus.paint(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		cactus.update();
	
		repaint();
	}

	


}