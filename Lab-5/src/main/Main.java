package main;

import gui.ControlPane;
import gui.FieldPane;
import gui.SimulationManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		// TODO

		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setSpacing(10);
		root.setPrefHeight(400);

		ControlPane controlPane = new ControlPane();
		FieldPane fieldPane = new FieldPane();

		root.getChildren().add(controlPane);
		root.getChildren().add(fieldPane);

		SimulationManager.setFieldPane(fieldPane);
		SimulationManager.setControlPane(controlPane);

		Scene scene = new Scene(root);

		primaryStage.setTitle("Harvest Simulator");
		primaryStage.setScene(scene);
		primaryStage.sizeToScene();
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
