
package be.github.homesecurity.model;

import java.util.ArrayList;
import java.util.List;

public class Home implements HomeNotifier {

    private final List<Security> securitieSystems = new ArrayList<>();

    public void subscribeSecuritySystem(Security security) {
        if (security != null && !securitieSystems.contains(security)) {
            securitieSystems.add(security);
        }
    }

    public void unsubscribeSecuritySystem(Security security) {
        securitieSystems.remove(security);
    }

    public void activateSecuritySystem() {
        for (Security security : securitieSystems) {
            security.update(true);
        }
    }

    public void deactivateSecuritySystem() {
        for (Security security : securitieSystems) {
            security.update(false);
        }
    }

    public void setSecurityStatus(Security security, boolean active) {
        if (securitieSystems.contains(security)) {
            security.update(active);
        }
    }

    public List<Security> getSecuritieSystems() {
        return List.copyOf(securitieSystems);
    }
}
