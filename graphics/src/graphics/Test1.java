package graphics;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Test1 {

	public static void main(String[] args) {
		DrawPane thomas=new DrawPane();
		//thomas.setBackground(Color.RED);
		JFrame app=new JFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(thomas);
		//app.setBackground(Color.WHITE);
		app.setSize(500,400);
		app.setVisible(true);
	}

}
