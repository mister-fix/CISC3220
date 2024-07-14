import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] A = new int[] {2, 8, 4, 3, 1, 6, 3};

        System.out.println("A Unsorted: " + Arrays.toString(A));

        int[] arrSorted = insertionSort(A);

        System.out.println("A Sorted:" + Arrays.toString(arrSorted));
    }

    public static int[] insertionSort(int[] arr) {
        for(int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;

            while(i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i = i - 1;
            }

            arr[i + 1] = key;
        }

        return arr;
    }
}