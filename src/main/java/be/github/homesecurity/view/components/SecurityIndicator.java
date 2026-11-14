package be.github.homesecurity.view.components;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;

import static be.github.homesecurity.Settings.*;

public class SecurityIndicator {

    private final HBox root;
    private final Circle indicator;

    public SecurityIndicator(
            String name,
            String icon,
            boolean active,
            Runnable onClick) {

        Label iconLabel = new Label(icon);
        iconLabel.setStyle("-fx-font-size: " + ICON_FONT_SIZE + "px;");
        iconLabel.setMinWidth(ICON_WIDTH);
        iconLabel.setPrefWidth(ICON_WIDTH);
        iconLabel.setAlignment(Pos.CENTER);

        Label nameLabel = new Label(name);
        nameLabel.setMinWidth(NAME_WIDTH);
        nameLabel.setPrefWidth(NAME_WIDTH);

        indicator = new Circle(INDICATOR_RADIUS);
        setActive(active);

        indicator.setOnMouseClicked(event -> onClick.run());

        root = new HBox(
                INDICATOR_SPACING,
                iconLabel,
                nameLabel,
                indicator
        );

        root.setAlignment(Pos.CENTER_LEFT);
    }

    public HBox getRoot() {
        return root;
    }

    public void setActive(boolean active) {
        indicator.setFill(active ? ACTIVE_COLOR : INACTIVE_COLOR);
    }
}