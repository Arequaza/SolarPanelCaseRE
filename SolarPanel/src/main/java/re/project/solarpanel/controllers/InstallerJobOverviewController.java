package re.project.solarpanel.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import re.project.solarpanel.actualthings.*;
import re.project.solarpanel.customhboxes.InstallerJobOverviewHBox;
import re.project.solarpanel.helperclasses.DataSaver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InstallerJobOverviewController {
    public ListView<InstallerJobOverviewHBox> plannedJobsListView;
    private static ObservableList<InstallerJobOverviewHBox> installerJobOverviewHBoxes;
    private static final Installer installer = new Installer("Bert");

    public void initialize() {
        DataSaver.addInstallerToTeam("Team 1", installer);
        DataSaver.addQuotationToTeam("Team 1", new Quotation("Sigrid", 8, "SB5000", false, 2000, true, LocalDateTime.now(), LocalDate.now()), LocalDate.now());
        setPlannedJobsListView(installer);
    }

    public void setPlannedJobsListView(Installer installer) {
        List<InstallerJobOverviewHBox> overviewHBoxList = new ArrayList<>();
        InstallationTeam installationTeam = DataSaver.getTeamOfMember(installer.getName());
        assert installationTeam != null;
        for (Quotation quotation : installationTeam.getQuotationsToDo()) {
            overviewHBoxList.add(new InstallerJobOverviewHBox(quotation));
        }

        installerJobOverviewHBoxes = FXCollections.observableList(overviewHBoxList);
        plannedJobsListView.setItems(installerJobOverviewHBoxes);
    }

    public static void updateOverview() {
        InstallationTeam installationTeam = DataSaver.getTeamOfMember(installer.getName());
        installerJobOverviewHBoxes.remove(0, installerJobOverviewHBoxes.size());
        assert installationTeam != null;
        for (Quotation quotation : installationTeam.getQuotationsToDo()) {
            installerJobOverviewHBoxes.add(new InstallerJobOverviewHBox(quotation));
        }
    }

    public static void infoButtonAction(Quotation quotation) {
        MaterialsScreenController.QUOTATION = quotation;
    }
}
