package main.java.ArrayList;

import java.util.ArrayList;
import java.util.List;

public class GetPermutation {
    public static String getPermutation(int n, int k) {
        k--;
        int times = n - 1;
        int factorail = 1;
        List<Integer> list = new ArrayList<Integer>();
        StringBuilder res = new StringBuilder();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        for(int i = 2; i < n; i++){
            factorail *= i;
        }
        while(times >= 0){
            int index = k / factorail;
            res.append(list.get(index));
            list.remove(index);
            k = k % factorail;
            if(times != 0){
                factorail /= times;
            }
            times--;
        }
        return res.toString();
    }

    public static void main(String[] Args){
        System.out.println(getPermutation(3, 3));
    }
}
