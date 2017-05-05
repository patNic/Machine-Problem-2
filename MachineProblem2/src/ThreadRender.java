import javax.swing.*;
import java.awt.*;
public class ThreadRender extends JLabel implements Runnable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	String[] string = {"src/images/r1.png", "src/images/r2.png", "src/images/r3.png"};
	public static ImageIcon[] icons = new ImageIcon[3];
	public ThreadRender(){
		for(int a = 0;a<3;a++){
			icons[a] = new ImageIcon(string[a]);
		}
		this.setIcon(icons[2]);
	}
	public void run(){
		int a = 0;
		while(!GUI.finish){
			try{
				Thread.sleep(400);
				this.setIcon(ThreadRender.icons[a]);
				a++;
				//System.out.println("running...");
				if(a==3) a=0;
				
			}catch(Exception e){}
		}
		
	}
	public void start(){
		run();
	}
	public static void main(String[] args){
		ThreadRender r = new ThreadRender();
		Thread t = new Thread(r);
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		p.add(r);
		p.setBackground(Color.BLACK);
		f.add(p);
		f.setSize(250,350);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		t.start();
	}
}
