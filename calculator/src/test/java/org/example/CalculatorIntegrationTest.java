package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
import java.awt.*;

class CalculatorIntegrationTest {
    @Test
    void testCalculatorUIAddition() {
        CalculatorUI ui = new CalculatorUI();
        JTextField display = (JTextField) TestUtils.getChildNamed(ui, "display");
        assertNotNull(display);
        // Simulate button presses: 2 + 3 =
        TestUtils.pressButton(ui, "2");
        TestUtils.pressButton(ui, "+");
        TestUtils.pressButton(ui, "3");
        TestUtils.pressButton(ui, "=");
        assertEquals("5.0", display.getText());
    }
}

// Utility class for simulating UI actions
class TestUtils {
    static Component getChildNamed(Container parent, String name) {
        for (Component c : parent.getComponents()) {
            if (name.equals(c.getName())) return c;
            if (c instanceof Container) {
                Component child = getChildNamed((Container) c, name);
                if (child != null) return child;
            }
        }
        return null;
    }
    static void pressButton(Container parent, String text) {
        for (Component c : parent.getComponents()) {
            if (c instanceof JButton && ((JButton) c).getText().equals(text)) {
                ((JButton) c).doClick();
                return;
            }
            if (c instanceof Container) pressButton((Container) c, text);
        }
    }
}
