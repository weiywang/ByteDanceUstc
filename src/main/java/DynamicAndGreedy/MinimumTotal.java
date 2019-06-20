package main.java.DynamicAndGreedy;

import java.util.ArrayList;
import java.util.List;

public class MinimumTotal {
    public static int minimumTotal(List<List<Integer>> triangle){
         for(int i = triangle.size() - 2; i >= 0; i--){
             for(int j = 0; j < triangle.get(i).size(); j++){
                 triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
             }
         }
         return triangle.get(0).get(0);
    }

    public static void main(String[] Args){
        List<List<Integer>> triangle = new ArrayList<>();
        ArrayList<Integer> triangle1 = new ArrayList<Integer>(){{
            add(2);
        }};
        ArrayList<Integer> triangle2 = new ArrayList<Integer>(){{
            add(3);
            add(4);
        }};
        ArrayList<Integer> triangle3 = new ArrayList<Integer>(){{
            add(6);
            add(5);
            add(7);
        }};
        ArrayList<Integer> triangle4 = new ArrayList<Integer>(){{
            add(4);
            add(1);
            add(8);
            add(3);
        }};
        triangle.add(triangle1);
        triangle.add(triangle2);
        triangle.add(triangle3);
        triangle.add(triangle4);
        int result =  minimumTotal(triangle);
        System.out.println(result);
    }
}
