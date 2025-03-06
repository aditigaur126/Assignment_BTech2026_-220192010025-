package dsa.array;

import java.util.Scanner;

public class paths {

    /********************************************************
     * METHOD 1
     *********************************************************************/

    int count = 0;

    void path(int i, int j, int m, int n) {

        if (i == m - 1 && j == n - 1) {
            count++;
            return;
        }
        if (i + 1 < m) {
            path(i + 1, j, m, n);
        }
        if (j + 1 < n) {
            path(i, j + 1, m, n);
        }
    }

    /**********************************************************************
     * METHOD 2
     *****************************************************/
    int path2(int i, int j, int m, int n) {
        if (i == m || j == n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        int down = path2(i + 1, j, m, n);
        int right = path2(i, j + 1, m, n);
        return down + right;
    }

    public static void main(String[] args) {
        paths p = new paths();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        // p.path(0, 0, m, n);
        int count = p.path2(0, 0, m, n);
        System.out.println(count); // right and downward movement only
        sc.close();
    }

}
