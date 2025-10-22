/**
 * Configuration record that holds all style settings for text formatting.
 * Encapsulates foreground and background colors (both basic and RGB),
 * as well as various text attributes.
 *
 * @param basicColor   the basic foreground color, or null if not set
 * @param rgbColor     the RGB foreground color, or null if not set
 * @param bgBasicColor the basic background color, or null if not set
 * @param bgRgbColor   the RGB background color, or null if not set
 * @param isBold       whether bold attribute is enabled
 * @param isDim        whether dim (faint) attribute is enabled
 * @param isItalic     whether italic attribute is enabled
 * @param isUnderlined whether underline attribute is enabled
 * @param isSlowBlink  whether slow blink attribute is enabled
 * @param isRapidBlink whether rapid blink attribute is enabled
 * @param isReverse    whether reverse video attribute is enabled
 * @param isHide       whether hidden (concealed) attribute is enabled
 */
record StyleConfig(
        BasicColor basicColor,
        Rgb rgbColor,
        BasicColor bgBasicColor,
        Rgb bgRgbColor,
        boolean isBold,
        boolean isDim,
        boolean isItalic,
        boolean isUnderlined,
        boolean isSlowBlink,
        boolean isRapidBlink,
        boolean isReverse,
        boolean isHide) {
}
