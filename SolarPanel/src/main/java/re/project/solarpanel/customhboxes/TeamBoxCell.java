package re.project.solarpanel.customhboxes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import re.project.solarpanel.actualthings.InstallationTeam;

public class TeamBoxCell extends HBox {
    public Label teamNameLabel = new Label();
    private InstallationTeam installationTeam;

    public TeamBoxCell(InstallationTeam installationTeam) {
        teamNameLabel.setText(installationTeam.getName());
        this.installationTeam = installationTeam;

        this.getChildren().add(teamNameLabel);
    }

    public InstallationTeam getInstallationTeam() {
        return installationTeam;
    }
}
