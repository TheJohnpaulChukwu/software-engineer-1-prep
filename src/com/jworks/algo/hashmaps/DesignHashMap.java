package com.jworks.algo.hashmaps;

import java.util.*;


class DesignHashMap {

    private final List<Bucket> hashTable;
    private final int keySpace;

    public DesignHashMap() {
        hashTable = new ArrayList<>();
        keySpace = 1000;
        for (int i = 0; i < keySpace; i++) {
            hashTable.add(new Bucket());
        }

    }

    public void put(int key, int value) {
        int hashedKey = hash(key);
        Bucket bucket = hashTable.get(hashedKey);
        bucket.update(key,value);
    }

    public int get(int key) {
        int hashedKey = hash(key);
        Bucket bucket = hashTable.get(hashedKey);
        return bucket.get(key);
    }
    
    public void remove(int key) {
        int hashedKey = hash(key);
        Bucket bucket = hashTable.get(hashedKey);
        bucket.remove(key);
    }

    // Compute the hash to determine the index
    private int hash(int key) {
        return key % keySpace;
    }
}