package re.project.solarpanel.helperclasses;

import re.project.solarpanel.actualthings.InstallationTeam;
import re.project.solarpanel.actualthings.Installer;
import re.project.solarpanel.actualthings.Quotation;

import java.time.LocalDate;
import java.util.ArrayList;

public class DataSaver {
    private static final ArrayList<Quotation> listOfQuotations = new ArrayList<>();
    private static final ArrayList<Quotation> approvedQuotations = new ArrayList<>();
    private static final ArrayList<InstallationTeam> installationTeams = new ArrayList<>();

    public static void addQuotationToList(Quotation quotation) {
        listOfQuotations.add(quotation);
    }

    public static void addApprovedQuotation(Quotation quotation) {
        listOfQuotations.remove(quotation);
        quotation.confirmQuotation();
        approvedQuotations.add(quotation);
    }

    public static void addQuotationToTeam(String nameOfTeam, Quotation quotation, LocalDate localDate) {
        for (InstallationTeam installationTeam: installationTeams) {
            if (installationTeam.getName().equalsIgnoreCase(nameOfTeam)) {
                installationTeam.addNewJob(quotation);
            }
        }
        approvedQuotations.remove(quotation);
    }

    public static void addInstallationTeam(InstallationTeam installationTeam) {
        installationTeams.add(installationTeam);
    }

    public static ArrayList<Quotation> getListOfQuotations() {
        return listOfQuotations;
    }

    public static ArrayList<Quotation> getApprovedQuotations() {
        return approvedQuotations;
    }

    public static ArrayList<InstallationTeam> getInstallationTeams() {
        return installationTeams;
    }

    public static void addInstallerToTeam(String name, Installer installer) {
        for (InstallationTeam installationTeam : installationTeams) {
            if (installationTeam.getName().equalsIgnoreCase(name)) {
                installationTeam.addMemberToTeam(installer);
            }
        }
    }

    public static InstallationTeam getTeamOfMember(String name) {
        for (InstallationTeam installationTeam: installationTeams) {
            for (Installer installer: installationTeam.getMemberInstallers()) {
                if (name.equalsIgnoreCase(installer.getName())) {
                    return installationTeam;
                }
            }
        }

        return null;
    }
}
