import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Pingpong extends JFrame implements ActionListener,KeyListener,MouseListener {        //Start of class

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnStr,btnStop;
	private Rect p1,p2;
	private Circle b;
	private Timer t1,t2,t3,t4;
	private JLabel j1,j2,j3,j4,j5,j6;
	private int i1,i2,iw1,iw2;
	private String s1,s2,s11,s21,sw1,sw2;


	
	
	public void paint(Graphics g) {                  //Method which i draw my players and ball
		super.paint(g);
		
		g.setColor(Color.black);
		g.drawLine(0, 300, 800,300);                   //draw lines determine my game field
		g.drawLine(0, 700, 800, 700);
		
		 p1.draw(g);
		 p2.draw(g);
		 b.draw(g);
	
	
	}
	
	public Pingpong() {                        //My constructor
		setLayout(null);
		init();
		setSize(800, 800);
		setVisible(true);                     //My window parameters
		setTitle("Ping Pong");
		setResizable(false);
	}

	public static void main(String [] args) {             //My main
		new Pingpong();
	}
	private void init() {                               //Helper method for my constructor
		btnStr= new JButton("Start");
		btnStr.setLocation(350, 30);
		btnStr.setSize(100, 50);                          
		add(btnStr);
		btnStr.setFocusable(false);
		
		
		btnStop= new JButton("Pause");
		btnStop.setLocation(350, 90);
		btnStop.setSize(100, 50);
		add(btnStop);
		btnStop.setFocusable(false);
		
		p1=new Rect(20,50,20,500,Color.blue); 
	    p2=new Rect(20,50,760,500,Color.red);               //My objects(Player1,Player2,Ball)
		b=new Circle(10,370,500,Color.black);
		
		addKeyListener(this);
		setFocusable(true);
		btnStr.addMouseListener(this);
		btnStop.addMouseListener(this);
		
		j1=new JLabel("Player 1");
		j1.setLocation(100,25);
		j1.setSize(120,100);
		j1.setForeground(Color.blue);
		j1.setFont(new Font(null,Font.PLAIN,30));
		add(j1);
		
		j2=new JLabel("Player 2");
		j2.setLocation(550,25);
		j2.setSize(120,100);
		j2.setForeground(Color.red);
		j2.setFont(new Font(null,Font.PLAIN,30));
		add(j2);
		
		j3=new JLabel("0");
		j3.setLocation(125,100);                         //Label which shows score of Player 1
		j3.setSize(120,100);
		j3.setForeground(Color.blue);
		j3.setFont(new Font(null,Font.PLAIN,50));
		add(j3);
		
		j4=new JLabel("0");
		j4.setLocation(575,100);
		j4.setSize(120,100);                              //Label which shows score of player 2 
		j4.setForeground(Color.red);
		j4.setFont(new Font(null,Font.PLAIN,50));
		add(j4);
		
		j5=new JLabel("Whoever scores 7 times wins");
		j5.setLocation(320,150);
		j5.setSize(200,100);
		add(j5);
		
		j6=new JLabel("");
		j6.setLocation(50,675);
		j6.setSize(500,100);                                //Label which shows who won
		j6.setFont(new Font(null,Font.PLAIN,50));
		add(j6);
		
	
	   
	   
	
		
	
		
		t1=new Timer(20,this);
		t2=new Timer(20,this);                          //My timers, they paints movements of game
		t3=new Timer(20,this);
		t4=new Timer(20,this);
		
		
	
	}

	public void score() {   //My helper method
		if(b.getX()==0) {
			s1=j4.getText();
			i1=Integer.parseInt(s1);
			i1=i1+1;
			s11=Integer.toString(i1);              //This method counts scores
			j4.setText(s11);
		}
	   if(b.getX()==780) {
		   s2=j3.getText();
			i2=Integer.parseInt(s2);
			i2=i2+1;
			s21=Integer.toString(i2);
			j3.setText(s21);
		   
	   }
	repaint();
	}
	public void winner() {
		sw1=j3.getText();
		iw1=Integer.parseInt(sw1);
		sw2=j4.getText();
		iw2=Integer.parseInt(sw2);                 //This method changes j6 when a player scores 7 times
		
		
		if(iw1==7){
			j6.setText("Player1 wins");
			j6.setForeground(Color.blue);
		}
		if(iw2==7){
			j6.setText("Player2 wins");
			j6.setForeground(Color.red);
		}
		
	}
	
	public void keyPressed(KeyEvent e) {
	

}
	
	 

	
	

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==(KeyEvent.VK_W)) {
			p1.moveU();
		
		 }
	 if(e.getKeyCode()==(KeyEvent.VK_S)) {
			p1.moveD();
		
		 }
	 if(e.getKeyCode()==(KeyEvent.VK_UP)) {
			p2.moveU();
		
		 }
	 if(e.getKeyCode()==(KeyEvent.VK_DOWN)) {
			p2.moveD();
		
		 }
	repaint();

}
	

	@Override
	public void keyTyped(KeyEvent e) {
		
	
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(t1)) {
			b.move1();
		
			 if (b.getX()+5==p2.getX()) {
				 if(b.getY()<=p2.getY()+50 && b.getY()>=p2.getY()) {  //This if function controls the ball and p2 crushed.
				t3.start();
				t1.stop();
				 }
			 }
				
			
			else if(b.getY()==305) {                             //this if function blocks ball from getting out from game field
				t2.start();
				t1.stop();
				
			}
			score();
			winner();
			repaint();
	}
		if(e.getSource().equals(t2)) {
			b.move2();
			 if (b.getX()+5==p2.getX()) {
				 if(b.getY()<=p2.getY()+50 && b.getY()>=p2.getY()) {  //This if function controls the ball and p2 crushed.
				t4.start();
				t2.stop();
				 }
			 }
			 else if(b.getY()==695) {
					t1.start();                               //this if function blocks ball from getting out from game field
					t2.stop();
					
				}
			 score();
			 winner();
			repaint();
		}
		if(e.getSource().equals(t3)) {
			b.move3();
			 if (b.getX()-5==p1.getX()+20) {
				 if(b.getY()<=p1.getY()+50 && b.getY()>=p1.getY()) {    //This if function controls the ball and p1 crushed.
				t1.start();
				t3.stop();
				 }
			 }
			 else if(b.getY()==305) {                                 //this if function blocks ball from getting out from game field
					t4.start();
					t3.stop();
					
				}
			score();
			winner();
			repaint();
		}
	
	if(e.getSource().equals(t4)) {
		b.move4();
		 if (b.getX()-5==p1.getX()+20) {
			 if(b.getY()<=p1.getY()+50 && b.getY()>=p1.getY()) {       //This if function controls the ball and p1 crushed.
			t2.start();
			t4.stop();
			
			 }
		 }
		 else if(b.getY()==695) {                                  //this if function blocks ball from getting out from game field
				t3.start();
				t4.stop();
				
				
			}
		
		score();
		winner();
		repaint();
	}
}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource().equals(btnStr)) {
			b.setX(370);
			b.setY(500);
			t3.start();
			t1.stop();                             //My listener for start button
			t2.stop();
			t4.stop();
			sw1=j3.getText();
			iw1=Integer.parseInt(sw1);
			sw2=j4.getText();
			iw2=Integer.parseInt(sw2);
			
			
			if(iw1==7){
				j3.setText("0");
				j4.setText("0");
				j6.setText("");
			
			}
			if(iw2==7){                            //Those if functions makes scores 0 when new game starts
				j3.setText("0");
				j4.setText("0");
				j6.setText("");
			
			}
		}
		if(e.getSource().equals(btnStop)) {
			t1.stop();
			t2.stop();
			t3.stop();                              //My listener for stop button stops the ball but ball is not continues from same direction.
			t4.stop();
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	


	

}  // End of class
