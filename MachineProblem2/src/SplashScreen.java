import java.awt.*;
import javax.swing.*;

public class SplashScreen extends JWindow {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int duration;
  public SplashScreen(int d) {
    duration = d;
  }

  public void showSplash() {
    JPanel content = new BackGroundPanel();
    content.setLayout(null);
    content.setBounds(0,0, 500, 350);
    JLabel label = new JLabel(new ImageIcon("src/images/oie_22145312CP8PHkJb (1).gif"));
    
    JLabel label1= new JLabel("MP 2");
    label1.setFont(new Font("Bookman Old Style", Font.BOLD, 45));
	label1.setForeground(new Color(255,255,255));
	label1.setBounds(200,10 , 150, 150);
	
	 JLabel label2= new JLabel("Image Compression Using Huffman Coding");
	 label2.setFont(new Font("Bookman Old Style", Font.BOLD+ Font.ITALIC, 20));
	 label2.setForeground(new Color(255,255,255));
	 label2.setBounds(25,25 , 500, 250);
		 
    label.setBounds(100, 50, 300, 350);
    content.add(label, BorderLayout.CENTER);
    content.add(label1);
    content.add(label2);
    
    int width = 500;
    int height =350;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width-width)/2;
    int y = (screen.height-height)/2;
    setBounds(x,y,width,height);
    add(content);

    setVisible(true);

    try { Thread.sleep(duration); } catch (Exception e) {}

    setVisible(false);
  }
  class BackGroundPanel extends JPanel 
	{
		
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image backgroundImage = new ImageIcon("src/images/splashBG.png").getImage();
	    public void paintComponent(Graphics g) {
	      g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	  }
	}

  public void showSplashAndExit() {
    showSplash();
    
  }

}