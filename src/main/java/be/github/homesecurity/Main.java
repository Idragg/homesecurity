package be.github.homesecurity;

import be.github.homesecurity.controller.HomeController;
import be.github.homesecurity.model.*;
import be.github.homesecurity.model.sim.DetectionSimulator;
import be.github.homesecurity.view.HomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static be.github.homesecurity.Settings.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Home model = new Home();
        HomeView view = new HomeView();

        HomeController controller = new HomeController(model, view);
        Security securitySystem1 = new Sensor("Front door");
        Security securitySystem2 = new Sensor("Kitchen");
        Security securitySystem3 = new Pressureplate("Stairwell");
        Security securitySystem4 = new Pressureplate("Side door");
        Security securitySystem5 = new Sensor("Bathroom");
        Security securitySystem6 = new Pressureplate("Kids room");
        Security securitySystem7 = new InfraredSensor("Shed");

        model.subscribeSecuritySystem(securitySystem1);
        model.subscribeSecuritySystem(securitySystem2);
        model.subscribeSecuritySystem(securitySystem3);
        model.subscribeSecuritySystem(securitySystem4);
        model.subscribeSecuritySystem(securitySystem5);
        model.subscribeSecuritySystem(securitySystem6);
        model.subscribeSecuritySystem(securitySystem7);
        controller.load();

        new DetectionSimulator(model);

        Scene scene = new Scene(view.getRoot(), WINDOW_WIDTH, WINDOW_HEIGHT);

        primaryStage.getIcons().add(new Image(LOGO_URL));
        primaryStage.setTitle(WINDOW_TITLE);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}