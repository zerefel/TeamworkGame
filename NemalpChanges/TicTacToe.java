

import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author ZerefeL
 */
public class TicTacToe extends Application {
	public static int counter = 1;


	
	static void buttonAction(Button btn){
			
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				if (counter%2==0) {	
					//Loads images from the hard drive
					File file = new File("C:/Users/Sven/workspace/TicTacToeGame/src/btn_images/green-cd-icon.png");
					Image image = new Image(file.toURI().toString());
					btn.setGraphic(new ImageView(image));
					//btn.setText("O");
					counter++;					
				}
				else {
					//loads images from the hard drive
					File file = new File("C:/Users/Sven/workspace/TicTacToeGame/src/btn_images/blue-cross-icon.png");
					Image image = new Image(file.toURI().toString()); 
					btn.setGraphic(new ImageView(image));
					//btn.setText("X");
					counter++;								
				}
				btn.setOnAction(null);				
			}
		});
	}
	
	@Override
	public void start(Stage primaryStage) {
		Thread runThread;
		
		// make buttons
		Button btn1 = new Button("");
		btn1.setPrefSize(200, 200);
		Button btn2 = new Button("");
		btn2.setPrefSize(200, 200);
		Button btn3 = new Button("");
		btn3.setPrefSize(200, 200);
		Button btn4 = new Button("");
		btn4.setPrefSize(200, 200);
		Button btn5 = new Button("");
		btn5.setPrefSize(200, 200);
		Button btn6 = new Button("");
		btn6.setPrefSize(200, 200);
		Button btn7 = new Button("");
		btn7.setPrefSize(200, 200);
		Button btn8 = new Button("");
		btn8.setPrefSize(200, 200);
		Button btn9 = new Button("");
		btn9.setPrefSize(200, 200);
		Button newGame = new Button("New Game");
		newGame.setPrefSize(100, 50);
		Label score = new Label("Score: ");
		Pane root = new Pane();
		btn1.setLayoutX(0);
		btn1.setLayoutY(0);
		btn2.setLayoutX(0);
		btn2.setLayoutY(200);
		btn3.setLayoutX(0);
		btn3.setLayoutY(400);
		btn4.setLayoutX(200);
		btn4.setLayoutY(0);
		btn5.setLayoutX(200);
		btn5.setLayoutY(200);
		btn6.setLayoutX(200);
		btn6.setLayoutY(400);
		btn7.setLayoutX(400);
		btn7.setLayoutY(0);
		btn8.setLayoutX(400);
		btn8.setLayoutY(200);
		btn9.setLayoutX(400);
		btn9.setLayoutY(400);
		newGame.setLayoutX(710);
		newGame.setLayoutY(50);
		score.setLayoutX(650);
		score.setLayoutY(450);
		root.getChildren().add(btn1);
		root.getChildren().add(btn2);
		root.getChildren().add(btn3);
		root.getChildren().add(btn4);
		root.getChildren().add(btn5);
		root.getChildren().add(btn6);
		root.getChildren().add(btn7);
		root.getChildren().add(btn8);
		root.getChildren().add(btn9);
		root.getChildren().add(newGame);
		root.getChildren().add(score);
	  
		int[][] board = new int[3][3];
		
		// Eventhandler for buttons
		Button[] buttons = {btn1,btn2,btn3,btn4,btn5,btn6,btn6,btn7,btn8,btn9};
		for (int i = 0; i < buttons.length; i++) {
			buttonAction(buttons[i]);
			int y = i % 3;
			int x = i / 3;
		}		
		
		newGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {				
				for (int i = 0; i < buttons.length; i++) {
					
					//buttons[i].setText("");
					buttons[i].setGraphic(null);
				}

				for (int i = 0; i < buttons.length; i++) {
					buttonAction(buttons[i]);
				}		
				counter=1;			
			}
		});
					
		// make Scene
		Scene scene = new Scene(root, 900, 600);
		primaryStage.setTitle("TicTacToe");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
