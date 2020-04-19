package io.embry.dsandalgos;

import android.util.Log;

import java.util.HashSet;

public class CommonNumbers {
    public CommonNumbers() {
        int[] arr1 = {1, 39, 482, 281, 304, 11, 83, 384, 11, 9, 12, 484, 3};
        int[] arr2 = {23, 25, 91, 304, 192, 11, 482, 3, 199, 223, 58, 103, 4};

        HashSet set = new HashSet();

        for (int i: arr1) {
            set.add(i);
        }

        for (int i: arr2) {
            if (set.contains(i)) {
                Log.v("TAG" , "contains " + i);
            }
        }
    }
}
