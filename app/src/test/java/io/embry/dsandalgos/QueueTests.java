package io.embry.dsandalgos;

import org.junit.Test;

import io.embry.dsandalgos.ds.BasicQueue;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertSame;
import static junit.framework.TestCase.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class QueueTests {

    @Test
    public void enqueueAndDequeue() {
        BasicQueue<Integer> q = new BasicQueue<>();
        q.enqueue(99);
        assertSame(q.size(), 1);
        q.dequeue();
        assertSame(q.size(), 0);

        for (int i = 0; i < 1000; i++) {
            q.enqueue(i);
        }
        assertEquals(q.size(), 1000);
    }

    @Test
    public void access() {
        BasicQueue<Integer> q = new BasicQueue<>();
        for (int i = 0; i < 1000; i++) {
            q.enqueue(i);
        }

        assertSame(q.access(16), 16);
    }

    @Test
    public void contains() {
        BasicQueue<Integer> q = new BasicQueue<>();
        for (int i = 0; i < 1000; i++) {
            q.enqueue(i);
        }

        assertTrue(q.contains(16));
        assertFalse(q.contains(1000));
    }
}