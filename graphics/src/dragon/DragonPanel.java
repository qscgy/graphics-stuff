package dragon;

import javax.swing.JPanel;

import java.awt.*;
import java.util.Scanner;

public class DragonPanel extends JPanel {
	private int n=0;
	int x,y;
	int step=1;
	String curve="F";
	Color color;
	Color color2=Color.GREEN;
	int direction=90;	//this way -->
	//long strokeNum=0;	//used for twindragon
	//boolean td=false;	//twindragon
	
	public DragonPanel(Color c,int n,int step){
		super();
		color=c;
		this.step=step;
		this.n=n-1;
		setBackground(Color.WHITE);
		//this.setIgnoreRepaint(true);
	}
	
	public void setN(int n){
		this.n=n-1;
	}
	
	public void setStep(int s){
		step=s;
	}
	
	public void setXY(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public void setColor2(Color c){
		color2=c;
		//td=true;
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(color);
		System.out.println(g.getColor());
		//System.out.println(td);
		g.setXORMode(new Color(124,11,244));
		//System.out.println("painting");
		int w=getWidth();
		int h=getHeight();
		x=w/2;
		y=h/2;
		generateCurve();
		//System.out.println(curve);
		for(int i=0;i<curve.length();i++){
			//System.out.println(direction);
			char c=curve.charAt(i);
			if(i%2==0){
			//	g.setColor(color);
			} else {
			//	g.setColor(color2);
			}
			System.out.println(g.getColor());
			if(c=='F'){
				if(direction%360==0){
					g.drawLine(x,y,x,y-step);
					y-=step;
				} else if(direction%360==90){
					g.drawLine(x,y,x+step,y);
					x+=step;
				} else if(direction%360==180){
					g.drawLine(x,y,x,y+step);
					y+=step;
				} else if(direction%360==270){
					g.drawLine(x, y, x-step, y);
					x-=step;
				}
			} else if(c=='L'){
				direction-=90;
				direction%=360;
				if(direction<0 && direction>=-90)	//makes sure that direction is not negative
					direction+=360;
			} else if(c=='R'){
				direction+=90;
				direction%=360;
				if(direction<0 && direction>=-90)
					direction+=360;
			}
		}
	}
	
	/*
	 * Dynamically generates a string representing the dragon curve. The
	 * algorithm is as follows: After each iteration, append a left turn (L)
	 * to curveSeq, and then append everything but that L onto the end, but
	 * drawn backwards. In this case, backwards means reversed and with L's
	 * and R's switched.
	 */
	private void generateCurve(){
		for(int i=0;i<=n;i++){
			//System.out.println(curve);
			curve+="L";
			curve+=switchChars(rev(curve.substring(0,curve.length()-1)),'L','R');
		}
	}
	
	//makes each occurence of c in str into r, and vice versa
	private String switchChars(String str,char c,char r){
		//System.out.println("switching");
		String switched="";
		for(int i=0;i<str.length();i++){
			//System.out.println("switching");
			char at=str.charAt(i);
			if(at==c)
				switched+=r;
			else if(at==r)
				switched+=c;
			else
				switched+=at;
		}
		return switched;
	}
	
	private String rev(String str){
		String reversed="";
		for(int i=str.length()-1;i>=0;i--){
			reversed+=str.charAt(i);
		}
		return reversed;
	}
	
	private void forward(Graphics g){
		//System.out.println(x+","+y);
		if(direction%360==0){
			g.drawLine(x,y,x,y-step);
			y-=step;
		} else if(direction%360==90){
			g.drawLine(x,y,x+step,y);
			x+=step;
		} else if(direction%360==180){
			g.drawLine(x,y,x,y+step);
			y+=step;
		} else if(direction%360==270){
			g.drawLine(x, y, x-step, y);
			x-=step;
		}
		//System.out.println(x+","+y+"\n");
	}
	
	private void left(){
		direction-=90;
		direction%=360;
		if(direction<0 && direction>=-90)	//makes sure that direction is not negative
			direction+=360;
	}
	
	private void right(){
		direction+=90;
		direction%=360;
		if(direction<0 && direction>=-90)
			direction+=360;
	}
	
}
