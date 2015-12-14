import java.awt.Rectangle;

import javax.swing.*;

public class Window {
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
	frame.setSize(1500, 500);
	
}
}
