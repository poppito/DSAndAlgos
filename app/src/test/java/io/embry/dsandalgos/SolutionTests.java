package io.embry.dsandalgos;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import io.embry.dsandalgos.algos.MergeSort;
import io.embry.dsandalgos.algos.UniqueCharacters;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

@RunWith(JUnit4.class)
public class SolutionTests {

    @Test
    public void testUniqueCharacters() {
        UniqueCharacters characters = new UniqueCharacters();
        assertTrue(characters.uniqueCharacters("abdef"));
        assertFalse(characters.uniqueCharacters("aaeded"));
        assertFalse(characters.uniqueCharacters("akdjdahdsfuakask"));
        assertTrue(characters.uniqueCharacters("12349"));
        assertFalse(characters.uniqueCharacters("!#*@$@#$*#@$()%812"));
    }


    @Test
    public void mergeSort() {
        int[] arr = {49, 498,18, 28, 4984, 92, 94, 1, 44, 5, 6, 3,22};

        MergeSort sort = new MergeSort(arr);

        for (int i: arr) {
            System.out.println(i);
        }
    }
}
