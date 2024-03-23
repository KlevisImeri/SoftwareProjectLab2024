package mainstring.dev;

import java.util.Scanner;

public abstract class Input {

  public static int getInt(int lowerBound, int upperBound) {
    int choice;
    Scanner scanner = new Scanner(System.in);

    while (true) {
      choice = 0;
      try {
        choice = scanner.nextInt();
        if (choice >= lowerBound && choice <= upperBound)
          break; // Exit the loop if the input is within the bounds
      } catch (Exception e) {
        e.printStackTrace();
        break;
      }
    }

    scanner.close();
    return choice;
  }


}
