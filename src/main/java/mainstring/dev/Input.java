package mainstring.dev;

import java.util.*;

public abstract class Input {

  public enum Color {
    RESET("\u001B[0m"), LIGHT_RED("\u001B[91m");

    private final String code;

    Color(String code) {
      this.code = code;
    }

    public String Code() {
      return code;
    }
  }

  private static List<String> in = new ArrayList<>();
  private static Scanner scanner;


  public static void in(String input) {
    in.add(input); // Append input and simulate pressing Enter
  }

  public static void setUpScanner() {
    if (!in.isEmpty()) {
      println(in.get(0), Color.LIGHT_RED); // Print the string in light red
      scanner = new Scanner(in.remove(0));
    } else {
      scanner = new Scanner(System.in);
    }
  }

  public static int getInt(int lowerBound, int upperBound) {
    setUpScanner();

    int choice;
    while (true) {
      choice = 0;
      try {
        choice = scanner.nextInt();
        clearPreviousLine();
        println(choice, Color.LIGHT_RED);
        if (choice >= lowerBound && choice <= upperBound) {
          break; // Exit the loop if the input is within the bounds
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

  public static char getChar(String allowedChars) {
    setUpScanner();

    char choice;
    while (true) {
      choice = '\0';
      try {
        String input = scanner.next();
        if (input.length() == 1 && allowedChars.indexOf(input.charAt(0)) != -1) {
          choice = input.charAt(0);
          clearPreviousLine();
          println(choice, Color.LIGHT_RED);
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
        println(input, Color.LIGHT_RED);
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

  public static void println(Object s, Color c) {
    System.out.print(c.Code());
    System.out.println(s); // Print the string
    System.out.print(Color.RESET.Code()); // Reset color to default
  }

}
