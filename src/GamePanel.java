import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
	int x = 100;
	int y = 100;
	boolean right;
	boolean up;
	Timer t;
	public void paintComponent(Graphics g)
	{
		g.fillRect(x,y,10,10);
	}
	public GamePanel()
	{
		Timer t = new Timer(1000/60,this);
		t.start();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (right)
		{
			x++;
		}
		else{
			x--;
		}
		if(up)
		{
			y--;
		}
		else
		{
			y++;
		}
		if (x <=100 && y ==10)
		{
			right = true;
		}
		else if (x>=10 && y ==100)
		{
			right = false;
		}
		else if (x ==100 && y<=100)
		{
			up = false;
		}
		else if (x ==10 && y >=10)
		{
			up = true;
		}
		repaint();
		
	}

}
