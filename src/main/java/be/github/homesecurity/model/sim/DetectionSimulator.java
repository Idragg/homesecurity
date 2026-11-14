package be.github.homesecurity.model.sim;

import be.github.homesecurity.model.Home;
import be.github.homesecurity.model.Security;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

import static be.github.homesecurity.Settings.*;

public class DetectionSimulator {
    private final Random random = new Random();
    private final Home home;

    private final ScheduledExecutorService scheduler;
    private final Consumer<Security> onDetectionChanged;
    private final AtomicBoolean isActive = new AtomicBoolean(false);

    public DetectionSimulator(Home home, Consumer<Security> onDetectionChanged) {
        this.home = home;
        this.onDetectionChanged = onDetectionChanged;

        this.scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.execute(this::simulateStep);
    }

    private void simulateStep() {
        if (home.getSecuritieSystems().isEmpty()) {
            stop();
            return;
        }

        int randomIndex = random.nextInt(home.getSecuritieSystems().size());
        Security security = home.getSecuritieSystems().get(randomIndex);

        if (security.isActive()) {
            isActive.set(true);
            security.setDetecting(true);
            onDetectionChanged.accept(security);
            printStatus(security);

            scheduler.schedule(() -> {
                isActive.set(false);
                security.setDetecting(false);
                onDetectionChanged.accept(security);
                printStatus(security);

                isActive.set(true);
                scheduler.schedule(() -> {
                    simulateStep();
                }, (long) random.nextInt(0, MAX_RANDOM_DELAY)
                        * RANDOM_DELAY_MULTIPLIER, TIMEUNIT);

            }, DETECTION_DURATION, TIMEUNIT);

        } else {
            isActive.set(false);
            scheduler.execute(this::simulateStep);
        }
    }

    public void stop() {
        isActive.set(false);
        scheduler.shutdownNow();
    }

    private void printStatus(Security security) {
        String state = security.isDetected() ? "detecting something" : "not detecting anything";
        System.out.println(security.getPlace() + " " + security.getClass().getSimpleName() + ": " + state);
    }
}
