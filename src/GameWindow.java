import javax.swing.*;

public class GameWindow {
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
		frame.setSize(500,500);
	}
}
