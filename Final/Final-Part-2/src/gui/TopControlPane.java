package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import logic.ButtonLogic;

public class TopControlPane extends BorderPane {

	private TimeDisplay timeDisplay;
	private Button newGameButton;

	public TopControlPane() {
		super();
		this.setPrefHeight(50);
		this.setPrefWidth(600);
		this.setPadding(new Insets(10, 20, 0, 20));
		timeDisplay = new TimeDisplay(0);
		newGameButton = new Button("New Game");
		newGameButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ButtonLogic.topControlPaneOnClick();
			}
		});
		this.setLeft(timeDisplay);
		this.setRight(newGameButton);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
	}

	public TimeDisplay getTimeDisplay() {
		return timeDisplay;
	}

	public Button getNewGameButton() {
		return newGameButton;
	}

	public void setNewGameButton(Button newGameButton) {
		this.newGameButton = newGameButton;
	}

	public void setTimeDisplay(TimeDisplay timeDisplay) {
		this.timeDisplay = timeDisplay;
	}
}
