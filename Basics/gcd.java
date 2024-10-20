package Basics;

// TimeComplexity - O(log to the base fyi (MIN(a,b)))
public class gcd {
    public static int gcd(int greater, int smaller) {

        while (greater > 0 && smaller > 0) {
            if (greater > smaller) {
                greater = greater % smaller;
            } else {
                smaller = smaller % greater;
            }
        }
        if (greater == 0) {
            return smaller;
        }
        return greater;
    }

    public static void main(String[] args) {
        
    }
}

// Notes

// GCD(greater,smaller) * LCM(greater,smaller)=greater*smaller
