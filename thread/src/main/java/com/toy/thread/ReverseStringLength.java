package com.toy.thread;

public class ReverseStringLength {

    private String str;
    private int length;

    public ReverseStringLength(String str){
        this.str = str;
        this.length = str == null ? 0 : str.length();
    }

    public boolean calculateLength(String str){
        if(str == null){
            return false;
        }

        char[] chars = str.toCharArray();
        boolean result = true;
        for (int i = 0; i < chars.length / 2 ; i++) {
            if(chars[i] != chars[chars.length-i-1]){
                return false;
            }
        }

        return true;
    }

    public int getMaxLength(){
        if(str == null){
            return 0;
        }

        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                String temp = str.substring(i, j);
                if(calculateLength(temp)) {
                    System.out.println(temp);
                    maxLength = maxLength<temp.length()?temp.length():maxLength;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String test = "abc012343210abc";
        ReverseStringLength model = new ReverseStringLength(test);
        System.out.println(model.getMaxLength());
//        System.out.println(model.calculateLength("abc012343210a"));
    }
}
