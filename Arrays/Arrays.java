package Arrays;

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

        for (int i = 0; i < arr.size()-1; i++) {
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

    public static void main(String[] args) {

        int arr[] = { 1, 1, 2, 2, 2, 3, 3 };
        logArray(arr);
        System.out.println("Largest element is " + secondLargest(arr));
        System.out.println("Given array is sorted " + isArraySorted(arr));
        System.out.println("After removing duplciates unique elements are " + removeDuplicates(arr));
        System.out.println("After removing duplciates using two pointer " + removeDuplicates2pointer(arr));
    }

    public static void logArray(int[] arr) {
        System.out.println("Given Array is : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}