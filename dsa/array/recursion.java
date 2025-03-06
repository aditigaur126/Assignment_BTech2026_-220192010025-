package dsa.array;

import java.util.ArrayList;

public class recursion {
    static void subSum(int[] a, ArrayList<Integer> list, int i, int n, int sum) {
        if (i > n) {

            if (sum == 0) {
                for (int x : list) {
                    System.out.print(x);

                }
                System.out.println();
            }

            return;
        }
        if (a[i] <= sum) { // this method can repeat a single element
            list.add(a[i]);
            subSum(a, list, i, n, sum - a[i]);
            list.remove(list.size() - 1);
        }

        subSum(a, list, i + 1, n, sum);

    }

    static void subSum2(int[] a, ArrayList<Integer> list, int i, int n, int sum) {
        if (i > n) {

            if (sum == 0) {
                for (int x : list) {
                    System.out.print(x);

                }
                System.out.println();
            }

            return;
        }
        // this method cannot repeat a single element
        list.add(a[i]);
        subSum2(a, list, i + 1, n, sum - a[i]);
        list.remove(list.size() - 1);
        subSum2(a, list, i + 1, n, sum + a[i]);

    }

    static void sub(int[] a, ArrayList<Integer> list, int i, int n) {
        if (i > n) {
            if (list.size() == 0) {
                System.out.println("[]");

            }
            for (int x : list) {
                System.out.print(x);
            }
            System.out.println();
            return;
        }
        list.add(a[i]);
        sub(a, list, i + 1, n);
        list.remove(list.size() - 1);
        sub(a, list, i + 1, n);
    }

    public static void main(String[] args) {
        int[] a = { 1, 2 };
        ArrayList<Integer> list = new ArrayList<>();
        sub(a, list, 0, a.length - 1);
        subSum(a, list, 0, a.length - 1, 3);
        subSum2(a, list, 0, a.length - 1, 3);
    }
}
