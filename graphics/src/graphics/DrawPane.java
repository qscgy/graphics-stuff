package graphics;

import java.awt.*;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class DrawPane extends JPanel {
	public DrawPane(){
		super();
		setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g){
		int w=getWidth();
		int h=getHeight();
		
		super.paintComponent(g);
		//g.drawString("Hi", 250, 200);
		//g.drawLine(0, 0, width, height);
		//g.drawOval(w/2-10,h/2-10,200,100);
		g.setColor(Color.BLUE);
		for(int i=0;i<w-50;i++){
			g.fillRect(i, 10, 50, 50);
			g.clearRect(0, 0, w, h);
		}
	}
}
