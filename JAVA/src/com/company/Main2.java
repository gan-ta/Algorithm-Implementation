package com.company;

class Solution2 {
    public String solution(String encrypted_text, String key, int rotation) {
        String answer = "";
        String temp = "";

        //rotation해독
        String a;
        String b;
        if(rotation < 0){
            rotation = -1 * rotation;
            rotation = rotation % encrypted_text.length();
            a = encrypted_text.substring(0, encrypted_text.length() - rotation);
            b = encrypted_text.substring(encrypted_text.length() - rotation, encrypted_text.length());
            temp = b + a;
        }
        else if(rotation > 0){
            rotation = rotation % encrypted_text.length();
            a = encrypted_text.substring(0, rotation);
            b = encrypted_text.substring(rotation, encrypted_text.length());
            temp = b + a;
        }
        else{
            temp = encrypted_text;
        }

        answer = dectypt(temp,key);

        return answer;
    }

    public String dectypt(String str, String key){

        String newStr = "";

        for(int i = 0 ; i < str.length(); i++){
            int def = key.charAt(i) - 'a' + 1;
            int change = str.charAt(i) - def;

            if(change < 97){
                change = 123 - (97 - change);
            }

            newStr += (char)change;
        }

        return newStr;
    }
}

public class Main2 {
//    public static void main(String[] args) {
//        Solution2 solution2 = new Solution2();
//        solution2.solution("qyyigoptvfb", "abcdefghijk",3);
//    }
}
