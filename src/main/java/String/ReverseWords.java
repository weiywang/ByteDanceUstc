package main.java.String;

public class ReverseWords {
    public static String reverseWords(String s) {
        s = s.trim();
        StringBuilder[] tempStringBuilder = new StringBuilder[s.length()];
        StringBuilder res = new StringBuilder();
        char[] str = s.toCharArray();
        int j = 0;
        for(int i = 0; i < str.length; i++){
            tempStringBuilder[j] = new StringBuilder();
            if(str[i] != ' ') tempStringBuilder[j].append(str[i]);
            else j++;
        }
        for(int i = tempStringBuilder.length - 1; i >= 0; i--){
            if(tempStringBuilder[i] != null){
                res.append(tempStringBuilder[i]);
            }
        }
        return res.toString();
    }

    public static void main(String[] Args){
        String s = "the sky is blue";
        String res = reverseWords(s);
        System.out.println(res);
    }
}
