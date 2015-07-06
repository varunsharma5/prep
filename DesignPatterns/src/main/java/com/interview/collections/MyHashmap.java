package com.interview.collections;


class AnEntry <K,V> {
	private AnEntry<K, V> next;
	private final K key;
	private V value;
	
	
	public AnEntry(K key, V value) {	
		this.key = key;
		this.value = value;
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	public V getValue() {
		return value;
	}
	
	public K getKey() {
		return key;
	}
	
	public void setNext(AnEntry<K, V> next) {
		this.next = next;
	}
	
	public AnEntry<K, V> getNext() {
		return next;
	}
}

class SimpleHashmap<K, V> {
	private int BUCKET_COUNT = 128;
	private AnEntry<K, V>[] buckets;
	
	public SimpleHashmap() {
		buckets = new AnEntry[BUCKET_COUNT];
	}
	
	public V get(K key) {
		if(key == null) {
			return null;
		}
		
		AnEntry<K, V> entry = buckets[bucketIndexForKey(key)];
		
		while(entry != null && entry.getKey().equals(key)) {
			entry = entry.getNext();
		}
		
		return entry != null ? entry.getValue() :  null;
	}
	
	public void put(K key, V value) {
		if(key == null) {
			return;
		}
		
		AnEntry<K, V> entry = buckets[bucketIndexForKey(key)];
		
		if(entry != null) {
			boolean done = false;
			while(!done) {
				if(key.equals(entry.getKey())) {
					entry.setValue(value);
					done = true;
				} else if(entry.getNext() == null) {
					entry.setNext(new AnEntry<K,V>(key, value));
					done = true;
				}
				
				entry = entry.getNext();
			}
		}
	}
	
	private int bucketIndexForKey(K k) {
		int bucketIndex = k.hashCode() % buckets.length;
		return bucketIndex;
	}
}




public class MyHashmap {

}
