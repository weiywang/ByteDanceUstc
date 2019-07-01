package main.java.String;

import java.util.Stack;

public class SimplifyPath {
    public static String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return path;
        }
        String[] list = path.split("/");
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < list.length; i++){
            if(list[i].equals(".") || list[i].isEmpty()){
                continue;
            } else if(!list[i].equals("..")){
                stack.push(list[i]);
            } else{
                if(!stack.empty()) {
                    stack.pop();
                }
            }
        }
        Stack<String> temp = new Stack<>();
        StringBuilder res = new StringBuilder();
        while(!stack.empty()){
            temp.push(stack.pop());
        }
        while(!temp.empty()){
            res.append("/" + temp.pop());
        }
        if(res.length() == 0){
            res.append("/");
        }
        return res.toString();
    }

    public static void main(String Args[]){
        String path = "/a//b////c/d//././/..";
        String res = simplifyPath(path);
        System.out.println(res);
    }
}
