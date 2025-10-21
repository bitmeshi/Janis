public final class Style {
    private final String ansiPrefix;

    public Style(String ansiPrefix) {
        this.ansiPrefix = ansiPrefix;
    }

    public String apply(String text) {
        return ansiPrefix + text + "\u001B[0m";
    }
}
