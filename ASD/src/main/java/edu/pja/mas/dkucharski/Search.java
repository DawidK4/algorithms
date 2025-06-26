package edu.pja.mas.dkucharski;

public class Search {
    /**
     * Performs a Jump Search to find the index of a target key in a sorted array.
     *
     * @param array The sorted array to search in.
     * @param key   The value to be searched.
     * @return The index of the key if found, or -1 if the key is not in the array.
     */
    public static int jumpSearch(int[] array, int key) {
        int n = array.length;

        if (n == 0) {
            return -1;
        }

        int step = (int) Math.floor(Math.sqrt(n));

        int prev = 0;

        while (array[Math.min(step, n) - 1] < key) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));

            if (prev >= n) {
                return -1;
            }
        }

        while (array[prev] < key) {
            prev++;
            if (prev == Math.min(step, n)) {
                return -1;
            }
        }

        if (array[prev] == key) {
            return prev;
        }

        return -1;
    }

    /**
     * Performs a Binary Search to find the index of a target key in a sorted array.
     * @param array - The sorted array to search in.
     * @param key - The value to be searched.
     * @return The index of the key if found, or -1 if the key is not in the array.
     */
    public static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == key) {
                return mid;
            }

            if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
