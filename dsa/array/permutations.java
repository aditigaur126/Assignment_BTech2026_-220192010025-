package dsa.array;

import java.util.*;

public class permutations {
    static void permutation(String st, String perm, int index) {
        if (st.length() == 0) {
            System.out.println(perm);
            return;
        }
        for (int i = 0; i < st.length(); i++) {
            char cur = st.charAt(i);
            String newS = st.substring(0, i) + st.substring(i + 1);
            permutation(newS, perm + cur, i);

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        permutation(sc.nextLine(), " ", 0);
        sc.close();
    }
}
