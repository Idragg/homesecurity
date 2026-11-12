# AGENTS.md

## 1\. Project Overview

This project is a **Home Security System** developed in Java.

The application manages different security systems within a home. Supported security devices include pressure plates and sensors.

The project also contains a `HomeNotifier` component for handling notifications related to security events.

The long-term goal is to expand the application into a desktop application using **JavaFX**.

AI agents working on this project should preserve the existing functionality while keeping the code clean, maintainable and extensible.

## 2\. Technologies

- **Java** – Main programming language.
- **JavaFX** – Planned graphical user interface.
- **Object-Oriented Programming (OOP)** – Application architecture.
- **MVC Architecture** – Preferred architecture for the JavaFX application.

Do not introduce additional frameworks or dependencies without a clear reason.

## 3\. Project Structure

The current project structure is expected to follow this layout:

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

For the future JavaFX implementation, use the following structure as a guideline:

text

```text
be/github/homesecurity/
├── Main.java
├── model/
│   ├── Home.java
│   ├── HomeNotifier.java
│   ├── Security.java
│   ├── Pressureplate.java
│   └── Sensor.java
├── controller/
│   └── HomeController.java
└── view/
    └── HomeView.java
```

Keep the existing model classes separate from the user interface.

## 4\. Architecture and Responsibilities

### Main

- Acts as the application entry point.
- Initializes the application.
- Should not contain business logic.
- When JavaFX is introduced, it should launch the JavaFX application.

### Home

- Represents a home.
- Manages registered security systems.
- Provides methods to activate and deactivate security systems.
- Supports individual and global security system operations.

### HomeNotifier

- Handles notifications related to the home security system.
- Keeps notification responsibilities separate from the security device implementations.
- Should be reusable by the JavaFX interface in the future.

### Security

- Represents the common abstraction for security systems.
- Defines shared behaviour for different security device types.
- Should be extended by concrete security implementations.

### Pressureplate

- Represents a pressure-based security device.
- Should inherit the common behaviour defined by `Security`.

### Sensor

- Represents a sensor-based security device.
- Should inherit the common behaviour defined by `Security`.

## 5\. Coding Guidelines

Follow these coding standards when creating or modifying code:

- Use meaningful and descriptive class, method and variable names.
- Follow Java naming conventions:
    - Classes: `PascalCase`
    - Methods: `camelCase`
    - Variables: `camelCase`
    - Constants: `UPPER_SNAKE_CASE`
- Keep methods focused on a single responsibility.
- Avoid unnecessary code duplication.
- Use appropriate access modifiers (`private`, `protected`, `public`).
- Prefer encapsulation over exposing internal fields.
- Use interfaces and inheritance where they improve the design.
- Add comments only when they clarify non-obvious behaviour.
- Keep the code readable and easy to maintain.

## 6\. JavaFX Guidelines

When implementing the graphical interface:

- Use JavaFX for all graphical components.
- Follow the MVC architecture.
- Keep business logic inside the model layer.
- Keep UI interaction logic inside controllers.
- Keep the view responsible for presentation.
- Do not place business logic directly inside JavaFX event handlers.
- Ensure that the interface reflects the actual state of the security systems.
- Use clear visual indicators for active and inactive security systems.
- Display notifications when relevant security events occur.

The JavaFX interface should eventually support:

- Viewing all registered security systems.
- Adding new security systems.
- Activating and deactivating individual systems.
- Activating and deactivating all systems.
- Viewing the current status of each system.
- Receiving notifications from `HomeNotifier`.

## 7\. Development Rules

When modifying the project, AI agents must:

1. Inspect the existing code before making changes.
2. Understand the current implementation before introducing new functionality.
3. Preserve existing functionality unless explicitly asked to change it.
4. Avoid unnecessary architectural changes.
5. Reuse existing classes and methods whenever possible.
6. Avoid introducing dependencies without justification.
7. Ensure that new code follows the existing project conventions.
8. Check that packages and imports are correct.
9. Avoid implementing functionality that already exists.
10. Explain significant architectural decisions.

## 8\. Testing and Validation

After implementing changes:

- Verify that the project compiles.
- Check for broken imports and package declarations.
- Test new functionality where possible.
- Ensure existing security system functionality still works.
- Verify that activation and deactivation behave correctly.
- Check that notifications are handled correctly.

Do not claim that tests have passed unless they have actually been executed.

## 9\. Important Constraints

- Do not remove existing security system implementations without permission.
- Do not bypass the `Home` class to manage registered security systems directly.
- Do not mix business logic with JavaFX presentation logic.
- Do not add unnecessary complexity.
- Do not assume functionality that has not been implemented.
- Ask for clarification when an important design decision is ambiguous.

## 10\. Main Development Goal

The main objective is to transform the existing console-based Home Security System into a maintainable JavaFX desktop application.

Prioritize:

1. Maintaining a clean object-oriented design.
2. Keeping the model independent of JavaFX.
3. Implementing a clear MVC structure.
4. Providing an intuitive user interface.
5. Maintaining reliable security system management and notifications.

All new implementations should support these goals.