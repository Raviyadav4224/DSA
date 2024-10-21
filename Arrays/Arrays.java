package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Arrays {

    public static int largestElement(int a[]) {
        int largest = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > largest) {
                largest = a[i];
            }
        }
        return largest;
    }

    public static int secondLargest(int a[]) {
        int sLargest = -1;
        int largest = a[0];

        // Better approach
        // for (int i = 0; i < a.length; i++) {
        // if (a[i] > largest) {
        // largest = a[i];
        // }
        // }
        // for (int i = 0; i < a.length; i++) {
        // if (a[i] > sLargest && a[i] != largest) {
        // sLargest = a[i];
        // }
        // }

        for (int i = 0; i < a.length; i++) {
            if (a[i] > largest) {
                sLargest = largest;
                largest = a[i];
            } else if (a[i] < largest && a[i] > sLargest) {
                sLargest = a[i];
            }
        }
        return sLargest;
    }

    public static boolean isArraySorted(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i + 1] < a[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean arraySortedOrNot(List<Integer> arr) {

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) < arr.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static int removeDuplicates(int a[]) {
        int k = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }

        int i = 0;
        for (Integer integer : set) {
            a[i] = integer;
            i++;
        }
        k = set.size();
        return k;
    }

    public static int removeDuplicates2pointer(int a[]) {
        int i = 0;
        for (int j = 1; j < a.length; j++) {
            if (a[j] != a[i]) {
                a[i + 1] = a[j];
                i++;
            }
        }
        return i + 1;
    }

    public static void leftRotateArrayByOne(int arr[]) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
    }

    public static void leftRotateByKPlaces(int arr[], int k) {
        int temp[] = new int[k];
        k = k % arr.length;

        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }

        for (int i = k; i < arr.length; i++) {
            arr[i - k] = arr[i];
        }

        for (int i = arr.length - k; i < arr.length; i++) {
            arr[i] = temp[i - (arr.length - k)];
        }
    }

    public static void leftRotateByKPlacesByReversing(int arr[], int k) {
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }

    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void reverse(int arr[], int start, int end) {
        while (start <= end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void moveZeroesToTheEnd(int arr[]) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                temp.add(arr[i]);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i < temp.size()) {
                arr[i] = temp.get(i);
            } else {
                arr[i] = 0;
            }
        }
    }

    public static void moveZeroesToTheEnd2Pointer(int arr[]) {
        int j = -1;
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] == 0) {
                j = index;
                break;
            }
        }
        if (j == -1) {
            System.out.println("No zeroes are there in the Array");
            return;
        }
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, j, i);
                j++;
            }
        }
    }

    public static int linearSearch(int arr[], int num) {
        int pos = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return pos = i;
            }
        }
        return pos;
    }

    public static void main(String[] args) {

        int arr[] = { 1, 0, 2, 0, 3, 4, 5, 0 };
        logArray(arr);
        // System.out.println("Largest element is " + secondLargest(arr));
        // System.out.println("Given array is sorted " + isArraySorted(arr));
        // System.out.println("After removing duplciates unique elements are " +
        // removeDuplicates(arr));
        // System.out.println("After removing duplciates using two pointer " +
        // removeDuplicates2pointer(arr));
        // leftRotateArrayByOne(arr);
        // leftRotateByKPlaces(arr, 2);
        // leftRotateByKPlacesByReversing(arr, 2);
        // System.out.println("rotating array left by K places");
        // moveZeroesToTheEnd2Pointer(arr);
        System.out.println("value 3 found at position "+linearSearch(arr, 9));
        logArray(arr);
    }

    public static void logArray(int[] arr) {
        System.out.println("Given Array is : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}