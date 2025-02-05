package dsa.array;

import java.util.*;

//Arrays.sort(arr) krk last se bhi print kra skte the

public class largest {
    static int max(int[] arr) {
        int n = arr.length;

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > ans) {
                ans = arr[i];
            }
        }
        return ans;
    }

    static int secl(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int smax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                smax = max;
                max = arr[i];

            } else if (arr[i] < max && arr[i] > smax) {
                smax = arr[i];
            }
        }
        return smax;

    }

    static int thirdl(int[] arr) {
        int n = arr.length;
        int smax = secl(arr);
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < smax && arr[i] > ans) {
                ans = arr[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("size:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("largest element is:" + max(arr));
        System.out.println("second largest element is:" + secl(arr));
        System.out.println("third largest element is:" + thirdl(arr));
        sc.close();
    }
}
