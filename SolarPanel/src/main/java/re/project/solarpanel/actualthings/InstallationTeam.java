package re.project.solarpanel.actualthings;

import java.util.ArrayList;

public class InstallationTeam {
    private final ArrayList<Quotation> quotationsToDo;
    private final ArrayList<Installer> memberInstallers;
    private final String name;

    public InstallationTeam(Installer installer, String name) {
        this.name = name;
        memberInstallers = new ArrayList<>();
        memberInstallers.add(installer);
        quotationsToDo = new ArrayList<>();
    }

    public InstallationTeam(ArrayList<Installer> installers, String name) {
        this.name = name;
        memberInstallers = new ArrayList<>();
        memberInstallers.addAll(installers);
        quotationsToDo = new ArrayList<>();
    }

    public void addNewJob(Quotation quotation) {
        quotationsToDo.add(quotation);
    }

    public ArrayList<Quotation> getQuotationsToDo() {
        return quotationsToDo;
    }

    public String getName() {
        return name;
    }


}
