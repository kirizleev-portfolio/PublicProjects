/**
 * QuickSort Algorithm
 * -------------------
 * A clean implementation of the QuickSort algorithm,
 * based on the divide-and-conquer paradigm.
 *
 * The array is partitioned around a pivot element:
 *  - Elements smaller than the pivot move left,
 *  - Elements greater move right.
 * Each partition is then sorted recursively.
 *
 * Key Concepts:
 *  - Divide and Conquer
 *  - Recursion and in-place swapping
 *  - Runtime behavior and pivot strategy
 *
 * Example:
 *  int[] data = {8, 3, 5, 2, 9, 1, 4, 7, 6};
 *  QuickSort.quickSort(data, 0, data.length - 1);
 *
 * Author: Vladimir Kirizleev (@vkir090)
 * License: MIT (free for educational and commercial use)
 */

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] unsorted = {8, 3, 5, 2, 9, 1, 4, 7, 6};

        // Measure runtime
        long start = System.nanoTime();
        quickSort(unsorted, 0, unsorted.length - 1);
        long end = System.nanoTime();

        // Print result
        System.out.println("QuickSort result:");
        for (int num : unsorted) {
            System.out.print(num + " ");
        }
        System.out.println("\nTime: " + (end - start) + " ns");
    }

    /**
     * Recursive QuickSort implementation.
     *
     * @param arr   Array to sort
     * @param start Start index
     * @param end   End index
     */
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        // Choose pivot (middle element)
        int pivotIndex = start + (end - start) / 2;
        int pivot = arr[pivotIndex];

        int left = start;
        int right = end;

        // Partition step
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;

            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        // Recursively sort partitions
        if (start < right) quickSort(arr, start, right);
        if (left < end) quickSort(arr, left, end);
    }

    /** Swaps two elements in an array. */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
