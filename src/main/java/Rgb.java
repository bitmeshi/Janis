record Rgb(int r, int g, int b) {
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
