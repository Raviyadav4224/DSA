package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ArraysHard {

    // TimeComplexity -> O(r)
    public static int ncr(int n, int r) {
        int ans = 1;
        for (int i = 0; i < r; i++) {
            ans = ans * (n - i);
            ans = ans / (i + 1);
        }
        return ans;
    }

    // TimeComplexity -> O(N)
    public static void printRowOfPascalTraiangle(int rows) {
        int ans = 1;
        if (rows == 1) {
            System.out.println(ans + " ");
            return;
        }
        System.out.print(ans + " ");
        for (int i = 1; i < rows; i++) {
            ans = ans * (rows - i);
            ans = ans / (i);
            System.out.print(ans + " ");
        }
        System.out.println("");
    }

    public static void pascalsTriangle(int rowLength) {

        for (int i = 1; i <= rowLength; i++) {
            printRowOfPascalTraiangle(i);
        }
    }

    public static void twoSum(int arr[], int target) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        int sum = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            System.out.println("sum is " + sum);
            int remaining = target - arr[i];

            if (prefixSum.containsKey(remaining)) {
                List<Integer> temp = new ArrayList<>();
                temp.add(prefixSum.get(remaining));
                temp.add(i);
                ans.add(temp);
            }
            prefixSum.put(arr[i], i);
        }
        System.out.println(ans);

    }

    public static void twoSumUsing2Pointer(int arr[], int target) {

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println("Indexes are " + left + " " + right);
                left++;
            } else if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            }
        }
    }

    public static void threeSum(int arr[], int target) {

        int sum = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {

            if (i != 0 && arr[i] == arr[i - 1])
                continue;

            int j = i + 1, k = arr.length - 1;

            while (j < k) {
                sum = arr[i] + arr[j] + arr[k];
                if (sum > target) {
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    System.out.println("Elements are [" + arr[i] + " " + arr[j] + " " + arr[k] + "]");
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1])
                        j++;
                    while (j < k && arr[k] == arr[k + 1])
                        k--;
                }
            }

        }
    }

    public static void main(String[] args) {

        int arr1[] = { -1, 0, 1, 2, -1, -4 };
        // System.out.println("ncr is " + ncr(5 - 1, 2 - 1));
        // printRowOfPascalTraiangle(5);
        // pascalsTriangle(5);
        threeSum(arr1, 0);
    }
}
