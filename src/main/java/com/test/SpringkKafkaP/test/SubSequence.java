package com.test.SpringkKafkaP.test;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SubSequence {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter wr = new PrintWriter(System.out);
//        int n = Integer.parseInt(br.readLine().trim());
//        String[] arr_a = br.readLine().split(" ");
//        int[] a = new int[n];
//        for(int i_a = 0; i_a < arr_a.length; i_a++)
//        {
//            a[i_a] = Integer.parseInt(arr_a[i_a]);
//        }
//        int k = Integer.parseInt(br.readLine().trim());
        int n = 6 ;
        int[] a= {10, 2, 3, 1, 5, 8};
        int k = 3;
        long out_ = solve(n, a, k);
        System.out.println(out_);

//        wr.close();
//        br.close();
    }

    private static final int MAX_V = 1000000;
    private static final long INF = Long.MAX_VALUE / 2;

    private static long[] bitLeft = new long[MAX_V + 1];
    private static long[] bitRight = new long[MAX_V + 1];

    private static void updateLeft(int idx, long val) {
        while (idx <= MAX_V) {
            if (val < bitLeft[idx]) bitLeft[idx] = val;
            idx += idx & (-idx);
        }
    }

    private static long queryLeft(int idx) {
        long res = INF;
        while (idx > 0) {
            System.out.println("bitLeft[idx]: " + bitLeft[idx] + ", res: " + res +   " idx: " + idx);
            if (bitLeft[idx] < res) {
                res = bitLeft[idx];
                System.out.println( "res: " + res );
            }
            idx -= idx & (-idx);
            System.out.println( " idx: " + idx);
        }
        return res;
    }

    private static void updateRight(int idx, long val) {
        while (idx > 0) {
            if (val < bitRight[idx]) bitRight[idx] = val;
            idx -= idx & (-idx);
        }
    }

    private static long queryRight(int idx) {
        long res = INF;
        while (idx <= MAX_V) {
            if (bitRight[idx] < res) res = bitRight[idx];
            idx += idx & (-idx);
        }
        return res;
    }

    static long solve(int n, int[] a, int k){
        // Base case: If sequence length is 1, the special value sum is zero.
        if (k <= 1) {
            return 0;
        }

        long[] dpOld = new long[n];
        Arrays.fill(dpOld, 0L);
        long[] dpNew = new long[n];

        for (int j = 2; j <= k; j++) {
            Arrays.fill(dpNew, INF);
            Arrays.fill(bitLeft, INF);
            Arrays.fill(bitRight, INF);

            for (int i = 0; i < n; i++) {
                int val = a[i];

                long ansLeft = queryLeft(val);
                long costLeft = (ansLeft != INF) ? (ansLeft + val) : INF;

                long ansRight = queryRight(val + 1);
                long costRight = (ansRight != INF) ? (ansRight - val) : INF;

                dpNew[i] = Math.min(costLeft, costRight);

                if (dpOld[i] != INF) {
                    updateLeft(val, dpOld[i] - val);
                    updateRight(val, dpOld[i] + val);
                }
            }
            long[] temp = dpOld;
            dpOld = dpNew;
            dpNew = temp;
        }

        long result = INF;
        for (int i = 0; i < n; i++) {
            if (dpOld[i] < result) {
                result = dpOld[i];
            }
        }

        return result == INF ? 0 : result;
    }

}
