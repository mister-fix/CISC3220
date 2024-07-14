import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // Array to be sorted by merge-sort algorithm
        int[] A = new int[] {2, 1, 6, 3, 4};
        // Array start point
        int p = 0;
        // Array end point
        int r = A.length - 1;

        // Printing the given unsorted array
        System.out.println("A: " + Arrays.toString(A));

        // Calling the merge-sort algorithm on the array
        int[] A2 = sort(A, p, r);

        // Printing the array after merge-sort
        System.out.println("A: " + Arrays.toString(A2));
    }

    /**
     * This method will sort a given array using the merge-sort algorithm
     */
    public static int[] sort(int[] A, int p, int r) {
        // Array midpoint
        int q;
        // Checking that the array start point is lower than end point
        if(p < r) {
            // Assign to q the midpoint of the array
            q = (p + r)/2;

            // Calling sort method on the array from start to midpoint
            sort(A, p, q);
            // Calling sort method on the array from midpoint to end
            sort(A, q + 1, r);
            // Calling the merge method to combine subarrays
            merge(A, p, q, r);

            // Printing changes to array as sorting continues
            System.out.println("A: " + Arrays.toString(A));
        }

        // Returning sorted array
        return A;
    }

    /**
     * This method will merge the sorted subarrays into one array
     */
    public static void merge(int[] A, int p, int q, int r) {
        // Size of left-side and right-side subarrays
        int n1 = q - p + 1;
        int n2 = r - q;

        // Creating left-side and right-side subarrays
        int L[] = new int[n1 + 1];
        int R[] = new int[n2 + 1];

        // Populating subarrays
        for(int i = 0; i < n1; ++i) {
            L[i] = A[p + i];
        }
        for(int j = 0; j < n2; ++j) {
            R[j] = A[q + 1 + j];
        }
        
        // Indeces for left and right subarrays
        int i = 0;
        int j = 0;
        int k = p;

        while(i < n1 && j < n2) {
            if (L[i] <= R[j]) {
				A[k] = L[i];
				i++;
			}
			else {
				A[k] = R[j];
				j++;
			}
            k++;
        }

        // Adding any missed values to left subarray
        while(i < n1) {
            A[k] = L[i];
            i++;
            k++;
        }
        // Adding any missed values to right subarray
        while(j < n2) {
            A[k] = R[j];
            j++;
            k++;
        }
    }
}