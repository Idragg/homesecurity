
package be.github.homesecurity.controller;

import be.github.homesecurity.model.Home;
import be.github.homesecurity.model.Pressureplate;
import be.github.homesecurity.model.Security;
import be.github.homesecurity.model.Sensor;
import be.github.homesecurity.model.sim.DetectionSimulator;
import be.github.homesecurity.view.HomeView;
import javafx.application.Platform;

public class HomeController {

    private final Home model;
    private final HomeView view;

    private DetectionSimulator detectionSimulator;

    public HomeController(Home model, HomeView view) {
        this.model = model;
        this.view = view;
    }

    public void load() {
        view.getBtnActivate().setOnAction(event -> activateSystem());
        view.getBtnDeactivate().setOnAction(event -> deactivateSystem());

        for (Security security : model.getSecuritieSystems()) {
            view.addSecurityIndicator(
                    security.getPlace(),
                    security.getPlace(),
                    getSecurityIcon(security),
                    security.isActive(),
                    () -> toggleSensor(security)
            );
        }

        detectionSimulator = new DetectionSimulator(
                model,
                security -> Platform.runLater(() ->
                        view.updateDetectingStatus(security)
                )
        );
    }

    private void activateSystem() {
        model.activateSecuritySystem();

        view.getBtnActivate().setDisable(true);
        view.getBtnDeactivate().setDisable(false);

        view.updateSystemStatus(true);
        updateAllSecurityStatuses();
    }

    private void deactivateSystem() {
        model.deactivateSecuritySystem();

        for (Security security : model.getSecuritieSystems()) {
            detectionSimulator.stopDetection(security);
        }

        view.getBtnDeactivate().setDisable(true);
        view.getBtnActivate().setDisable(false);

        view.updateSystemStatus(false);
        updateAllSecurityStatuses();
    }

    private void toggleSensor(Security security) {
        boolean newStatus = !security.isActive();

        model.setSecurityStatus(security, newStatus);

        if (!newStatus) {
            detectionSimulator.stopDetection(security);
        }

        view.updateSecurityStatus(
                security.getPlace(),
                newStatus
        );

        view.updateDetectingStatus(security);
    }

    private void updateAllSecurityStatuses() {
        for (Security security : model.getSecuritieSystems()) {
            view.updateSecurityStatus(
                    security.getPlace(),
                    security.isActive()
            );

            view.updateDetectingStatus(security);
        }
    }

    private String getSecurityIcon(Security security) {
        return switch (security) {
            case Sensor sensor -> "📡";
            case Pressureplate pressureplate -> "👣";
            default -> "🔒";
        };
    }

    /**
     * TODO
     * AANMAKEN CONTROLE OM TE ZIEN OF ALLE SENSORS OPSTAAN ZO JA SYSTEEM ACTIEF ZO NEE SYSTEEM UIT
     * */
}