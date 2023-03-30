package re.project.solarpanel;

import javafx.fxml.FXML;

import java.util.ArrayList;

public class DataSaver {
    private static ArrayList<Quotation> listOfQuotations = new ArrayList<>();
    private static ArrayList<Quotation> approvedQuotations = new ArrayList<>();

    public static void addQuotationToList(Quotation quotation) {
        listOfQuotations.add(quotation);
    }

    public static void addApprovedQuotation(Quotation quotation) {
        listOfQuotations.remove(quotation);
        approvedQuotations.add(quotation);
    }

    public static ArrayList<Quotation> getListOfQuotations() {
        return listOfQuotations;
    }
}
