package Basics;

import java.util.HashMap;

public class Hashing {

    // TimeComplexity -> O(N)
    // SpaceComplexity -> O(k)
    public static void hashing(int arr[], int hash[]) {

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]] += 1;
        }
    }

    // TimeComplexity -> O(1)
    // SpaceComplexity -> O(k)
    public static void hashingUsingHashmap(int arr[], HashMap<Integer, Integer> hashMap) {
        // HashMap<Number, Number> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            } else {
                hashMap.put(arr[i], 1);
            }
        }
    }

    public static void main(String[] args) {

    }
}
