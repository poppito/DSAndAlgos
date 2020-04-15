package io.embry.dsandalgos.ds;

public class BasicQueue<T> {

    private T[] data;
    private int head = -1;
    private int tail = -1;

    public BasicQueue() {
        data = (T[]) new Object[1000];
    }

    public int size() {
        if (head == -1 && tail == -1) {
            return 0;
        } else {
            return tail - head + 1;
        }
    }

    public void enqueue(T item) {
        if ((tail + 1) % data.length == head) {
            throw new IllegalArgumentException("Sorry the queue is full");
        }
        if (size() == 0) {
            head++;
            tail++;
            data[tail] = item;
        } else {
            tail++;
            data[tail] = item;
        }
    }

    public T dequeue() {
        if (size() == 0) {
            return null;
        } else if (head == tail) {
            T item = data[tail];
            head = -1;
            tail = -1;
            return item;
        } else {
            T item = data[tail];
            head++;
            return item;
        }
    }

    public T access(int position) {
        if (size() == 0 || size() < position) {
            return null;
        }
        for (int i=head; i < tail; i++) {
            if (i == position) {
                return data[i];
            }
        }
        return null;
    }

    public boolean contains(T item) {
        if (size() == 0) {
            return false;
        }
        for (int i=head; i<tail; i++) {
            if (item == data[i]) {
                return true;
            }
        }
        return false;
    }
}
