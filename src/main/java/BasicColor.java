/**
 * Enumeration of basic ANSI terminal colors.
 * Includes standard 8 colors and their bright variants (16 colors total).
 * Each color has an associated ANSI code offset used to generate the proper escape sequence.
 */
public enum BasicColor {
    /**
     * Standard black color
     */
    BLACK(0),
    /** Standard red color */
    RED(1),
    /** Standard green color */
    GREEN(2),
    /** Standard yellow color */
    YELLOW(3),
    /** Standard blue color */
    BLUE(4),
    /** Standard magenta color */
    MAGENTA(5),
    /** Standard cyan color */
    CYAN(6),
    /** Standard white color */
    WHITE(7),

    /** Bright variant of black (gray) */
    BRIGHT_BLACK(60),
    /** Bright variant of red */
    BRIGHT_RED(61),
    /** Bright variant of green */
    BRIGHT_GREEN(62),
    /** Bright variant of yellow */
    BRIGHT_YELLOW(63),
    /** Bright variant of blue */
    BRIGHT_BLUE(64),
    /** Bright variant of magenta */
    BRIGHT_MAGENTA(65),
    /** Bright variant of cyan */
    BRIGHT_CYAN(66),
    /** Bright variant of white */
    BRIGHT_WHITE(67);

    private final int ansiCodeOffset;

    /**
     * Constructs a BasicColor with the specified ANSI code offset.
     *
     * @param ansiCodeOffset the offset value added to the base ANSI code
     */
    BasicColor(int ansiCodeOffset) {
        this.ansiCodeOffset = ansiCodeOffset;
    }

    /**
     * Generates the ANSI escape code for this color.
     *
     * @param isBackground true if this color should be applied as background, false for foreground
     * @return the complete ANSI escape sequence for this color
     */
    public String getAnsiCode(boolean isBackground) {
        int baseCode = isBackground ? 40 : 30;
        return String.format("\u001b[%dm", baseCode + this.ansiCodeOffset);
    }
}
