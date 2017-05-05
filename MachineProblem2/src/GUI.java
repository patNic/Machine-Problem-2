import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.awt.event.*;

public class GUI extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel openButton;
	private JLabel creditsButton;
	private JLabel exitButton;
	private JLabel descButton;
	private JLabel viewer;
	private JLabel image;
	private JLabel title;
	private JLabel menu;
	JScrollPane pane, scroll;
	private String huffName;
	private JPanel panelPic= new JPanel();
	public static boolean hasOpened=false;
	private static boolean hasTrained=false;
	public ImageIcon[] buttonsIcon = new ImageIcon[9];
	public ImageIcon[] buttonShad= new ImageIcon[9];
	private Handler handler= new Handler();
	public static JLabel[] upButtons= new JLabel[40];
	public static ImageIcon[] upButtonIcon= new ImageIcon[40];
	
	public File toComp;
	public File path;
	 BufferedImage buff;
	 Trial trial = new Trial();
	public static boolean isEnabled=true;
	public static boolean toShow=true;
	public static JPanel panel = new BackGroundPanel();
	JLabel  blurPanel;
	PopWindow popUp;
	Image openedImage;
	JLabel action;
	boolean enable = false;
	boolean train = false;
	public static Thread thread;
	public static boolean finish = false;
	public GUI(Boolean start){}
	public GUI()
	{
		init();
	}
	public void init()
	{
		ImageIcon blur= new ImageIcon("src/images/imageedit_1_9078028947.png");
		
		action= new JLabel("Current Action");
		action.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		action.setForeground(new Color(55,55,255));
		action.setBounds(735,55,300,30);
		
		
		panel.setPreferredSize(new Dimension(1000,600));
		panel.setLayout(null);
		add(panel);
		
		upButtonIcon[0] = new ImageIcon("src/images/train.png");
		upButtonIcon[1] = new ImageIcon("src/images/compress.png");
		upButtonIcon[2] = new ImageIcon("src/images/menu.png");
		upButtonIcon[3] = new ImageIcon("src/images/trainShad.png");
		upButtonIcon[4] = new ImageIcon("src/images/compressShad.png");
		upButtonIcon[5] = new ImageIcon("src/images/menuShadow.png");
		upButtonIcon[6] = new ImageIcon("src/images/trainLabel.png");
		upButtonIcon[7] = new ImageIcon("src/images/compressLabel.png");
		upButtonIcon[8] = new ImageIcon("src/images/menuLabel.png");
		upButtonIcon[9] = new ImageIcon("src/images/trainDescrip1.png");
		upButtonIcon[10] = new ImageIcon("src/images/compressDescrip.png");
		upButtonIcon[11] = new ImageIcon("src/images/menuClicked.png");
		upButtonIcon[12] = new ImageIcon("src/images/back.png");
		upButtonIcon[13] = new ImageIcon("src/images/discard.png");
		upButtonIcon[14] = new ImageIcon("src/images/backShad.png");
		upButtonIcon[15] = new ImageIcon("src/images/discardShad.png");
		upButtonIcon[16] = new ImageIcon("src/images/trainClicked.png");
		upButtonIcon[17] = new ImageIcon("src/images/compressClicked.png");
		upButtonIcon[18] = new ImageIcon("src/images/newHuff.png");
		upButtonIcon[19] = new ImageIcon("src/images/upDateHuff.png");
		upButtonIcon[20] = new ImageIcon("src/images/newHuffShad.png");
		upButtonIcon[21] = new ImageIcon("src/images/upDateHuffShad.png");
		upButtonIcon[22] = new ImageIcon("src/images/back.png");
		upButtonIcon[23] = new ImageIcon("src/images/render.png");
		upButtonIcon[24] = new ImageIcon("src/images/renderLabel.png");
		upButtonIcon[25] = new ImageIcon("src/images/renderShad.png");
		upButtonIcon[26] = new ImageIcon("src/images/renderDescrip.png");
		upButtonIcon[27] = new ImageIcon("src/images/renderClicked.png");
		upButtonIcon[28] = new ImageIcon("src/images/rend.png");
		upButtonIcon[29] = new ImageIcon("src/images/rendShad.png");
		upButtonIcon[30] = new ImageIcon("src/images/ok.png");
		upButtonIcon[31] = new ImageIcon("src/images/okShad.png");
		upButtonIcon[32] = new ImageIcon("src/images/r3.png");
		upButtonIcon[33] = new ImageIcon("src/images/c1.png");
		upButtonIcon[34] = new ImageIcon("src/images/d.png");
		upButtonIcon[35] = new ImageIcon("src/images/comp.png");
		upButtonIcon[36] = new ImageIcon("src/images/compShad.png");
		
		for(int i=0; i <37; i++)
		{
			upButtons[i]= new JLabel(upButtonIcon[i]);
		}
		upButtons[0].setBounds(170, 44, upButtonIcon[3].getIconWidth(), upButtonIcon[3].getIconHeight());
		upButtons[1].setBounds(260, 44, upButtonIcon[4].getIconWidth(), upButtonIcon[4].getIconHeight());
		upButtons[2].setBounds(490, 44, upButtonIcon[5].getIconWidth(), upButtonIcon[5].getIconHeight());
		upButtons[6].setBounds(165, 87, upButtonIcon[6].getIconWidth(), upButtonIcon[6].getIconHeight());
		upButtons[7].setBounds(232, 87, upButtonIcon[7].getIconWidth(), upButtonIcon[7].getIconHeight());
		upButtons[8].setBounds(480, 87, upButtonIcon[8].getIconWidth(), upButtonIcon[8].getIconHeight());
		upButtons[9].setBounds(745, 150, upButtonIcon[9].getIconWidth(), upButtonIcon[9].getIconHeight());
		upButtons[10].setBounds(745, 150, upButtonIcon[10].getIconWidth(), upButtonIcon[10].getIconHeight());
		upButtons[11].setBounds(90, 44, upButtonIcon[11].getIconWidth(), upButtonIcon[11].getIconHeight());
		upButtons[12].setBounds(740, 340, upButtonIcon[12].getIconWidth(), upButtonIcon[12].getIconHeight());
		upButtons[13].setBounds(740, 400, upButtonIcon[13].getIconWidth(), upButtonIcon[13].getIconHeight());
		upButtons[16].setBounds(80, 44, upButtonIcon[16].getIconWidth(), upButtonIcon[16].getIconHeight());
		upButtons[17].setBounds(80, 44, upButtonIcon[17].getIconWidth(), upButtonIcon[17].getIconHeight());
		upButtons[18].setBounds(770, 160, upButtonIcon[20].getIconWidth(), upButtonIcon[21].getIconHeight());
		upButtons[19].setBounds(770, 320, upButtonIcon[21].getIconWidth(), upButtonIcon[21].getIconHeight());
		upButtons[22].setBounds(740, 480, upButtonIcon[22].getIconWidth(), upButtonIcon[22].getIconHeight());
		upButtons[23].setBounds(330, 44, upButtonIcon[25].getIconWidth(), upButtonIcon[25].getIconHeight());
		upButtons[24].setBounds(340, 87, upButtonIcon[24].getIconWidth(), upButtonIcon[24].getIconHeight());
		upButtons[26].setBounds(745, 150, upButtonIcon[26].getIconWidth(), upButtonIcon[26].getIconHeight());
		upButtons[27].setBounds(80, 50, upButtonIcon[27].getIconWidth(), upButtonIcon[27].getIconHeight());
		upButtons[28].setBounds(211, 450, upButtonIcon[29].getIconWidth(), upButtonIcon[29].getIconHeight());
		upButtons[30].setBounds(740, 480, upButtonIcon[30].getIconWidth(), upButtonIcon[30].getIconHeight());
		upButtons[32].setBounds(780, 130,upButtonIcon[32].getIconWidth(), upButtonIcon[32].getIconHeight());
		upButtons[33].setBounds(780, 130,upButtonIcon[33].getIconWidth(), upButtonIcon[33].getIconHeight());
		upButtons[35].setBounds(770, 160, upButtonIcon[36].getIconWidth(), upButtonIcon[36].getIconHeight());
		
		upButtons[0].addMouseListener(handler);
		upButtons[1].addMouseListener(handler);
		upButtons[2].addMouseListener(handler);
		upButtons[12].addMouseListener(handler);
		upButtons[13].addMouseListener(handler);
		upButtons[18].addMouseListener(handler);
		upButtons[19].addMouseListener(handler);
		upButtons[22].addMouseListener(handler);
		upButtons[23].addMouseListener(handler);
		upButtons[28].addMouseListener(handler);
		upButtons[30].addMouseListener(handler);
		upButtons[35].addMouseListener(handler);
		
		buttonsIcon[0] = new ImageIcon("src/images/open.png");
		buttonsIcon[1] = new ImageIcon("src/images/credits.png");
		buttonsIcon[2] = new ImageIcon("src/images/exit.png");
		buttonsIcon[3] = new ImageIcon("src/images/desc.png");
		buttonsIcon[4] = new ImageIcon("src/images/fileBrowser.jpg");
		buttonsIcon[5] = new ImageIcon("src/images/imagecom.png");
		
		buttonShad[0]=new ImageIcon("src/images/openShad.png");
		buttonShad[1]=new ImageIcon("src/images/creditsShad.png");
		buttonShad[2]=new ImageIcon("src/images/exitShad.png");
		buttonShad[3]=new ImageIcon("src/images/descShad.png");
		
		
		openButton= new JLabel(buttonsIcon[0]);
		creditsButton= new JLabel(buttonsIcon[1]);
		exitButton= new JLabel(buttonsIcon[2]);
		descButton= new JLabel(buttonsIcon[3]);
		viewer= new JLabel(buttonsIcon[4]);
		image= new JLabel(buttonsIcon[5]);
		blurPanel= new JLabel(blur);
		openButton.addMouseListener(handler);
		creditsButton.addMouseListener(handler);
		exitButton.addMouseListener(handler);
		descButton.addMouseListener(handler);
		
		title= new JLabel("Image Compressor");
		title.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		title.setForeground(new Color(55,55,255));
		
		menu= new JLabel("Menu");
		menu.setFont(new Font("Bookman Old Style", Font.BOLD, 25));
		menu.setForeground(new Color(55,55,255));
		
		panel.add(title);
		panel.add(menu);
		panel.add(image);
		panel.add(creditsButton);
		panel.add(exitButton);
		panel.add(descButton);
		panel.add(upButtons[28]);
		panel.setPreferredSize(new Dimension(1000, 600));
		panel.setLayout(null);
		add(panel);
		openButton.setBounds(150, 250, buttonsIcon[0].getIconWidth(), buttonsIcon[0].getIconHeight());
		panelPic.add(openButton);
		panelPic.add(viewer);
		
	
		panelPic.setOpaque(false);
		panelPic.setLayout(null);
		panelPic.setBounds(60, 130, 660, 400);
		panel.add(panelPic);
		creditsButton.setBounds(740, 160, buttonsIcon[1].getIconWidth(), buttonsIcon[1].getIconHeight());
		descButton.setBounds(740, 220, buttonsIcon[1].getIconWidth(), buttonsIcon[2].getIconHeight());
		exitButton.setBounds(740, 280, buttonsIcon[1].getIconWidth(), buttonsIcon[2].getIconHeight());
		viewer.setBounds(225, 90, buttonsIcon[4].getIconWidth(), buttonsIcon[4].getIconHeight());
		image.setBounds(80, 45, buttonsIcon[5].getIconWidth(), buttonsIcon[5].getIconHeight());
		title.setBounds(155,55,300,30);
		menu.setBounds(795,55,300,30);
		blurPanel.setBounds(0,0, blur.getIconWidth(), blur.getIconHeight());
		
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
            }
	 });
	}
	static class BackGroundPanel extends JPanel 
	{
		
	   /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	Image backgroundImage = new ImageIcon("src/images/viewer.jpg").getImage();
	    public void paintComponent(Graphics g) {
	      g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	  }
	}
	private class Handler extends MouseAdapter
	{
		public void mouseEntered(MouseEvent e)
		{
				if(e.getSource()==openButton)
				{
					openButton.setIcon(buttonShad[0]);
				}
				else if(e.getSource()==upButtons[28])
				{
					upButtons[28].setIcon(upButtonIcon[29]);
				}
				else if(e.getSource()==upButtons[35])
				{
					upButtons[35].setIcon(upButtonIcon[36]);
				}
				else if(e.getSource()==creditsButton)
				{
					creditsButton.setIcon(buttonShad[1]);
				}
				else if(e.getSource()==exitButton)
				{
					exitButton.setIcon(buttonShad[2]);
				}
				else if(e.getSource()==descButton)
				{
					descButton.setIcon(buttonShad[3]);
				}
				else if(e.getSource()==upButtons[0])
				{
					upButtons[0].setIcon(upButtonIcon[3]);
					panel.remove(upButtons[33]);
					panel.remove(upButtons[32]);
					panel.add(upButtons[9]);
					panel.repaint();
					panel.revalidate();
				}
				else if(e.getSource()==upButtons[1])
				{
					upButtons[1].setIcon(upButtonIcon[4]);
					panel.remove(upButtons[33]);
					panel.remove(upButtons[32]);
					panel.add(upButtons[10]);
					panel.repaint();
					panel.revalidate();
				}
				else if(e.getSource()==upButtons[2])
				{
					panel.remove(upButtons[33]);
					panel.remove(upButtons[32]);
					upButtons[2].setIcon(upButtonIcon[5]);
				}
				else if(e.getSource()==upButtons[12])
				{
					upButtons[12].setIcon(upButtonIcon[14]);
					
				}
				else if(e.getSource()==upButtons[13])
				{
					upButtons[13].setIcon(upButtonIcon[15]);
				}
				else if(e.getSource()==upButtons[18])
				{
					upButtons[18].setIcon(upButtonIcon[20]);
				}
				else if(e.getSource()==upButtons[19])
				{
					upButtons[19].setIcon(upButtonIcon[21]);
				}
				else if(e.getSource()==upButtons[22])
				{
					upButtons[22].setIcon(upButtonIcon[14]);
				}
				else if(e.getSource()==upButtons[30])
				{
					upButtons[30].setIcon(upButtonIcon[31]);
				}
				else if(e.getSource()==upButtons[23])
				{
					upButtons[23].setIcon(upButtonIcon[25]);
					panel.remove(upButtons[33]);
					panel.remove(upButtons[32]);
					panel.add(upButtons[26]);
					panel.repaint();
					panel.revalidate();
				}
		}
		
		public void mouseExited(MouseEvent e)
		{
				if(e.getSource()==openButton)
				{
					openButton.setIcon(buttonsIcon[0]);
				}
				else if(e.getSource()==creditsButton)
				{
					creditsButton.setIcon(buttonsIcon[1]);
				}
				else if(e.getSource()==upButtons[35])
				{
					upButtons[35].setIcon(upButtonIcon[35]);
				}
				else if(e.getSource()==exitButton)
				{
					exitButton.setIcon(buttonsIcon[2]);
				}
				else if(e.getSource()==descButton)
				{
					descButton.setIcon(buttonsIcon[3]);
				}
				else if(e.getSource()==upButtons[0])
				{
					upButtons[0].setIcon(upButtonIcon[0]);
					panel.remove(upButtons[9]);
					panel.repaint();
					panel.revalidate();
				}
				else if(e.getSource()==upButtons[28])
				{
					upButtons[28].setIcon(upButtonIcon[28]);
				}
				else if(e.getSource()==upButtons[1])
				{
					upButtons[1].setIcon(upButtonIcon[1]);
					panel.remove(upButtons[10]);
					panel.repaint();
					panel.revalidate();
				}
				else if(e.getSource()==upButtons[2])
				{
					upButtons[2].setIcon(upButtonIcon[2]);
				}
				else if(e.getSource()==upButtons[12])
				{
					upButtons[12].setIcon(upButtonIcon[12]);
				}
				else if(e.getSource()==upButtons[13])
				{
					upButtons[13].setIcon(upButtonIcon[13]);
				}
				else if(e.getSource()==upButtons[18])
				{
					upButtons[18].setIcon(upButtonIcon[18]);
				}
				else if(e.getSource()==upButtons[19])
				{
					upButtons[19].setIcon(upButtonIcon[19]);
				}
				else if(e.getSource()==upButtons[22])
				{
					upButtons[22].setIcon(upButtonIcon[22]);
				}
				else if(e.getSource()==upButtons[30])
				{
					upButtons[30].setIcon(upButtonIcon[30]);
				}
				else if(e.getSource()==upButtons[23])
				{
					upButtons[23].setIcon(upButtonIcon[23]);
					panel.remove(upButtons[26]);
					panel.repaint();
					panel.revalidate();
				}
			
		}
		public void mouseClicked(MouseEvent e)
		{
				if(e.getSource()==creditsButton)
				{
					popUp= new PopWindow();
					
					creditsButton.setIcon(buttonShad[1]);
					popUp.setLocationRelativeTo(panel);
					
					popUp.credits();
					creditsButton.setIcon(buttonsIcon[1]);
					popUp.setModal(true);
					popUp.setVisible(true);
					panel.repaint();
					panel.revalidate();
				}
				if(e.getSource()==exitButton)
				{
					popUp= new PopWindow();
					exitButton.setIcon(buttonShad[2]);
					popUp.setLocationRelativeTo(panel);
					popUp.exit();
					exitButton.setIcon(buttonsIcon[2]);
					popUp.setModal(true);
					popUp.setVisible(true);
				}
				if(e.getSource()==descButton)
				{
					descButton.setIcon(buttonShad[3]);
					popUp= new PopWindow();
					
					popUp.setLocationRelativeTo(panel);
					
					popUp.description();
					descButton.setIcon(buttonsIcon[3]);
					popUp.setModal(true);
					popUp.setVisible(true);
					panel.repaint();
					panel.revalidate();
				}
				else if(e.getSource()==upButtons[2])
				{
					upButtons[2].setIcon(upButtonIcon[2]);
					panel.remove(upButtons[0]);
					panel.remove(upButtons[1]);
					panel.remove(upButtons[2]);
					panel.remove(upButtons[6]);
					panel.remove(upButtons[7]);
					panel.remove(upButtons[8]);
					panel.remove(upButtons[23]);
					panel.remove(upButtons[24]);
					
					panel.add(upButtons[11]);
					panel.add(creditsButton);
					panel.add(exitButton);
					panel.add(descButton);
					panel.add(upButtons[12]);
					panel.add(upButtons[13]);
					
					panel.repaint();
					panel.revalidate();
				}
				else if(e.getSource()==upButtons[12])
				{
					upButtons[12].setIcon(upButtonIcon[12]);
					
					panel.remove(upButtons[11]);
					panel.remove(creditsButton);
					panel.remove(exitButton);
					panel.remove(descButton);
					panel.remove(upButtons[12]);
					panel.remove(upButtons[13]);
					
					panel.add(upButtons[0]);
					panel.add(upButtons[1]);
					panel.add(upButtons[2]);
					panel.add(upButtons[6]);
					panel.add(upButtons[7]);
					panel.add(upButtons[8]);
					panel.add(upButtons[23]);
					panel.add(upButtons[24]);
					
					panel.repaint();
					panel.revalidate();
				}
				else if(e.getSource()==upButtons[22])
				{
					upButtons[22].setIcon(upButtonIcon[22]);
					
					panel.remove(upButtons[16]);
					panel.remove(upButtons[18]);
					panel.remove(upButtons[19]);
					panel.remove(upButtons[22]);
					panel.remove(upButtons[17]);
					panel.remove(upButtons[35]);
					
					panel.add(upButtons[0]);
				//	panel.add(upButtons[1]);
					panel.add(upButtons[2]);
					panel.add(upButtons[6]);
				//	panel.add(upButtons[7]);
			       panel.add(upButtons[8]);
					//panel.add(upButtons[23]);
					//panel.add(upButtons[24]);
					
					upButtons[22].setIcon(upButtonIcon[22]);
					panel.repaint();
					panel.revalidate();
				}
				else if(e.getSource()==upButtons[30])
				{
					upButtons[30].setIcon(upButtonIcon[29]);
					
					panel.remove(upButtons[16]);
					panel.remove(upButtons[18]);
					panel.remove(upButtons[19]);
					panel.remove(upButtons[30]);
					panelPic.removeAll();
					panelPic.repaint();
					panelPic.revalidate();
					panel.removeAll();
					init();
					panelPic.repaint();
					panelPic.revalidate();
					panel.repaint();
					panel.revalidate();
				}
				else if(e.getSource()==upButtons[13])
				{
					panelPic.removeAll();
					panelPic.repaint();
					panelPic.revalidate();
					panel.removeAll();
					init();
					
					panel.repaint();
					panel.revalidate();
				}
				
				else if(e.getSource()==upButtons[0])
				{
					upButtons[0].setIcon(upButtonIcon[0]);
					panel.remove(upButtons[0]);
					panel.remove(upButtons[1]);
					panel.remove(upButtons[2]);
					panel.remove(upButtons[6]);
					panel.remove(upButtons[7]);
					panel.remove(upButtons[8]);
					panel.remove(upButtons[8]);
					panel.remove(upButtons[9]);
					panel.remove(upButtons[23]);
					panel.remove(upButtons[26]);
					panel.remove(upButtons[25]);
					panel.remove(upButtons[24]);
					
					panel.add(upButtons[16]);
					panel.add(upButtons[18]);
					panel.add(upButtons[19]);
					panel.add(upButtons[22]);
					upButtons[0].setIcon(upButtonIcon[0]);
					panel.repaint();
					panel.revalidate();
				}
				
				if(e.getSource()==upButtons[23])
				{
					upButtons[23].setIcon(upButtonIcon[26]);
					panel.remove(upButtons[0]);
					panel.remove(upButtons[1]);
					panel.remove(upButtons[2]);
					panel.remove(upButtons[22]);
					panel.remove(upButtons[6]);
					panel.remove(upButtons[7]);
					panel.remove(upButtons[8]);
					panel.remove(upButtons[23]);
					panel.remove(upButtons[26]);
					panel.remove(upButtons[25]);
					panel.remove(upButtons[24]);
					panel.add(upButtons[32]);
					panel.add(upButtons[27]);
					panel.repaint();
					panel.revalidate();
					
					 JFileChooser chooser = new JFileChooser();
					 FileNameExtensionFilter filter= new FileNameExtensionFilter("cycole", "CYCOLE", "*.cycole");
					 chooser.setFileFilter(filter);
					 chooser.addChoosableFileFilter(filter);
					 chooser.setAcceptAllFileFilterUsed(false);
				        
				        int option = chooser.showOpenDialog(panel);
				        if (option == JFileChooser.APPROVE_OPTION) {
				        	
				        	panel.add(upButtons[0]);
							//panel.add(upButtons[1]);
							panel.add(upButtons[2]);
							panel.add(upButtons[6]);
						//	panel.add(upButtons[7]);
							panel.add(upButtons[8]);
							panel.add(upButtons[23]);
							panel.add(upButtons[24]);
							panel.add(upButtons[30]);
							
							
							panel.remove(upButtons[27]);
							panel.repaint();
							panel.revalidate();
							
							 chooser.getSelectedFile();
							
								 panelPic.removeAll();
								 panelPic.repaint();
								 RenderPanel can= new RenderPanel(buff.getWidth(), buff.getHeight(), Trial.pix2D);
								  scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
								  scroll.getViewport().setOpaque(false);
								  scroll.setOpaque(false);
								  scroll.setBounds(0,0,645, 400);
								  scroll.setViewportView(can);
						          panelPic.add(scroll);
						          panelPic.repaint();
								 panelPic.revalidate(); 
								 //upButtons[32].setVisible(false);
								 
							 
				          chooser.getSelectedFiles();
				        }
				        else
				        {
				        	panel.add(upButtons[0]);
							panel.add(upButtons[1]);
							panel.add(upButtons[2]);
							panel.add(upButtons[6]);
							panel.add(upButtons[7]);
							panel.add(upButtons[8]);
							panel.add(upButtons[23]);
							panel.add(upButtons[24]);
							
							//upButtons[32].setEnabled(true);
							panel.remove(upButtons[27]);
							panel.repaint();
							panel.revalidate();
				        }
				       
				}
			   if(e.getSource()==upButtons[1])
				{
					panel.remove(upButtons[0]);
					panel.remove(upButtons[1]);
					panel.remove(upButtons[2]);
					panel.remove(upButtons[6]);
					panel.remove(upButtons[7]);
					panel.remove(upButtons[8]);
					panel.remove(upButtons[23]);
					panel.remove(upButtons[26]);
					panel.remove(upButtons[25]);
					panel.remove(upButtons[24]);
					panel.remove(upButtons[10]);
					panel.add(upButtons[33]);
					panel.add(upButtons[17]);
					panel.repaint();
					panel.revalidate();
					
					 JFileChooser chooser = new JFileChooser();
					 FileNameExtensionFilter filter= new FileNameExtensionFilter("huff", "HUFF", "*.huff");
					 chooser.setFileFilter(filter);
					 chooser.addChoosableFileFilter(filter);
					 chooser.setAcceptAllFileFilterUsed(false);
				        
				        int option = chooser.showOpenDialog(panel);
				        
				        if (option == JFileChooser.APPROVE_OPTION) {
				        	panel.add(upButtons[0]);
							panel.add(upButtons[1]);
							panel.add(upButtons[2]);
							panel.add(upButtons[6]);
							panel.add(upButtons[7]);
							panel.add(upButtons[8]);
							panel.add(upButtons[23]);
							panel.add(upButtons[24]);
							
							panel.remove(upButtons[17]);
							panel.repaint();
							panel.revalidate();
				         
				          File readFile= chooser.getSelectedFile();
				         
				    	   huffName= readFile.getName().substring(0, readFile.getName().length()-5);
				       try
				       {   
					        File f= new File( chooser.getCurrentDirectory(),huffName +".CYCOLE");
					        f.createNewFile();
					        if(hasTrained==true)
					        {
					        	HashMap<String,String> readMap = trial.readHuffFile(readFile);
					        	 trial.compress(buff, f, readMap);
					        
					        }
					        else
					        {
					        	BufferedWriter w= new BufferedWriter(new FileWriter(f));
					        	trial= new Trial(buff, w);
					        	 HashMap<String,String> readMap = trial.readHuffFile(readFile);
					        	trial.compress(buff, f, readMap);
					        }
					    	   
				       }
				       catch(IOException exception)
				       {
				    	   exception.printStackTrace();
				       }
				        }
				        else
				        {
				        	panel.add(upButtons[0]);
							panel.add(upButtons[1]);
							panel.add(upButtons[2]);
							panel.add(upButtons[6]);
							panel.add(upButtons[7]);
							panel.add(upButtons[8]);
							panel.add(upButtons[23]);
							panel.add(upButtons[24]);
							
							panel.remove(upButtons[17]);
							panel.repaint();
							panel.revalidate();
				        }
				}
			   if(e.getSource()==upButtons[19])
				{	
					 JFileChooser chooser = new JFileChooser();
					 FileNameExtensionFilter filter= new FileNameExtensionFilter("huff", "HUFF", "*.huff");
					 chooser.setFileFilter(filter);
					 chooser.addChoosableFileFilter(filter);
					 chooser.setAcceptAllFileFilterUsed(false);
				        
				        int option = chooser.showOpenDialog(panel);
				        
				        if (option == JFileChooser.APPROVE_OPTION) {
				         
				          File readFile= chooser.getSelectedFile();
				          String temp= readFile.getName();
				          String name= temp.substring(0, temp.length()-5);
				        
				          path= chooser.getCurrentDirectory();
				          File m= new File(path, name);
				          
				          toComp=m;
				          try
				          {
							trial.updateHuffFile(buff, readFile);
							 panel.remove(upButtons[18]);
						     panel.remove(upButtons[19]);
						     panel.remove(upButtons[16]);
						     panel.add(upButtons[35]);    
						     panel.add(upButtons[17]);    
						     panel.repaint();
						      panel.revalidate();
							
				          }
				          catch (IOException e1)
				          {
							e1.printStackTrace();
				          }
				        }
				        else
				        {
				        	panel.add(upButtons[0]);
							panel.add(upButtons[1]);
							panel.add(upButtons[2]);
							panel.add(upButtons[6]);
							panel.add(upButtons[7]);
							panel.add(upButtons[8]);
							panel.add(upButtons[23]);
							panel.add(upButtons[24]);
							
							panel.remove(upButtons[17]);
							panel.repaint();
							panel.revalidate();
				        }
				}
				if(e.getSource()==openButton)
				{
					trial= new Trial();
					String name="FileName: ";
					JTextArea textArea= new JTextArea(10, 10);
					textArea.setBounds(75, 550, 500, 220);
					textArea.setFont(new Font("Bookman Old Style", Font.PLAIN, 20));
					textArea.setForeground(new Color(255, 255,255));
					textArea.setOpaque(false);
					
					openButton.setIcon(buttonShad[0]);
					 JFileChooser chooser = new JFileChooser();
					 FileNameExtensionFilter filter= new FileNameExtensionFilter("png", "PNG", "*.png");
					 chooser.setFileFilter(filter);
					 chooser.addChoosableFileFilter(filter);
					 chooser.setAcceptAllFileFilterUsed(false);
				        
				        int option = chooser.showOpenDialog(panel);
				        
				        if (option == JFileChooser.APPROVE_OPTION) {
				          chooser.getSelectedFiles();
				       
				          ImageIcon icon= new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
				          JLabel filePng= new JLabel(icon);
				          
				          try
				          {
				        	  buff= ImageIO.read(chooser.getSelectedFile());  
				          }
				          catch(IOException expc)
				          {}
				        
				          chooser.getSelectedFile().getName();
				          System.out.println("You chose to open this file: " +
				                  chooser.getSelectedFile().getName());
				          name+=chooser.getSelectedFile().getName();
				          textArea.setText(name);
				         
				          panel.removeAll();
				          panel.repaint();
				          panel.revalidate();
				          panelPic.removeAll();
				          
				          pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				          pane.getViewport().setOpaque(false);
				          pane.setOpaque(false);
				          pane.setBounds(0,0,645, 400);
				          pane.setViewportView(filePng);
				          panelPic.add(pane);
				          panelPic.repaint();
				          panelPic.revalidate();
				          pane.repaint();
				         
				          panel.add(panelPic);
				         panel.add(textArea);
				         panel.add(new JLabel(chooser.getSelectedFile().getName()));
				         panel.revalidate();
				         init2();
				         panel.repaint();
				         panel.revalidate();
				         hasOpened=true;
				}
				        else
				        {
				        	hasOpened=false;
				        }
			}
				if(e.getSource()==upButtons[18])
				{
						JFileChooser saver = new JFileChooser("./");
							 FileNameExtensionFilter filter= new FileNameExtensionFilter("HUFF", "*.HUFF");
							 
							saver.addChoosableFileFilter(filter);
							saver.setAcceptAllFileFilterUsed(false);
					        int returnVal = saver.showSaveDialog(panel);
					        File file= saver.getSelectedFile();
					      
					        toComp=file;
					        path= saver.getCurrentDirectory();
					        if (returnVal == JFileChooser.APPROVE_OPTION)
					        {       
							        if(file.getName().endsWith(".HUFF"))
							        	;
							        else
							        	file= new File(saver.getSelectedFile()+".HUFF");
							        
							        panel.remove(upButtons[18]);
							        panel.remove(upButtons[16]);
							        panel.remove(upButtons[19]);
							        panel.add(upButtons[35]);  
							        panel.add(upButtons[17]);    
							        panel.repaint();
							        panel.revalidate();
					        }
					        BufferedWriter writer = null;
					          
			            try
			            {
			            	writer = new BufferedWriter( new FileWriter(file));
			            	trial= new Trial(buff, writer);
			            	hasTrained=true;
			            }
			            catch (IOException exp)
			            {
			            	exp.printStackTrace();
			            }
			            
				}
				if(e.getSource()==upButtons[28])
				{
					panel.remove(title);
					panel.remove(image);
					panel.remove(menu);
					panel.remove(creditsButton);
					panel.remove(exitButton);
					panel.remove(descButton);
					openButton.setVisible(false);
					panel.repaint();
					panel.revalidate();
					panel.add(upButtons[32]);
					panel.add(upButtons[30]);
					panel.add(upButtons[27]);
					panel.add(action);
		        	panel.remove(upButtons[28]);
					panel.repaint();
					panel.revalidate();
					
					 JFileChooser chooser = new JFileChooser();
					 FileNameExtensionFilter filter= new FileNameExtensionFilter("cycole", "CYCOLE", "*.cycole");
					 chooser.setFileFilter(filter);
					 chooser.addChoosableFileFilter(filter);
					 chooser.setAcceptAllFileFilterUsed(false);
				        
					// JLabel rendered= new JLabel(chooser.getSelectedFile());
				        int option = chooser.showOpenDialog(panel);
				        
				        if (option == JFileChooser.APPROVE_OPTION) {
							 File open = chooser.getSelectedFile();
								 panelPic.removeAll();
								 panelPic.repaint();
								 Trial tryAl = new Trial();
								
								 String renderName= chooser.getSelectedFile().getName();
								 String corHuff= renderName.substring(0, renderName.length()-7)+".HUFF";
								 File renderPath= chooser.getCurrentDirectory();
								
								 FileTry tr= new FileTry(open);
								 File ff= new File(renderPath, corHuff);
								 try
								 {
									 File fil= tr.convertToBin();
									 HashMap<String, String> readMap = tryAl.readHuffFile(ff);
									 tryAl.writeCodes(open, FileTry.width, FileTry.height, fil, readMap);
									 
									 FileWriter w = new FileWriter(open);
									 w.write(tr.cbuf);
									 w.close();
								 }
								 catch(IOException except)
								 {
									 except.printStackTrace();
								 }
								 
								 RenderPanel can= new RenderPanel(FileTry.width, FileTry.height, Trial.pix2D);
								  scroll = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
								  scroll.getViewport().setOpaque(false);
								  scroll.setOpaque(false);
								  scroll.setBounds(0,0,645, 400);
								  scroll.setViewportView(can);
						          panelPic.add(scroll);
						          panelPic.repaint();
								 panelPic.revalidate();
								 init2();
				}
				        else
				        {
				        	panel.removeAll();
				        	panel.revalidate();
				        	panel.repaint();
				        	panel.add(openButton);
				        	openButton.setVisible(false);
				        	init();
				        }
			}
				if(e.getSource()==upButtons[35])
				{
					panel.remove(upButtons[35]);
					panel.remove(upButtons[0]);
					panel.remove(upButtons[1]);
					panel.remove(upButtons[2]);
					panel.remove(upButtons[6]);
					panel.remove(upButtons[7]);
					panel.remove(upButtons[8]);
					panel.remove(upButtons[23]);
					panel.remove(upButtons[26]);
					panel.remove(upButtons[25]);
					panel.remove(upButtons[24]);
					panel.remove(upButtons[10]);
					panel.remove(upButtons[16]);
					
					panel.add(upButtons[33]);
					panel.add(upButtons[17]);
					panel.add(upButtons[33]);
					panel.repaint();
					panel.revalidate();
					
					
				       try
				       {   
					        File f= new File(path,toComp.getName() +".CYCOLE");
					        f.createNewFile();
					        
					        File ff= new File(path,toComp.getName()+".HUFF");
					        
					        if(hasTrained==true)
					        {
					        	HashMap<String,String> readMap = trial.readHuffFile(ff);
					        	 trial.compress(buff, f, readMap);
					        }
					        else
					        {
					        	BufferedWriter w= new BufferedWriter(new FileWriter(f));
					        	trial= new Trial(buff, w);
					        	 HashMap<String,String> readMap = trial.readHuffFile(ff);
					        	trial.compress(buff, f, readMap);
					        }  
					        init3();
					        panel.remove(upButtons[33]);
				        	panel.remove(upButtons[17]);
				        	panel.repaint();
				        	panel.revalidate();
				       }
				       catch(IOException exc)
				       {
				    	   exc.printStackTrace();
				       }
			}
}
	public void init2()
	{
		panel.add(upButtons[0]);
		
		//panel.add(upButtons[1]);
		panel.add(upButtons[2]);
		panel.add(upButtons[6]);
	//	panel.add(upButtons[7]);
		panel.add(upButtons[8]);
		//panel.add(upButtons[23]);
		//panel.add(upButtons[24]);
		
		panel.add(action);
	}
	public void init3()
	{
		panel.add(upButtons[0]);
	
		panel.add(upButtons[2]);
		panel.add(upButtons[6]);

		panel.add(upButtons[8]);
		panel.add(upButtons[23]);
		panel.add(upButtons[24]);
		
		panel.add(action);
	}
}
}