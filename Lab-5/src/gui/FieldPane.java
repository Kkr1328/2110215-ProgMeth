package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

//You might need to do something to the following line
public class FieldPane extends GridPane {

	private ObservableList<FieldCell> fieldCells = FXCollections.observableArrayList();

	public FieldPane() {
		// TODO complete the FieldPane's constructor
		this.setPrefWidth(500);
		this.setAlignment(Pos.CENTER);
		this.setVgap(8);
		this.setHgap(8);
		this.setPadding(new Insets(8));
		this.setBorder(new Border(
				new BorderStroke(Color.LIGHTGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		this.setBackground(new Background(new BackgroundFill(Color.LIMEGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 6; y++) {
				FieldCell fieldCell = new FieldCell();
				fieldCells.add(fieldCell);
				this.add(fieldCell, x, y);
			}
		}
	}

	public int calculateIncome() {
		// TODO
		int totIncome = 0;
		for (FieldCell fieldCell : fieldCells) {
			if (fieldCell.getCrop() != null) {
				totIncome += fieldCell.getCrop().getIncome();
			}
		}
		return totIncome;
	}

}
