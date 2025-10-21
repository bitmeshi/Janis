public enum BasicColor {
    BLACK(0),
    RED(1),
    GREEN(2),
    YELLOW(3),
    BLUE(4),
    MAGENTA(5),
    CYAN(6),
    WHITE(7),

    BRIGHT_BLACK(60),
    BRIGHT_RED(61),
    BRIGHT_GREEN(62),
    BRIGHT_YELLOW(63),
    BRIGHT_BLUE(64),
    BRIGHT_MAGENTA(65),
    BRIGHT_CYAN(66),
    BRIGHT_WHITE(67);

    private final int ansiCodeOffset;

    BasicColor(int ansiCodeOffset) {
        this.ansiCodeOffset = ansiCodeOffset;
    }

    public String getAnsiCode(boolean isBackground) {
        int baseCode = isBackground ? 40 : 30;
        return String.format("\u001b[%dm", baseCode + this.ansiCodeOffset);
    }
}
