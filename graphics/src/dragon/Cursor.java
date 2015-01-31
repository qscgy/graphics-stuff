package dragon;

public class Cursor {
	public int x,y,endX,endY,n;
	public int step;
	public String curveSeq="F";	//level 0 curve
	public int direction=90;	//---> that way
	
	public Cursor(int x,int y,int n,int s){
		System.out.println("cursor");
		this.x=x;
		this.y=y;
		this.n=n-1;	//this is needed in generateCurve
		step=s;
		this.endX=this.x+step;
		this.endY=y;	//starts out facing right (line  will go this way --->)
		generateCurve();
		System.out.println(curveSeq);
	}
	
	public Cursor(int x,int y){
		this(x,y,0,1);
	}
	
	public String getCurveSeq(){
		return curveSeq;
	}
	
	public void moveX(int amt){
		x+=amt;
	}
	
	public void moveY(int amt){
		y+=amt;
	}
	
	public void setXY(int x,int y){
		this.x=x;
		this.y=y;
	}
	
	public void setStep(int s){
		step=s;
	}
	
	public int getX(){
		return x;
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
			System.out.println(curveSeq);
			curveSeq+="L";
			curveSeq+=switchChars(rev(curveSeq.substring(0,curveSeq.length()-1)),'L','R');
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
	
	//reverses a string
	private String rev(String str){
		String reversed="";
		for(int i=str.length()-1;i>=0;i--){
			reversed+=str.charAt(i);
		}
		return reversed;
	}
	
	/*
	 * This method rotates (endX,endY) 90 degrees clockwise about
	 * (x,y).It does this by making temp variables that are (endx,endY) transformed
	 * so that (x,y) is on the origin. Now, (endX,endY)=>(-endY,endX) in this coor.
	 * system.
	 */
	public void right(){
		int tempEndX=endX-x;
		int tempEndY=endY-y;
		endX=-tempEndY+x;	//transform back out
		endY=+tempEndX+y;
		direction+=90;
		System.out.println(x+","+y+"\t"+endX+","+endY);
	}
	
	//basically the same as right, but for a left rotation where (a,b)=>(b,-a) (in this coor.
	//system).
	public void left(){
		int tempEndX=endX-x;
		int tempEndY=endY-y;
		endX=tempEndY+x;	//transform back out
		endY=-tempEndX+y;
		direction-=90;
		System.out.println(x+","+y+"\t"+endX+","+endY);
	}
	
	//shifts positions so that they are at the end of the last line drawn
	public void shift(){
		y=endY;
		x=endX;
		if(direction%360==0){
			endY-=step;
		} else if(direction%360==90){
			endX+=step;
		} else if(direction%360==180){
			endY+=step;
		} else {
			endX-=step;
		}
		System.out.println(x+","+y+"\t"+endX+","+endY);
	}
}















