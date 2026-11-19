package be.github.homesecurity.model;

public class Pressureplate implements Security {
    private String place;
    private boolean active;
    private boolean detected;

    public Pressureplate(String place) {
        this.active = false;
        this.place = place;
        this.detected = false;
    }

    public Pressureplate() {
        this.active = false;
        this.detected = false;
        place = "Unknown";
    }

    @Override
    public void update(boolean active) {
        if (this.active && active) {
            System.out.printf("This %s by \"%s\" is already active\n", this.getClass().getSimpleName(), place);
        } else if (!this.active && active) {
            System.out.printf("This %s \"%s\" is now active\n", this.getClass().getSimpleName(), place);
        } else {
            System.out.printf("This %s \"%s\" is deactivated\n", this.getClass().getSimpleName(), place);
            setDetecting(false);
        }
        this.active = active;
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
