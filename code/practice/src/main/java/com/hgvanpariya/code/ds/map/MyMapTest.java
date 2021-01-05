package com.hgvanpariya.code.ds.map;

public class MyMapTest {

    public static void main(String[] args) {
        MyMap<String, String> myMap = new MyMap<String, String>();
        myMap.put("HI", "OK");
        myMap.put("HI1", "OK1");

        System.out.println(myMap.get("H"));
    }
}
