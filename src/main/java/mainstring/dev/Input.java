package mainstring.dev;

import java.util.*;
import mainstring.dev.Output.Color;

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
          getInt(lowerBound, upperBound);
          break;
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
          getChar(allowedChars);
          break;
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
          getLine();
          break;
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



  private static boolean check(String input) {
    String lowerCaseInput = input.toLowerCase();
    boolean print = false;

    switch (lowerCaseInput) {
      case "prints":
        System.err.println(game.menu.settings);
        print = true;
        break;
      case "printp":
        System.err.println(game.players);
        print = true;
        break;
      case "printg":
        System.err.println(game.grid);
        print = true;
        break;
      case "exit":
        Output.println("|-------------------------Application Exited--------------------------|\n",
            Color.LIGHT_BLUE);
        System.exit(1);
        break;
    }

    clearPreviousLine();
    Output.println(input, Color.LIGHT_YELLOW);

    return print;
  }

  public static String[] split(String input) {
    boolean hasSquareBrackets = input.startsWith("[") && input.endsWith("]");
    if (hasSquareBrackets) {
      input = input.substring(1, input.length() - 1);
    }
    return input.split(",(?![^\\[]*\\])");
  }

  // public static List<String> split(String input) {
  // List<String> result = new ArrayList<>();
  // input = input.trim(); // Assign the trimmed input back to input variable
  // String content = input; // Initialize content with the input

  // if (input.startsWith("[") && input.endsWith("]")) {
  // // Extract the content between '[' and ']'
  // content = input.substring(1, input.length() - 1);
  // }

  // // Split the content by comma
  // String[] arrayContent = content.split(",");

  // // Add each element to the result list
  // result.addAll(Arrays.asList(arrayContent));

  // // Print the result for debugging
  // System.out.println(result);

  // return result;
  // }



  // public static List<Object> getListLine() {
  // String input = scanner.nextLine();
  // List<Object> result = new ArrayList<>();

  // // Split the input line by commas
  // String[] elements = input.split(",");

  // // Process each element
  // for (String element : elements) {
  // element = element.trim(); // Remove leading and trailing whitespace

  // // If the element starts with '[' and ends with ']', it's an array
  // if (element.startsWith("[") && element.endsWith("]")) {
  // // Extract the content between '[' and ']', split it by comma, and add to result
  // String content = element.substring(1, element.length() - 1);
  // String[] arrayContent = content.split(",");
  // result.add(Arrays.asList(arrayContent)); // Convert array content to list
  // } else {
  // // Otherwise, add the element as is
  // result.add(element);
  // }
  // }

  // clearPreviousLine();
  // Output.println(input, Color.GREEN);

  // return result;
  // }


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
