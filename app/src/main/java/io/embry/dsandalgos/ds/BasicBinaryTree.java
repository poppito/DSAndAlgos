package io.embry.dsandalgos.ds;

public class BasicBinaryTree<T extends Comparable> {

    public Node root;

    private int size;

    public int size() {
        return size;
    }

    public BasicBinaryTree() {
        this.root = null;
    }

    public void add(T item) {
        Node node = new Node(item);
        if (root == null) {
            root = node;
            size++;
        } else {
            insert(root, node);
        }
    }

    public boolean delete(T item) {
        boolean deleted = false;

        if (root == null) {
            return deleted;
        }

        Node currentNode = getNode(item);

        if (currentNode != null) {
            if (currentNode.left == null && currentNode.right == null) {
                unlink(currentNode, null);
                deleted = true;
            } else if (currentNode.left != null && currentNode.right == null) {
                unlink(currentNode, currentNode.left);
                deleted = true;
            } else if (currentNode.left == null && currentNode.right != null) {
                deleted = true;
                unlink(currentNode, currentNode.right);
            } else {
                Node child = currentNode.left;
                while (child.right != null && child.left != null) {
                    child = child.right;
                }

                child.parent.right = null;
                child.left = currentNode.left;
                child.right = currentNode.right;
                unlink(currentNode, child);
                deleted = true;
            }
        }
        if (deleted) {
            size--;
        }
        return deleted;
    }

    private void unlink(Node currentNode, Node newNode) {
        if (currentNode == root) {
            newNode.left = currentNode.left;
            newNode.right = currentNode.right;
            root = newNode;
        } else if (currentNode.parent.left == currentNode) {
            currentNode.parent.left = newNode;
            newNode.parent = currentNode.parent;
        } else {
            currentNode.parent.right = newNode;
            newNode.parent = currentNode.parent;
        }
    }

    public boolean contains(T item) {
        return getNode(item) != null;
    }

    private Node getNode(T item) {
        if (root == null) {
            return null;
        }
        Node currentNode = root;
        while (currentNode != null) {
            if (item.compareTo(currentNode.item) < 0) {
                currentNode = currentNode.left;
            } else if (item.compareTo(currentNode.item) > 0) {
                currentNode = currentNode.right;
            } else {
                return currentNode;
            }
        }
        return null;
    }


    private void insert(Node parent, Node child) {
         if (child.item.compareTo(parent.item) < 0) {
             if (parent.left == null) {
                 parent.left = child;
                 child.parent = parent;
                 size++;
             } else {
                 insert(parent.left, child);
             }
         } else if (child.item.compareTo(parent.item) > 0) {
             if (parent.right == null) {
                 parent.right = child;
                 child.parent = parent;
                 size++;
             } else {
                 insert(parent.right, child);
             }
         }
    }

    public class Node {
        public T item;
        public Node left;
        public Node right;
        public Node parent;

        public Node(T item) {
            this.left = null;
            this.right = null;
            this.parent = null;
            this.item = item;
        }
    }

    public void dfsInOrder() {
        dfsInOrder(root);
    }

    public void dfsPreorder() {
        dfsPreorder(root);
    }

    public void dfsPostOrder() {
        dfsPostOrder(root);
    }

    private void dfsInOrder(Node currentNode) {
        if (currentNode == null) return;
        dfsInOrder(currentNode.left);
        System.out.println(currentNode.item);
        dfsInOrder(currentNode.right);
    }

    private void dfsPostOrder(Node currentNode) {
        if (currentNode == null) {
            return;
        }
        dfsPostOrder(currentNode.left);
        dfsPostOrder(currentNode.right);
        System.out.println(currentNode.item);
    }
    private void dfsPreorder(Node currentNode) {
        if (currentNode == null) {
            return;
        }
        System.out.println(currentNode.item);
        dfsPreorder(currentNode.left);
        dfsPreorder(currentNode.right);
    }

    public void bfs() {
        BasicQueue<Node> queue = new BasicQueue<>();
        queue.enqueue(root);

        while (queue.size() != 0) {
            Node currentNode = queue.dequeue();
            System.out.println(currentNode.item);
            if (currentNode.left != null) {
                queue.enqueue(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.enqueue(currentNode.right);
            }
        }
    }
}
