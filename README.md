The calculator module is designed using RESTful API architecture and supports various output types (Web, mobile web). The module carries out financial planning through microservices. Each microservice is responsible for a specific type of scheduling (e.g. interest scheduling, loan payment scheduling, foreign exchange exchanged).

# abc_web_testing Project with Java 17

This project is a test automation framework using **Gauge**, **Maven**, and **Java 17**. Gauge provides a simple and readable way to write test cases in plain English, and Maven is used as the build tool.

## Prerequisites

Before setting up the project, ensure the following tools are installed:

1. **Java 17**
   - Verify installation: `min. Java17`
   - Download: [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://jdk.java.net/)

2. **Maven**
   - Verify installation: `mvn -version`
   - Download: [Maven Official Website](https://maven.apache.org/download.cgi)

3. **Gauge**
   - Install Gauge CLI: 
     ```bash
     brew install gauge  # For macOS
     choco install gauge # For Windows
     sudo apt install gauge # For Linux
     ```
   - Verify installation: `gauge -v`
   - Install Gauge Java plugin:
     ```bash
     gauge install java
     ```

4. **IDE (Optional)**
   - Use an IDE like IntelliJ IDEA or Eclipse for easier development.

---

## Project Setup

1. **Clone the Repository**
   ```bash
   git clone <[repository-url](https://github.com/KadircanBoztepe/abc_web_testing_kadircan)>

---

## Dowload Dependencies

1. ** To download Maven dependencies in the project directory:
 mvn clean install

---

## Running Tests

1. ** To run tests with the Gauge CLI:
gauge run specs

or to run via Maven:

mvn testing

---

## Open Project

1. **Go to the project directory with the “Open Project” or “Import Project” option and select the pom.xml file.
To refresh Maven dependencies, Reload from the Maven panel in the IDE.

---

## Troubleshooting

1. **Gauge Commands Not Found Ensure Gauge is installed and added to your PATH environment variable.
2. **Driver Issues Ensure browser drivers (e.g., ChromeDriver, GeckoDriver) are compatible with the browser version.
3. **When you want to run the automation in Safari, make sure you log in to the Safari app and give permission for the automation.
4. **Maven Build Issues Run mvn dependency:tree to debug dependency conflicts.

---

## Integrations

1. **Browser Drivers Use WebDriverManager to handle browser driver dependencies automatically:
  <dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.5.0</version>
</dependency>

2. **Logging Use Log4j or SLF4J for logging:
   <dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>2.0.7</version>
</dependency>
