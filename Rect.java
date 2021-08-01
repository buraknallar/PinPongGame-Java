import java.awt.Color;
import java.awt.Graphics;

public class Rect {    //Start of class
	private int w,h,x,y;
	private Color c;
	
	public Rect(int w,int h,int x,int y,Color c){       //My constructor
		this.w=w;
		this.h=h;
		this.x=x;
		this.y=y;
		this.c=c;
		
		
	}
	
	
	
	public int getW() {
		return w;
	}



	public void setW(int w) {
		this.w = w;
	}



	public int getH() {
		return h;
	}



	public void setH(int h) {
		this.h = h;
	}



	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public Color getC() {
		return c;
	}



	public void setC(Color c) {
		this.c = c;
	}


	public void draw(Graphics g) {            //Method which draws my players
		  g.setColor(c);
		  g.fillRect(x, y,w, h);
		
	}
	public void moveD() {                    //movements of my players
		if(y!=650) {                 
			y=y+25;
		}
		                                   //if functions blocks my players get out from game field
		
		}
	public void moveU() {
		if(y!=300) {
			y=y-25;
		}
		
		
		
	}

}
