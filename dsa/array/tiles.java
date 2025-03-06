//on a floor of m*n the tiles 1*n has to be placed such that the floor is covered     
package dsa.array;

import java.util.*;

public class tiles {
    static int tile(int m, int n) {
        if (m == n) { // only two ways either both horizontal or vertical
            return 2;
        }
        if (m < n) { // if the rows and lesser than the columns of tile then only one way to place it
                     // horizontally
            return 1;
        }
        int hor = tile(m - 1, n);
        int ver = tile(m - n, n);
        return hor + ver;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int ways = tile(m, n);
        System.out.println(ways);
        sc.close();
    }

}
