package com.tdm.algorithm.eddie;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Stack<String> resultStack;

    static String str;
    static String bomb;
    static int bombLen;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        bomb = br.readLine();

        //Stack 으로해야함.
        resultStack = new Stack<>();
        bombLen = bomb.length();

        for(int i = 0 ; i < str.length(); i++) {
            char c = str.charAt(i);
            resultStack.push(""+c);
            if(resultStack.size() >= bombLen) {
                checkBomb();
            }
        }

        if(resultStack.size() == 0) {
            System.out.println("FRULA");
        } else {
            StringBuffer sb = new StringBuffer();
            for(String s : resultStack) {
                sb.append(s);
            }
            System.out.println(sb.toString());
        }

    }

    public static boolean checkBomb() {
        StringBuffer sb = new StringBuffer();
        List<String> temp = new ArrayList<>();
        for(int i = 0; i < bombLen; i++) {
            if(resultStack.size() > 0) {
                String pop = resultStack.pop();
                sb.insert(0, pop);
                temp.add(0,pop);
            }
        }
        if(sb.toString().equals(bomb)) {
            return true;
        } else {
            resultStack.addAll(temp);
        }
        return false;
    }
}


//시간초과
//        boolean found = true;
//        while (found) {
//            if(str.indexOf(bomb) != -1) {
//                String[] strArray = str.split(bomb);
//                StringBuffer sb = new StringBuffer();
//                for(String s: strArray) {
//                    sb.append(s);
//                }
//                str = sb.toString();
//            } else {
//                found = false;
//            }
//        }

//시간 초과
//        boolean found = true;
//        while (found) {
//            int len = str.length();
//            str = str.replaceAll(bomb, "");
//            int replaceLen = str.length();
//
//            if(len == replaceLen) {
//                found = false;
//            }
//        }
//        if(str.isEmpty()) {
//            str = "FRULA";
//        }
//        System.out.println(str);
