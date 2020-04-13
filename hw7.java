package hw7;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
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

			Polyline line = new Polyline(100.0, 100.0);

			line.setStroke(Color.BLACK);
			line.setFill(Color.WHITE);

			ObservableList<Double> list = line.getPoints();

			this.setOnKeyPressed(e -> {
				double x = 0, y = 0;
				
				switch (e.getCode()) {
				case DOWN:
					x = list.get(list.size() - 2);
					y = list.get(list.size() - 1) + 10;
					break;
				case UP:
					x = list.get(list.size() - 2);
					y = list.get(list.size() - 1) -10; 
					break;
				case RIGHT:
					x = list.get(list.size() - 2) +10; 
					y = list.get(list.size() - 1);
					break;
				case LEFT:
					x = list.get(list.size() - 2) -10; 
					y = list.get(list.size() - 1);
					break;
				default:
					break;

				}

				list.add(x);
				list.add(y);

			});
			this.getChildren().add(line);

		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}