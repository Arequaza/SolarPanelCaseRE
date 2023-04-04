package re.project.solarpanel.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import re.project.solarpanel.actualthings.Stock;

import java.util.ArrayList;
import java.util.List;

public class UpdateStockController {
    public TextField amountInput;
    public ChoiceBox<String> itemChooseBox;
    public ListView<UpdatedStockHBox> itemsAddedList;
    private static ObservableList<UpdatedStockHBox> itemsAddedObservableList;

    public void initialize() {
        List<String> itemsToAddHBoxes = new ArrayList<>();
        itemsToAddHBoxes.add("Solar Panels");
        itemsToAddHBoxes.add("Inverter SB2000");
        itemsToAddHBoxes.add("Inverter SB5000");
        itemsToAddHBoxes.add("Inverter SB6000");
        itemsToAddHBoxes.add("Inverter SB8000");
        itemsToAddHBoxes.add("Inverter SB12000");
        itemsToAddHBoxes.add("Phase Connector");
        ObservableList<String> itemsChooseObservableList = FXCollections.observableList(itemsToAddHBoxes);
        itemChooseBox.setItems(itemsChooseObservableList);


        itemsAddedObservableList = FXCollections.observableList(new ArrayList<>());
        itemsAddedList.setItems(itemsAddedObservableList);
    }

    public void addButtonClick(ActionEvent actionEvent) {
        int amount = Integer.parseInt(amountInput.getText());
        String nameItem = itemChooseBox.getSelectionModel().getSelectedItem();
        itemsAddedObservableList.add(new UpdatedStockHBox(nameItem, amount));
        amountInput.setText("");
        itemChooseBox.getSelectionModel().clearSelection();
    }

    public void updateStockButtonClick(ActionEvent actionEvent) {
        for (UpdatedStockHBox updatedStockHBox: itemsAddedObservableList) {
            switch (updatedStockHBox.itemName.getText()) {
                case "Solar Panels" -> Stock.addSolarPanels(updatedStockHBox.getAmount());
                case "Inverter SB2000" -> Stock.addInverterSB2000(updatedStockHBox.getAmount());
                case "Inverter SB5000" -> Stock.addInverterSB5000(updatedStockHBox.getAmount());
                case "Inverter SB6000" -> Stock.addInverterSB6000(updatedStockHBox.getAmount());
                case "Inverter SB8000" -> Stock.addInverterSB8000(updatedStockHBox.getAmount());
                case "Inverter SB12000" -> Stock.addInverterSB12000(updatedStockHBox.getAmount());
                case "Phase Connector" -> Stock.addPhaseConnector(updatedStockHBox.getAmount());
            }
        }

        itemsAddedObservableList.remove(0, itemsAddedObservableList.size());
    }

}
