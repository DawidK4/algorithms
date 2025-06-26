package edu.pja.mas.dkucharski;

public abstract class Hoare {
    /**
     * Implements the Hoare partitioning scheme for QuickSort.
     * @param array The array to be partitioned.
     * @param low The starting index of the subarray to be partitioned.
     * @param high The ending index of the subarray to be partitioned.
     * @return The index of the last element in the left partition.
     */
    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
            } while (array[i] < pivot);

            do {
                j--;
            } while (array[j] > pivot);

            if (i >= j) {
                return j;
            }

            // Swap elements
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
