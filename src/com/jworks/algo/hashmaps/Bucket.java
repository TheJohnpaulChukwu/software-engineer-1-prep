package com.jworks.algo.hashmaps;
import java.util. * ;
class Bucket {

  List<Pair<Integer,Integer>> bucket;
  // Initialize bucket here
  public Bucket() {

    bucket = new LinkedList<>();
    
  }
  // put value in bucket
  public void update(int key, int value) {

    boolean isKeyExists = false;

    //so this method caters for both fresh insert of values with new key or update of values for existing key
    for (Pair<Integer,Integer> pair :bucket) {
      if(pair.getKey() == key){
        pair.setValue(value);
        isKeyExists = true;
        break;
      }
    }

    if(!isKeyExists){
      Pair<Integer,Integer> pair = new Pair<>(key, value);
      bucket.add(pair);
    }

  }
  // get value from bucket
  public int get(int key) {
    return bucket.stream()
            .filter(bucketPair -> bucketPair.getKey() == key)
            .findFirst().map(Pair::getValue)
            .orElse(-1);
    // Key not found
  }

  // delete value from bucket
  public void remove(int key) {
    bucket.removeIf(pair -> pair.key == key);

  }
}

class Pair<K, V> {
  K key;
  V value;

  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  public K getKey() {
    return key;
  }

  public V getValue() {
    return value;
  }

  public void setValue(V value) {
    this.value = value;
  }
}