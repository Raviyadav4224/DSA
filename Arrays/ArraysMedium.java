package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraysMedium {
    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void logArray(int[] arr1) {
        System.out.println();
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static boolean TwoSumEqualToTargetK(int arr1[], int target) {

        boolean isEqualToTarget = false;

        for (int i = 0; i < arr1.length; i++) {

            // for (int j = 0; j < arr2.length; j++) {
            // if (i == j)
            // continue;
            // if (arr1[i] + arr2[j] == target) {
            // isEqualToTarget = true;
            // System.out.println("index are " + i + " " + j);
            // }
            // }
            for (int j = i + 1; j < arr1.length; j++) {
                if (arr1[i] + arr1[j] == target) {
                    isEqualToTarget = true;
                    System.out.println("index are " + i + " " + j);
                }
            }
        }
        return isEqualToTarget;
    }

    public static void TwoSumEqualToTargetKUsingHashing(int arr[], int target) {

        HashMap<Integer, Integer> sum = new HashMap<>();
        int ans[] = { -1, -1 };
        for (int i = 0; i < arr.length; i++) {
            int required = target - arr[i];

            if (sum.containsKey(required)) {
                ans[0] = sum.get(required);
                ans[1] = i;
            }
            sum.put(arr[i], i);
        }

        System.out.println(ans[0] + " " + ans[1]);
    }

    public static void TwoSumEqualToTargetKUsing2Pointer(int arr[], int target) {

        int sum = 0, left = 0, right = arr.length - 1;

        while (left < right) {
            sum = arr[left] + arr[right];
            if (sum == target) {
                System.out.println("Sum match found" + left + " " + right);
                left++;
            } else if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            }
        }

    }

    public static void merge012s(int arr[]) {

        int zeroes = 0, ones = 0, twos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroes++;
            } else if (arr[i] == 1) {
                ones++;
            } else {
                twos++;
            }
        }

        System.out.println("z o t " + zeroes + ones + twos);
        for (int i = 0; i < zeroes; i++) {
            arr[i] = 0;
        }
        for (int i = zeroes; i < (zeroes + ones); i++) {
            arr[i] = 1;
        }
        for (int i = zeroes + ones; i < (zeroes + ones + twos); i++) {
            arr[i] = 2;
        }
        logArray(arr);
    }

    public static void dutchNationFlagAlgorithm(int arr[]) {

        int low = 0, mid = 0, high = arr.length - 1;

        while (mid <= high) {

            if (arr[mid] == 0) {
                swap(arr, mid, low);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else if (arr[mid] == 2) {
                swap(arr, mid, high);
                high--;
            }
        }
        logArray(arr);
    }

    public static int majorityElementNBy2(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    count++;
                }
            }
            if (count > arr.length / 2) {
                return arr[i];
            }
        }
        return -1;
    }

    public static int majorityElementNBy2UsingHashing(int arr[]) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (freq.containsKey(arr[i])) {
                freq.put(arr[i], freq.get(arr[i]) + 1);
            } else {
                freq.put(arr[i], 1);
            }
        }
        System.out.println(freq);
        for (Map.Entry<Integer, Integer> it : freq.entrySet()) {
            if (it.getValue() > (arr.length / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }

    public static void mooreVotingAlgorithm(int arr[]) {

        int count = 0;
        int element = 0;

        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                count = 1;
                element = arr[i];
            } else if (arr[i] != element) {
                count--;
            } else if (arr[i] == element) {
                count++;
            }
        }

        // if given that the array contains majority element this step is not required
        int count1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                count1++;
            }
        }
        if (count1 > arr.length / 2) {
            System.out.println("Majority element is " + element);
        } else {
            System.out.println("No majority element");
        }
    }

    public static void maximumSubArraySum(int arr[]) {

        // int max = 0;
        // for (int i = 0; i < arr.length; i++) {
        // int sum = 0;
        // for (int j = i; j < arr.length; j++) {
        // sum += arr[j];
        // if (sum > max) {
        // max = sum;
        // }
        // }
        // }
        // System.out.println("Maximum subarray sum is " + max);

        // Kadane's algorthm
        int max = 0, sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println("Maximum subarray sum is " + max);

    }

    public static void KadaneAlgorithm(int arr[]) {
        int max = 0, sum = 0, start = 0, startIndex = -1, endIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) {
                start = i;
            }

            sum += arr[i];

            if (sum > max) {
                max = sum;
                startIndex = start;
                endIndex = i;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println("Maximum subarray sum is " + max);
        System.out.println("Start index and end index is" + startIndex + " " + endIndex);
    }

    public static void buySellStocks(int arr[]) {

        int min = arr[0], profit = 0, cost = 0;

        for (int i = 1; i < arr.length; i++) {

            cost = arr[i] - min;
            profit = Math.max(cost, profit);
            min = Math.min(min, arr[i]);
        }
        System.out.println("Maximum profitn is " + profit);
    }

    public static void rearrangeArray(int arr[]) {
        // [3,1,-2,-5,2,-4]
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                pos.add(arr[i]);
            } else {
                neg.add(arr[i]);
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {
            arr[2 * i] = pos.get(i);
            arr[2 * i + 1] = neg.get(i);
        }
        logArray(arr);
    }

    public static void rearrangeArrayOptimal(int arr[]) {

        int ans[] = new int[arr.length];
        // [3,1,-2,-5,2,-4]
        int pos = 0;
        int neg = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                ans[pos] = arr[i];
                pos += 2;
            } else {
                ans[neg] = arr[i];
                neg += 2;
            }
        }
        logArray(ans);
    }

    public static void rearrangeArrayPosNotEqualToNeg(int arr[]) {
        // [3,1,-2,-5,2,-4,6,8]
        // [3,1,2,6,8]
        // [-2,-5,-4]
        // 3 , -2,1,-5,2,-4
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                pos.add(arr[i]);
            } else {
                neg.add(arr[i]);
            }
        }

        if (pos.size() > neg.size()) {
            int index = 0;
            for (int i = 0; i < neg.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[2 * i + 1] = neg.get(i);
                index++;
            }
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[index] = pos.get(i);
            }
        } else {
            int index = 0;
            for (int i = 0; i < pos.size(); i++) {
                arr[2 * i] = neg.get(i);
                arr[2 * i + 1] = pos.get(i);
                index++;
            }
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index] = neg.get(i);
            }
        }
        logArray(arr);
    }

    public static void main(String[] args) {

        int arr1[] = { 3, 1, -2, -5, 2, 4 };
        int arr2[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        logArray(arr1);
        logArray(arr2);

        // TwoSumEqualToTargetK(arr1, 9));
        // TwoSumEqualToTargetKUsingHashing(arr1, 111);
        // TwoSumEqualToTargetKUsing2Pointer(arr1, 9);
        // merge012s(arr2);
        // dutchNationFlagAlgorithm(arr2);
        // System.out.println("Majorityn element is " + majorityElementNBy2(arr2));
        // System.out.println("Majorityn element is " +
        // majorityElementNBy2UsingHashing(arr2));
        // mooreVotingAlgorithm(arr2);
        // maximumSubArraySum(arr2);
        // KadaneAlgorithm(arr2);
        // buySellStocks(arr1);
        // rearrangeArray(arr1);
        rearrangeArrayPosNotEqualToNeg(arr1);
    }

}
