package hw7;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Drawing extends Application {
	@Override
	public void start(Stage primaryStage) {
		Pane p = new DrawPane();
		Scene scene = new Scene(p, 400, 400);
		p.requestFocus();
		primaryStage.setTitle("Drawing"); // Set the stage title
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	class DrawPane extends Pane {
		public DrawPane() {

			Line line = new Line(10, 10, 10, 10);

			line.setStrokeWidth(1);
			line.setStroke(Color.BLACK);
			line.setFill(Color.WHITE);
			line.setStartX(100.0);
			line.setStartY(100.0);
			line.setEndX(100.0);
			line.setEndY(100.0);

			this.setOnKeyPressed(e -> {

				switch (e.getCode()) {
				case DOWN:

					line.setEndY(line.getEndY() + 10);
					break;

				case UP:
					line.setStartY(line.getStartY() - 10);
					break;
				case RIGHT:
					line.setEndX(line.getEndX() + 10);
					break;
				case LEFT:
					line.setStartX(line.getStartX() - 10);
					break;
				default:
					break;

				}

			});
			this.getChildren().add(line);

		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}