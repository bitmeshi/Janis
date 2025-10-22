import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicColorTest {

    @Test
    @DisplayName("Test basic text color")
    void testBasicColor() {
        String red = BasicColor.RED.getAnsiCode(false);
        assertEquals("\u001b[31m", red);
    }

    @Test
    @DisplayName("Test basic background color")
    void testBasicBackgroundColor() {
        String blueBg = BasicColor.BLUE.getAnsiCode(true);
        assertEquals("\u001b[44m", blueBg);
    }

    @Test
    @DisplayName("Test bright text color")
    void testBrightColor() {
        String brightGreen = BasicColor.BRIGHT_GREEN.getAnsiCode(false);
        assertEquals("\u001b[92m", brightGreen);
    }

    @Test
    @DisplayName("Test bright background color")
    void testBrightBackgroundColor() {
        String brightMagentaBg = BasicColor.BRIGHT_MAGENTA.getAnsiCode(true);
        assertEquals("\u001b[105m", brightMagentaBg);
    }
}