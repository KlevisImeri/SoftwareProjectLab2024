package mainstring.dev.Model;

import java.util.*;
import mainstring.dev.Model.Output.Color;

/**
 * Provides utility methods for handling user input in a flexible way, allowing for both real-time
 * and simulated inputs. This class is designed to support testing scenarios by simulating inputs or
 * using real-time inputs from the console.
 */
public abstract class Input {
  static Scanner scanner = new Scanner(System.in);
  public static Game game;

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
    int choice = 0;
    while (true) {
      try {
        String input = scanner.next();
        Output.println(input, Color.LIGHT_RED);

        if (check(input)) {
          return getInt(lowerBound, upperBound);
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
    char choice = '\0';
    while (true) {
      try {
        String input = scanner.next();
        Output.println(input, Color.LIGHT_RED);

        if (check(input)) {
          return getChar(allowedChars);
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
    String input = "";
    while (true) {
      try {
        input = scanner.next();
        Output.println(input, Color.LIGHT_RED);

        if (check(input)) {
          return getLine();
        }

        clearPreviousLine();
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
   * Checks the input for specific commands and performs corresponding actions.
   * 
   * @param input The input string to be checked.
   * @return true if a command was found and executed; false otherwise.
   */
  private static boolean check(String input) {
    String lowerCaseInput = input.toLowerCase();
    boolean print = false;

    switch (lowerCaseInput) {
      case "prints":
        clearPreviousLine();
        Output.println(input, Color.LIGHT_GREEN);
        System.err.println(game.getMenu().settings);
        print = true;
        break;
      case "printp":
        clearPreviousLine();
        Output.println(input, Color.LIGHT_GREEN);
        System.err.println(game.getPlayers());
        print = true;
        break;
      case "printg":
        clearPreviousLine();
        Output.println(input, Color.LIGHT_GREEN);
        System.err.println(game.getGrid());
        print = true;
        break;
      case "exit":
        Output.println("[Application Exited]\n", Color.LIGHT_BLUE);
        System.exit(1);
        break;
    }


    return print;
  }

  /**
   * Splits a string into an array of substrings, considering square brackets as delimiters.
   * 
   * @param input The input string to be split.
   * @return An array of substrings after splitting the input string.
   */
  public static String[] split(String input) {
    boolean hasSquareBrackets = input.startsWith("[") && input.endsWith("]");
    if (hasSquareBrackets) {
      input = input.substring(1, input.length() - 1);
    }
    return input.split(",(?![^\\[]*\\])");
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
