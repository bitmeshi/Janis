final class AnsiCodeGenerator {
    public static String getAnsiPrefix(StyleConfig config) {
        return getColorTextPrefix(config) + getColorBackgroundPrefix(config) + getAttributePrefix(config);
    }

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
