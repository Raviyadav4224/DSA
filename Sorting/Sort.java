package Sorting;
public class Sort {

    public static void selectionSort(int a[]) {
        int n = a.length;
        for (int j = 0; j < n - 1; j++) {
            int min = j;
            for (int k = j + 1; k < n - 1; k++) {
                if (a[k] < a[min]) {
                    int t = a[k];
                    a[k] = a[min];
                    a[min] = t;
                    min = k;
                }
            }
        }

    }

    public static void bubbleSort(int a[]) {
        int n = a.length;
        boolean swapped = false;
        for (int j = 0; j < n - 1; j++) {
            for (int k = 0; k < n - 1 - j; k++) {
                if (a[k] > a[k + 1]) {
                    swapped = true;
                    int t = a[k + 1];
                    a[k + 1] = a[k];
                    a[k] = t;
                }
            }
            if (!swapped) {
                return;
            }

        }
    }

    public static void insertionSort(int a[]) {

        // int a[] = { 12, 4, 5, 2, 8, 9, 13 };
        // 2 1
        int n = a.length;
        for (int j = 0; j < n - 1; j++) {
            int k = j;
            while (k > 0 && a[k - 1] > a[k]) {
                int t = a[k - 1];
                a[k - 1] = a[k];
                a[k] = t;
                k--;
            }
        }
    }

    public static void showMe(int a[]) {
        for (int j : a) {
            System.out.print(" " + j);
        }
    }

    public static void mergeSort(int a[], int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;

        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        merge(a, low, mid, high);

    }

    public static void merge(int[] a, int low, int mid, int high) {
        int result[] = new int[high-low+1];
        int left = low;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= high) {
            if (a[left] <= a[right]) {
                result[index] = a[left];
                left++;
            } else {
                result[index] = a[right];
                right++;
            }
            index++;
        }

        while (left <= mid) {
            result[index] = a[left];
            left++;
        }

        while (right <= high) {
            result[index] = a[right];
            right++;
        }
        for (int i = low; i <= high; i++) {
            a[i] = result[i - low];
        }

    }

    public static void main(String[] args) {
        System.out.println("Sort");

        int a[] = { 12, 4, 5, 2, 8, 9, 13 };
        showMe(a);
        System.out.println();
        mergeSort(a, 0, a.length - 1);
        // bubbleSort(a);
        // System.out.println("aft");
        // showMe(a);
        // System.out.println("aft");
        // selectionSort(a);
        // showMe(a);
        // System.out.println("aft");
        // insertionSort(a);
        showMe(a);
    }
}
