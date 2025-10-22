import java.util.Objects;

public final class Janis {
    public static StyleBuilder of(String text) {
        Objects.requireNonNull(text, "text must not be null");
        return new StyleBuilder(text);
    }

    public static StyleBuilder style() {
        return new StyleBuilder();
    }
}
