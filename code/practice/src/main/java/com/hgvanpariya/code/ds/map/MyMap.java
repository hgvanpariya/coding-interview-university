package com.hgvanpariya.code.ds.map;

import java.util.LinkedList;

public class MyMap<K, V> {

    LinkedList<Entry>[] buckets ;
	static int DEFAULT_MAP_SIZE = 10;
	
	public MyMap() {
		this(DEFAULT_MAP_SIZE);
	}
	
	
	public MyMap(int size) {
		buckets = new LinkedList[size];
	}
	

	public void put(K key, V value) {
		int calculateIndex = calculateIndex(key);
		if(buckets[calculateIndex] == null) {
		    buckets[calculateIndex] = new LinkedList<Entry>();
		}
		buckets[calculateIndex].add(new Entry(key, value));
	}
	
	public Object get(K key) {
	    if(key == null) {
	        return null;
	    }
        int calculateIndex = calculateIndex(key);
        
        for (MyMap<K, V>.Entry linkedList : buckets[calculateIndex]) {
            if(linkedList.key == key) {
                return linkedList.value;
            }
        }
        return null;
    }

	private int calculateIndex(K key) {
		return (key.hashCode() % buckets.length);
		
	}
	
	class Entry{
	    Object key;
	    Object value;
	    
	    Entry(Object key,Object value){
	        this.key = key;
	        this.value = value;
	    }
	    
	}
}
