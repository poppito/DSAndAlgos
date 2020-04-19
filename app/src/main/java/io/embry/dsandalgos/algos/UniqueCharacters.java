package io.embry.dsandalgos.algos;

import java.util.HashSet;

public class UniqueCharacters {
    public boolean uniqueCharacters(String in) {
        char[] arr = in.toCharArray();
        HashSet store = new HashSet();
        for (int i=0; i<arr.length; i++) {
            if (store.contains(arr[i])) {
                System.out.println(arr[i] + "is not unique!");
                return false;
            }
            store.add(arr[i]);
        }
        return true;
    }
}
