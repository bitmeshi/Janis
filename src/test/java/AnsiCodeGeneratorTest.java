import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnsiCodeGeneratorTest {

    @Test
    @DisplayName("Test with all style configurations empty")
    void emptyStyleConfig() {
        StyleConfig config = new StyleConfig(
                null, null,
                null, null,
                false, false,
                false, false,
                false, false,
                false, false
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("", ansiCode);
    }

    @Test
    @DisplayName("Test with only red text color")
    void redTextColor() {
        StyleConfig config = new StyleConfig(
                BasicColor.RED, null,
                null, null,
                false, false,
                false, false,
                false, false,
                false, false
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("\u001b[31m", ansiCode);
    }

    @Test
    @DisplayName("Test with green background color")
    void greenBackgroundColor() {
        StyleConfig config = new StyleConfig(
                null, null,
                BasicColor.GREEN, null,
                false, false,
                false, false,
                false, false,
                false, false
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("\u001b[42m", ansiCode);
    }

    @Test
    @DisplayName("Test with RGB text color and bold attribute")
    void textColorRgb() {
        StyleConfig config = new StyleConfig(
                null, new Rgb(255, 100, 50),
                null, null,
                false, false,
                false, false,
                false, false,
                false, false
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("\u001b[38;2;255;100;50m", ansiCode);
    }

    @Test
    @DisplayName("Test with RGB background color")
    void backgroundColorRgb() {
        StyleConfig config = new StyleConfig(
                null, null,
                null, new Rgb(0, 150, 200),
                false, false,
                false, false,
                false, false,
                false, false
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("\u001b[48;2;0;150;200m", ansiCode);
    }

    @Test
    @DisplayName("Test with basic text color and RGB text color (basic takes precedence)")
    void textColorBasicAndRgb() {
        StyleConfig config = new StyleConfig(
                BasicColor.BLUE, new Rgb(0, 0, 255),
                null, null,
                false, false,
                false, false,
                false, false,
                false, false
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("\u001b[34m", ansiCode);
    }

    @Test
    @DisplayName("Test with basic background color and RGB background color (basic takes precedence)")
    void backgroundColorBasicAndRgb() {
        StyleConfig config = new StyleConfig(
                null, null,
                BasicColor.YELLOW, new Rgb(255, 255, 0),
                false, false,
                false, false,
                false, false,
                false, false
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("\u001b[43m", ansiCode);
    }

    @Test
    @DisplayName("Test with bold")
    void boldAttribute() {
        StyleConfig config = new StyleConfig(
                null, null,
                null, null,
                true, false,
                false, false,
                false, false,
                false, false
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("\u001b[1m", ansiCode);
    }

    @Test
    @DisplayName("Test with dim")
    void dimAttribute() {
        StyleConfig config = new StyleConfig(
                null, null,
                null, null,
                false, true,
                false, false,
                false, false,
                false, false
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("\u001b[2m", ansiCode);
    }

    @Test
    @DisplayName("Test with italic")
    void italicAttribute() {
        StyleConfig config = new StyleConfig(
                null, null,
                null, null,
                false, false,
                true, false,
                false, false,
                false, false
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("\u001b[3m", ansiCode);
    }

    @Test
    @DisplayName("Test with underline")
    void underlineAttribute() {
        StyleConfig config = new StyleConfig(
                null, null,
                null, null,
                false, false,
                false, true,
                false, false,
                false, false
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("\u001b[4m", ansiCode);
    }

    @Test
    @DisplayName("Test with slow blink")
    void slowBlinkAttribute() {
        StyleConfig config = new StyleConfig(
                null, null,
                null, null,
                false, false,
                false, false,
                true, false,
                false, false
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("\u001b[5m", ansiCode);
    }

    @Test
    @DisplayName("Test with rapid blink")
    void rapidBlinkAttribute() {
        StyleConfig config = new StyleConfig(
                null, null,
                null, null,
                false, false,
                false, false,
                false, true,
                false, false
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("\u001b[6m", ansiCode);
    }

    @Test
    @DisplayName("Test with reverse")
    void reverseAttribute() {
        StyleConfig config = new StyleConfig(
                null, null,
                null, null,
                false, false,
                false, false,
                false, false,
                true, false
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("\u001b[7m", ansiCode);
    }

    @Test
    @DisplayName("Test with hide")
    void hideAttribute() {
        StyleConfig config = new StyleConfig(
                null, null,
                null, null,
                false, false,
                false, false,
                false, false,
                false, true
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("\u001b[8m", ansiCode);
    }

    @Test
    @DisplayName("Test with multiple attributes")
    void multipleAttributes() {
        StyleConfig config = new StyleConfig(
                BasicColor.CYAN, null,
                null, new Rgb(0, 150, 200),
                true, false,
                true, false,
                false, false,
                true, false
        );
        String ansiCode = AnsiCodeGenerator.getAnsiPrefix(config);
        assertEquals("\u001b[36m\u001b[48;2;0;150;200m\u001b[1m\u001b[3m\u001b[7m", ansiCode);
    }
}