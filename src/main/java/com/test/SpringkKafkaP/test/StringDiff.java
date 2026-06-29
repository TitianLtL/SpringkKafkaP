package com.test.SpringkKafkaP.test;


import java.util.ArrayList;
import java.util.List;

public class StringDiff {
    public static void main(String[] args) {
//        String str1 = "abdgggda";
//        String str2 = "abdggda";
        String str1 = "mmgghh";
        String str2 =  "mfggh";
        findRemovalIndices(str1, str2).forEach(System.out::println);

    }

    public static List<Integer> findRemovalIndices(String str1, String str2) {
        List<Integer> result = new ArrayList<>();
        int n1 = str1.length();
        int n2 = str2.length();

        // Enforce the length constraint
        if (n1 != n2 + 1) {
            result.add(-1);
            return result;
        }

        // 1. Longest common prefix
        int p = 0;
        while (p < n2 && str1.charAt(p) == str2.charAt(p)) {
            p++;
        }

        // 2. Longest common suffix
        int s = 0;
        while (s < n2 && str1.charAt(n1 - 1 - s) == str2.charAt(n2 - 1 - s)) {
            s++;
        }

        int start = n2 - s;
        int end = p;

        // 3. Check if a valid window exists
        if (start > end) {
            result.add(-1);
            return result;
        }

        // 4. Fill the list with the valid range
        for (int i = start; i <= end; i++) {
            result.add(i);
        }

        return result;
    }

}