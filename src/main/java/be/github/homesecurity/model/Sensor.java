package be.github.homesecurity.model;

public class Sensor implements Security {
    private String place;
    private boolean active;

    public Sensor(String place) {
        this.active = false;
        this.place = place;
    }

    public Sensor() {
        this.active = false;
        place = "Unknown";
    }

    @Override
    public void update(boolean active) {
        // true
        if (this.active && active) {
            System.out.printf("This senor by \"%s\" is already active\n", place);
        } else if (!this.active && active) {
            System.out.printf("This sensor \"%s\" is now active\n", place);
            this.active = active;
        }else {
            System.out.printf("This sensor \"%s\" is deactivated\n", place);
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
}
