package io.embry.dsandalgos;

import org.junit.Test;

import io.embry.dsandalgos.ds.BasicStack;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class StackTests {

    @Test
    public void PushAndPopItem() {
        BasicStack<Integer> stack = new BasicStack<>();
        assertNull(stack.pop());
        assertTrue(stack.push(99));
        assertSame(stack.pop(), 99);

        for (int i=0; i<= 999; i++) {
            stack.push(i);
        }

        assertFalse(stack.push(1));
    }

    @Test
    public void StackContains() {
        BasicStack<Integer> stack = new BasicStack<>();
        for (int i = 0; i<= 29; i++) {
            stack.push(i);
        }
        assertFalse(stack.contains(500));
        assertTrue(stack.contains(18));
    }

    @Test
    public void StackFind() {
        BasicStack<Integer> stack = new BasicStack<>();
        for (int i = 0; i<= 29; i++) {
            stack.push(i);
        }
        assertSame(29, stack.access(29));
    }
}