import java.util.Comparator;
import java.util.Objects;

public class ArraySorts {

    private ArraySorts() {
        throw new AssertionError("cannot be instantiated");
    }

    public static void bubbleSort(int[] arr) {
        if (arr == null)
            throw new IllegalArgumentException("array cannot be null");

        int n = arr.length;
        for (int i=0; i<n-1; i++) {
            for (int j=0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static <T> void bubbleSortWithComparator(T[] arr, Comparator<? super T> c) {
        if (arr == null || c == null) {
            throw new IllegalArgumentException("Array/Comparator cannot be null");
        }

        int n = arr.length;
        for (int i=0; i<n-1; i++) {
            for (int j=0; j < n - i - 1; j++) {
                if (c.compare(arr[j], arr[j+1]) > 0){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    public static void bubbleSortOptimized(int[] arr) {

        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }
        int n = arr.length;
        while (n != 0) {
            int swap = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i-1] > arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;

                    swap = i;
                }
            }
            n = swap;
        }

    }

    public static <T>
    void bubbleSortOptimizedWithComparator(T[] arr, Comparator<? super T> c) {

        if (arr == null || c == null) {
            throw new IllegalArgumentException("Array/Comparator cannot be null");
        }

        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length cannot be 0");
        }

        int n = arr.length;

        while (n != 0) {
            int swap = 0;
            for (int i = 1; i < n; i++) {
                if (c.compare(arr[i-1], arr[i]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;

                    swap = i;
                }
            }
            n = swap;
        }


    }

    public static void insertionSort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }
        int n = arr.length;

        for (int i = 1; i < n; ++i) {

            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }

    public static <T> void insertionSortWithComparator(T[] arr, Comparator<? super T> c) {
        if (arr == null){
            throw new IllegalArgumentException("Array cannot be null");
        }

        int n = arr.length;

        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j > 0 && c.compare(arr[j], key) > 0) {
                arr[j+1] = arr[j];
                j = j - 1;
            }

            arr[j+1] = key;

        }

    }

    public static void countingSort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        int max = arr[0];
        int min = arr[0];

        for (int i=0; i<arr.length;i++){
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        int[] counts = new int[max-min+1];

        for (int i = 0; i < arr.length; i++){
            counts[arr[i]-min]++;
        }

        int sortedIndex = 0;

        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                arr[sortedIndex++] = i + min;
                counts[i]--;
            }
        }
    }

    public static void heapSort(int[] arr) {
        Objects.requireNonNull(arr);

        int n = arr.length;

        buildHeap(arr, n);

        while (n > 1) {
            swap(arr, 0, n - 1);
            n--;
            heapify(arr, n, 0);
        }


    }

    private static void buildHeap(int[] arr, int n) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }

    }

    private static void heapify(int[] arr, int length, int parent) {
        int leftChild = parent * 2 + 1;
        int rightChild = parent * 2 + 2;
        int greater;

        if (leftChild < length && arr[leftChild] > arr[parent]) {
            greater = leftChild;
        } else {
            greater = parent;
        }

        if (rightChild < length && arr[rightChild] > arr[greater]) {
            greater = rightChild;
        }

        if (greater != parent) {
            swap(arr, parent, greater);
            heapify(arr, length, greater);
        }

    }

    private static void swap(int[] arr, int parent, int greater) {
        int temp = arr[parent];
        arr[parent] = arr[greater];
        arr[greater] = temp;

    }
}
