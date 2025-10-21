public final class Janis {
    public static StyleBuilder of(String text) {
        return new StyleBuilder(text);
    }

    public static StyleBuilder style() {
        return new StyleBuilder();
    }
}
