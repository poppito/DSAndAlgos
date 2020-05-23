package io.embry.dsandalgos.algos;

public class Monotonic {
    public boolean isMonotonic(int[] in) {
        return isIncreasing(in) || isDecreasing(in);
    }

    private boolean isIncreasing(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 < arr.length) {
                if (arr[i] > arr[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isDecreasing(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            if (i + 1 < arr.length) {
                if (arr[i] < arr[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
