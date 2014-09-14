package tictactoe;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author ZerefeL
 */
public class TicTacToe extends Application {
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
		// Eventhandler for buttons
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				btn1.setText("X");
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				btn2.setText("X");
			}
		});
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				btn3.setText("X");
			}
		});
		btn4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				btn4.setText("X");
			}
		});
		btn5.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				btn5.setText("X");
			}
		});
		btn6.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				btn6.setText("X");
			}
		});
		btn7.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				btn7.setText("X");
			}
		});
		btn8.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				btn8.setText("X");
				
			}
		});
		btn9.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				btn9.setText("X");
			}
		});
		// make Scene
		Scene scene = new Scene(root, 900, 600);
		primaryStage.setTitle("TicTacToe");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
