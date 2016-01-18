import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.JPanel;

public class Animation extends JPanel implements ActionListener{
	private int x,y,w,h;
	GameObject dinosaur;
	GameObject cactus;
	int count=0;

	ArrayList<GameObject>cactusList;
	Timer t;
	public Animation()
	{
		cactusList = new ArrayList<GameObject>();
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
			dinosaur.setisJumping(true);
		}
	}
	
	public void paint(Graphics g)
	{
		dinosaur.paint(g);
		for(int i = 0;i<cactusList.size();i++)
		{
			GameObject go = cactusList.get(i);
			go.paint(g);
		}
		cactus.paint(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		cactus.Cactusupdate();
		dinosaur.Dinoupdate();
		count++;
		for(int i =0;i<cactusList.size();i++){
			GameObject go = cactusList.get(i);
			go.Cactusupdate();
		}
		
		if(cactus.getX()>100 && cactus.getX()<150)
		{
			if(dinosaur.getY()>350)
			{
				System.out.println("Game OVER");
				System.exit(0);;
			}
		}
		if(count ==240)
		{
			count =0;
			addCactus();

		}
		repaint();
	}

	private void addCactus()
	{
		cactusList.add(new GameObject(1000,390,25,100));

		{
			
		}
	}


}