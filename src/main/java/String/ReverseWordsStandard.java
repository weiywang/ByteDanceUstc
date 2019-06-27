package main.java.String;

public class ReverseWordsStandard {
    public static String reverseWords(String s) {
        String trimed = s.trim();
        String[] splits = trimed.split(" ");

        StringBuilder res = new StringBuilder();
        for(int i = splits.length - 1; i >= 0; i--){
            if(!splits[i].trim().isEmpty()){
                res.append(splits[i].trim()).append(" ");
            }
        }
        return res.toString().trim();
    }

    public static void main(String[] Args){
        String s = "the sky is blue";
        String res = reverseWords(s);
        System.out.println(res);
    }
}
