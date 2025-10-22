/**
 * Represents a reusable text style with ANSI escape codes.
 * A Style instance can be applied to multiple text strings, applying the same
 * formatting (colors, attributes) to each.
 */
public final class Style {
    private final String ansiPrefix;

    /**
     * Constructs a Style with the specified ANSI prefix.
     *
     * @param ansiPrefix the ANSI escape sequence prefix containing style codes
     */
    public Style(String ansiPrefix) {
        this.ansiPrefix = ansiPrefix;
    }

    /**
     * Applies this style to the given text.
     * Wraps the text with the ANSI escape codes for this style and resets formatting at the end.
     *
     * @param text the text to style
     * @return the styled text with ANSI escape codes
     */
    public String apply(String text) {
        return ansiPrefix + text + "\u001B[0m";
    }
}
