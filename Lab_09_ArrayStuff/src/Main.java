import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // variables and initializing arrays
        int ARRAY_SIZE = 100;
        int dataTotal = 0;
        int average = 0;

        int[] data = new int[ARRAY_SIZE];

        Random rnd = new Random();

        Scanner in = new Scanner(System.in);

        // set random variables into array
        for (int x = 0; x < data.length; x++) {
            data[x] = rnd.nextInt(100) + 1;
        }
        // display array
        for (int x = 0; x < data.length; x++) {
            System.out.print(data[x] + " | ");
        }
        // calculating average
        for (int x = 0; x < data.length; x++) {
            dataTotal += data[x];
        }
        average = dataTotal / ARRAY_SIZE;

        System.out.println("\nThe average of random numbers in the array is: " + average);

        // getting user input
        int userNum = SafeInput.getRangedInt(in, "\nChoose a number", 1, 100);
        int sameNumber = 0;

        // loop through array
        for (int x = 0; x < data.length; x++) {
            if (data[x] == userNum) {
                sameNumber += 1;
            }
        }
        System.out.println("Your number: " + userNum + " was repeated " + sameNumber + " time(s) in the random array.");
        boolean foundTarget = false;
        userNum = SafeInput.getRangedInt(in, "\nChoose a number", 1, 100);
        for (int x = 0; x < data.length; x++) {
            if (data[x] == userNum) {
                System.out.println("The number: " + userNum + " was found at index position " + x + " in the array.");
                foundTarget = true;
            }
        }
        if (!foundTarget) {
            System.out.println("Your number: " + userNum + " was not found in the array.");
        }
        // min and max in array
        int min = data[0];
        int max = data[0];
        for (int x = 0; x < data.length; x++) {
            if (min > data[x]) {
                min = data[x];
            }
            else if (max < data[x]) {
                max = data[x];
            }
        }
        System.out.println("\nThe minimum value in the array was: " + min + " and the maximum value in the array was: " + max);

        // avg
        System.out.println("\nThe average of the data points is: " + getAverage(data));

        // min
        System.out.println("\nThe min of the data points is: " + min(data));

        // max
        System.out.println("\nThe max of the data points is: " + max(data));

        // occurrence
        userNum = SafeInput.getRangedInt(in, "Choose a number", 1, 100);
        System.out.println("\nYour number: " + userNum + " occurred " + occurrenceScan(data, userNum) + " times in the array.");

        // sum
        System.out.println("\nThe sum of all the values in the array is " + sum(data));

        // contains value
        userNum = SafeInput.getRangedInt(in, "Choose a number", 1, 100);
        String text = "";
        if (contains(data, userNum)) {
            System.out.println("Your number: " + userNum + " was found in the array.");
        }
        else {
            System.out.println("Your number: " + userNum + " was not found in the array.");
        }
    }

    public static double getAverage(int values[]) {
        // variables
        int dataTotal = 0;
        int ARRAY_SIZE = values.length;
        double average = 0;

        // calculating average
        for (int x = 0; x < values.length; x++) {
            dataTotal += values[x];
        }
        average = dataTotal / ARRAY_SIZE;

        return average;
    }

    public static int min(int values[]) {
        // variables
        int min = 0;

        min = values[0];

        // loops through data checking if value is smaller
        for (int x = 0; x < values.length; x++) {
            if (min > values[x]) {
                min = values[x];
            }
        }

        return min;
    }

    public static int max(int values[]) {
        // variables
        int max = 0;

        max = values[0];

        // loops through data checking if value is greater
        for (int x = 0; x < values.length; x++) {
            if (max < values[x]) {
                max = values[x];
            }
        }

        return max;
    }

    public static int occurrenceScan(int values[], int target) {
        // variables
        int sameNumber = 0;

        // loop through array
        for (int x = 0; x < values.length; x++) {
            if (values[x] == target) {
                sameNumber += 1;
            }
        }

        return sameNumber;
    }

    public static int sum(int values[]) {
        // variables
        int total = 0;

        // loop through array
        for (int x = 0; x < values.length; x++) {
            total += values[x];
        }

        return total;
    }

    public static boolean contains(int values[], int target) {
        // variables
        boolean targetFound = false;

        for (int x = 0; x < values.length; x++) {
            if (target == values[x]) {
                targetFound = true;
                break;
            }
        }

        return targetFound;
    }
}