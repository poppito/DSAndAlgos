package io.embry.dsandalgos;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import io.embry.dsandalgos.algos.BinarySearch;
import io.embry.dsandalgos.algos.BubbleSort;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] arr = {1,2,4,6,44,99,201};
        int first = 0;
        int last = arr.length;

        int[] arr1 = {19,200,4,69,434,999,21};

        BinarySearch bs = new BinarySearch(first, last, arr, 2);
        BinarySearch bs2 = new BinarySearch(first, last, arr, 99);
        BinarySearch bs3 = new BinarySearch(first, last, arr, 10);
        BinarySearch bs4  = new BinarySearch(first, last, arr, 201);

        BubbleSort bbs = new BubbleSort(arr1);

        for (int i = 0; i <= arr1.length - 1; i++) {
            Log.v("TAG", String.valueOf(arr1[i]));
        }
    }
}
