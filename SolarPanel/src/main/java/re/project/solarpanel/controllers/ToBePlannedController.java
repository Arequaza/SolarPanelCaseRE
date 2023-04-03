package re.project.solarpanel.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import re.project.solarpanel.helperclasses.DataSaver;
import re.project.solarpanel.actualthings.Quotation;
import re.project.solarpanel.customhboxes.ToBePlannedOverviewHBox;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToBePlannedController {
    public ListView<ToBePlannedOverviewHBox> toBePlannedList;
    public static ObservableList<ToBePlannedOverviewHBox> toBePlannedObservableList;
    public static final ToBePlannedController TO_BE_PLANNED_CONTROLLER = new ToBePlannedController();

    public ToBePlannedController() {
    }

    public void initialize() {
        DataSaver.addApprovedQuotation(new Quotation("Merel", 12, "SB5000", false, 5566, LocalDateTime.now()));
        setViewList();
    }

    private void setViewList() {
        List<ToBePlannedOverviewHBox> overviewHBoxList = new ArrayList<>();
        for (Quotation quotation : DataSaver.getApprovedQuotations()) {
            overviewHBoxList.add(new ToBePlannedOverviewHBox(quotation));
        }

        toBePlannedObservableList = FXCollections.observableList(overviewHBoxList);
        toBePlannedList.setItems(toBePlannedObservableList);
    }

    public static void addNewItemToBePlanned(Quotation quotation) {
        ToBePlannedOverviewHBox toBePlannedOverviewHBox = new ToBePlannedOverviewHBox(quotation);
        toBePlannedObservableList.add(toBePlannedOverviewHBox);
    }

    public void planButtonClick(Quotation quotation) {
        PlanningController.planQuotation(quotation);
    }

    public static void removePlannedItem(Quotation quotation) {
        for (int i = 0; i < toBePlannedObservableList.size(); i++) {
            if (toBePlannedObservableList.get(i).getQuotation().equals(quotation)) {
                toBePlannedObservableList.remove(i);
                break;
            }
        }
    }
}
