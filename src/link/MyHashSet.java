package link;

import java.util.Iterator;
import java.util.LinkedList;

class MyHashSet {
    private static final int PRIME = 1543;
    private LinkedList[] list;

    public MyHashSet() {
        list = new LinkedList[PRIME];
        for (int i = 0; i < PRIME; i++) {
            list[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int hash = hash(key);
        Iterator<Integer> iterator = list[hash].iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                return;
            }
        }
        list[hash].offerLast(key);
    }

    public void remove(int key) {
        int hash = hash(key);
        Iterator<Integer> iterator = list[hash].iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                iterator.remove();
            }
        }
    }

    public boolean contains(int key) {
        int hash = hash(key);
        Iterator<Integer> iterator = list[hash].iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == key) {
                return true;
            }
        }
        return false;
    }

    public int hash(int key) {
        return key % PRIME;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.add(2);

    }
}
