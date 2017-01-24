package q1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1>Statistics</h1>
 * 
 * <p>
 * Calculate the mean and standard deviation of an array of values. 
 * Can use file redirection.
 * </p>
 *
 * @author Lin, Tony
 * @version 1.0 Dec 6, 2016
 */
public class Statistics {

    /**
     * <p>
     * This is the main method (entry point) that gets called by the JVM.
     * </p>
     *
     * @param args
     *            command line arguments.
     */
    public static void main(String[] args) {
        // your code will go here!!!
        ArrayList<Integer> array = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter some integers to find the mean and "
                + "standard deviation. Cancel by inputting a non-numeric "
                + "value.");
        while (scan.hasNextInt()) {
            array.add(Integer.parseInt(scan.next()));
        }
        scan.close();
        
        double[] arr = new double[array.size()];
        int length = arr.length;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = array.get(i);
            sum += arr[i];
        }

        double mean = (double) sum / length;

        double sumOfDiff = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.pow((arr[i] - mean), 2);
            sumOfDiff += arr[i];
        }
        System.out.println("Mean is: " + mean);
        System.out.println("Standard Deviation is: " + Math.sqrt(sumOfDiff 
                / (length - 1)));

        System.out.println("Question one was called and ran sucessfully.");
    }

};
