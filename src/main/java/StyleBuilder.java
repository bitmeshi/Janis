import java.util.Objects;

/**
 * Builder class for creating styled text or reusable Style objects.
 * Provides a fluent API for configuring text colors (foreground and background),
 * and various text attributes like bold, italic, underline, etc.
 *
 * <p>Two usage patterns are supported:</p>
 * <ul>
 *   <li>Immediate styling: created via {@link Janis#of(String)}, use {@link #render()} to get styled text</li>
 *   <li>Reusable style: created via {@link Janis#style()}, use {@link #build()} to get a Style object</li>
 * </ul>
 */
public final class StyleBuilder {
    private final String text;
    private BasicColor basicColor;
    private Rgb rgbColor;
    private BasicColor bgBasicColor;
    private Rgb bgRgbColor;
    private boolean isBold;
    private boolean isDim;
    private boolean isItalic;
    private boolean isUnderlined;
    private boolean isSlowBlink;
    private boolean isRapidBlink;
    private boolean isReverse;
    private boolean isHide;

    /**
     * Constructs a StyleBuilder with the given text for immediate styling.
     *
     * @param text the text to be styled
     */
    public StyleBuilder(String text) {
        this.text = text;
    }

    /**
     * Constructs a StyleBuilder for creating a reusable Style object.
     */
    public StyleBuilder() {
        this.text = null;
    }

    /**
     * Sets the foreground text color using a basic ANSI color.
     *
     * @param basicColor the basic color to use for text (must not be null)
     * @return this StyleBuilder for method chaining
     * @throws NullPointerException if basicColor is null
     */
    public StyleBuilder color(BasicColor basicColor) {
        Objects.requireNonNull(basicColor, "BasicColor cannot be null");
        this.basicColor = basicColor;
        return this;
    }

    /**
     * Sets the foreground text color using RGB values.
     *
     * @param r the red component (0-255)
     * @param g the green component (0-255)
     * @param b the blue component (0-255)
     * @return this StyleBuilder for method chaining
     * @throws IllegalArgumentException if any RGB value is not in the range 0-255
     */
    public StyleBuilder rgb(int r, int g, int b) {
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
            throw new IllegalArgumentException("RGB values must be in the range 0-255");
        }
        this.rgbColor = new Rgb(r, g, b);
        return this;
    }

    /**
     * Sets the foreground text color using a hexadecimal color string.
     *
     * @param hex the hexadecimal color string (e.g., "#FF0000" or "#F00")
     * @return this StyleBuilder for method chaining
     * @throws IllegalArgumentException if the hex format is invalid
     * @throws NullPointerException     if hex is null
     */
    public StyleBuilder hex(String hex) throws IllegalArgumentException {
        Objects.requireNonNull(hex, "Hexadecimal string cannot be null");
        this.rgbColor = Rgb.fromHex(hex);
        return this;
    }

    /**
     * Sets the background color using a basic ANSI color.
     *
     * @param basicColor the basic color to use for background (must not be null)
     * @return this StyleBuilder for method chaining
     * @throws NullPointerException if basicColor is null
     */
    public StyleBuilder bgColor(BasicColor basicColor) {
        Objects.requireNonNull(basicColor, "Background BasicColor cannot be null");
        this.bgBasicColor = basicColor;
        return this;
    }

    /**
     * Sets the background color using RGB values.
     *
     * @param r the red component (0-255)
     * @param g the green component (0-255)
     * @param b the blue component (0-255)
     * @return this StyleBuilder for method chaining
     * @throws IllegalArgumentException if any RGB value is not in the range 0-255
     */
    public StyleBuilder bgRgb(int r, int g, int b) {
        if (r < 0 || r > 255 || g < 0 || g > 255 || b < 0 || b > 255) {
            throw new IllegalArgumentException("RGB values must be in the range 0-255");
        }
        this.bgRgbColor = new Rgb(r, g, b);
        return this;
    }

    /**
     * Sets the background color using a hexadecimal color string.
     *
     * @param hex the hexadecimal color string (e.g., "#FF0000" or "#F00")
     * @return this StyleBuilder for method chaining
     * @throws IllegalArgumentException if the hex format is invalid
     * @throws NullPointerException if hex is null
     */
    public StyleBuilder bgHex(String hex) throws IllegalArgumentException {
        Objects.requireNonNull(hex, "Background hexadecimal string cannot be null");
        this.bgRgbColor = Rgb.fromHex(hex);
        return this;
    }

    /**
     * Enables bold text attribute.
     *
     * @return this StyleBuilder for method chaining
     */
    public StyleBuilder bold() {
        this.isBold = true;
        return this;
    }

    /**
     * Enables dim (faint) text attribute.
     *
     * @return this StyleBuilder for method chaining
     */
    public StyleBuilder dim() {
        this.isDim = true;
        return this;
    }

    /**
     * Enables italic text attribute.
     *
     * @return this StyleBuilder for method chaining
     */
    public StyleBuilder italic() {
        this.isItalic = true;
        return this;
    }

    /**
     * Enables underlined text attribute.
     *
     * @return this StyleBuilder for method chaining
     */
    public StyleBuilder underlined() {
        this.isUnderlined = true;
        return this;
    }

    /**
     * Enables slow blink text attribute.
     *
     * @return this StyleBuilder for method chaining
     */
    public StyleBuilder slowBlink() {
        this.isSlowBlink = true;
        return this;
    }

    /**
     * Enables rapid blink text attribute.
     *
     * @return this StyleBuilder for method chaining
     */
    public StyleBuilder rapidBlink() {
        this.isRapidBlink = true;
        return this;
    }

    /**
     * Enables reverse video (swaps foreground and background colors).
     *
     * @return this StyleBuilder for method chaining
     */
    public StyleBuilder reverse() {
        this.isReverse = true;
        return this;
    }

    /**
     * Enables hidden (concealed) text attribute.
     *
     * @return this StyleBuilder for method chaining
     */
    public StyleBuilder hide() {
        this.isHide = true;
        return this;
    }

    /**
     * Renders the styled text immediately.
     * This method can only be called when the StyleBuilder was created with {@link Janis#of(String)}.
     *
     * @return the text with applied ANSI styling
     * @throws IllegalStateException if called on a StyleBuilder created with {@link Janis#style()}
     */
    public String render() throws IllegalStateException {
        if (text == null) {
            throw new IllegalStateException("render() cannot be called when style method is used, use build() instead.");
        }

        StyleConfig config = new StyleConfig(
                this.basicColor,
                this.rgbColor,
                this.bgBasicColor,
                this.bgRgbColor,
                this.isBold,
                this.isDim,
                this.isItalic,
                this.isUnderlined,
                this.isSlowBlink,
                this.isRapidBlink,
                this.isReverse,
                this.isHide
        );
        String ansiPrefix = AnsiCodeGenerator.getAnsiPrefix(config);

        return ansiPrefix + text + "\u001B[0m";
    }

    /**
     * Builds a reusable Style object.
     * This method can only be called when the StyleBuilder was created with {@link Janis#style()}.
     *
     * @return a Style object that can be applied to multiple texts
     * @throws IllegalStateException if called on a StyleBuilder created with {@link Janis#of(String)}
     */
    public Style build() throws IllegalStateException {
        if (this.text != null) {
            throw new IllegalStateException("build() cannot be called when of method is used, use render() instead.");
        }

        StyleConfig config = new StyleConfig(
                this.basicColor,
                this.rgbColor,
                this.bgBasicColor,
                this.bgRgbColor,
                this.isBold,
                this.isDim,
                this.isItalic,
                this.isUnderlined,
                this.isSlowBlink,
                this.isRapidBlink,
                this.isReverse,
                this.isHide
        );
        String ansiPrefix = AnsiCodeGenerator.getAnsiPrefix(config);

        return new Style(ansiPrefix);
    }
}
