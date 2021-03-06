import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GameObject implements KeyListener {
	boolean isJumping;
	boolean isFalling;
	int count;
	int speed;
	private String color;
	private int x, y, w, h;
	BufferedImage image;
	int hopCount;
	int hopSpeed = 2;
	int jumpSpeed = 16;
	SoundPlayer sound;
	int jumpcount = 0;

	public static void main(String[] args) {
	}

	public GameObject(int X, int Y, int W, int H, int Speed, BufferedImage Image) {
		sound = new SoundPlayer("jump.wav");
		x = X;
		y = Y;
		w = W;
		h = H;
		speed = Speed;
		image = Image;

	}

	public void paint(Graphics g) {

		g.drawImage(image, x, y, w, h, null);

	}

	public void Cactusupdate(int s) {
		x -= s;

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

	public void Dinoupdate() {
		
		count++;
		if(isJumping)
		{
			if (count%2 ==0)
			{
	
					jumpSpeed--;
			}
				y = y-jumpSpeed;
						
			if(y >390)
			{
				isJumping = false;
				jumpSpeed = 16;
				y = 390;
			}
			}
			if(!isJumping)
			{
				if(count%5 ==0)
				{
					hopSpeed*=-1;
				}
				y-=hopSpeed;
			}
	}
	
		
	
	void jump() {
		
		new Thread(sound).start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.out.println("test");
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean getisJumping() {
		return isJumping;
	}

	public void setisJumping(boolean jump) {
		isJumping = jump;
	}

}
