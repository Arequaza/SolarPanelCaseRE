package re.project.solarpanel.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import re.project.solarpanel.helperclasses.DataSaver;
import re.project.solarpanel.actualthings.Quotation;
import re.project.solarpanel.customhboxes.CustomHBoxCell;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OpenQuotationOverview {

    public ListView<CustomHBoxCell> quotationListView;
    public static ObservableList<CustomHBoxCell> observableList;
    public static final OpenQuotationOverview QUOTATION_OVERVIEW = new OpenQuotationOverview();

    public OpenQuotationOverview() {
    }

    @FXML
    protected void initialize() {
        DataSaver.addQuotationToList(new Quotation("Are", 10, "SB5000", false, 4961, LocalDateTime.now()));
        setListView();
    }


    private void setListView() {
        List<CustomHBoxCell> listViewCells = new ArrayList<>();
        for (Quotation quotation: DataSaver.getListOfQuotations()) {
            listViewCells.add(new CustomHBoxCell(quotation));
        }

        observableList = FXCollections.observableList(listViewCells);
        quotationListView.setItems(observableList);
    }

    public void addNewItem(Quotation quotation) {
        CustomHBoxCell customHBoxCell = new CustomHBoxCell(quotation);
        observableList.add(customHBoxCell);
    }

    public void approveButtonClick(Quotation quotation) {
        DataSaver.addApprovedQuotation(quotation);
        for (int i = 0; i < observableList.size(); i++) {
            if (observableList.get(i).getQuotation().equals(quotation)) {
                observableList.remove(i);
                break;
            }
        }
        ToBePlannedController.addNewItemToBePlanned(quotation);
    }











}
