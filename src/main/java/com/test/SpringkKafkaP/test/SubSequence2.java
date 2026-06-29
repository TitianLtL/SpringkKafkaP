package com.test.SpringkKafkaP.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class SubSequence2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr_a = br.readLine().split(" ");
        int[] a = new int[n];
        for(int i_a = 0; i_a < arr_a.length; i_a++)
        {
            a[i_a] = Integer.parseInt(arr_a[i_a]);
        }
        int k = Integer.parseInt(br.readLine().trim());

        long out_ = solve(n, a, k);
        System.out.println(out_);

        wr.close();
        br.close();
    }

    /**
     *
     * @param n 6              5
     * @param a 10 2 3 1 5 8   9 5 1 4 9
     * @param k 3              2
     * @return
     */

//    static long leftSmallest(int[] a, int k) {
//        long[] left = new long[a.length];
//        Arrays.fill(left, Long.MAX_VALUE);
//        for (int i = 0; i < a.length; i++) {
//            if (i > 0) left[i] = Math.min(left[i], left[i - 1]);
//            if (i >= k - 1) left[i] = Math.min(left[i], a[i - (k - 1)]);
//        }
//        return left;
//    }

    static long solve(int n, int[] a, int k){
        // Base case: If sequence length is 1, the special value sum is zero.
        if (k <= 1) {
            return 0;
        }



        for (int j = 2; j <= k; j++) {

        }


        return 0;
    }

}
