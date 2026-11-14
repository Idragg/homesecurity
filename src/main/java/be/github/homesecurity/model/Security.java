package be.github.homesecurity.model;

public interface Security {
    void update(boolean active);
    boolean isActive();
    String getPlace();
    void setDetecting(boolean detecting);
    boolean isDetected();
}
