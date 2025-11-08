# Astrotalk App Automation Framework

This repository contains a **robust Appium automation framework** built in **Java** for testing the **Astrotalk mobile application**.  
The framework is designed to be scalable, maintainable, and efficient, following best practices in mobile test automation.

---

## Features

- Mobile automation using **Appium** (supports Android/iOS)  
- Developed in **Java**  
- **TestNG** for test management and reporting  
- **Page Object Model (POM)** design pattern for clean and reusable code  
- **Maven** for dependency management and build automation  
- Comprehensive test scripts covering core functionalities of the Asttak app  
- Easy integration with **CI/CD pipelines**

---

## Folder Structure

```text
Appium-Frame-Work/
├── src/
│   ├── main/java/      # Core framework classes
│   └── test/java/      # Test scripts
├── resources/          # Test data, config files
├── pom.xml             # Maven project file
└── README.md



Getting Started
1. Clone the repository
git clone https://github.com/GaneshTimande/Appium-Frame-Work.git

2. Install dependencies
mvn clean install

3. Run tests
mvn test

Notes

Ensure Appium server is running before executing tests.

Update device capabilities in the configuration files for your target devices.

Test reports will be generated automatically after execution.

Keep your project modular by adding new tests in src/test/java and reusable code in src/main/java.
