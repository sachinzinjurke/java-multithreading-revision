package com.home.thread.streams;

public class ReverseString {

    public static void main(String[] args) {
        String original = "sachin";
        String reverse="";

        for(int i=original.length()-1; i >=0;i--){
            reverse+= original.charAt(i);
        }
        System.out.println(reverse);

        String original1 = "Hello";
        String reversed = new StringBuilder(original1).reverse().toString();
        System.out.println("Reversed: " + reversed);
    }
}
