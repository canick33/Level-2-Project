import javax.swing.JOptionPane;

public class gameManager {
	Animation a;
	boolean b = true;
	public static void main(String[] args)
	
	
	{
		gameManager jesus = new gameManager();
		
	}
	public gameManager()
	{
		Window w = new Window();
		a = new Animation();
		while(b)
		{
			System.out.println("hi");
			if(!a.WinStatus())
			{
				
				b = false;
				a.setCurrentState(2);

			}
		}
		
	}
}
