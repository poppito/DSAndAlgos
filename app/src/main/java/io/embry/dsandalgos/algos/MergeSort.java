package io.embry.dsandalgos.algos;

public class MergeSort {

    public MergeSort(int[] array) {
        sort(array, 0, array.length - 1);
    }


    public void sort(int[] in, int l, int r) {

        if (l < r) {
            int m = (l + r) /2;

            sort(in, l, m);
            sort(in, m + 1, r);
            mergeSort(in, l, m, r);
        }
    }

    public void mergeSort(int[] in, int l, int m, int r) {
        int m1 = m - l + 1;
        int m2 = r - m;

        int[] arr1 = new int[m1];
        int[] arr2 = new int[m2];

        for (int i=0; i<m1; i++) {
            arr1[i] = in[l + i];
        }

        for (int j=0; j<m2; j++) {
            arr2[j] = in[m + 1 + j];
        }

        int i=0, j=0;
        int k = l;

        while (i < m1 && j < m2) {
            if (arr1[i] <= arr2[j]) {
                in[k] = arr1[i];
                i++;
            } else {
                in[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < m1) {
            in[k] = arr1[i];
            i++;
            k++;
        }

        while (j < m2) {
            in[k] = arr2[j];
            j++;
            k++;
        }
    }
}