package re.project.solarpanel.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import re.project.solarpanel.actualthings.Stock;
import re.project.solarpanel.customhboxes.InventoryHBox;
import re.project.solarpanel.helperclasses.DataSaver;

import java.util.ArrayList;

public class NeededInventoryController {
    public ListView<InventoryHBox> inventoryList;
    private static ObservableList<InventoryHBox> inventoryObservableList;

    public void initialize() {
        inventoryObservableList = FXCollections.observableList(new ArrayList<>());
        inventoryList.setItems(inventoryObservableList);
        Stock.updateSolarPanelsNeeded();
        Stock.updateInvertersNeeded();
        Stock.updatePhaseConnectorsNeeded();
        setInventoryList();
    }
    public void refreshButtonClick(ActionEvent actionEvent) {
        inventoryObservableList.remove(0, inventoryObservableList.size());
        Stock.updateSolarPanelsNeeded();
        Stock.updateInvertersNeeded();
        Stock.updatePhaseConnectorsNeeded();
        setInventoryList();
    }

    public void setInventoryList() {
        if (Stock.getSolarPanels() < Stock.getSolarPanelsNeeded()) {
            inventoryObservableList.add(new InventoryHBox("Solar Panels", Stock.getSolarPanelsNeeded() - Stock.getSolarPanels()));
        }
        if (Stock.getInverterSB2000() < Stock.getInverterSB2000Needed()) {
            inventoryObservableList.add(new InventoryHBox("Inverter SB2000", Stock.getInverterSB2000Needed() - Stock.getInverterSB2000()));
        }
        if (Stock.getInverterSB5000() < Stock.getInverterSB5000Needed()) {
            inventoryObservableList.add(new InventoryHBox("Inverter SB5000", Stock.getInverterSB5000Needed() - Stock.getInverterSB5000()));
        }
        if (Stock.getInverterSB6000() < Stock.getInverterSB6000Needed()) {
            inventoryObservableList.add(new InventoryHBox("Inverter SB6000", Stock.getInverterSB6000Needed() - Stock.getInverterSB6000()));
        }
        if (Stock.getInverterSB8000() < Stock.getInverterSB8000Needed()) {
            inventoryObservableList.add(new InventoryHBox("Inverter SB8000", Stock.getInverterSB8000Needed() - Stock.getInverterSB8000()));
        }
        if (Stock.getInverterSB12000() < Stock.getInverterSB12000Needed()) {
            inventoryObservableList.add(new InventoryHBox("Inverter SB12000", Stock.getInverterSB12000Needed() - Stock.getInverterSB12000()));
        }
        if (Stock.getPhaseConnector() < Stock.getPhaseConnectorNeeded()) {
            inventoryObservableList.add(new InventoryHBox("Phase Connector", Stock.getPhaseConnectorNeeded() - Stock.getPhaseConnector()));
        }
    }

    public void checkStock() {

    }
}
