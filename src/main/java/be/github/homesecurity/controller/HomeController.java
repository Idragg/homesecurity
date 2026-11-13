
package be.github.homesecurity.controller;

import be.github.homesecurity.model.Home;
import be.github.homesecurity.model.Security;
import be.github.homesecurity.view.HomeView;

public class HomeController {
    private final Home model;
    private final HomeView view;

    public HomeController(Home model, HomeView view) {
        this.model = model;
        this.view = view;
    }

    public void load() {
        view.getBtnActivate().setOnAction(event -> activateSystem());
        view.getBtnDeactivate().setOnAction(event -> deactivateSystem());

        for (Security security : model.getSecuritieSystems()) {
            view.addSecurityIndicator(
                    security,
                    () -> toggleSensor(security)
            );
        }
    }

    private void activateSystem() {
        model.activateSecuritySystem();

        view.getBtnActivate().setDisable(true);
        view.getBtnDeactivate().setDisable(false);

        view.updateSystemStatus(true);
        view.updateAllSecurityStatuses(model.getSecuritieSystems());
    }

    private void deactivateSystem() {
        model.deactivateSecuritySystem();

        view.getBtnDeactivate().setDisable(true);
        view.getBtnActivate().setDisable(false);

        view.updateSystemStatus(false);
        view.updateAllSecurityStatuses(model.getSecuritieSystems());
    }

    private void toggleSensor(Security security) {
        boolean newStatus = !security.isActive();

        model.setSecurityStatus(security, newStatus);
        view.updateSecurityStatus(security, newStatus);
    }
}
