package View;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class View {

	private Group mainGroup;
	private Scene mainScene;
	/// private Stage stage;
	private Label mainLabel;
	private VBox v1;
	private GridPane board;
	private Label label00, label01, label02, label03, label10, label11, label12, label13, label20, label21, label22,
			label23, label30, label31, label32, label33;

	public View(Stage primaryStage) {
		mainGroup = new Group();
		mainScene = new Scene(mainGroup, 300, 450);

		v1 = new VBox();
		v1.setPrefSize(300, 450);

		mainLabel = new Label("2048");
		mainLabel.setPrefSize(300, 150);

		board = new GridPane();
		board.setPrefSize(300, 300);

		CreateLabels();

		v1.getChildren().addAll(mainLabel,board);
		mainGroup.getChildren().addAll(v1);
		primaryStage.setResizable(false);
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("Simplex Algorithm");
		primaryStage.show();
	}

	private void CreateLabels() {
		label00 = new Label("0");
		
		board.add(label00, 0, 0);
		label01 = new Label("0");
		board.add(label01, 0, 1);
		label02 = new Label("0");
		board.add(label02, 0, 2);
		label03 = new Label("0");
		board.add(label03, 0, 3);
		label10 = new Label("0");
		board.add(label10, 1, 0);
		label11 = new Label("0");
		board.add(label11, 1, 1);
		label12 = new Label("0");
		board.add(label12, 1, 2);
		label13 = new Label("0");
		board.add(label13, 1, 3);
		label20 = new Label("0");
		board.add(label20, 2, 0);
		label21 = new Label("0");
		board.add(label21, 2, 1);
		label22 = new Label("0");
		board.add(label22, 2, 2);
		label23 = new Label("0");
		board.add(label23, 2, 3);
		label30 = new Label("0");
		board.add(label30, 3, 0);
		label31 = new Label("0");
		board.add(label31, 3, 1);
		label32 = new Label("0");
		board.add(label32, 3, 2);
		label33 = new Label("0");
		board.add(label33, 3, 3);
	}

	public void KeyEvent(EventHandler<KeyEvent> keyListener) {
		mainScene.setOnKeyPressed(keyListener);
	}
	public void loadBoard(int[][] b) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				//board.
			}
		}
	}

}
