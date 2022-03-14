package Controller;

import Model.Model;
import View.View;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {

	public Controller(Model model, View view) {
		EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.UP) {
					view.loadBoard(model.moveUp());
				}
				if (event.getCode() == KeyCode.S || event.getCode() == KeyCode.DOWN) {
					view.loadBoard(model.moveDown());
				}
				if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.LEFT) {
					view.loadBoard(model.moveLeft());
				}
				if (event.getCode() == KeyCode.D || event.getCode() == KeyCode.RIGHT) {
					view.loadBoard(model.moveRight());
				}
				event.consume();
			}
		};
		view.KeyEvent(keyListener);
	}

}
