package main.java.DataStructure;

import java.util.*;

public class AllOne {

    private Map<String, Bucket> data = new HashMap<>();
    private List<Bucket> bucketsList = new ArrayList<>();

    /** Initialize your data structure here. */
    public AllOne() {

    }

    public static class Bucket{
        private int value;
        private Set<String> keys = new HashSet<>();
        private Bucket pre;
        private Bucket next;

        public Bucket(int value){
            this.value = value;
        }
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(data.containsKey(key)){
            Bucket bucket = data.get(key);
            bucket.keys.remove(key);

            if(bucket.next == null){
                bucket.next = new Bucket(bucket.value + 1);
                bucket.next.pre = bucket;
                bucketsList.add(bucket.next);
            }

            bucket.next.keys.add(key);
            data.put(key, bucket.next);
        }else{
            if(bucketsList.size() == 0){
                bucketsList.add(new Bucket(1));
            }
            Bucket bucket = bucketsList.get(0);
            bucket.keys.add(key);
            data.put(key, bucket);
        }


    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!data.containsKey(key)){
            return;
        }
        if(data.get(key).pre == null){
            data.get(key).keys.remove(key);
            data.remove(key);
        }else{
            data.get(key).pre.keys.add(key);
            data.get(key).keys.remove(key);
            data.put(key, data.get(key).pre);
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(bucketsList.size() == 0){
            return "";
        }
        for(int i = bucketsList.size() - 1; i >= 0; i--) {
            if (!bucketsList.get(i).keys.isEmpty()) {
                Iterator<String> iterator = bucketsList.get(i).keys.iterator();
                if (iterator.hasNext()) {
                    return iterator.next();
                }else{
                    return "";
                }
            }
        }
        return "";
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(bucketsList.size() == 0){
            return "";
        }
        for(Bucket bucket : bucketsList) {
            if (!bucket.keys.isEmpty()) {
                Iterator<String> iterator = bucket.keys.iterator();
                if (iterator.hasNext()) {
                    return iterator.next();
                }else{
                    return "";
                }
            }
        }
        return "";
    }
}
