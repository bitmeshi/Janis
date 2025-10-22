<img width="395.5" height="189" alt="Janis_logo" src="https://github.com/user-attachments/assets/3bf2b60d-aab1-4831-aef0-067c5b5f9f98" />

[![Java](https://img.shields.io/badge/Java-21+-orange?style=flat&logo=java)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com)

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

> **Note:** This library is not yet published to JitPack or Maven Central. To use it, you need to clone the repository
> and build it locally.

### Build from Source

```bash
git clone https://github.com/bitmeshi/Janis.git
cd Janis
./gradlew build
```

Then include the generated JAR in your project's classpath.

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
BasicColor.BLACK,BasicColor.RED,BasicColor.GREEN,BasicColor.YELLOW,
BasicColor.BLUE,BasicColor.MAGENTA,BasicColor.CYAN,BasicColor.WHITE

// Bright variants
BasicColor.BRIGHT_BLACK,BasicColor.BRIGHT_RED,BasicColor.BRIGHT_GREEN,
BasicColor.BRIGHT_YELLOW,BasicColor.BRIGHT_BLUE,BasicColor.BRIGHT_MAGENTA,
BasicColor.BRIGHT_CYAN,BasicColor.BRIGHT_WHITE
```

#### RGB Colors

24-bit true color support:

```java
// Using RGB values (0-255)
Janis.of("Text").

rgb(255,128,0).

render();

// Using hexadecimal notation
Janis.

of("Text").

hex("#FF8000").

render();
Janis.

of("Text").

hex("#F80").

render();  // Short form
```

#### Background Colors

All color methods have background equivalents:

```java
Janis.of("Text").

bgColor(BasicColor.BLUE).

render();
Janis.

of("Text").

bgRgb(50,100,150).

render();
Janis.

of("Text").

bgHex("#326496").

render();
```

### Text Attributes

```java
// Bold text
Janis.of("Bold").

bold().

render();

// Dim (faint) text
Janis.

of("Dim").

dim().

render();

// Italic text
Janis.

of("Italic").

italic().

render();

// Underlined text
Janis.

of("Underlined").

underlined().

render();

// Slow blink
Janis.

of("Blinking").

slowBlink().

render();

// Rapid blink
Janis.

of("Fast blink").

rapidBlink().

render();

// Reverse video (swap foreground/background)
Janis.

of("Reversed").

reverse().

render();

// Hidden (concealed) text
Janis.

of("Hidden").

hide().

render();
```

### Combining Styles

Chain multiple style methods together:

```java
Janis.of("Important Warning")
    .

color(BasicColor.YELLOW)
    .

bgColor(BasicColor.RED)
    .

bold()
    .

underlined()
    .

render();
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

System.out.

println(info.apply("[INFO]") +" Application started");
        System.out.

println(warn.apply("[WARN]") +" Low memory warning");
        System.out.

println(error.apply("[ERROR]") +" Connection failed");
        System.out.

println(success.apply("[SUCCESS]") +" Task completed");
```

### Progress Bar

```java
Style progress = Janis.style().bgColor(BasicColor.GREEN).build();
Style remaining = Janis.style().bgColor(BasicColor.BRIGHT_BLACK).build();

int percent = 60;
int filled = percent / 5;
int empty = 20 - filled;

String bar = progress.apply("█".repeat(filled)) + remaining.apply("░".repeat(empty));
System.out.

println("Progress: ["+bar +"] "+percent+"%");
```

### Rainbow Text

```java
String[] colors = {"#FF0000", "#FF7F00", "#FFFF00", "#00FF00", "#0000FF", "#4B0082", "#9400D3"};
String text = "Rainbow";

for(
int i = 0; i <text.

length();

i++){
        System.out.

print(Janis.of(String.valueOf(text.charAt(i))).

hex(colors[i]).

render());
        }
        System.out.

println();
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

The library throws appropriate exceptions for invalid input:

```java
// NullPointerException for null values
Janis.of(null);  // throws NullPointerException

// IllegalArgumentException for invalid RGB values
Janis.

of("Text").

rgb(300,0,0);  // throws IllegalArgumentException

// IllegalArgumentException for invalid hex format
Janis.

of("Text").

hex("FF0000");  // throws IllegalArgumentException (missing #)

// IllegalStateException for incorrect method usage
StyleBuilder builder = Janis.of("Text");
builder.

build();  // throws IllegalStateException (should use render())
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
- Keep the API simple and intuitive
- Add tests for new features
- Update documentation (README, Javadocs) when needed
- Ensure all tests pass before submitting PR
- Keep commits atomic and write clear commit messages

### Areas for Contribution

- 🐛 Bug fixes and error handling improvements
- ✨ New text styling features (strikethrough, double underline, etc.)
- 📚 Documentation improvements and examples
- 🧪 Additional test cases
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

- Inspired by popular terminal styling libraries:
    - [chalk](https://github.com/chalk/chalk) (JavaScript/Node.js)
    - [colorama](https://github.com/tartley/colorama) (Python)
    - [colored](https://github.com/dmlc/colored) (Rust)
- Built with modern Java features:
    - **Records** (Java 16+) for immutable data holders (`Rgb`, `StyleConfig`)
    - **Builder Pattern** for fluent and readable API design
    - **Enums** for type-safe color constants
- Based on ANSI/VT100 escape code standards (ECMA-48)
- Thanks to the Java community for continuous improvements to the language

## Repository

GitHub: [https://github.com/bitmeshi/Janis](https://github.com/bitmeshi/Janis)

---

Made with ❤️ and Java
