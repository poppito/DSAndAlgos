package io.embry.dsandalgos.ds;

public class BasicLinkedList<T> {

    private Node first;
    private Node last;

    private int nodeCount = 0;

    public BasicLinkedList() {
        first = null;
        last = null;
    }

    public int size() {
        return nodeCount;
    }

    public void add(T item) {
        if (first == null) {
            first = new Node(item);
            last = first;
        } else {
            Node newNode = new Node(item);
            last.next = newNode;
            last = newNode;
        }
        nodeCount++;
    }

    public T remove() {
        if (first == null) {
            return null;
        } else {
            T item = first.item;
            first = first.next;
            nodeCount--;
            return item;
        }
    }

    public void insert(T item, int position) {
        if (position >= size() + 1) {
            add(item);
            nodeCount++;
        } else {
            Node currentNode = first;
            int index = 0;
            while (index < position) {
                currentNode = currentNode.next;
                index++;
            }
            Node newNode = new Node(item);
            Node nextNode = currentNode.next;
            currentNode.next = newNode;
            newNode.next = nextNode;
            nodeCount++;
        }
    }

    public T removeAt(int position) {
        if (position > size()) {
            throw new IllegalArgumentException("Nope");
        } else if (position == 0) {
            return remove();
        } else {
            Node currentNode = first;
            int currentIndex = 0;
            while (currentIndex < position) {
                currentNode = currentNode.next;
                currentIndex++;
            }
            Node nextNode = currentNode.next;
            T item = nextNode.item;
            currentNode.next = nextNode.next;
            nodeCount--;
            return item;
        }
    }

    public T find(T item) {
        Node currentNode = first;
        if (first.item == item) {
            return first.item;
        }
        for (int i=0;i<nodeCount;i++) {
            currentNode = currentNode.next;
            if (currentNode.item == item) {
                return currentNode.item;
            }
        }
        return null;
    }


    private class Node {
        private T item;
        private Node next;
        public Node(T item) {
            this.item = item;
            next = null;
        }
    }
}
