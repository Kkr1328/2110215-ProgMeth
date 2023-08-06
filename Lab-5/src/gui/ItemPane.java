package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

//You might need to do something to the following line
public class ItemPane extends GridPane {

	private ObservableList<ItemButton> itemButtonList = FXCollections.observableArrayList();

	public ItemPane() {
		// TODO implements the ItemPane's constructor
		this.setAlignment(Pos.CENTER);
		this.setVgap(10);
		this.setHgap(10);
		ItemButton Corn = new ItemButton("Corn");
		itemButtonList.add(Corn);
		ItemButton Coffee = new ItemButton("Coffee");
		itemButtonList.add(Coffee);
		ItemButton Blueberry = new ItemButton("Blueberry");
		itemButtonList.add(Blueberry);
		ItemButton Strawberry = new ItemButton("Strawberry");
		itemButtonList.add(Strawberry);
		ItemButton Pineapple = new ItemButton("Pineapple");
		itemButtonList.add(Pineapple);
		ItemButton DestroyTool = new ItemButton("DestroyTool");
		itemButtonList.add(DestroyTool);
		int i = 0;
		for (ItemButton item : itemButtonList) {
			item.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					if (SimulationManager.getMoney() >= item.getItem().getPrice()) {
						setSelectedButton(item);
					}
				}
			});
			this.add(item, (i) % 3, (int) (i++) / 3);
		}
	}

	public void setSelectedButton(ItemButton selecteditemButton) {
		// TODO set selectedItemButton of SimulationManager to given ItemButton
		// resetButtonsBackgroundColor and the highlight the selecteditemButton
		SimulationManager.setSelectedItemButton(selecteditemButton);
		resetButtonsBackGroundColor();
		selecteditemButton.highlight();
	}

	public void resetButtonsBackGroundColor() {
		// TODO unhighlight each button in itemButtonList
		for (ItemButton button : itemButtonList) {
			button.unhighlight();
		}
	}

}
