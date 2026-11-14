package be.github.homesecurity.model;

public class InfraredSensor implements Security {
    private String place;
    private boolean active;
    private boolean detected;

    public InfraredSensor(String place) {
        this.place = place;
        this.active = false;
        this.detected = false;
    }

    public InfraredSensor() {
        this.place = "unknown";
        this.active = false;
        this.detected = false;
    }

    @Override
    public void update(boolean active) {
        if (this.active && active) {
            System.out.printf("This %s by \"%s\" is already active\n", this.getClass().getSimpleName(), place);
        } else if (!this.active && active) {
            System.out.printf("This %s \"%s\" is now active\n", this.getClass().getSimpleName(), place);
            this.active = active;
        } else {
            System.out.printf("This %s \"%s\" is deactivated\n", this.getClass().getSimpleName(), place);
            this.active = active;
        }
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public String getPlace() {
        return place;
    }

    @Override
    public void setDetecting(boolean detecting) {
        this.detected = detecting;
    }

    @Override
    public boolean isDetected() {
        return detected;
    }
}
