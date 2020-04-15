package io.embry.dsandalgos.ds;

public class BasicHashTable<X, Y> {

    public HashEntry[] data;
    private int capacity;
    private int size = 0;

    public BasicHashTable(int capacity) {
        this.capacity = capacity;
        data = new HashEntry[capacity];
    }

    private int calculateHash(X key) {
        int hash = key.hashCode() % capacity;

        while (data[hash] != null && !data[hash].key.equals(key) && hash < capacity) {
            hash = (hash + 1) % capacity;
        }
        return hash;
    }

    public void put(X key, Y value) {
        int hash = calculateHash(key);
        data[hash] = new HashEntry(key, value);
        size++;
    }

    public Y get(X key) {
        int hash = calculateHash(key);
        if (data[hash] == null) {
            return null;
        } else {
            return (Y) data[hash].value;
        }
    }

    public Y delete(X key) {
        Y value = get(key);
        int hash = calculateHash(key);
        if (data[hash] != null) {
            data[hash] = null;
            size--;
            hash = (hash + 1) % capacity;
            while (data[hash] != null) {
                HashEntry he = data[hash];
                data[hash] = null;
                size--;
                put((X) he.key, (Y) he.value);
                hash = (hash + 1) % capacity;
            }
        }
        return value;
    }

    public boolean hasKey(X key) {
        int hash = calculateHash(key);
        if (data[hash].key != key) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasValue(Y value) {
        for (int i=0; i<capacity; i++) {
            HashEntry entry = data[i];
            if (entry != null && entry.value == value) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    private class HashEntry<X, Y> {
        public X getKey() {
            return key;
        }

        public void setKey(X key) {
            this.key = key;
        }

        public Y getValue() {
            return value;
        }

        public void setValue(Y value) {
            this.value = value;
        }

        private X key;
        private Y value;


        public HashEntry(X key, Y value) {
            this.key = key;
            this.value = value;
        }
    }
}
