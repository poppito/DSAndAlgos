package io.embry.dsandalgos.algos;

import android.util.Log;

public class BubbleSort {

    public BubbleSort(int[] array) {
        bubbleSort(array);
    }

    int[] bubbleSort(int[] array) {
        for (int i=0; i <= array.length - 1; i++) {
            for (int j=i+1; j<= array.length - 1; j++) {
                Log.v("TAG", "comparing " + String.valueOf(i) + " with " + String.valueOf(j));
                if (array[i] > array[j]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                 }
            }
        }
        return array;
    }
}