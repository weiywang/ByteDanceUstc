package main.java.String;

import java.util.Arrays;

public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int lengthOne = s1.length();
        int lengthTwo = s2.length();
        int[] charOne = new int[26];
        int[] charTwo = new int[26];

        for(char c : s1.toCharArray()){
            charOne[c - 'a']++;
        }

        for(int i = 0; i < lengthTwo; i++){
            if(i >= lengthOne){
                --charTwo[s2.charAt(i - lengthOne) - 'a'];
            }
            charTwo[s2.toCharArray()[i] - 'a']++;
            if(Arrays.equals(charOne, charTwo)){
                return true;
            }
        }
        return false;
    }
}
