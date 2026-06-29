package com.test.SpringkKafkaP.test;


import java.util.LinkedHashMap;
import java.util.Optional;

public class FindFirstNoRepeatChar {

    public static void main(String[] args){
     String inputString = "Swiss";
     Optional<Character>  firstChar = findFirstChar(inputString);
        if (firstChar.isPresent()){
            System.out.println(firstChar.get());
        }else {
            System.out.println("none");
        }

    }
    private static Optional<Character>  findFirstChar (String input){

        int length = input.length();
        char[] toCharArray = input.toCharArray();
        var mapper = new LinkedHashMap<Character, Integer>();

        for (int i = 0;  i<length ; i++) {
            char lowerCaseChar = Character.toLowerCase(toCharArray[i]);
            if (mapper.get(lowerCaseChar) != null){
                mapper.put(lowerCaseChar,mapper.get(lowerCaseChar) +1);
            }else {
                mapper.put(lowerCaseChar,1);
            }
        }
       return mapper.keySet().stream().filter(one -> mapper.get(one) == 1).findFirst();
    }
}
