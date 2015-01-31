package dragon;
import javax.swing.*;

import java.awt.*;
public class DrawDragon {

	public static void main(String[] args) {
		JFrame app=new JFrame();
		DragonPanel dp=new DragonPanel(new Color(0,0,255),15,2);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.add(dp);
		//dp.setColor2(Color.GREEN);
		//dp.setN(10);
		//dp.setColor(new Color(255,0,255));
		//dp.setStep(5);
		app.setSize(1000,922);
		//dp.setIgnoreRepaint(true);
		app.setVisible(true);
	}

}
