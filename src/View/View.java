package View;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {

	private Group mainGroup;
	private Scene mainScene;
	/// private Stage stage;
	private Label mainLabel, scoreLabel1, scoreLabel2;
	private VBox v1, v2;
	private Pane pane;
	private HBox h1;

	public View(Stage primaryStage) {
		mainGroup = new Group();
		mainGroup.getStylesheets().add(getClass().getResource("/CSS/FullStyle.css").toExternalForm());
		mainScene = new Scene(mainGroup, 300, 450);

		v1 = new VBox();
		v1.setPrefSize(300, 450);

		v2 = new VBox();
		v2.setPrefSize(300, 150);

		mainLabel = new Label("2048");
		mainLabel.setPrefSize(300, 100);

		h1 = new HBox();
		scoreLabel1 = new Label("your score is: ");
		scoreLabel2 = new Label();
		h1.getChildren().addAll(scoreLabel1, scoreLabel2);
		h1.getStylesheets().add(getClass().getResource("/CSS/SmallLabel.css").toExternalForm());

		v2.getChildren().addAll(mainLabel, h1);

		pane = new Pane();
		v1.getChildren().addAll(v2, pane);
		mainGroup.getChildren().addAll(v1);
		primaryStage.setResizable(false);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("2048");
		primaryStage.show();
	}

	public void KeyEvent(EventHandler<KeyEvent> keyListener) {
		mainScene.setOnKeyPressed(keyListener);
	}

	public void loadBoard(int[][] b) {
		pane.getChildren().clear();
		GridPane board = new GridPane();
		board.setPrefSize(300, 300);

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {

				Label tempLabel = new Label(String.valueOf(b[i][j]));
				tempLabel.setPrefSize(300 / 4, 300 / 4);
				tempLabel.setAlignment(Pos.CENTER);
				tempLabel.setStyle("-fx-background-color: lightgreen;");
				board.add(tempLabel, j, i);

				if (b[i][j] == 0) {
					tempLabel.setStyle("-fx-text-fill: white;");
				}
				if (b[i][j] == 2) {
					tempLabel.setStyle("-fx-background-color: antiquewhite;");
				}
				if (b[i][j] == 4) {
					tempLabel.setStyle("-fx-background-color: darkkhaki;");
				}
				if (b[i][j] == 8) {
					tempLabel.setStyle("-fx-background-color: darkseagreen;");
				}
				if (b[i][j] == 16) {
					tempLabel.setStyle("-fx-background-color: lightsalmon;");
				}
				if (b[i][j] == 32) {
					tempLabel.setStyle("-fx-background-color: olive;");
				}
				if (b[i][j] == 64) {
					tempLabel.setStyle("-fx-background-color: tomato;");
				}
				if (b[i][j] == 128) {
					tempLabel.setStyle("-fx-background-color: lightgreen;");
				}
				if (b[i][j] == 256) {
					tempLabel.setStyle("-fx-background-color: darkorange;");
				}
				if (b[i][j] == 512) {
					tempLabel.setStyle("-fx-background-color: chocolate;");
				}
				if (b[i][j] == 1024) {
					tempLabel.setStyle("-fx-background-color: forestgreen;");
				}
				if (b[i][j] == 2048) {
					tempLabel.setStyle("-fx-background-color: green;");
				}

			}
		}
		scoreLabel2.setText(String.valueOf(boardSum(b)));
		pane.getChildren().addAll(board);
	}

	private int boardSum(int[][] b) {
		int sum =0 ;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				sum = sum + b[i][j];
			}
		}
		return sum;
	}

}
