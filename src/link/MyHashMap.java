package link;

import java.util.Iterator;
import java.util.LinkedList;

class Pair {
    public int key;
    public int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class MyHashMap {
    private static final int PRIME = 1543;
    private LinkedList[] list;

    public MyHashMap() {
        list = new LinkedList[PRIME];
        for (int i = 0; i < list.length; i++) {
            list[i] = new LinkedList();
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        Iterator<Pair> iterator = list[hash].iterator();
        while (iterator.hasNext()) {
            Pair next = iterator.next();
            if (next.key == key) {
                next.value = value;
                return;
            }
        }
        list[hash].add(new Pair(key, value));
    }

    public int get(int key) {
        int hash = hash(key);
        Iterator<Pair> iterator = list[hash].iterator();
        while (iterator.hasNext()) {
            Pair next = iterator.next();
            if (next.key == key) {
                return next.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        Iterator<Pair> iterator = list[hash].iterator();
        while (iterator.hasNext()) {
            Pair next = iterator.next();
            if (next.key == key) {
                iterator.remove();
            }
        }
    }

    private int hash(int key) {
        return key % PRIME;
    }
}
