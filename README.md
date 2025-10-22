<div align="center">
  <img width="395.5" height="189" alt="Janis_logo" src="https://github.com/user-attachments/assets/3bf2b60d-aab1-4831-aef0-067c5b5f9f98" />
  <br><br>
</div>

[![Java](https://img.shields.io/badge/Java-21+-orange?style=flat&logo=java)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![JitPack](https://jitpack.io/v/bitmeshi/Janis.svg)](https://jitpack.io/#bitmeshi/Janis)

A lightweight and fluent Java library for styling terminal text with ANSI escape codes. Create beautiful, colorful
console output with an intuitive API.

## Features

✨ **Fluent API** - Chain methods for easy and readable styling  
🎨 **Rich Color Support** - Basic 16 colors and 24-bit RGB/HEX colors  
🎯 **Text Attributes** - Bold, italic, underline, blink, and more  
♻️ **Reusable Styles** - Create styles once, apply to multiple texts  
🚀 **Zero Dependencies** - Pure Java, no external libraries required  
📦 **Lightweight** - Minimal footprint, maximum performance

## Requirements

- Java 21 or higher

## Installation

### Gradle

Add the JitPack repository to your `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

Add the dependency to your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.bitmeshi:Janis:v1.0.0")
}
```

### Maven

Add the JitPack repository to your `pom.xml`:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Add the dependency:

```xml
<dependency>
    <groupId>com.github.bitmeshi</groupId>
    <artifactId>Janis</artifactId>
    <version>v1.0.0</version>
</dependency>
```

### Build from Source

Alternatively, you can clone and build the project locally:

```bash
git clone https://github.com/bitmeshi/Janis.git
cd Janis
./gradlew build
```

Then include the generated JAR in your project's classpath.

## Documentation

📖 **[View Javadoc Documentation](https://jitpack.io/com/github/bitmeshi/Janis/latest/javadoc/)**

Complete API reference with detailed documentation for all classes and methods.

## Quick Start

### Immediate Styling

Style text and render it immediately:

```java
public class Example {
    public static void main(String[] args) {
        // Simple colored text
        System.out.println(Janis.of("Hello, World!").color(BasicColor.RED).render());

        // Bold and colored
        System.out.println(Janis.of("Success!").color(BasicColor.GREEN).bold().render());

        // RGB colors
        System.out.println(Janis.of("Custom color").rgb(255, 100, 50).render());

        // Hex colors
        System.out.println(Janis.of("Hex color").hex("#FF6B35").render());
    }
}
```

### Reusable Styles

Create a style once and apply it to multiple texts:

```java
public class Example {
    public static void main(String[] args) {
        // Create a reusable style
        Style errorStyle = Janis.style()
                .color(BasicColor.BRIGHT_RED)
                .bold()
                .build();

        // Apply to multiple texts
        System.out.println(errorStyle.apply("Error: File not found"));
        System.out.println(errorStyle.apply("Error: Invalid input"));
        System.out.println(errorStyle.apply("Error: Connection failed"));
    }
}
```

## API Documentation

### Colors

#### Basic Colors

16 standard ANSI colors available through the `BasicColor` enum:

```java
// Standard colors
BasicColor.BLACK, BasicColor.RED, BasicColor.GREEN, BasicColor.YELLOW,
BasicColor.BLUE, BasicColor.MAGENTA, BasicColor.CYAN, BasicColor.WHITE

// Bright variants
BasicColor.BRIGHT_BLACK, BasicColor.BRIGHT_RED, BasicColor.BRIGHT_GREEN,
BasicColor.BRIGHT_YELLOW, BasicColor.BRIGHT_BLUE, BasicColor.BRIGHT_MAGENTA,
BasicColor.BRIGHT_CYAN, BasicColor.BRIGHT_WHITE
```

#### RGB Colors

24-bit true color support:

```java
// Using RGB values (0-255)
Janis.of("Text").rgb(255, 128, 0).render();

// Using hexadecimal notation
Janis.of("Text").hex("#CD2C58").render();

// Short form (each digit is repeated twice: #RGB -> #RRGGBB)
Janis.of("Text").hex("#CCC").render();  // Equivalent to #CCCCCC
Janis.of("Text").hex("#F80").render();  // Equivalent to #FF8800
```

#### Background Colors

All color methods have background equivalents:

```java
Janis.of("Text").bgColor(BasicColor.BLUE).render();
Janis.of("Text").bgRgb(50, 100, 150).render();
Janis.of("Text").bgHex("#326496").render();
```

### Text Attributes

```java
// Bold text
Janis.of("Bold").bold().render();

// Dim (faint) text
Janis.of("Dim").dim().render();

// Italic text
Janis.of("Italic").italic().render();

// Underlined text
Janis.of("Underlined").underlined().render();

// Slow blink
Janis.of("Blinking").slowBlink().render();

// Rapid blink
Janis.of("Fast blink").rapidBlink().render();

// Reverse video (swap foreground/background)
Janis.of("Reversed").reverse().render();

// Hidden (concealed) text
Janis.of("Hidden").hide().render();
```

### Combining Styles

Chain multiple style methods together:

```java
Janis.of("Important Warning")
    .color(BasicColor.YELLOW)
    .bgColor(BasicColor.RED)
    .bold()
    .underlined()
    .render();
```

### Factory Methods

#### `Janis.of(String text)`

Creates a `StyleBuilder` for immediate styling. Use `render()` to get the styled text.

```java
String styled = Janis.of("Hello").color(BasicColor.GREEN).render();
```

#### `Janis.style()`

Creates a `StyleBuilder` for reusable styles. Use `build()` to create a `Style` object.

```java
Style successStyle = Janis.style().color(BasicColor.GREEN).bold().build();
String message = successStyle.apply("Operation completed");
```

## Examples

### Logger-style Output

```java
Style info = Janis.style().color(BasicColor.BRIGHT_BLUE).bold().build();
Style warn = Janis.style().color(BasicColor.BRIGHT_YELLOW).bold().build();
Style error = Janis.style().color(BasicColor.BRIGHT_RED).bold().build();
Style success = Janis.style().color(BasicColor.BRIGHT_GREEN).bold().build();

System.out.println(info.apply("[INFO]") + " Application started");
System.out.println(warn.apply("[WARN]") + " Low memory warning");
System.out.println(error.apply("[ERROR]") + " Connection failed");
System.out.println(success.apply("[SUCCESS]") + " Task completed");
```

### Progress Bar

```java
Style progress = Janis.style().bgColor(BasicColor.GREEN).build();
Style remaining = Janis.style().bgColor(BasicColor.BRIGHT_BLACK).build();

int percent = 60;
int filled = percent / 5;
int empty = 20 - filled;

String bar = progress.apply("█".repeat(filled)) + remaining.apply("░".repeat(empty));
System.out.println("Progress: [" + bar + "] " + percent + "%");
```

### Rainbow Text

```java
String[] colors = {"#FF0000", "#FF7F00", "#FFFF00", "#00FF00", "#0000FF", "#4B0082", "#9400D3"};
String text = "Rainbow";

for (int i = 0; i < text.length(); i++) {
    System.out.print(Janis.of(String.valueOf(text.charAt(i))).hex(colors[i]).render());
}
System.out.println();
```

## Terminal Support

ANSI escape codes are supported by most modern terminals:

- ✅ Linux/Unix terminals (bash, zsh, etc.)
- ✅ macOS Terminal and iTerm2
- ✅ Windows Terminal (Windows 10+)
- ✅ Windows PowerShell (Windows 10+)
- ✅ Most IDE terminals (IntelliJ IDEA, VS Code, Eclipse)
- ⚠️ Legacy Windows Command Prompt (limited support)

## Error Handling

Janis validates input and throws specific exceptions to help you catch errors early. Here's what to expect:

### Null Input Validation

The library does not accept `null` values for text or color parameters:

```java
// ❌ This will throw NullPointerException
Janis.of(null).render();

// ✅ Always provide a valid string
Janis.of("").render();  // Empty strings are OK
Janis.of("Valid text").render();
```

**Exception:** `NullPointerException`  
**Message:** "Text cannot be null"

### RGB Color Range Validation

RGB values must be in the range 0-255. Any value outside this range will be rejected:

```java
// ❌ Invalid: values exceed 255
Janis.of("Text").rgb(300, 0, 0).render();  // Red value too high
Janis.of("Text").bgRgb(0, -10, 0).render();  // Green value negative

// ✅ Valid: all values between 0-255
Janis.of("Text").rgb(255, 128, 0).render();
Janis.of("Text").bgRgb(0, 0, 0).render();  // Black is valid
```

**Exception:** `IllegalArgumentException`  
**Message:** "RGB values must be between 0 and 255"

### Hexadecimal Format Validation

Hex color codes must follow specific format rules:

```java
// ❌ Invalid formats
Janis.of("Text").hex("FF0000").render();     // Missing # prefix
Janis.of("Text").hex("#GG0000").render();    // Invalid characters (G)
Janis.of("Text").hex("#12").render();        // Too short
Janis.of("Text").hex("#1234567").render();   // Too long

// ✅ Valid formats
Janis.of("Text").hex("#FF0000").render();    // Full format (6 digits)
Janis.of("Text").hex("#F00").render();       // Short format (3 digits)
Janis.of("Text").hex("#fff").render();       // Lowercase is OK
Janis.of("Text").hex("#ABC").render();       // Mixed case is OK
```

**Exception:** `IllegalArgumentException`  
**Message:** "Invalid hex color format. Use #RGB or #RRGGBB"

### Method Usage Validation

Use the correct terminal method for your styling approach:

```java
// ❌ Wrong: using build() with Janis.of()
StyleBuilder builder = Janis.of("Text").color(BasicColor.RED);
Style style = builder.build();  // throws IllegalStateException

// ✅ Correct: use render() with Janis.of()
String styled = Janis.of("Text").color(BasicColor.RED).render();

// ✅ Correct: use build() with Janis.style()
Style reusableStyle = Janis.style().color(BasicColor.RED).build();
String result = reusableStyle.apply("Text");
```

**Exception:** `IllegalStateException`  
**Message:** "Cannot build a Style from a text-based builder. Use render() instead"

### Best Practices

To avoid runtime errors:

1. **Validate user input** before passing to Janis:
```java
String userInput = getUserInput();
if (userInput != null && !userInput.isEmpty()) {
    System.out.println(Janis.of(userInput).color(BasicColor.GREEN).render());
}
```

2. **Catch exceptions** when working with dynamic values:
```java
try {
    String hexColor = getDynamicColor();  // e.g., from config file
    System.out.println(Janis.of("Text").hex(hexColor).render());
} catch (IllegalArgumentException e) {
    System.err.println("Invalid color format: " + e.getMessage());
    // Fallback to a default color
    System.out.println(Janis.of("Text").color(BasicColor.WHITE).render());
}
```

3. **Validate RGB ranges** from external sources:
```java
int r = getRedValue();
int g = getGreenValue();
int b = getBlueValue();

if (r >= 0 && r <= 255 && g >= 0 && g <= 255 && b >= 0 && b <= 255) {
    System.out.println(Janis.of("Text").rgb(r, g, b).render());
} else {
    System.err.println("RGB values must be between 0 and 255");
}
```
## Building and Testing

### Build the Project

```bash
./gradlew build
```

### Run Tests

```bash
./gradlew test
```

### Generate JAR

```bash
./gradlew jar
```

The JAR file will be generated in `build/libs/`.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

### How to Contribute

1. **Fork the repository** - Click the "Fork" button at the top right of the repository page
2. **Clone your fork** - `git clone https://github.com/your-username/Janis.git`
3. **Create a feature branch** - `git checkout -b feature/amazing-feature`
4. **Make your changes** - Implement your feature or bug fix
5. **Write/update tests** - Ensure your changes are covered by tests
6. **Run tests** - `./gradlew test` to verify everything works
7. **Commit your changes** - `git commit -m 'Add some amazing feature'`
8. **Push to your fork** - `git push origin feature/amazing-feature`
9. **Open a Pull Request** - Go to the original repository and click "New Pull Request"

### Development Guidelines

- Follow existing code style and conventions
- Write clean, maintainable code
- Add tests for new features or bug fixes
- Update documentation when needed
- Ensure all tests pass before submitting PR
- Keep commits focused and write clear commit messages

### Areas for Contribution

- 🐛 Bug fixes and error handling improvements
- ✨ New styling features or color utilities
- 📚 Documentation improvements and examples
- 🧪 Additional test coverage
- 🎨 Color palette utilities
- 🔧 Performance optimizations

## Issues

Found a bug or have a feature request? Please open an issue on GitHub:

- **Bug Reports**: Include details about your environment (OS, terminal, Java version) and steps to reproduce
- **Feature Requests**: Describe the feature and how it would benefit the library
- **Questions**: Feel free to ask questions about usage or implementation

[Open an Issue](https://github.com/bitmeshi/Janis/issues)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Inspired by popular terminal styling libraries from other languages:
    - [chalk](https://github.com/chalk/chalk) (JavaScript/Node.js)
    - [colorama](https://github.com/tartley/colorama) (Python)
    - [colored](https://github.com/dmlc/colored) (Rust)
- Built with modern Java features:
    - **Records** (Java 16+) for immutable data structures
    - **Builder Pattern** for fluent API design
    - **Enums** for type-safe constants
- Implements ANSI escape code standards for terminal text formatting
- Thanks to the open-source community for inspiration and best practices

## Repository

GitHub: [https://github.com/bitmeshi/Janis](https://github.com/bitmeshi/Janis)

---

Made with ❤️ and Java
