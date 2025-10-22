import java.util.Objects;

/**
 * Main entry point for the Janis styling library.
 * Provides factory methods for creating styled text with ANSI escape codes.
 * This class offers two approaches: immediate text styling with {@code of()} or
 * reusable style creation with {@code style()}.
 */
public final class Janis {
    /**
     * Private constructor to prevent instantiation.
     * This is a utility class that should only be accessed through its static methods.
     */
    private Janis() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Creates a StyleBuilder initialized with the given text for immediate styling.
     * Use this method when you want to style a specific text and render it immediately.
     *
     * @param text the text to be styled (must not be null)
     * @return a StyleBuilder instance that can be configured and rendered
     * @throws NullPointerException if text is null
     */
    public static StyleBuilder of(String text) {
        Objects.requireNonNull(text, "text must not be null");
        return new StyleBuilder(text);
    }

    /**
     * Creates a StyleBuilder for creating a reusable Style object.
     * Use this method when you want to create a style that can be applied to multiple texts.
     *
     * @return a StyleBuilder instance that can be configured and built into a Style
     */
    public static StyleBuilder style() {
        return new StyleBuilder();
    }
}
