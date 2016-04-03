import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class GameWindow implements KeyListener, MouseListener, MouseMotionListener{
	JFrame frame;
	GamePanel panel;
	public static void main(String[] args)
	{
		GameWindow gw = new GameWindow();

	}
	public GameWindow()
	{
		JFrame frame = new JFrame();
		panel = new GamePanel();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.addKeyListener(this);
		frame.addMouseListener(this);
		frame.addMouseListener(this);
		frame.setSize(500,500);
	}
	@Override
	public void mouseDragged(MouseEvent e) {
	InputManager.mouseDragged(e);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		InputManager.mouseMoved(e);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		InputManager.mouseClicked(e);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		InputManager.mousePressed(e);
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		InputManager.mousePressed(e);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		InputManager.mouseEntered(e);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		InputManager.mouseExited(e);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		InputManager.keyTyped(e);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		InputManager.keyPressed(e);
		System.out.println("hi");
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		InputManager.keyReleased(e);

		
	}
}
