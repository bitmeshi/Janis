import java.util.Objects;

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

    public StyleBuilder(String text) {
        this.text = text;
    }

    public StyleBuilder() {
        this.text = null;
    }

    public StyleBuilder color(BasicColor basicColor) {
        Objects.requireNonNull(basicColor, "BasicColor cannot be null");
        this.basicColor = basicColor;
        return this;
    }

    public StyleBuilder rgb(int r, int g, int b) {
        this.rgbColor = new Rgb(r, g, b);
        return this;
    }

    public StyleBuilder hex(String hex) throws IllegalArgumentException {
        Objects.requireNonNull(hex, "Hexadecimal string cannot be null");
        this.rgbColor = Rgb.fromHex(hex);
        return this;
    }

    public StyleBuilder bgColor(BasicColor basicColor) {
        Objects.requireNonNull(basicColor, "Background BasicColor cannot be null");
        this.bgBasicColor = basicColor;
        return this;
    }

    public StyleBuilder bgRgb(int r, int g, int b) {
        this.bgRgbColor = new Rgb(r, g, b);
        return this;
    }

    public StyleBuilder bgHex(String hex) throws IllegalArgumentException {
        Objects.requireNonNull(hex, "Background hexadecimal string cannot be null");
        this.bgRgbColor = Rgb.fromHex(hex);
        return this;
    }

    public StyleBuilder bold() {
        this.isBold = true;
        return this;
    }

    public StyleBuilder dim() {
        this.isDim = true;
        return this;
    }

    public StyleBuilder italic() {
        this.isItalic = true;
        return this;
    }

    public StyleBuilder underlined() {
        this.isUnderlined = true;
        return this;
    }

    public StyleBuilder slowBlink() {
        this.isSlowBlink = true;
        return this;
    }

    public StyleBuilder rapidBlink() {
        this.isRapidBlink = true;
        return this;
    }

    public StyleBuilder reverse() {
        this.isReverse = true;
        return this;
    }

    public StyleBuilder hide() {
        this.isHide = true;
        return this;
    }

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
