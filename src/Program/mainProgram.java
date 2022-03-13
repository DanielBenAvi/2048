package Program;

import Controller.Controller;
import Model.Model;
import View.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class mainProgram extends Application {

	@Override
	public void start(Stage primaryStage) {
		Model model = new Model();
		View view = new View(primaryStage);

		@SuppressWarnings("unused")
		Controller controller = new Controller(model, view);
	}

	public static void main(String[] args) {
		launch(args);

	}
}
