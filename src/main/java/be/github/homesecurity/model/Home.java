package be.github.homesecurity.model;

import java.util.ArrayList;
import java.util.List;

public class Home implements HomeNotifier {
    private List<Security> securitieSystems = new ArrayList<Security>();
    private boolean active;

    public void subscribeSecuritySystem(Security security){
        securitieSystems.add(security);
    }

    public void unsubscribeSecuritySystem(Security security){
        securitieSystems.remove(security);
    }

    private void notifySubscribers() {
        for (Security subscriber : securitieSystems) {
            subscriber.update(this.active);
        }
    }

    private void notifySubscriber(Security security){
        security.update(this.active);
    }

    public void activateSecuritySystem() {
        this.active = true;
        notifySubscribers();
    }

    public void activateSecurity(Security security) {
        this.active = true;
        notifySubscriber(security);
    }

    public void deactivateSecurity(Security security) {
        this.active = false;
        notifySubscriber(security);
    }

    public void deactivateSecuritySystem() {
        this.active = false;
        notifySubscribers();
    }
}
