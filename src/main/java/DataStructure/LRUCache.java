package main.java.DataStructure;

import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

public class LRUCache {
    Map<Integer, Integer> map;
    Stack<Integer> stack;
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        stack = new Stack<>();
        size = capacity;
    }

    public int get(int key) {
        if(!stack.contains(key)){
            return -1;
        }
        stack.remove(Integer.valueOf(key));
        stack.push(Integer.valueOf(key));
        return map.get(key);
    }

    public void put(int key, int value) {
        if(stack.contains(key)){
            stack.remove(Integer.valueOf(key));
        } else{
            if(stack.size() == size){
                int count = stack.remove(0);
                map.remove(Integer.valueOf(count));
            }
        }
        stack.push(key);
        map.put(key, value);
    }
}
