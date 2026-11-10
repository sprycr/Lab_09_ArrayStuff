import java.util.Random;
import java.util.Scanner;

public class ArrayStuff {
  public static double getAverage(double values[]) {
    double sum = 0;
    double average = 0;
    for (int i = 0; i < values.length; i++) {
      sum += values[i];
    }
    average = sum / values.length;
    return average;
  }

  public static void main(String[] args) {
    int[] dataPoints = new int[100];
    Random rand = new Random();
    Scanner in = new Scanner(System.in);
    int sum = 0;
    double average = 0;
    for (int i = 0; i < dataPoints.length; i++) {
      dataPoints[i] = rand.nextInt(100) + 1;
    }
    for (int j = 0; j < dataPoints.length; j++) {
      System.out.printf("| %-3d ", dataPoints[j]);
      sum += dataPoints[j];
    }
    System.out.print("|\n");
    System.out.println("the sum of the random array of data points is: " + sum);
    average = (double) sum / dataPoints.length;
    System.out.println("the average of the random array of data points is: " + average);
    // enhanced:
    // for (int i = 0; i < dataPoints.length() - 1; i++) {
    // dataPoints[i] = rand.nextInt(100) + 1;
    // }
    int userInt = SafeInput.getRangedInt(in, "Please enter an integer.", 1, 100);
    int occurrances = 0;
    for (int dataPoint : dataPoints) {
      if (dataPoint == userInt) {
        occurrances++;
      }
      sum += dataPoint;
    }
    System.out.println("the value " + userInt + " shows up in the set " + occurrances + " times.");
    int secondUserInt = SafeInput.getRangedInt(in, "Please enter another integer.", 1, 100);
    int position = 0;
    int count = 0;
    for (int i = 0; i < dataPoints.length; i++) {
      if (dataPoints[i] == secondUserInt) {
        position = i;
        System.out.println("The value " + secondUserInt + " was found at array index " + position);
        break;
      }
      if (i == dataPoints.length - 1 && dataPoints[i] != secondUserInt) {
        System.out.println("the value " + secondUserInt + " is not in the array.");
      }
    }

    int min = dataPoints[0];
    int max = dataPoints[0];
    for (int i = 0; i < dataPoints.length; i++) {
      if (dataPoints[i] >= max) {
        max = dataPoints[i];
      } else {
        if (dataPoints[i] < min) {
          min = dataPoints[i];
        }
      }
    }
    System.out.println("the minimum value of the array is: " + min);
    System.out.println("the maximum value of the array is: " + max);
    //convert int array to double.
//    int [] dataPointsCopy = new int [dataPoints.length];
//    for (int i = 0; i < dataPoints.length; i++) {
//      dataPointsCopy[i] = dataPoints[i];
//    }
//
//    double [] dataPoints = new int [dataPointsCopy.length];
//    for (int i = 0; i < dataPoints.length; i++) {
//      dataPoints[i] = dataPointsCopy[i];
//    }

    System.out.println("Average of dataPoints is: " + getAverage(dataPoints));
  }
}
