import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameObject implements KeyListener {
	boolean isJumping;
	boolean isFalling;
	int count;
	int speed;
	private int x,y,w,h;
	public static void main (String[] args)
	{
	}
	public GameObject(int X,int Y,int W,int H,int Speed)
	{
		x=X;
		y = Y;
		w = W;
		h = H;
		speed =Speed;
	}
	public void paint(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(x, y, w, h);
		
	}
	public void Cactusupdate(int s)
	{
		x-=s;

	}
	public boolean isJumping() {
		return isJumping;
	}
	public void setJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public void Dinoupdate()
	{
		
		if(isJumping)
		{
			if(isFalling)
			{
				y = y+10;
			}
			else{
				
			if(y>150)
			{
				 y = y-10;
			}
			else
			{
				isFalling = true;
					 y = y+1;
			}

			}
			if(y>=390)
			{
				isJumping = false;
				isFalling = false;
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
	public boolean getisJumping()
	{
		return isJumping;
	}
	public void setisJumping(boolean jump)
	{
		System.out.println(isJumping);
		isJumping = jump;
	}
	

	
}


