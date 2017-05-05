import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PopWindow extends JDialog
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel= new BackGroundPanel();
	JLabel[] proceed= new JLabel[6];
	ImageIcon proc[]= new ImageIcon[6];
	ImageIcon[] exits= new ImageIcon[4];
	public static boolean isEnabled=true;
	
	Handler handler= new Handler();
	
	public PopWindow()
	{
		setSize(600,350);
		add(panel);
		panel.setLayout(null);
		setFocusableWindowState(false);
		setFocusable(false);
		setUndecorated(true);
		setAlwaysOnTop(true);
	}
	class BackGroundPanel extends JPanel 
	{
	   /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	Image backgroundImage = new ImageIcon("src/images/popUp.png").getImage();
	    public void paintComponent(Graphics g) {
	      g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	  }
	}
	private class Handler extends MouseAdapter
	{
		public void mouseEntered(MouseEvent e)
		{
			if(e.getSource()==proceed[0])
			{
				proceed[0].setIcon(proc[2]);
			}
			else if(e.getSource()==proceed[1])
				proceed[1].setIcon(proc[3]);
			
			else if(e.getSource()==proceed[2])
				proceed[2].setIcon(exits[2]);
			else if(e.getSource()==proceed[3])
				proceed[3].setIcon(exits[3]);
			else if(e.getSource()==proceed[4])
				proceed[4].setIcon(proc[5]);
			
		}
		public void mouseExited(MouseEvent e)
		{
			if(e.getSource()==proceed[0])
				proceed[0].setIcon(proc[0]);
			else if(e.getSource()==proceed[1])
				proceed[1].setIcon(proc[1]);
			else if(e.getSource()==proceed[2])
				proceed[2].setIcon(exits[0]);
			else if(e.getSource()==proceed[3])
				proceed[3].setIcon(exits[1]);
			else if(e.getSource() == proceed[4])
				proceed[4].setIcon(proc[4]);
		}
		public void mouseClicked(MouseEvent e)
		{
			if(e.getSource()==proceed[0])
				;
			else if(e.getSource()==proceed[1])
			{
				PopWindow.this.setVisible(false);
				setModal(false);
			}
			else if(e.getSource()==proceed[2])
				System.exit(0);
			else if(e.getSource()==proceed[3])
			{
				GUI.isEnabled=true;
				PopWindow.this.setVisible(false);
			}else if(e.getSource() == proceed[4]){
				PopWindow.this.setVisible(false);
				setModal(false);
			}
		}
	}
	public void credits()
	{
		JPanel[] credits= new JPanel[3];
		proc[0] = new ImageIcon("src/images/proceed.png");
		proc[1] = new ImageIcon("src/images/backProceed.png");
		proc[2] = new ImageIcon("src/images/proceedShad.png");
		proc[3] = new ImageIcon("src/images/backProceedShad.png");
		
		proceed[0] = new JLabel(proc[0]);
		proceed[1] = new JLabel(proc[1]);
		
		proceed[0].setBounds(540, 300, proc[2].getIconWidth(),proc[2].getIconHeight());
		proceed[1].setBounds(20, 300, proc[2].getIconWidth(),proc[2].getIconHeight());
		
		proceed[0].addMouseListener(handler);
		proceed[1].addMouseListener(handler);
		
		credits[0]= new JPanel();
		credits[0].setOpaque(false);
		credits[0].setLayout(null);
		
		
		JLabel cred= new JLabel("CREDITS");
		cred.setBounds(210, 10, 360, 40);
		cred.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		cred.setForeground(new Color(202, 198,19));
		
		JTextArea textArea= new JTextArea(1000, 1000);
		textArea.setBounds(15, 55, 500, 220);
		textArea.setText("(1)https://www.dyclassroom.com/image-"
				+ "\nprocessing-project/how-to-get-and-set-"
				+ "\npixel-value-in-java\n");
		textArea.append("(2) http://nikktech.com/main/images/pics/"
				+ "\nreviews/dune_hd/solo_4k\n");
		textArea.append("(3) stackoverflow.com\n");
		textArea.append("(4) https://www.javatpoint.com/java-hashmap\n");
		textArea.append("(5) https://www.tutorialspoint.com/java/"); 
		textArea.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		textArea.setForeground(new Color(255, 255,255));
		textArea.setOpaque(false);
		
		credits[0].setBounds(0, 0, 600, 350);
		credits[0].add(cred);
		credits[0].add(textArea);
		
		panel.add(credits[0]);
		//credits[0].add(proceed[0]);
		credits[0].add(proceed[1]);
	}
	public void description()
	{
		JPanel des;
		proc[4] = new ImageIcon("src/images/backProceed.png");
		proc[5] = new ImageIcon("src/images/backProceedShad.png");
		
		proceed[4] = new JLabel(proc[4]);
		
		proceed[4].setBounds(20, 300, proc[4].getIconWidth(),proc[4].getIconHeight());
		
		proceed[4].addMouseListener(handler);
		
		des= new JPanel();
		des.setOpaque(false);
		des.setLayout(null);
		
		
		JLabel descrip= new JLabel("DESCRIPTION");
		descrip.setBounds(210, 10, 360, 40);
		descrip.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		descrip.setForeground(new Color(202, 198,19));
		
		JTextArea textArea= new JTextArea(1000, 1000);
		textArea.setBounds(15, 55, 500, 220);
		textArea.setText("This Application is about:");
		textArea.append("\n\nMulti-channel Image Compression using "
				+ "\nHuffman Coding,\n");
		textArea.append("where Huffman coding is a coding scheme "
				+ "\nwhich leverages the inherent redundancy of values "
				+ "\nin a set of data to create resulting code that is "
				+ "\noptimally compressed\n");
		textArea.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		textArea.setForeground(new Color(255, 255,255));
		textArea.setOpaque(false);
		
		des.setBounds(0, 0, 600, 350);
		des.add(descrip);
		des.add(textArea);
		
		panel.add(des);
		//credits[0].add(proceed[0]);
		des.add(proceed[4]);
	}
	public void allAbout()
	{
		JPanel[] desc= new JPanel[3];
		desc[0]= new JPanel();
		JTextArea textArea= new JTextArea(100, 100);
		desc[0].setOpaque(false);
		
		JLabel cred= new JLabel("DESCRIPTION");
		panel.add(desc[0]);
		cred.setBounds(275, 15, 650, 45);
		cred.setFont(new Font("Bookman Old Style", Font.BOLD, 30));
		cred.setForeground(new Color(202, 198,19));
		desc[0].add(cred);
		textArea.setBounds(20, 55, 740, 450);
		textArea.setText(" Image Compression blabla");
		textArea.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
		textArea.setForeground(new Color(255, 255,255));
		textArea.setOpaque(false);
		desc[0].add(textArea);
		desc[0].setBounds(20, 10, 750, 300);
	}
	public void exit()
	{
		JLabel[] exit= new JLabel[3];
		exit[0]= new JLabel();
		
		JLabel cred= new JLabel("EXIT?");
		cred.setBounds(200, 95, 670, 85);
		cred.setFont(new Font("Bookman Old Style", Font.BOLD, 80));
		cred.setForeground(new Color(202, 198,19));
		
		exits[0]=new ImageIcon("src/images/okay.png");
		exits[1]=new ImageIcon("src/images/cancel.png");
		exits[2]=new ImageIcon("src/images/okayShad.png");
		exits[3]=new ImageIcon("src/images/cancelShad.png");
		
		proceed[2] = new JLabel(exits[0]);
		proceed[3] = new JLabel(exits[1]);
		
		proceed[2].setBounds(30, 245, exits[0].getIconWidth(), exits[0].getIconHeight());
		proceed[3].setBounds(370, 245, exits[1].getIconWidth(), exits[1].getIconHeight());
		
		proceed[2].addMouseListener(handler);
		proceed[3].addMouseListener(handler);
		
		panel.add(cred);
		panel.add(proceed[2]);
		panel.add(proceed[3]);
	}
}
