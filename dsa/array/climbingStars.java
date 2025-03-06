package dsa.array;

import java.util.*;

public class climbingStars {
    static int climbingStairs(int n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        return climbingStairs(n - 1) + climbingStairs(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = climbingStairs(n);
        System.out.print(count);

    }
}
