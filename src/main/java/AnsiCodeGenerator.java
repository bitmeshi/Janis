/**
 * Utility class for generating ANSI escape codes based on style configurations.
 * This class handles the conversion of style settings into proper ANSI sequences
 * for terminal text formatting.
 */
final class AnsiCodeGenerator {
    /**
     * Generates the complete ANSI prefix string for the given style configuration.
     * Combines text color, background color, and text attributes into a single ANSI sequence.
     *
     * @param config the style configuration containing color and attribute settings
     * @return the complete ANSI escape sequence prefix
     */
    public static String getAnsiPrefix(StyleConfig config) {
        return getColorTextPrefix(config) + getColorBackgroundPrefix(config) + getAttributePrefix(config);
    }

    /**
     * Generates the ANSI code for text foreground color.
     * Supports both RGB colors (24-bit true color) and basic 8/16 colors.
     * RGB colors take precedence over basic colors if both are set.
     *
     * @param config the style configuration
     * @return the ANSI escape sequence for foreground color, or empty string if no color is set
     */
    private static String getColorTextPrefix(StyleConfig config) {
        if (config.rgbColor() != null && config.basicColor() == null) {
            Rgb rgb = config.rgbColor();
            return String.format("\u001b[38;2;%d;%d;%dm", rgb.r(), rgb.g(), rgb.b());
        }

        if (config.basicColor() != null) {
            return config.basicColor().getAnsiCode(false);
        }

        return "";
    }

    /**
     * Generates the ANSI code for background color.
     * Supports both RGB colors (24-bit true color) and basic 8/16 colors.
     * RGB colors take precedence over basic colors if both are set.
     *
     * @param config the style configuration
     * @return the ANSI escape sequence for background color, or empty string if no color is set
     */
    private static String getColorBackgroundPrefix(StyleConfig config) {
        if (config.bgRgbColor() != null && config.bgBasicColor() == null) {
            Rgb rgb = config.bgRgbColor();
            return String.format("\u001b[48;2;%d;%d;%dm", rgb.r(), rgb.g(), rgb.b());
        }

        if (config.bgBasicColor() != null) {
            return config.bgBasicColor().getAnsiCode(true);
        }

        return "";
    }

    /**
     * Generates ANSI codes for text attributes such as bold, italic, underline, etc.
     * Multiple attributes can be combined in a single string.
     *
     * @param config the style configuration containing attribute flags
     * @return the combined ANSI escape sequences for all enabled attributes
     */
    private static String getAttributePrefix(StyleConfig config) {
        StringBuilder prefix = new StringBuilder();

        if (config.isBold()) {
            prefix.append("\u001b[1m");
        }

        if (config.isDim()) {
            prefix.append("\u001b[2m");
        }

        if (config.isItalic()) {
            prefix.append("\u001b[3m");
        }

        if (config.isUnderlined()) {
            prefix.append("\u001b[4m");
        }

        if (config.isSlowBlink()) {
            prefix.append("\u001b[5m");
        }

        if (config.isRapidBlink()) {
            prefix.append("\u001b[6m");
        }

        if (config.isReverse()) {
            prefix.append("\u001b[7m");
        }

        if (config.isHide()) {
            prefix.append("\u001b[8m");
        }

        return prefix.toString();
    }
}
