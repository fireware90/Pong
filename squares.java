//052115
//052315 052415 052515
import javafx.scene.control.Button;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

public class squares extends Pane{
	public final double r = 10;		//change radius of ball
	private double j = Math.random()*240+30;
	private double x=150,y=j;		//location location location
	private double x1=150,y1=150;	//change size of everything
	private double dx = 1, dy=1;
	private double l=20;		//rectangle length
	private Circle c=new Circle(x,j,r);
	private Rectangle r1 = new Rectangle(10,0,5,l);
	private Rectangle r2 = new Rectangle(290,0,5,l);
	private Timeline a;
	private String pp1="0";
	private String pp2="0";
	private Label p1 = new Label(pp1);
	private Label p2 = new Label(pp2);
	private boolean wfound = false;
	private Button yy= new Button("YES");
	private Button nn=new Button("NAH");
	private double chan=Math.random();
	
	public squares(){
		c.setFill(Color.PURPLE);
		p1.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC,20));
		p1.relocate(x1-3*r, r);
		p2.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC,20));
		p2.relocate(x1+3*r, r);
		getChildren().addAll(c,r1,r2,p1,p2);
	}
	public Circle getc(){
		return c;
	}
	public boolean found(){
		return wfound;
	}
	public void start(){
			a=new Timeline(new KeyFrame(Duration.millis(10),e->moveS()));	//lower is faster
			a.setCycleCount(Timeline.INDEFINITE);
			a.play();
	}
	public double getx1(){
		return x1;
	}
	public double gety1(){
		return y1;
	}
	public void play(){
		a.play();
		if(Integer.parseInt(pp1)==5||Integer.parseInt(pp2)==5){
			ww();
			a.pause();
		}
	}
	public void pause(){
		a.pause();
	}
	public void increaseSp(){
		a.setRate(a.getRate()+.02);
		
	}
	public void decreaseSp(){
		a.setRate(a.getRate()>0?a.getRate()-.01:0);
	}
	public void moveS(){	//boundaries and constraints
		if(x<0 || x>getWidth()-r || (Math.abs(j-r2.getY())<r && Math.abs(x-r2.getX())<10) || (Math.abs(j-r1.getY())<10 && Math.abs(x-r1.getX())<10)){
			double qq=Math.random();
			if(qq>.5){
				increaseSp();
				dx*=-1.031;
			}
			else{
				increaseSp();
				dx*=-1.05;
			}	
		}
		if(j<0 || j>getHeight()-r || (Math.abs(j-r2.getY())<10 && Math.abs(x-r2.getX())<10) || (Math.abs(j-r1.getY())<10 && Math.abs(x-r1.getX())<10)){
			double qq=Math.random();
			if(qq>.5){
				increaseSp();
				dy*=-1.03;
			}
			else{
				increaseSp();
				dy*=-1.03;
			}
		}
		if(chan<.25){
			x-=dx;j-=dy;
		}
		else if(chan>=.25 && chan<.5){
			x+=dx;
			j+=1.5*dy;
		}
		else if(chan>=.5 && chan<.75){
			j+=1.5*dy;
			x-=dx;	
		}
		else
			x+=dx;j-=dy;
		c.setCenterX(x);
		c.setCenterY(j);
		win();		//to win here
		nround();
	}
	public void nround(){
		if(wfound==true){
			a.stop();
			c.relocate(x,j);
			wfound=false;

		}
	}
	public void reset(){
		pp1="0";
		p1.setText(pp1);
		pp2="0";
		p2.setText(pp1);
	}
	public void win(){
		if(x>=getHeight()-r){
			decreaseSp();
			wfound = true;
			int q= Integer.parseInt(pp1);
			q++;
			pp1=String.valueOf(q);
			p1.setText(pp1);
			ww();
			pagain();
		}			
		else if(x<0){
			decreaseSp();
			wfound = true;
			int q= Integer.parseInt(pp2);
			q++;
			pp2=String.valueOf(q);
			p2.setText(pp2);
			ww();
			pagain();
		}
	}	
	public void ww(){	//end screen display
		if(Integer.parseInt(pp1)>=5){
			Label w1=new Label("PLAYER 1 WINS\nPLAY AGAIN????");
			a.pause();
			w1.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC,20));
			w1.relocate(x1-5*r,y1-2*r);
			getChildren().add(w1);
		}
		else if(Integer.parseInt(pp2)>=5){
			Label w2=new Label("PLAYER 2 WINS?!\nPLAY AGAIN????");
			a.pause();
			w2.setFont(Font.font("Times New Roman",FontWeight.BOLD, FontPosture.ITALIC,20));
			w2.relocate(x1-5*r,y1-2*r);
			getChildren().add(w2);
		}
		else
			return;
			
	}
	public void pagain(){	//buttons for end game display
		if(Integer.parseInt(pp1)>=5 ||Integer.parseInt(pp2)>=5){
			yy.relocate(x1-4*r,y1+3*r);
			nn.relocate(x1, y1+3*r);
			getChildren().addAll(yy,nn);
		}	
	}
	public Button a1(){
		return yy;
	}
	public Button a2(){
		return nn;
	}
	//movement of blocks
	public void moveRd(){
		if(r2.getY()>getHeight()-3*r)
			return;
		r2.setY(r2.getY()+10);
	}
	public void moveRup(){
		if(r2.getY()<r)
			return;
		r2.setY(r2.getY()-10);
	}
	public void moveRd1(){
		if(r1.getY()>getHeight()-3*r)
			return;
		r1.setY(r1.getY()+10);
	}
	public void moveRup1(){
		if(r1.getY()<r)
			return;
		r1.setY(r1.getY()-10);
	}
}
