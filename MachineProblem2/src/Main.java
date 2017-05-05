import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Main extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GUI g = new GUI();
	public Main()
	{
		SplashScreen splash= new SplashScreen(5000);
		splash.showSplashAndExit();
		
		ImageIcon icon= new ImageIcon("src/images/imagecom.png");
		Image image= icon.getImage();
		JFrame frame= new JFrame();
		frame.add(g);
		frame.setIconImage(image);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setVisible(true);
		frame.setBounds(0,0,1020, 635);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.addWindowListener(new AreYouSure() );  
	}
	public static void main(String[] args)
	{
		new Main();
	}
	 private class AreYouSure extends WindowAdapter
	 {  
	        public void windowClosing( WindowEvent e )
	        {  
	           PopWindow pop= new PopWindow();
	           pop.exit();
	           pop.setModal(true);
	           pop.setLocationRelativeTo(g);
	           pop.setVisible(true);
	        }
	 }
}