package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BinarySearch1D {

    public static int binarySearch(int arr[], int k) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int binarySearchUsingRecursion(int arr[], int low, int high, int k) {
        if (low >= high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == k) {
            return mid;
        } else if (arr[mid] < k) {
            return binarySearchUsingRecursion(arr, low, mid - 1, k);
        } else {
            return binarySearchUsingRecursion(arr, mid + 1, high, k);
        }
    }

    public static int binarySearchLowerBound(int arr[], int k) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int binarySearchFirstOccurence(int arr[], int target) {

        int low = 0, high = arr.length - 1;

        int first = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("First occurence of " + target + " is " + first);
        return first;
    }

    public static int binarySearchLastOccurence(int arr[], int target) {

        int low = 0, high = arr.length - 1;

        int last = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Last occurence of " + target + " is " + last);
        return last;
    }

    public static int searchInSortedRotatedArrayUsingBinarySearch(int arr[], int target) {

        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            // identify the sorted half
            // 4,5,6,7,0,1,2
            else if (arr[low] <= arr[mid]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (arr[mid] <= target && target <= arr[high]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int mimimumInSortedArrayUsingBinarySearch(int arr[]) {
        int low = 0, high = arr.length - 1, ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            // When we get a sorted portion no need to again divide the array in two halves
            if (arr[low] <= arr[high]) {
                ans = Math.min(ans, arr[low]);
                break;
            }
            if (arr[low] <= arr[mid]) {
                ans = Math.min(ans, arr[low]);
                low = mid + 1;
            } else {
                ans = Math.min(ans, arr[mid]);
                high = mid - 1;
            }
        }
        return ans;
    }

    public static int singleElement(int arr[]) {
        int n = arr.length;
        int low = 1, high = n - 2;

        if (n == 1) {
            return arr[0];
        }
        if (arr[0] != arr[1]) {
            return arr[0];
        }
        if (arr[n - 1] != arr[n - 2]) {
            return arr[n - 1];
        }
        // 1 1 2 2 3 3 4 5 5 6 6
        // even odd
        // odd even
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == arr[mid - 1] && arr[mid] == arr[mid + 1]) {
                return arr[mid];
            } else if ((mid % 2 == 0 && arr[mid] == arr[mid + 1]) || (mid % 2 == 1 && arr[mid] == arr[mid - 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

    public static int peakElement(int arr[]) {

        int n = arr.length - 1;
        int low = 0, high = n - 2;

        if (n == 1) {
            return arr[0];
        }
        if (arr[0] > arr[1]) {
            return arr[0];
        }
        if (arr[n - 1] > arr[n - 2]) {
            return arr[n - 1];
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return arr[mid];
            }
            // left half has increasing order
            else if (arr[mid - 1] > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // String s = "asdas";
        // System.out.println(s.charAt(1));
        int arr1[] = { 4, 5, 6, 7, 1, 2 };
        // int c = binarySearch(arr1, 0, arr1.length - 1, 5);
        // System.out.println("C is " + c);
        // Set<Integer> res = new HashSet<>();
        // res.add(null);
        // HashMap<Integer, Integer> freq = new HashMap<>();
        // List<Integer> res1 = new ArrayList<>();
        // System.out.println(freq);
        // for (Map.Entry<Integer, Integer> value : freq.entrySet()) {
        // if (value.getValue() >= 2) {
        // res1.add(value.getKey());
        // }
        // }
        // System.out.println("element 5 found at index " + binarySearchLowerBound(arr1,
        // 11));
        // int first = binarySearchFirstOccurence(arr1, 8);
        // int last = binarySearchLastOccurence(arr1, 8);
        // System.out.println("Total occurences are " + (last - first));
        // System.out.println("Smallest is " +
        // mimimumInSortedArrayUsingBinarySearch(arr1));
        System.out.println("Single is " + singleElement(arr1));

    }
}