package io.embry.dsandalgos;

import org.junit.Test;

import io.embry.dsandalgos.ds.BasicLinkedList;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertSame;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class LinkedListTest {

    @Test
    public void AddAndRemove() {
        BasicLinkedList<Integer> list = new BasicLinkedList<>();
        int i = 0;
        while (i < 10) {
            list.add(i);
            i++;
        }
        assertEquals(list.size(), 10);
        assertSame(list.remove(), 0);
        assertEquals(list.size(), 9);
        assertSame(list.find(9), 9);
        assertSame(list.removeAt(4), 6);
    }
}