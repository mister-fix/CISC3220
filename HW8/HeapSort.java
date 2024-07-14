import java.util.Arrays;

public class HeapSort {
    private int size;
    private int maxSize;
    private int Heap[];
    
    public HeapSort(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        Heap = new int[this.maxSize + 1];
        Heap[0] = Integer.MAX_VALUE;
    }
    
    private int parent(int i) {
        return i / 2;
    }
    private int left(int i) {
        return 2 * i;
    }
    private int right(int i) {
        return (2 * i) + 1;
    }
    
    private boolean isLeaf(int position){
        if (position >= (size / 2) && position <= size) {
            return true;
        }   
        else {
            return false;
        }
    }
    
    private void swapElement(int fPos, int sPos) {
        int current = Heap[fPos];
        Heap[fPos] = Heap[sPos];
        Heap[sPos] = current;
    }
    
    private void maxHeapify(int position) {
        if (isLeaf(position)) {
            return;
        }
    
        if (Heap[position] < Heap[left(position)] || Heap[position] < Heap[right(position)]) {
            if (Heap[left(position)] > Heap[right(position)]) {
                swapElement(position, left(position));
                maxHeapify(left(position));
            } else {
                swapElement(position, right(position));
                maxHeapify(right(position));
            }
        }
    }
    
    static void maxHeapify(int arr[], int n, int i) {
        int max = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
    
        if (l < n && arr[l] > arr[max])
        max = l;
    
        if (r < n && arr[r] > arr[max])
        max = r;
        
        if (max != i) {
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
            
            maxHeapify(arr, n, max);
        }
    }
    
    static void buildMaxHeap(int arr[], int n) {
        int start = (n / 2) - 1;

        for (int i = start; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }
    
    public void printMaxHeap() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " \n\tLeft Child : " + Heap[2 * i] + "\n\tRight Child :" + Heap[2 * i + 1]);
            System.out.println();
        }
    }
    
    public int extractMax() {
        Heap[1] = Heap[size--];

        maxHeapify(1);

        return Heap[1];
    }
    
    public void sort(int arr[]) {
        int n = arr.length;
        
        for (int i = n / 2 - 1; i >= 0; i--)
        maxHeapify(arr, n, i);
    
        for (int i=n-1; i>0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            maxHeapify(arr, i, 0);
        }
    }
    
    public void insert(int element) {
        Heap[++size] = element;
        
        int current = size;
        while (Heap[current] > Heap[parent(current)]) {
            swapElement(current, parent(current));
            current = parent(current);
        }
    }
    
    public static void main(String args[]) {
        int arr[] = {3, 6, 1, 8, 12, 4, 7};
        int n = arr.length;
        
        HeapSort heap = new HeapSort(8);

        for(int i=0; i<n; i++) {
            heap.insert(arr[i]);
        }
        
        System.out.println("Array to sort: " + Arrays.toString(arr));

        System.out.println("Max Heap is: ");
        heap.printMaxHeap();

        System.out.println("The maximum value is: " + heap.extractMax());
        heap.sort(arr);

        System.out.print("Sorted array: ");
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
    }
}