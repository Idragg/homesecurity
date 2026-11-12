# 🏠 Home Security System

## 📖 About the Project

The **Home Security System** is a Java-based project designed to manage and control different security systems within a home.

The application supports multiple types of security devices, such as pressure plates and sensors. These devices can be activated and deactivated individually or all at once.

The project also includes a `HomeNotifier` component, responsible for handling notifications related to the home security system.

The long-term goal is to develop this project into a **JavaFX desktop application**, providing users with an intuitive graphical interface to manage their home security.

## 🎯 Features

- Create and manage multiple security systems.
- Support different types of security devices:
    - **Pressureplate:** A pressure-based security device, for example, at doors and entrances.
    - **Sensor:** A sensor-based security device, for example, in stairwells, bedrooms and other rooms.
- Register security systems within a home.
- Activate all security systems simultaneously.
- Deactivate all security systems simultaneously.
- Activate individual security systems.
- Handle notifications through the `HomeNotifier` component.

## 🛠️ Technologies

| Technology | Purpose |
| --- | --- |
| Java | Main programming language |
| JavaFX | Graphical user interface (planned) |
| Object-Oriented Programming | Application structure and reusability |

## 📂 Project Structure

The project currently follows this structure:

text

```text
src/
└── main/
    └── java/
        └── be/
            └── github/
                └── homesecurity/
                    ├── Main.java
                    └── model/
                        ├── Home.java
                        ├── HomeNotifier.java
                        ├── Security.java
                        ├── Pressureplate.java
                        └── Sensor.java
```

## 📚 Class Overview

| Class | Description |
| --- | --- |
| `Main` | Entry point of the application. |
| `Home` | Manages the security systems within a home. |
| `HomeNotifier` | Handles notifications related to events and changes within the home security system. |
| `Security` | Base class for the different security systems. |
| `Pressureplate` | Represents a pressure-based security device. |
| `Sensor` | Represents a sensor-based security device. |

## ⚙️ How It Works

When the application starts, a new home is created. Different security systems are then instantiated and registered with the home.

### Creating security systems

java

```java
Home home = new Home();

Security frontDoor = new Pressureplate("Front door");
Security kitchen = new Pressureplate("Kitchen");
Security stairwell = new Sensor("Stairwell");
Security bedroomDoor = new Sensor("Bedroom door");
```

### Registering security systems

java

```java
home.subscribeSecuritySystem(frontDoor);
home.subscribeSecuritySystem(kitchen);
home.subscribeSecuritySystem(stairwell);
home.subscribeSecuritySystem(bedroomDoor);
```

### Activating all security systems

java

```java
home.activateSecuritySystem();
```

### Deactivating all security systems

java

```java
home.deactivateSecuritySystem();
```

### Activating an individual security system

java

```java
home.activateSecurity(frontDoor);
```

## 🚀 Future Improvements

The project is planned to evolve into a JavaFX desktop application.

Potential improvements include:

- Create a graphical user interface using JavaFX.
- Display an overview of all registered security systems.
- Show the current status of each security system (active/inactive).
- Add new security systems through the graphical interface.
- Activate and deactivate individual security systems.
- Activate and deactivate all security systems simultaneously.
- Integrate `HomeNotifier` notifications into the graphical interface.
- Display real-time notifications when a security system is triggered.
- Create a user-friendly home security dashboard.

## 💻 Installation and Execution

1. Clone the repository:bash
   ```bash
   git clone <repository-url>
   ```
2. Open the project in IntelliJ IDEA or another Java IDE.
3. Make sure you have a compatible JDK installed.
4. Run the `Main` class to start the application.

## 📌 Project Status

**In Development**

The basic functionality for managing and controlling home security systems has been implemented.

The project includes different security devices and a notification component. The next development phase focuses on creating a graphical user interface using JavaFX.

---

**Home Security System** – An expandable home security management system built with Java.