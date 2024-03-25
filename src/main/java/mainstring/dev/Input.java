package mainstring.dev;

import java.util.*;
import mainstring.dev.Output.Color;

/**
 * Provides utility methods for handling user input in a flexible way, allowing for both real-time
 * and simulated inputs. This class is designed to support testing scenarios by simulating inputs or
 * using real-time inputs from the console.
 */
public abstract class Input {

  // List to hold simulated inputs
  private static List<String> in = new ArrayList<>();

  // Scanner object for reading input
  public static Scanner scanner;

  /**
   * Simulates user input by adding a string to the list of inputs.
   *
   * @param input The simulated input string to be added.
   */
  public static void in(String input) {
    in.add(input); // Append input to simulate user entry
  }

  /**
   * Sets up the scanner for reading inputs. If there are simulated inputs available, it uses those;
   * otherwise, it reads from the standard input stream (System.in).
   */
  public static void setUpScanner() {
    if (!in.isEmpty()) {
      Output.println(in.get(0), Color.LIGHT_RED);
      scanner = new Scanner(in.remove(0));
    } else {
      scanner = new Scanner(System.in);
    }
  }

  /**
   * Gets an integer input from the user that falls within a specified range. If the input is not an
   * integer, or not within the specified range, it prompts the user again until a valid input is
   * received. It also supports an "exit" command to terminate the application.
   *
   * @param lowerBound The lower bound of the acceptable input range (inclusive).
   * @param upperBound The upper bound of the acceptable input range (inclusive).
   * @return The user's choice as an integer within the specified bounds.
   */
  public static int getInt(int lowerBound, int upperBound) {
    setUpScanner();

    int choice = 0;
    while (true) {
      try {
        String input = scanner.next();
        clearPreviousLine();
        Output.println(input, Color.LIGHT_RED);

        if ("exit".equalsIgnoreCase(input)) {
          Output.println(
              "|-------------------------Application Exited--------------------------|\n",
              Color.LIGHT_BLUE);
          System.exit(1);
        }

        choice = Integer.parseInt(input);
        clearPreviousLine();
        if (choice >= lowerBound && choice <= upperBound) {
          Output.println(input, Color.LIGHT_GREEN);
          break; // Exit the loop if the input is within the bounds
        }
      } catch (NumberFormatException e) {
        clearPreviousLine();
      }
    }

    return choice;
  }

  /**
   * Prompts the user for a single character input that must be within the allowed characters
   * specified. If the input is "exit" (case-insensitive), the application will terminate.
   *
   * @param allowedChars A string containing all allowed characters.
   * @return The chosen character if it is within the allowed characters; '\0' otherwise.
   */
  public static char getChar(String allowedChars) {
    setUpScanner();

    char choice = '\0';
    while (true) {
      try {
        String input = scanner.next();
        clearPreviousLine();
        Output.println(input, Color.LIGHT_RED);

        if ("exit".equalsIgnoreCase(input)) {
          Output.println(
              "|---------------------------Application Exited----------------------------|\n",
              Color.LIGHT_BLUE);
          System.exit(1);
        }

        if (input.length() == 1 && allowedChars.indexOf(input.charAt(0)) != -1) {
          choice = input.charAt(0);
          clearPreviousLine();
          Output.println(choice, Color.LIGHT_GREEN);
          break; // Exit the loop if the input is within the allowed characters
        } else {
          clearPreviousLine();
        }
      } catch (Exception e) {
        e.printStackTrace();
        break;
      }
    }

    return choice;
  }

  /**
   * Reads a line of text from the user. If the input is "exit" (case-insensitive), the application
   * will terminate.
   *
   * @return The input line as a string.
   */
  public static String getLine() {
    setUpScanner();

    String input = "";
    while (true) {
      try {
        input = scanner.nextLine();
        clearPreviousLine();


        if ("exit".equalsIgnoreCase(input)) {
          Output.println(input, Color.LIGHT_RED);
          Output.println(
              "|---------------------------Application Exited----------------------------|\n",
              Color.LIGHT_BLUE);
          System.exit(1);
        }
        Output.println(input, Color.LIGHT_GREEN);

        break; // Exit the loop after successfully reading a line
      } catch (Exception e) {
        e.printStackTrace();
        break;
      }
    }

    return input;
  }

  /**
   * Attempts to clear the previous line in the console. This method uses ANSI escape codes to move
   * the cursor up and clear the line. Compatibility and effectiveness may vary depending on the
   * console or terminal emulator.
   */
  public static void clearPreviousLine() {
    System.out.print("\033[A\033[K");
    System.out.flush();
  }
}
