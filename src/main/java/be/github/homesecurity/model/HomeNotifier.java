package be.github.homesecurity.model;

public interface HomeNotifier {
    void subscribeSecuritySystem(Security security);

    void unsubscribeSecuritySystem(Security security);

}
