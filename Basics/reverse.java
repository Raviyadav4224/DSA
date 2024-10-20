package Basics;

// TimeComplexity O(N)
public class reverse {
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void reverseLoop(int a[]) {
        for (int i = 0; i <= a.length / 2; i++) {
            swap(a, i, a.length - 1 - i);
        }
    }

    public static void reverseRecurse(int a[],int left) {
        if (left >= a.length / 2) {
            return;
        }
        swap(a, left, a.length-1-left);
        reverseRecurse(a, left+1);
    }
    public static void main(String[] args) {
        
    }
}
