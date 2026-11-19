
package be.github.homesecurity.controller;

import be.github.homesecurity.model.Home;
import be.github.homesecurity.model.Pressureplate;
import be.github.homesecurity.model.Security;
import be.github.homesecurity.model.Sensor;
import be.github.homesecurity.model.sim.DetectionSimulator;
import be.github.homesecurity.view.HomeView;
import javafx.application.Platform;

import java.util.List;

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
        updateAllSecurityStatuses();
        checkAllSecurityStatuses();
    }

    private void deactivateSystem() {
        model.deactivateSecuritySystem();

        for (Security security : model.getSecuritieSystems()) {
            detectionSimulator.stopDetection(security);
        }

        updateAllSecurityStatuses();
        checkAllSecurityStatuses();
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

        checkAllSecurityStatuses();
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

    private void checkAllSecurityStatuses() {
        boolean allActive = model.getSecuritySystemsStatus();

        view.getBtnDeactivate().setDisable(!allActive);
        view.getBtnActivate().setDisable(allActive);

        view.updateSystemStatus(allActive);
    }
}