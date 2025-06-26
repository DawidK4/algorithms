package edu.pja.mas.dkucharski;

public abstract class MergeSort {
    public static int[] mergeSort(int[] S, int len) {
        if (len <= 1) {
            int[] single = new int[len];
            if (len == 1) single[0] = S[0];
            return single;
        }
        int m = len / 2;
        int[] left = mergeSort(slice(S, 0, m), m);
        int[] right = mergeSort(slice(S, m, len), len - m);
        return merge(left, left.length, right, right.length);
    }

    // Helper to slice array S[a:b]
    private static int[] slice(int[] S, int a, int b) {
        int[] result = new int[b - a];
        System.arraycopy(S, a, result, 0, b - a);
        return result;
    }

    // Merges two sorted arrays
    public static int[] merge(int[] a1, int len1, int[] a2, int len2) {
        int[] result = new int[len1 + len2];
        int i = 0, j = 0, k = 0;
        while (i < len1 && j < len2) {
            if (a1[i] < a2[j]) result[k++] = a1[i++];
            else result[k++] = a2[j++];
        }
        while (i < len1) result[k++] = a1[i++];
        while (j < len2) result[k++] = a2[j++];
        return result;
    }
}