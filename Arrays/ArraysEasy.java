package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;

public class ArraysEasy {

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

    public static List<Integer> union2pointer(int arr1[], int arr2[]) {
        List<Integer> union = new ArrayList<>();
        int n1 = arr1.length;
        int n2 = arr2.length;

        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                    i++;
                }
            } else {
                if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                    j++;
                }
            }
        }

        return union;
    }

    public static List<Integer> intersection2pointer(int arr1[], int arr2[]) {
        List<Integer> intersection = new ArrayList<>();
        int n1 = arr1.length;
        int n2 = arr2.length;

        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] > arr2[j]) {
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else {
                intersection.add(arr1[i]);
                i++;
                j++;
            }
        }

        return intersection;
    }

    public static int missingNumber(int arr[], int n) {
        for (int i = 1; i <= n; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == i) {
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                return i;
            }
        }
        return 0;
    }

    public static int missingNumberHashing(int arr[], int n) {
        int hash[] = new int[n + 1];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]] = hash[arr[i]] + 1;
        }
        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }
        return 0;
    }

    public static int missingNumberSummation(int arr[], int n) {

        int actualSum = (n * (n + 1)) / 2;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }

        return actualSum - sum;
    }

    public static int missingNumberXOR(int arr[], int n) {

        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < n - 1; i++) {
            xor1 = xor1 ^ (i + 1);
            xor2 = xor2 ^ arr[i];
        }
        xor1 = xor1 ^ n;
        return xor1 ^ xor2;
    }

    public static void maximumConsecutiveOnes(int arr[]) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        System.out.println("consecutive ones are " + max);
    }

    public static void numberAppearingones(int arr[]) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }
        System.out.println("Number that appear twice is " + xor);

    }

    public static void LongestSubArray(int arr[], int d) {
        int longestLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                // Summation
                // for (int k = i; k <= j; k++) {
                // sum = sum + arr[k];
                // }
                sum = sum + arr[j];

                if (sum == d) {
                    longestLength = Math.max(longestLength, j - i + 1);
                }
            }
        }
        System.out.println(longestLength);
    }

    public static int LongestSubArrayUsingHashing(int arr[], int k) {

        HashMap<Integer, Integer> prefixSum = new HashMap<Integer, Integer>();
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];

            if (sum == k) {
                maxLength = i + 1;
            }

            int remaining = sum - k;
            if (prefixSum.containsKey(remaining)) {
                int len = i - prefixSum.get(remaining);
                maxLength = Math.max(maxLength, len);
            }

            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }
        }
        return maxLength;
    }

    public static int LongestSubArrayUsing2Pointer(int arr[], int k) {

        int sum = 0;
        int maxLength = 0;
        int i = 0;
        int j = 0;
        
        while (j < arr.length) {
            sum = sum + arr[j];
            if (sum == k) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
            while (sum > k && i <= j) {
                sum = sum - arr[i];
                i++;
            }
            j++;
        }

        return maxLength;
    }

    public static void main(String[] args) {

        int arr[] = { 10, 5, 2, 7, 1, 9 };
        int arr2[] = { 1, 1, 2, 3, 3, 4, 4 };
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
        // System.out.println("value 3 found at position " + linearSearch(arr, 9));
        // System.out.println("Union of two arrays is " + intersection2pointer(arr,
        // arr2));
        // System.out.println("The missing number is " + missingNumberXOR(arr, 6));
        // maximumConsecutiveOnes(arr);
        // numberAppearingones(arr2);
        // LongestSubArray(arr, 15);
        System.out.println("Maximum length of subarray with sum 15 is " + LongestSubArrayUsing2Pointer(arr, 15));

        // logArray(arr);
    }

    public static void logArray(int[] arr) {
        System.out.println("Given Array is : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}