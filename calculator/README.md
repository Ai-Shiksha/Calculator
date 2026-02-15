# Calculator Application

This is a simple modular calculator application built with Java Swing in a Maven project. It supports basic arithmetic operations (addition, subtraction, multiplication, division) and provides a graphical user interface.

## Project Structure

- `Calculator.java`: Core logic for arithmetic operations.
- `CalculatorUI.java`: Swing-based user interface for the calculator.
- `Main.java`: Entry point to launch the application.
- `CalculatorTest.java`: Unit tests for the calculator logic.
- `CalculatorIntegrationTest.java`: Integration test for the UI/controller.

## How to Run

1. Build the project with Maven:
   ```sh
   mvn clean install
   ```
2. Run the application:
   ```sh
   mvn exec:java -Dexec.mainClass="org.example.Main"
   ```

## Example Usage

- Enter numbers and select operations (+, -, *, /) using the UI buttons.
- Press `=` to see the result.
- Press `C` to clear the display.

### Example Calculations
- `2 + 3 =` displays `5.0`
- `10 / 2 =` displays `5.0`
- `7 * 8 =` displays `56.0`
- `9 - 4 =` displays `5.0`

## Testing

- Run all tests with:
  ```sh
  mvn test
  ```

## Notes
- Division by zero will display `Error`.
- The UI is implemented using Java Swing for simplicity and portability.
