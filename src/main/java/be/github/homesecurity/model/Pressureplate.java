package be.github.homesecurity.model;

public class Pressureplate implements Security {
    private String place;
    private boolean active;

    public Pressureplate(String place) {
        this.active = false;
        this.place = place;
    }

    public Pressureplate() {
        this.active = false;
        place = "Unknown";
    }

    @Override
    public void update(boolean active) {
        if (this.active && active) {
            System.out.printf("This pressure plate \"%s\" is already active\n", place);
        } else if (!this.active && active) {
            System.out.printf("This pressure plate \"%s\" is now active\n", place);
            this.active = active;
        }else {
            System.out.printf("This pressure plate \"%s\" is deactivated\n", place);
            this.active = active;
        }
    }
}
