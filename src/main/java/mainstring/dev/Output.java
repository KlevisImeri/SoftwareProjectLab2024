package mainstring.dev;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Provides utilities for colored output to the console. This class supports printing messages in
 * various colors by leveraging ANSI escape codes.
 */
public abstract class Output {

  /**
   * Enum representing console colors, encapsulating the ANSI escape codes for each color.
   */
  public enum Color {
    RESET("\u001B[0m"), BLACK("\u001B[30m"), RED("\u001B[31m"), GREEN("\u001B[32m"), YELLOW(
        "\u001B[33m"), BLUE("\u001B[34m"), MAGENTA("\u001B[35m"), CYAN("\u001B[36m"), WHITE(
            "\u001B[37m"), LIGHT_RED("\u001B[91m"), LIGHT_GREEN("\u001B[92m"), LIGHT_YELLOW(
                "\u001B[93m"), LIGHT_BLUE(
                    "\u001B[94m"), LIGHT_MAGENTA("\u001B[95m"), LIGHT_CYAN("\u001B[96m");

    // ANSI escape code for the color
    private final String code;

    /**
     * Constructs a Color instance with the specified ANSI escape code.
     *
     * @param code The ANSI escape code for the color.
     */
    Color(String code) {
      this.code = code;
    }

    /**
     * Retrieves the ANSI escape code for the color.
     *
     * @return The ANSI escape code as a string.
     */
    public String Code() {
      return code;
    }
  }


  // Return a string containing only the hash codes of the elements in the collection
  public static String toStringID(Collection<? extends Object> elements) {
    return elements.stream().map(Object::hashCode).map(String::valueOf)
        .collect(Collectors.joining(", ", "[", "]"));
  }

  // Return a string containing only the hash codes of the elements in the collection
  public static String toString(Collection<? extends Object> elements) {
    return elements.stream().map(Object::toString).collect(Collectors.joining("\n"));
  }

  /**
   * Prints a line of text to the console in the specified color, then resets the color to default.
   *
   * @param s The object to be printed (its toString method will be called).
   * @param c The color in which to print the text.
   */
  public static void println(Object s, Color c) {
    System.out.print(c.Code());
    System.out.println(s); // Print the string
    System.out.print(Color.RESET.Code()); // Reset color to default
  }
}
