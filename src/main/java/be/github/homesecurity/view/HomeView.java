
package be.github.homesecurity.view;

import be.github.homesecurity.view.components.SecurityIndicator;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

import java.util.LinkedHashMap;
import java.util.Map;

import static be.github.homesecurity.Settings.*;

public class HomeView {

    private Image logoImage;
    private Button btnActivate;
    private Button btnDeactivate;
    private Circle sensorIndicator;
    private Label lblSensorStatus;
    private VBox root;
    private VBox securityList;

    private final Map<String, SecurityIndicator> securityIndicators =
            new LinkedHashMap<>();

    private HBox buttonBox;

    public HomeView() {
        initView();
        settingView();
    }

    private void initView() {
        // Buttons
        btnActivate = new Button("Activate");
        btnDeactivate = new Button("Deactivate");

        buttonBox = new HBox(15);

        // Main sensor status
        sensorIndicator = new Circle(12);
        lblSensorStatus = new Label("Security system disabled");

        // Dynamic security list
        securityList = new VBox(15);
        securityList.setAlignment(Pos.CENTER_LEFT);
        securityList.setPadding(new Insets(20));
        securityList.setMaxWidth(Double.MAX_VALUE);

        root = new VBox(ROOT_SPACING);
        root.setStyle(BACKGROUND_COLOR);
        root.setPadding(new Insets(ROOT_PADDING));
    }

    private void settingView() {

        btnActivate.setPadding(new Insets(10, 25, 10, 25));
        btnDeactivate.setPadding(new Insets(10, 25, 10, 25));
        btnDeactivate.setDisable(true);

        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(btnActivate, btnDeactivate);

        HBox sensorBox = new HBox(10);
        sensorBox.setAlignment(Pos.CENTER);
        sensorBox.getChildren().addAll(
                sensorIndicator,
                lblSensorStatus
        );

        sensorIndicator.setFill(INACTIVE_COLOR);

        // Logo
        logoImage = new Image(
                getClass().getResourceAsStream(LOGO_URL)
        );

        ImageView logo = new ImageView(logoImage);
        logo.setFitWidth(LOGO_WIDTH);
        logo.setPreserveRatio(true);

        // Main layout
        root.setAlignment(Pos.TOP_CENTER);

        root.getChildren().addAll(
                logo,
                buttonBox,
                sensorBox,
                securityList
        );
    }

    // Add a security system dynamically
    public void addSecurityIndicator(
            String id,
            String name,
            String icon,
            boolean active,
            Runnable onClick) {

        SecurityIndicator indicator = new SecurityIndicator(
                name,
                icon,
                active,
                onClick
        );

        securityList.getChildren().add(indicator.getRoot());
        securityIndicators.put(id, indicator);
    }

    // Update one security system
    public void updateSecurityStatus(String id, boolean active) {
        SecurityIndicator indicator = securityIndicators.get(id);

        if (indicator != null) {
            indicator.setActive(active);
        }
    }

    // Update main system status
    public void updateSystemStatus(boolean active) {
        sensorIndicator.setFill(active ? ACTIVE_COLOR : INACTIVE_COLOR);

        lblSensorStatus.setText(
                active ? STATUS_ACTIVE : STATUS_INACTIVE
        );
    }

    public Button getBtnActivate() {
        return btnActivate;
    }

    public Button getBtnDeactivate() {
        return btnDeactivate;
    }

    public VBox getRoot() {
        return root;
    }
}
