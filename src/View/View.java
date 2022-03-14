package View;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {

	private Group mainGroup;
	private Scene mainScene;
	/// private Stage stage;
	private Label mainLabel;
	private VBox v1;
	private Pane pane;

	public View(Stage primaryStage) {
		mainGroup = new Group();
		mainScene = new Scene(mainGroup, 300, 450);

		v1 = new VBox();
		v1.setPrefSize(300, 450);

		mainLabel = new Label("2048");
		mainLabel.setPrefSize(300, 150);
		
		pane = new Pane();
		v1.getChildren().addAll(mainLabel,pane);
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
				tempLabel.setPrefSize(300/4, 300/4);
				tempLabel.setAlignment(Pos.CENTER);
				board.add(tempLabel, i, j);
				
			}
		}
		pane.getChildren().addAll(board);
	}

}
