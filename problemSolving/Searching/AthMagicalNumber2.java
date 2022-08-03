package Searching;

public class AthMagicalNumber2 {
    public int solve(int A, int B, int C) {
//1.Find low and high range
//2.Apply Binary search.Find how many no's will be divisible by a&b till mid.
//3.Based on this change the low or high values.
//Formula in this problem to find total no's will be divisible by a& b till mid: A | B=(x/a)+(x/b)-(x/(lcm(a,b)))
//Formula to find LCM :a/gcd(a,b)*b;
        long ans = 0;
        long left = Math.min((long) B, (long) C);
        long right = (long) 1e15;
        long lcm = lcm(B, C);
        while (left <= right) {
            long mid = (left + right) / 2;
            long multipleOfB = mid / B;
            long multipleOfC = mid / C;
            long multipleOfBOrC = mid / lcm;
            long totalDivisibleTillMid = (multipleOfB + multipleOfC) - multipleOfBOrC;
            if (totalDivisibleTillMid >= A) {
                ans = mid;
                ;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) (ans % 1000000007);
    }

    //Method to return gcd
    public int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    public int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }
}
