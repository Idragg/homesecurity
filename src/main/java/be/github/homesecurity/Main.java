package be.github.homesecurity;

import be.github.homesecurity.model.Home;
import be.github.homesecurity.model.Pressureplate;
import be.github.homesecurity.model.Security;
import be.github.homesecurity.model.Sensor;

public class Main {
    static void main() {
        Home home = new Home();
        Security securitySystem1 = new Pressureplate("Front door");
        Security securitySystem2 = new Pressureplate("Kitchen");
        Security securitySystem3 = new Sensor("Stairwell");
        Security securitySystem4 = new Sensor("Bedroom door");

        Security securitySystem5 = new Sensor("Bathroom door");
        Security securitySystem6 = new Sensor();

        home.subscribeSecuritySystem(securitySystem1);
        home.subscribeSecuritySystem(securitySystem2);
        home.subscribeSecuritySystem(securitySystem3);
        home.subscribeSecuritySystem(securitySystem4);
        home.subscribeSecuritySystem(securitySystem5);
        home.subscribeSecuritySystem(securitySystem6);

        System.out.println("Active security system");
        home.activateSecuritySystem();

        System.out.println("\nCurrent security system");
        home.activateSecuritySystem();

        System.out.println("\nDeactivated security system");
        home.deactivateSecuritySystem();

        System.out.println("\nActivating security system");
        home.activateSecurity(securitySystem1);
        home.activateSecurity(securitySystem6);
    }
}
