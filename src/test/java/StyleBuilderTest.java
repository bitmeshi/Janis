import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StyleBuilderTest {

    private StyleBuilder style;
    private StyleBuilder styleWithText;

    @BeforeAll
    void setup() {
        style = Janis.style();
        styleWithText = Janis.of("Sample Text");
    }

    @Test
    @DisplayName("Test with null basic color")
    void testNullBasicColor() {
        Exception exception = assertThrows(NullPointerException.class, () -> style.color(null));
        String expectedMessage = "BasicColor cannot be null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test with null basic background color")
    void testNullBgBasicColor() {
        Exception exception = assertThrows(NullPointerException.class, () -> style.bgColor(null));
        String expectedMessage = "Background BasicColor cannot be null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test with null hexadecimal color")
    void testNullHexColor() {
        Exception exception = assertThrows(NullPointerException.class, () -> style.hex(null));
        String expectedMessage = "Hexadecimal string cannot be null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test with null hexadecimal background color")
    void testNullBgHexColor() {
        Exception exception = assertThrows(NullPointerException.class, () -> style.bgHex(null));
        String expectedMessage = "Background hexadecimal string cannot be null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test with of method with null text")
    void testOfMethodWithNullText() {
        Exception exception = assertThrows(NullPointerException.class, () -> Janis.of(null));
        String expectedMessage = "text must not be null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test with of method and render method")
    void testOfMethodAndRender() {
        String text = styleWithText.bold().render();
        assertEquals("\u001B[1mSample Text\u001B[0m", text);
    }

    @Test
    @DisplayName("Test with of method and build method")
    void testOfMethodAndBuild() {
        Exception exception = assertThrows(IllegalStateException.class, () -> styleWithText.build());
        String expectedMessage = "build() cannot be called when of method is used, use render() instead.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test with style method and render method")
    void testStyleMethodAndRender() {
        Exception exception = assertThrows(IllegalStateException.class, () -> style.render());
        String expectedMessage = "render() cannot be called when style method is used, use build() instead.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Test with style method and build method")
    void testStyleMethodAndBuild() {
        Style styleExample = style.bold().build();
        assertNotNull(styleExample);
        assertEquals("\u001B[1mSample Text\u001B[0m", styleExample.apply("Sample Text"));
    }
}