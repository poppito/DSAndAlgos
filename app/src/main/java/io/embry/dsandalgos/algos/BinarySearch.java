package io.embry.dsandalgos.algos;

public class BinarySearch {
    private int first;
    private int last;
    private int[] array;
    private int key;

    public BinarySearch(int first, int last, int[] array, int key) {
        this.first = first;
        this.last = last;
        this.array = array;
        this.key = key;

        binSearch(first, last, array, key);
    }

    private void binSearch(int first, int last, int[] array, int key) {
        int mid = (first + last)/2;

        while (first <= last) {
            if (array[mid] < key) {
                first = mid + 1;
                binSearch(first, last, array, key);
                break;
            } else if (array[mid] > key) {
                last = mid - 1;
                binSearch(first, last, array, key);
                break;
            } else if (array[mid] == key) {
                System.out.println("found key at index" + mid);
                break;
            }
        }
    }
}
