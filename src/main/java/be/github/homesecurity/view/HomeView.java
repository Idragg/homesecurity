
package be.github.homesecurity.view;

import be.github.homesecurity.model.Security;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HomeView {

    private Image logoImage;
    private Button btnActivate;
    private Button btnDeactivate;
    private Circle sensorIndicator;
    private Label lblSensorStatus;
    private VBox root;
    private VBox securityList;

    private final Map<Security, Circle> securityIndicators =
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

        sensorIndicator.setFill(Color.GREEN);

        // Logo
        logoImage = new Image(
                getClass().getResourceAsStream("/logo.png")
        );

        ImageView logo = new ImageView(logoImage);
        logo.setFitWidth(300);
        logo.setPreserveRatio(true);

        // Main layout
        root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        root.getChildren().addAll(
                logo,
                buttonBox,
                sensorBox,
                securityList
        );
    }

    // Add a security system dynamically
    public void addSecurityIndicator(Security security, Runnable onClick) {

        Label label = new Label(security.getPlace());

        Circle circle = new Circle(12);
        circle.setFill(
                security.isActive() ? Color.RED : Color.GREEN
        );

        circle.setOnMouseClicked(event -> onClick.run());

        HBox row = new HBox(15, label, circle);
        row.setAlignment(Pos.CENTER_LEFT);

        securityList.getChildren().add(row);

        securityIndicators.put(security, circle);
    }

    // Update one security system
    public void updateSecurityStatus(Security security, boolean active) {

        Circle circle = securityIndicators.get(security);

        if (circle != null) {
            circle.setFill(active ? Color.RED : Color.GREEN);
        }
    }

    // Update all security systems
    public void updateAllSecurityStatuses(List<Security> securities) {

        for (Security security : securities) {
            updateSecurityStatus(security, security.isActive());
        }
    }

    // Update main system status
    public void updateSystemStatus(boolean active) {

        sensorIndicator.setFill(active ? Color.RED : Color.GREEN);

        lblSensorStatus.setText(
                active
                        ? "Security system active"
                        : "Security system disabled"
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
