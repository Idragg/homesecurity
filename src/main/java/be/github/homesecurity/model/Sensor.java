package be.github.homesecurity.model;

public class Sensor implements Security {
    private String place;
    private boolean active;
    private boolean detected; // detected something = true

    public Sensor(String place) {
        this.active = false;
        this.place = place;
        this.detected = false;
    }

    public Sensor() {
        this.active = false;
        this.detected = false;
        place = "Unknown";
    }

    @Override
    public void update(boolean active) {
        // true
        if (this.active && active) {
            System.out.printf("This %s by \"%s\" is already active\n", this.getClass().getSimpleName(), place);
        } else if (!this.active && active) {
            System.out.printf("This %s \"%s\" is now active\n", this.getClass().getSimpleName(), place);
            this.active = active;
        }else {
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

    public boolean isDetected() {
        return detected;
    }
}
