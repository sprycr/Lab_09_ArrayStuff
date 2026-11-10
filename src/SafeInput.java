import java.util.Scanner;

public class SafeInput {

  // ------------------------------------------
  // --------------- Strings ------------------
  // ------------------------------------------

  /**
   *
   * @param pipe   a Scanner opened to read from System.in
   * @param prompt prompt for the user
   * @return a String response that is not zero length
   */
  public static String getNonZeroLenString(Scanner pipe, String prompt) {
    String retString = ""; // Set this to zero length. Loop runs until it isn't
    do {
      System.out.print("\n" + prompt + ": "); // show prompt add space
      retString = pipe.nextLine();
    } while (retString.length() == 0);

    return retString;

  }

  // Validate a regex string
  public static String getRegExString(Scanner pipe, String prompt, String regexPattern) {
    String response = "";
    boolean done = false;
    do {
      System.out.println(prompt);
      response = pipe.nextLine();
      if (response.matches(regexPattern)) {
        done = true;
      } else {
        System.out.println("your input must match " + regexPattern);
      }
    } while (!done);
    return response;
  }

  // -------------------------------------------
  // --------------- integers ------------------
  // -------------------------------------------
  // validate an integer
  public static int getInt(Scanner pipe, String prompt) {
    int retVal = 0;
    String trash = "";
    boolean done = false;
    do {
      System.out.println(prompt);
      if (pipe.hasNextInt()) {
        retVal = pipe.nextInt();
        pipe.nextLine(); // clear the buffer
        done = true;
      } else {
        trash = pipe.nextLine();
        System.out.println("Please input a valid integer. You entered: " + trash);
      }
    } while (!done);
    return retVal;
  }

  // validate an integer within a range
  public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
    int retVal = 0;
    String trash = "";
    prompt = prompt + " [" + low + "-" + high + "]";
    boolean done = false;
    do {
      System.out.println(prompt);
      if (pipe.hasNextInt()) {
        retVal = pipe.nextInt();
        if (retVal >= low && retVal <= high) {
          done = true;
        } else {
          System.out.println("Please enter a number in the range [" + low + "-" + high + "]. You entered: " + retVal);
          done = false;
        }
        pipe.nextLine(); // clear the buffer
      } else {
        trash = pipe.nextLine();
        System.out.println("Please input a valid integer. You entered: " + trash);
      }
    } while (!done);
    return retVal;
  }

  // ------------------------------------------
  // --------------- Doubles ------------------
  // ------------------------------------------
  // validate a double.
  public static double getDouble(Scanner pipe, String prompt) {
    double retVal = 0;
    String trash = "";
    boolean done = false;
    do {
      System.out.println(prompt);
      if (pipe.hasNextDouble()) {
        retVal = pipe.nextDouble();
        pipe.nextLine(); // clear the buffer
        done = true;
      } else {
        trash = pipe.nextLine();
        System.out.println("Please input a valid double. You entered: " + trash);
      }
    } while (!done);
    return retVal;
  }

  // validate a Double within a range
  public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
    double retVal = 0;
    String trash = "";
    prompt = prompt + " [" + low + "-" + high + "]";
    boolean done = false;
    do {
      System.out.println(prompt);
      if (pipe.hasNextDouble()) {
        retVal = pipe.nextDouble();
        if (retVal >= low && retVal <= high) {
          done = true;
        } else {
          System.out.println("Please enter a number in the range [" + low + "-" + high + "]. You entered: " + retVal);
          done = false;
        }
        pipe.nextLine(); // clear the buffer
      } else {
        trash = pipe.nextLine();
        System.out.println("Please input a valid Double. You entered: " + trash);
      }
    } while (!done);
    return retVal;
  }

  // -------------------------------------------
  // --------------- Booleans ------------------
  // -------------------------------------------
  public static boolean getYNConfirm(Scanner pipe, String prompt) {
    boolean valid = false;
    // replay logic
    do { // loop until valid input received
      System.out.print(prompt);
      if (pipe.hasNextLine()) {
        String input = pipe.nextLine();

        if (input.equalsIgnoreCase("") || input.equalsIgnoreCase("Y")) {
          valid = true;
          return true;
        } else if (input.equalsIgnoreCase("N")) {
          System.out.println("Exiting...");
          valid = true;
          return false;
        } else {
          valid = false;
          System.out.println("Please input a valid response. You entered: " + input);
        }
      }
    } while (!valid);
    return false;
  }
  // -----------------------------------------
  // --------------- Other ------------------
  // -----------------------------------------

  public static void prettyHeader(String msg) {
    int padding = (54 - msg.length()) / 2;
    // Top
    for (int i = 0; i < 60; i++) {
      System.out.print("*");
    }
    System.out.println();
    // Middle
    System.out.print("***");// NOT PRINTLN!!!!!!!
    for (int i = 0; i < padding; i++) {
      System.out.print(" ");
    }
    System.out.print(msg);
    for (int i = 0; (i < 54 - msg.length() - padding); i++) {
      System.out.print(" ");
    }
    System.out.println("***");
    // Bottom
    for (int i = 0; i < 60; i++) {
      System.out.print("*");
    }
    System.out.println();
  }
}
