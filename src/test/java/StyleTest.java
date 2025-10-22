import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StyleTest {

    @Test
    @DisplayName("Test apply method")
    void testApply() {
        Style style = Janis.style().color(BasicColor.BRIGHT_CYAN).bold().build();
        String result = style.apply("Hello, World!");
        assertEquals("\u001B[96m\u001B[1mHello, World!\u001B[0m", result);
    }
}