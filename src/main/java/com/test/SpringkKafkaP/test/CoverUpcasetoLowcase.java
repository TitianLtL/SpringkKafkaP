package com.test.SpringkKafkaP.test;

public class CoverUpcasetoLowcase {


    public static void main(String[] args) {
        String org= "Hello World";
        char[] returned = new char[org.length()];

        for (int i = 0; i < org.length(); i++) {
            char ch = org.charAt(i);
            if (Character.isUpperCase(ch)) {
                returned [i] =  Character.toLowerCase(ch);
            } else if (Character.isLowerCase(ch)) {
                returned [i] =  Character.toUpperCase(ch);
            }
            else {
                returned [i] = ch;
            }
        }
        System.out.println(returned);
    }
}
