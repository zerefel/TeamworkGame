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

public class TicTacToå extends Application {
		
	static int xPlayerToStartFirst = 1;
	static int playerTurn = xPlayerToStartFirst;
	static int xPlayerScore = 0;
	static int oPlayerScore = 0;
	static int count = 0;
	
	static Label status = new Label();
	static Label xScore = new Label("X score: 0");
	static Label oScore = new Label("O score: 0");	
	
	static int[] board = new int[9];
	
	static File xFile = new File("images/blue-cross-icon.png");
	static Image xImage = new Image(xFile.toURI().toString());  
	static File oFile = new File("images/green-cd-icon.png");
	static Image oImage = new Image(oFile.toURI().toString());
	
	
	static void buttonAction(Button btn, int i){
			
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				if (playerTurn == 1) {												
						btn.setGraphic(new ImageView(xImage));					
						playerTurn = -playerTurn;			
						board[i] = 1;	
						count++;
						if (isWin(1)) {
							playerTurn = 0;
							xPlayerScore++;
							count = 0;
							status.setText("X wins!");
							xScore.setText("X score: " + xPlayerScore);							
							//JOptionPane.showMessageDialog(null, "X " + " WINS!");
							
						} else {
							status.setText("O's turn");
						}						
					
				} else if (playerTurn == -1){
					
					btn.setGraphic(new ImageView(oImage));
					playerTurn = -playerTurn;			
					board[i] = 2;
					count++;
					if (isWin(2)) {
						playerTurn = 0;
						oPlayerScore++;
						count = 0;
						status.setText("O wins!");
						oScore.setText("O score: " + oPlayerScore);
						//JOptionPane.showMessageDialog(null, "Î " + " WINS!");
					} else {
						status.setText("X's turn");
					}					
				}
				
				if (count == 9) {
					status.setText("Draw");
					//JOptionPane.showMessageDialog(null, "Draw.");
				}
							
				btn.setOnAction(null);				
			}
		});
	}
	
	@Override
	public void start(Stage primaryStage) {
		//Thread runThread;
		
		// make buttons and labels
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
		newGame.setPrefSize(105, 50);
		final Button resetScore = new Button("Reset Score");
		resetScore.setPrefSize(105, 50);	
		xScore.setId(("xScore"));
		oScore.setId(("oScore"));
		status.setId(("lblStatus"));
		status.setText("X's turn");
		Label version = new Label("v1.0");
		version.setId(("version"));
		
		
		//layouts
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
		newGame.setLayoutY(30);
		resetScore.setLayoutX(710);
        resetScore.setLayoutY(110);
		xScore.setLayoutX(690);
		xScore.setLayoutY(250);
		oScore.setLayoutX(688);
		oScore.setLayoutY(300);	
		status.setLayoutX(680);
		status.setLayoutY(470);
		version.setLayoutX(860);
		version.setLayoutY(575);
		
		
		Pane root = new Pane();
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
		root.getChildren().add(resetScore);
		root.getChildren().add(xScore);
		root.getChildren().add(oScore);
		root.getChildren().add(status);
		root.getChildren().add(version);
	  
		
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

				xPlayerToStartFirst = -xPlayerToStartFirst;
				playerTurn = xPlayerToStartFirst;
				count = 0;			
				
				status.setText("X's turn");
				
				for (int i = 0; i < buttons.length; i++) {
					buttonAction(buttons[i], i);
				}					
				
				for (int i = 0; i < board.length; i++) {
					board[i] = 0;
				}	
				
				if (playerTurn == 1) {
					status.setText("X's turn");
				} else {
					status.setText("O's turn");
				}						
			}
		});
		
		resetScore.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {		
				xPlayerScore = 0;
				oPlayerScore = 0;
				xScore.setText("X score: " + oPlayerScore);
				oScore.setText("O score: " + oPlayerScore);
			}
		});
						
		// make Scene
		Scene scene = new Scene(root, 900, 600);
		primaryStage.setTitle("TicTacToe");
		primaryStage.setScene(scene);
		scene.getStylesheets().add(TicTacToå.class.getResource("button_effects.css").toExternalForm());
		primaryStage.show();	
	}
	
	public static boolean isWin (int x) {
		
		if ((	//check rows
				board[0] == board[1] && board[1] == board[2] && board [2] == x)
			|| (board[3] == board[4] && board[4] == board[5] && board[5] == x)
			|| (board[6] == board[7] && board[7] == board[8] && board[8] == x)
			
				//check columns
			|| (board[0] == board[3] && board[3] == board[6] && board[6] == x)
			|| (board[1] == board[4] && board[4] == board[7] && board[7] == x)
			|| (board[2] == board[5] && board[5] == board[8] && board[8] == x)
			
				//check diagonals
			|| (board[0] == board[4] && board[4] == board[8] && board[8] == x)
			|| (board[2] == board[4] && board[4] == board[6] && board[6] == x)) {
			
			return true;
		}					
		return false;
	}
	
	public static void main(String[] args) {
        launch(args);
    }
}
