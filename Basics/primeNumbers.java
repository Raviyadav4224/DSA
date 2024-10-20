package Basics;

// TimeComplexity - O(sqrt(N))
public class primeNumbers {
    public static boolean primeNumber(int num) {
        int count = 0;

        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (num / i != 1) {
                    count++;
                }
            }
        }
        if (count == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}

// Prime numbers - has exactly two factors - 1 and itself
// TimeComplexity - O(sqrt(N))
// Loop till Sqrt(N)
// i=1;i<Math.sqrt(n);i++
// or
// i=1;i*i<=n;i++