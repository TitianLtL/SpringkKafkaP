package com.test.SpringkKafkaP.test;

/**
 * Print reverse array in Java using recursion for the given input array without using any extra space.
 * Ignore the implicit stack used in recursion for computing the space complexity.
 */
public class reverseArrayNoLoop {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        recursionNoLoop(arr, 0, arr.length - 1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void recursionNoLoop(int [] arr, int start , int end) {
        int swap=0;
        if (start < end) {
           swap = arr[start] ;
           arr[start] = arr[end];
           arr[end] = swap;
           recursionNoLoop(arr, start + 1, end - 1);
        }

    }



}
