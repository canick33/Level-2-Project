import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class Window implements KeyListener{
	JFrame frame;
	Rectangle test;
	Animation a; 
	private int x,y,w,h;


public static void main (String[] args)
{ 
	Window w = new Window();
}
public Window()
{
	x=100;
	y=100;
	w=100;
	h=100;


	a = new Animation();
	frame = new JFrame();
	frame.setVisible(true);
	frame.add(a);
	frame.addKeyListener(this); 
	frame.setSize(1500, 500);
	
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyPressed(KeyEvent e) {

 a.keyPressed(e);
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
