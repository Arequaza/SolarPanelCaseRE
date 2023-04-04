package re.project.solarpanel.customhboxes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class InventoryHBox extends HBox {
    public Label nameItem = new Label();
    public Label amountOfItem = new Label();

    public InventoryHBox(String nameItem, int amountOfItem) {
        this.nameItem.setText(nameItem);
        this.nameItem.setMaxWidth(Double.MAX_VALUE);
        this.amountOfItem.setText(Integer.toString(amountOfItem));
        HBox.setHgrow(this.nameItem, Priority.ALWAYS);

        this.getChildren().addAll(this.nameItem, this.amountOfItem);
    }
}
