package tictactoe;

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
public class TicTacToe_Nikola extends Application {
	
	public static int xPlayerToStartFirst = 1;
	public static int xPlayerTurn = xPlayerToStartFirst;
	
	//private char whoseTurn = 'X';
	
	public static int[] board = new int[9];
	
	public static File xImage = new File("src/btn_images/blue-cross-icon.png");
	public static File oImage = new File("src/btn_images/green-cd-icon.png");
	
	static void buttonAction(Button btn, int i){
			
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				if (xPlayerTurn == 1) {
					Image image = new Image(xImage.toURI().toString());  
					btn.setGraphic(new ImageView(image));
					xPlayerTurn = -xPlayerTurn;		
					if (i != -1) {
						board[i] = 1;
						count++;
						//btn.setText("X");
						
						isWin(1);
						System.out.println("Winner: " + isWin(1));
						System.out.println("Draw: " + isDraw());
						for (int i : board) {
							System.out.println(i);
						}
					}				
				}
				else if (xPlayerTurn == -1){
					Image image = new Image(oImage.toURI().toString());
					btn.setGraphic(new ImageView(image));
					xPlayerTurn = -xPlayerTurn;
					if (i != -1) {
						board[i] = 2;
						count++;
						isWin(2);
						System.out.println("Winner: " + isWin(2));
						System.out.println("Draw: " + isDraw());
						for (int i : board) {
							System.out.println(i);
						}
					}
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
		btn1.setStyle("-fx-text-color: transparent;");
		Button btn2 = new Button("");
		btn2.setPrefSize(200, 200);
		btn2.setStyle("-fx-text-color: transparent;");
		Button btn3 = new Button("");
		btn3.setPrefSize(200, 200);
		btn3.setStyle("-fx-text-color: transparent;");
		Button btn4 = new Button("");
		btn4.setPrefSize(200, 200);
		btn4.setStyle("-fx-text-color: transparent;");
		Button btn5 = new Button("");
		btn5.setPrefSize(200, 200);
		btn5.setStyle("-fx-text-color: transparent;");
		Button btn6 = new Button("");
		btn6.setPrefSize(200, 200);
		btn6.setStyle("-fx-text-color: transparent;");
		Button btn7 = new Button("");
		btn7.setPrefSize(200, 200);
		btn7.setStyle("-fx-text-color: transparent;");
		Button btn8 = new Button("");
		btn8.setPrefSize(200, 200);
		btn8.setStyle("-fx-text-color: transparent;");
		Button btn9 = new Button("");
		btn9.setPrefSize(200, 200);
		btn9.setStyle("-fx-text-color: transparent;");
		Button newGame = new Button("New Game");
		newGame.setPrefSize(100, 50);
		Label score = new Label("Score: ");
		final Label lblStatus = new Label("X's turn");
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
		
		lblStatus.setLayoutX(650);
		lblStatus.setLayoutY(500);
		
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
		root.getChildren().add(lblStatus);
	  
		
		
		// Eventhandler for buttons
		Button[] buttons = {btn1,btn4,btn7,btn2,btn5,btn8,btn3,btn6,btn9};
		for (int i = 0; i < buttons.length; i++) {
			buttonAction(buttons[i], i);
			
		}		
		
		newGame.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {				
				for (int i = 0; i < buttons.length; i++) {
					
					buttons[i].setGraphic(null);
				}

				for (int i = 0; i < buttons.length; i++) {
					buttonAction(buttons[i], -1);
				}		
				
				xPlayerToStartFirst = -xPlayerToStartFirst;
				xPlayerTurn = xPlayerToStartFirst;	
				count = 0;
				
				for (int i = 0; i < board.length; i++) {
					board[i] = 0;
				}				
			}
		});
		
					
		// make Scene
		Scene scene = new Scene(root, 900, 600);
		primaryStage.setTitle("TicTacToe");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static boolean isWin (int x) {
		
		if ((board[0] == board[1] && board[1] == board[2] && board [2] == x)
			|| (board[3] == board[4] && board[4] == board[5] && board[5] == x)
			|| (board[6] == board[7] && board[7] == board[8] && board[8] == x)
			
			|| (board[0] == board[3] && board[3] == board[6] && board[6] == x)
			|| (board[1] == board[4] && board[4] == board[7] && board[7] == x)
			|| (board[2] == board[5] && board[5] == board[8] && board[8] == x)
			
			|| (board[0] == board[4] && board[4] == board[8] && board[8] == x)
			|| (board[2] == board[4] && board[4] == board[6] && board[6] == x)) {
			
			return true;
		}
					
		return false;
	}
	
	
	public static boolean isDraw (){
		boolean allMovesDone = true;
		
		for (int i : board) {
			if (i == 0) {
				allMovesDone = false;
			}
		}	
		return allMovesDone;
	}
	
	private void handleMouseClick(int x) {
		
		
	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
