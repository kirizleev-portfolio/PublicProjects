/**
 * MergeSort Algorithm
 * -------------------
 * A clean implementation of the classic Merge Sort algorithm
 * following the divide-and-conquer principle.
 *
 * The array is recursively divided into halves and then merged
 * back into a sorted sequence. Includes a simple runtime
 * comparison with Java's built-in Arrays.sort().
 *
 * Key Concepts:
 *  - Recursion and divide-and-conquer logic
 *  - Efficient splitting and merging of subarrays
 *  - Benchmarking vs. Arrays.sort()
 *
 * Example:
 *  int[] data = {8, 3, 5, 2, 9, 1, 4, 7, 6};
 *  int[] sorted = MergeSort.divide(data);
 *
 * Author: Vladimir Kirizleev (@vkir090)
 * License: MIT (free for educational and commercial use)
 */

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] unsorted = {8, 3, 5, 2, 9, 1, 4, 7, 6};

        // Sort using custom MergeSort implementation
        int[] sorted = divide(unsorted);

        System.out.println("MergeSort result:");
        for (int num : sorted) System.out.print(num + " ");
        System.out.println("\n");

        // Compare performance with Java’s built-in sort
        long start = System.nanoTime();
        Arrays.sort(unsorted);
        long end = System.nanoTime();

        System.out.println("Arrays.sort() time: " + (end - start) + " ns");
    }

    /** Recursively divides the array into halves. */
    public static int[] divide(int[] arr) {
        if (arr.length == 1) return arr;

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        return merge(divide(left), divide(right));
    }

    /** Merges two sorted arrays into one sorted result. */
    public static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) merged[k++] = left[i++];
            else merged[k++] = right[j++];
        }

        while (i < left.length) merged[k++] = left[i++];
        while (j < right.length) merged[k++] = right[j++];

        return merged;
    }
}
