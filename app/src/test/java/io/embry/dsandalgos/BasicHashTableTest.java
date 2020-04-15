package io.embry.dsandalgos;

import org.junit.Test;

import io.embry.dsandalgos.ds.BasicHashTable;

import static junit.framework.Assert.assertSame;
import static junit.framework.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BasicHashTableTest {

    @Test
    public void hashTest() {
        BasicHashTable<Integer, Integer> table = new BasicHashTable<>(10);
        table.put(99, 88);
        table.put(Integer.MAX_VALUE, Integer.MIN_VALUE);
        table.put(99, 44);
        table.put(39, 44);

        assertSame(44, table.get(39));
        assertSame(44, table.get(99));

        table.put(39, 49);
        assertSame(49, table.delete(39));

        table.put(1, 39);
        table.put(2, 34);

        assertTrue(table.hasKey(1));
        assertTrue(table.hasKey(2));
        assertTrue(table.hasValue(39));
        assertTrue(table.hasValue(34));
    }
}