import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;

public class RenderPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int height = 0;
    private int width = 0;
    private int pixel[][];
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);

        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
            	
                try{
                    g.setColor(setColorValue(x,y));
                    g.drawLine(x, y, x, y);	
                    
                }catch(Exception e){
                	
                }
            }
        }
        GUI.upButtons[32].setIcon(GUI.upButtonIcon[34]);
        GUI.upButtons[32].repaint();
    }
    public RenderPanel(int width, int height, int[][] p){
    	
    	this.width = width;
	    this.height = height;
	    pixel =p;
	    this.setPreferredSize(new Dimension(width, height));
	    this.setOpaque(false);
    }
    private Color setColorValue(int w, int h) {
    	int rgb = pixel[w][h];
        return new Color(((rgb>>16) & 0xff), (rgb>>8) & 0xff, rgb & 0xff, (rgb>>24) & 0xff);
    }   
}