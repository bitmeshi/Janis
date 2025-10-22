import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RgbTest {

    @Test
    @DisplayName("Test with long hexadecimal string")
    void fromHexLong() {
        Rgb color = Rgb.fromHex("#1A2B3C");
        assertEquals(26, color.r());
        assertEquals(43, color.g());
        assertEquals(60, color.b());
    }

    @Test
    @DisplayName("Test with short hexadecimal string with 0")
    void fromHexShortWithZero() {
        Rgb color = Rgb.fromHex("#0F3");
        assertEquals(0, color.r());
        assertEquals(255, color.g());
        assertEquals(51, color.b());
    }

    @Test
    @DisplayName("Test with shor hexadecimal string")
    void fromHexShort() {
        Rgb color = Rgb.fromHex("#ABC");
        assertEquals(170, color.r());
        assertEquals(187, color.g());
        assertEquals(204, color.b());
    }

    @Test
    @DisplayName("Test with invalid hexadecimal length")
    void fromHexInvalidLength() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Rgb.fromHex("#12345"));
        String expectedMessage = "Invalid hexadecimal color format, expected #RGB or #RRGGBB. Got: #12345";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test with invalid hexadecimal without #")
    void fromHexInvalidNoHash() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Rgb.fromHex("123456"));
        String expectedMessage = "Invalid hexadecimal color format, expected #RGB or #RRGGBB. Got: 123456";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test with invalid hexadecimal characters")
    void fromHexInvalidCharacters() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Rgb.fromHex("#GGHHII"));
        String expectedMessage = "Invalid hexadecimal color value: #GGHHII";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}