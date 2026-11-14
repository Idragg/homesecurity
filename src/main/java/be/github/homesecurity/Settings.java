package be.github.homesecurity;

import javafx.scene.paint.Color;

import java.util.concurrent.TimeUnit;

public class Settings {

    // =========================
    // COLORS
    // =========================

    public static final String BACKGROUND_COLOR =
            "-fx-background-color: #345A78;";

    public static final Color ACTIVE_COLOR = Color.RED;
    public static final Color INACTIVE_COLOR = Color.GREEN;
    public static final Color DETECTING_COLOR = Color.YELLOW;
    public static final Color NOT_DETECTING_COLOR = Color.TRANSPARENT;


    // =========================
    // IMAGES
    // =========================

    public static final String LOGO_URL = "/logo.png";


    // =========================
    // LAYOUT
    // =========================

    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;

    public static final int ROOT_SPACING = 20;
    public static final int BUTTON_SPACING = 15;
    public static final int SECURITY_LIST_SPACING = 15;

    public static final int ROOT_PADDING = 20;
    public static final int SECURITY_LIST_PADDING = 20;

    public static final int LOGO_WIDTH = 300;


    // =========================
    // TEXT
    // =========================

    public static final String WINDOW_TITLE = "HomeSecurity";

    public static final String STATUS_ACTIVE =
            "Security system active";

    public static final String STATUS_INACTIVE =
            "Security system disabled";

    // =========================
    // SECURITY INDICATOR
    // =========================

    public static final int INDICATOR_RADIUS = 12;
    public static final int INDICATOR_SPACING = 15;

    public static final int ICON_FONT_SIZE = 20;
    public static final int ICON_WIDTH = 40;
    public static final int NAME_WIDTH = 120;

    // =========================
    // DETECTION SIMULATOR
    // =========================

    // Time unit used for all simulation delays
    public static final TimeUnit TIMEUNIT = TimeUnit.SECONDS;

    // Duration for which a security system detects something
    public static final int DETECTION_DURATION = 5;

    // Maximum random delay value (exclusive)
    public static final int MAX_RANDOM_DELAY = 5;

    // Multiplier used to calculate the random delay in seconds
    public static final int RANDOM_DELAY_MULTIPLIER = 1;
}