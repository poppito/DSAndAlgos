package io.embry.dsandalgos.ds;

public class BasicStack<T> {

    private T[] data;
    private int pointer = -1;

    public BasicStack() {
        data = (T[]) new Object[1000];
    }

    public boolean push(T item) {
        if (pointer < data.length - 1) {
            data[++pointer] = item;
            return true;
        } else {
            return false;
        }
    }

    public T pop() {
        if (pointer == -1) return null;
        return data[pointer--];
    }

    public T access(T t) {
        while (pointer >= 0) {
            T item = pop();
            if (item == t) {
                return item;
            }
            pointer--;
        }
        return null;
    }

    public boolean contains(T t) {
        for (int i=0; i<= pointer; i++) {
            if (data[i] == t) {
                return true;
            }
        }
        return false;
    }
}
