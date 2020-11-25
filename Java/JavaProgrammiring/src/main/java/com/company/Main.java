package com.company;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        System.out.println(newInteger(null));
        System.out.println(newString(null));
        System.out.println(newString("null"));
        System.out.println((char[])null);
        System.out.println((true?null:0));
        System.out.println((String)null);
    }
}
