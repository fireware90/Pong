//continuation of squares
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
public class squaress extends Application{
	public void start(Stage p){
		squares s = new squares();

		s.setOnKeyPressed(e->{
			switch(e.getCode()){
			case UP: s.moveRup(); break;
			case DOWN: s.moveRd(); break;
			case S: s.moveRd1(); break;
			case W: s.moveRup1(); break;
			case SPACE: s.start(); break;
			case ENTER: s.pause(); break;
			case SHIFT: s.play(); break;
			case Q: start(p); break;
			default: break;
			}
		});
		s.a1().setOnAction(e->{
			start(p);
		});
		s.a2().setOnAction(e->{
			System.exit(1);
		});
		Scene ss = new Scene(s,2*s.getx1(),2*s.gety1());	//gets x and y from squares
		p.setTitle("blocks");
		p.setScene(ss);
		p.show();
		s.requestFocus();
		
		
		
	}
	public static void main(String[] args){
		launch(args);
	}
}
