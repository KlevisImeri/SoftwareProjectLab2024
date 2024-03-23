package mainstring.dev;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public abstract class Input {

  public static int getInt(int lowerBound, int upperBound) {
    int choice;
    Scanner scanner = new Scanner(System.in);

    while (true) {
      choice = 0;
      try {
        choice = scanner.nextInt();
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
    return 'i';
  }

  public static in(String input){
    // String input = "2\n20\n";
    // InputStream in = new ByteArrayInputStream(input.getBytes());
    // System.setIn(in);
  }

  public static void clearPreviousLine() {
    System.out.print("\033[A\033[K");
    System.out.flush();
  }
}
