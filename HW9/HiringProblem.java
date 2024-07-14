import java.util.Arrays;
import java.util.ArrayList;

public class HiringProblem {
    public static void main(String[] args) {
        // Candidate minimum and maximum value
        final int MIN = 0, MAX = 100;

        // Array that will hold all candidate values
        int[] arr = new int[5];

        // Loop for 5 array iterations
        for(int i = 0; i < 5; i++) {
            // Loading the array
            loadArray(arr, MIN, MAX);

            // Calculating the hiring cost for each array
            calculateHiringCost(arr);
        }
    }

    /**
     * This method will populate the array with 5 random integer values
     */
    public static void loadArray(int[] arr, int MIN, int MAX) {
        // Populating the array with random candidate values
        for(int i = 0; i < arr.length; i++) {
            arr[i] = (int)Math.floor(Math.random() * (MAX - MIN + 1) + MIN);
        }

        // Printing the array
        System.out.println("Array: " + Arrays.toString(arr));
    }

    /**
     * This method will calculate the hiring cost for the candidate values in the array
     */
    public static void calculateHiringCost(int[] arr) {
        // Best candidate, hired, and final cost trackers
        int best = 0, cost = 0;
        ArrayList<Integer> hiredCandidates = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > best) {
                cost++;
                cost += (arr[i] - best);
                best = arr[i];

                hiredCandidates.add(i);
            } else {
                // Cost increase due to interview even if candidate is not hired
                cost++;
            }
        }

        // Printing final results
        printFinalResults(hiredCandidates, cost);
    }

    /**
     * This method will print the final result from calculating the hiring problem
     */
    public static void printFinalResults(ArrayList<Integer> arrList, int cost) {
        System.out.println("Candidates hired: " + Arrays.toString(arrList.toArray())
            .replace("[", "")
            .replace("]", "")
        );

        System.out.println("Total hiring cost: $" + cost);
        System.out.println();
    }
}