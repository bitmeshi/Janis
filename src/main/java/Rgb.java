/**
 * Represents an RGB color with red, green, and blue components.
 * Each component should be in the range 0-255.
 * Supports parsing from hexadecimal color strings.
 *
 * @param r the red component (0-255)
 * @param g the green component (0-255)
 * @param b the blue component (0-255)
 */
record Rgb(int r, int g, int b) {
    /**
     * Creates an Rgb instance from a hexadecimal color string.
     * Supports both short format (#RGB) and full format (#RRGGBB).
     * In short format, each digit is duplicated (e.g., #F0A becomes #FF00AA).
     *
     * @param hex the hexadecimal color string (must start with # and be either 4 or 7 characters long)
     * @return an Rgb instance representing the color
     * @throws IllegalArgumentException if the hex string format is invalid or contains invalid hex values
     */
    public static Rgb fromHex(String hex) throws IllegalArgumentException {
        if (!hex.startsWith("#") || (hex.length() != 4 && hex.length() != 7)) {
            throw new IllegalArgumentException("Invalid hexadecimal color format, expected #RGB or #RRGGBB. Got: " + hex);
        }

        try {
            if (hex.length() == 4) {
                char red = hex.charAt(1);
                char green = hex.charAt(2);
                char blue = hex.charAt(3);

                int r = Integer.parseInt("" + red + red, 16);
                int g = Integer.parseInt("" + green + green, 16);
                int b = Integer.parseInt("" + blue + blue, 16);

                return new Rgb(r, g, b);
            }

            String red = hex.substring(1, 3);
            String green = hex.substring(3, 5);
            String blue = hex.substring(5, 7);

            int r = Integer.parseInt(red, 16);
            int g = Integer.parseInt(green, 16);
            int b = Integer.parseInt(blue, 16);

            return new Rgb(r, g, b);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid hexadecimal color value: " + hex, e);
        }
    }
}
