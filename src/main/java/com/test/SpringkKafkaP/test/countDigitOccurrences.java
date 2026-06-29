package com.test.SpringkKafkaP.test;

public class countDigitOccurrences {

    public static void main(String[] args) {

        System.out.println(findDigitOccur(5, 4));
    }

    public static int findDigitOccur(int n, int d) {
        int count = 0;
        while (n > 0) {
            int rem = n % 10;
            if (rem == d) {
                count++;
            }
            n = n / 10;

        }
        return count;

    }
}
