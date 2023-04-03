package re.project.solarpanel.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import re.project.solarpanel.actualthings.InstallationTeam;
import re.project.solarpanel.actualthings.Installer;
import re.project.solarpanel.actualthings.Quotation;
import re.project.solarpanel.customhboxes.DateHBoxCell;
import re.project.solarpanel.customhboxes.OrderInformationHBox;
import re.project.solarpanel.customhboxes.TeamBoxCell;
import re.project.solarpanel.helperclasses.DataSaver;

import java.time.LocalDate;
import java.util.ArrayList;

public class PlanningController {
    public ListView<TeamBoxCell> teamsListView;
    private static ObservableList<TeamBoxCell> teamsObservableList;
    public ListView<DateHBoxCell> dateListView;
    private static ObservableList<DateHBoxCell> dateObservableList;
    private static Quotation quotationToPlan;
    public static final PlanningController PLANNING_CONTROLLER = new PlanningController();
    public ListView<OrderInformationHBox> orderInformationListVIew;
    private static ObservableList<OrderInformationHBox> orderInformationHBoxObservableList;

    public PlanningController() {
    }

    public void initialize() {
        DataSaver.addInstallationTeam(new InstallationTeam(new Installer("John"), "Team 1"));
        DataSaver.addInstallationTeam(new InstallationTeam(new Installer("Oliver"), "Team 2"));
        DataSaver.addInstallationTeam(new InstallationTeam(new Installer("Greg"), "Team 3"));

        dateObservableList = FXCollections.observableList(new ArrayList<>());
        dateListView.setItems(dateObservableList);
        teamsObservableList = FXCollections.observableList(new ArrayList<>());
        teamsListView.setItems(teamsObservableList);
        orderInformationHBoxObservableList = FXCollections.observableList(new ArrayList<>());
        orderInformationListVIew.setItems(orderInformationHBoxObservableList);
    }

    public static void planQuotation(Quotation quotation) {
        quotationToPlan = quotation;
        LocalDate localDateNow = LocalDate.now();

        orderInformationHBoxObservableList.remove(0, orderInformationHBoxObservableList.size());
        orderInformationHBoxObservableList.add(new OrderInformationHBox(quotation));


        for (int i = 0; i < 30; i++) {
            for (InstallationTeam installationTeam: DataSaver.getInstallationTeams()) {
                if (teamAvailable(localDateNow.plusDays(7 + i), installationTeam)) {
                    dateObservableList.add(new DateHBoxCell(localDateNow.plusDays(7 + i)));
                    break;
                }
            }
        }
    }

    private static boolean teamAvailable(LocalDate localDate, InstallationTeam installationTeam) {

        for (Quotation quotation : installationTeam.getQuotationsToDo()) {
            if (quotation.getDatePlanned().isEqual(localDate)) {
                return false;
            }
        }

        return true;
    }

    public void scheduleButtonClick(ActionEvent actionEvent) {
        // get which date is selected
        LocalDate chosenLocalDate = isASpecificDateSelected();
        // get which team is selected
        TeamBoxCell selectedTeamCell = teamsListView.getSelectionModel().getSelectedItem();
        InstallationTeam selectedTeam = selectedTeamCell.getInstallationTeam();
        if (chosenLocalDate != null && selectedTeam != null) {
            // add date to quotation
            quotationToPlan.setDatePlanned(chosenLocalDate);
            // add quotation to team
            DataSaver.addQuotationToTeam(selectedTeam.getName(), quotationToPlan);
            // remove quotation from toBePlannedList
            ToBePlannedController.removePlannedItem(quotationToPlan);
            // clear everything
            dateUnselected();
            dateObservableList.remove(0, dateObservableList.size());
            orderInformationHBoxObservableList.remove(0, orderInformationHBoxObservableList.size());
        }
    }

    private LocalDate isASpecificDateSelected() {
        for (DateHBoxCell dateHBoxCell: dateObservableList) {
            if (dateHBoxCell.checkBox.isSelected()) {
                return dateHBoxCell.localDate;
            }
        }

        return null;
    }

    public void dateSelected(LocalDate localDate) {
        for (InstallationTeam installationTeam : DataSaver.getInstallationTeams()) {
            if (teamAvailable(localDate, installationTeam)) {
                TeamBoxCell teamBoxCell = new TeamBoxCell(installationTeam);
                teamsObservableList.add(teamBoxCell);
            }
        }
    }

    public void dateUnselected() {
        teamsObservableList.remove(0, teamsObservableList.size());
    }

    public boolean isASpecificDateSelected(LocalDate localDate) {
        for (DateHBoxCell dateHBoxCell: dateObservableList) {
            if (dateHBoxCell.checkBox.isSelected() && !localDate.isEqual(dateHBoxCell.localDate)) {
                return true;
            }
        }

        return false;
    }

    public void deselectBoxes(LocalDate localDate) {
        for (DateHBoxCell dateHBoxCell: dateObservableList) {
            if (!localDate.equals(dateHBoxCell.localDate) && dateHBoxCell.checkBox.isSelected()) {
                dateHBoxCell.checkBox.fire();
            }
        }
    }

}
