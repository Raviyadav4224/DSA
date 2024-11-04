package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

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

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {

            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;

                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    long sum = 0;
                    sum += nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        result.add(temp);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    }
                }
            }
        }
        return result;
    }

    public static void largestSubArrayWith0Sum(int arr[], int target) {

        // using Hashing
        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        int sum = 0, maxLength = -1, count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == target) {
                maxLength = i + 1;
                count++;
            }
            int remaining = sum - target;
            if (prefixSum.containsKey(remaining)) {
                int len = i - prefixSum.get(remaining);
                maxLength = Math.max(maxLength, len);
                count++;
            }
            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }
        }
        System.out.println("Max length is " + maxLength + " " + "Total Subarrays are " + count);
    }

    public static void numberOfSubarraysWithGivenSumK(int arr[], int k) {

        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        prefixSum.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            sum ^= arr[i];

            if (prefixSum.containsKey(sum ^ k)) {
                count += prefixSum.get(sum ^ k);
            }

            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, 1);
            } else {
                prefixSum.put(sum, prefixSum.get(sum) + 1);
            }

            // prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        System.out.println("number of subarrays are " + count);
    }

    public static int mergeSort(int arr[], int low, int high) {
        int count = 0;

        if (low >= high) {
            return count;
        }

        int mid = (low + high) / 2;
        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);
        count += merge(arr, low, mid, high);
        return count;
    }

    public static void logArray(int a[]) {
        for (int j : a) {
            System.out.print(" " + j);
        }
    }

    public static int merge(int arr[], int low, int mid, int high) {
        int left = low, right = mid + 1;
        int index = 0, count = 0, result[] = new int[high - low + 1];
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                result[index] = arr[left];
                left++;
                count += (mid - left + 1);
            } else {
                result[index] = arr[right];
                right++;
            }
            index++;
        }

        while (left <= mid) {
            result[index] = arr[left];
            left++;
            index++;
        }
        while (right <= high) {
            result[index] = arr[right];
            right++;
            index++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = result[i - low];
        }
        return count;
    }

    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {

        List<List<Integer>> ans = new ArrayList<>();
        // Brute force
        Arrays.sort(arr, (int a[], int b[]) -> a[0] - b[0]);
        // for (int i = 0; i < arr.length; i++) {
        // int start = arr[i][0];
        // int end = arr[i][1];
        // if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
        // continue;
        // }
        // for (int j = i + 1; j < arr.length; j++) {
        // if (arr[j][0] <= end) {
        // end = Math.max(end, arr[j][0]);
        // } else {
        // break;
        // }
        // }
        // ans.add(Arrays.asList(start, end));
        // }
        // System.out.println(ans);

        // optimal solution
        // [[1,3],[2,6],[5,10],[15,18]]
        for (int i = 0; i < arr.length; i++) {

            // When no ans is present and if ongerval doesn't overlaps
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1]));
            }
            // when it overlaps;
            else {
                ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {

        int arr1[] = { 5, 4, 3, 2, 1 };
        // System.out.println("ncr is " + ncr(5 - 1, 2 - 1));
        // printRowOfPascalTraiangle(5);
        // pascalsTriangle(5);
        // threeSum(arr1, 6);
        // largestSubArrayWith0Sum(arr1, 15);
        // numberOfSubarraysWithGivenSumK(arr1, 6);
        // logArray(arr1);
        // int c = mergeSort(arr1, 0, arr1.length - 1);
        // System.err.println("Count is " + c);
        // logArray(arr1);
        int arr[][] = new int[3][2];
        int m = arr.length;
        int n = arr[0].length;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Enter a number ");
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        mergeOverlappingIntervals(arr);
    }
}
