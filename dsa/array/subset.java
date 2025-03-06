package dsa.array;

import java.util.ArrayList;

public class subset {
    void print(ArrayList<Integer> list){
        for(int i:list){
            System.out.print(i);
        }
    }

    void subsets(int[] a, ArrayList<Integer> sub) {
        if (a.length == 0) {
            print(sub);
            return;
        }
        for(int i=0;i<a.length;i++){
             
        }
    }

public static void main(String[] args) {
    int[] a={1,2,3};
    subsets(int[]a,new ArrayList<>());
}
}
