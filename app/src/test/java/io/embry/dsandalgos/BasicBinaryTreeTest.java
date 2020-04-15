package io.embry.dsandalgos;

import org.junit.Test;

import io.embry.dsandalgos.ds.BasicBinaryTree;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class BasicBinaryTreeTest {

    @Test
    public void binaryTreeTest() {
        BasicBinaryTree tree = new BasicBinaryTree();
        tree.add(19);
        tree.add(47);
        tree.add(37);
        tree.add(1);
        tree.add(22);
        tree.add(23);

        assertSame(6, tree.size());
        assertTrue(tree.contains(1));
        assertTrue(tree.contains(23));
        assertFalse(tree.contains(9));

        tree.delete(23);
        tree.delete(19);
        tree.delete(1);

        assertFalse(tree.contains(23));
        assertFalse(tree.contains(19));
        assertFalse(tree.contains(1));
    }

    @Test
    public void dfs() {
        BasicBinaryTree tree = new BasicBinaryTree();
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);

        tree.dfsInOrder();
        System.out.println("\n\n\n");
        tree.dfsPreorder();
        System.out.println("\n\n\n");
        tree.dfsPostOrder();
        System.out.println("\n\n\n");
        tree.bfs();
        System.out.println("\n\n\n");
    }
}