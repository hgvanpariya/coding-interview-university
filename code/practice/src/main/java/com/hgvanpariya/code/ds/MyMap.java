package com.hgvanpariya.code.ds;

public class MyMap<K, V> {

	Object[] buckets ;
	static int DEFAULT_MAP_SIZE = 10;
	
	public MyMap() {
		this(DEFAULT_MAP_SIZE);
	}
	
	
	public MyMap(int size) {
		buckets = new Object[size];
	}
	

	public void put(K key, V value) {
		int calculateIndex = calculateIndex(key);
		
	}

	private int calculateIndex(K key) {
		return (key.hashCode() % buckets.length);
		
	}
}
