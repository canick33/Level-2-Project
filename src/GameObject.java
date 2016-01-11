import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameObject implements KeyListener {
	boolean isJumping = false;
	private int x,y,w,h;
	public static void main (String[] args)
	{
	}
	public GameObject(int X,int Y,int W,int H)
	{
		x=X;
		y = Y;
		w = W;
		h = H;
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(x, y, w, h);
		
	}
	public void update()
	{
		
		x--;
		if(isJumping)
		{
			if(y<300)
			{
			 y--;
			}
			else
			{
				y++;
			}
			if(y<=20)
			{
				isJumping = false;
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			System.out.println("test"); 
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	
}


