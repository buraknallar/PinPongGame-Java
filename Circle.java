import java.awt.Color;
import java.awt.Graphics;


public class Circle {   //Start of class
	private int x,y,r;
	private Color c;
	
public Circle(int r,int x,int y,Color c) {       //Constructor
	this.r=r;
	this.x=x;
	this.y=y;
	this.c=c;
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

public int getR() {
	return r;
}

public void setR(int r) {
	this.r = r;
}

public Color getC() {
	return c;
}

public void setC(Color c) {
	this.c = c;
}
public void draw(Graphics g) {           //method which draws circle
	
	g.setColor(c);
	g.fillOval(x,y,r,r);
}
public void move1() {
	x=x+5;                                //NorthEast movement of my ball
    y=y-5;
}

public void move2() {
	
	x=x+5;                                //SouthEast movement of my ball
	y=y+5;
}

public void move3() {
	
	x=x-5;                               //NorthWest movement of my ball
	y=y-5;
}

public void move4() {
	
	x=x-5;                              //SouthWest movement of my ball
	y=y+5;
}

}  //End of class
