package re.project.solarpanel.controllers;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class UpdatedStockHBox extends HBox {
    public Label itemName = new Label();
    public Label amountAdded = new Label();
    private final int amount;

    public UpdatedStockHBox(String nameItem, int amountAdded) {
        itemName.setText(nameItem);
        itemName.setMaxWidth(Double.MAX_VALUE);
        this.amountAdded.setText(Integer.toString(amountAdded));
        amount = amountAdded;

        HBox.setHgrow(itemName, Priority.ALWAYS);

        this.getChildren().addAll(itemName, this.amountAdded);
    }

    public int getAmount() {
        return amount;
    }
}
