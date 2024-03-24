package mainstring.dev;

import java.util.*;
import mainstring.dev.Output.Color;

public abstract class Input {

  private static List<String> in = new ArrayList<>();
  public static Scanner scanner;


  public static void in(String input) {
    in.add(input); // Append input and simulate pressing Enter
  }

  public static void setUpScanner() {
    if (!in.isEmpty()) {
      Output.println(in.get(0), Color.LIGHT_RED);
      scanner = new Scanner(in.remove(0));
    } else {
      scanner = new Scanner(System.in);
    }
  }

  public static int getInt(int lowerBound, int upperBound) {
    setUpScanner();

    int choice = 0;
    while (true) {
      try {
        String input = scanner.next();
        clearPreviousLine();
        Output.println(input, Color.LIGHT_RED);

        if ("exit".equalsIgnoreCase(input)) {
          Output.println("|-------------------------Application Exited--------------------------|\n",
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

  public static char getChar(String allowedChars) {
    setUpScanner();

    char choice = '\0';
    while (true) {
      try {
        String input = scanner.next();
        clearPreviousLine();
        Output.println(input, Color.LIGHT_RED);

        if ("exit".equalsIgnoreCase(input)) {
          Output.println("|---------------------------Application Exited----------------------------|\n",
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

  public static String getLine() {
    setUpScanner();

    String input = "";
    while (true) {
      try {
        input = scanner.nextLine();
        clearPreviousLine();
        

        if ("exit".equalsIgnoreCase(input)) {
          Output.println(input, Color.LIGHT_RED);
          Output.println("|---------------------------Application Exited----------------------------|\n",
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

  public static void clearPreviousLine() {
    System.out.print("\033[A\033[K");
    System.out.flush();
  }



}
