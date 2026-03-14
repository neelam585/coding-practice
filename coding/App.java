//package com.globalsoftwaresupport;

import java.lang.Integer;
import java.util.*;

public class App {

    public static void main(String[] args) {

        Stack<String> names = new Stack<>();

        names.push("Adam");
        names.push("Joe");
        names.push("Ana");
        names.push("Daniel");
        names.push("Katy");

        while(!names.isEmpty()) {
            System.out.println(names.pop());
        }
        // o/p:
        // Katy
        //Daniel
        //Ana
        //Joe
        //Adam

        //LinkHashSet
        //hashSet
        //hashMap
        //LinkedHashMap
        //ArrayList
        Set<String> set = new LinkedHashSet<>();
        set.add("Neelam");
        set.add("Richa");
        set.add("Sadhana");
        set.add("Neha");

        for(String s : set){
            System.out.println("LinkedHashSet " +s);
        }
//LinkedHashSet Neelam
//LinkedHashSet Richa
//LinkedHashSet Sadhana
//LinkedHashSet Neha
        Set<String> set1 = new HashSet<>();
        set1.add("Lucknow");
        set1.add("Delhi");
        set1.add("Kanpur");
        set1.add("Gorakhpur");
        for(String s1 : set1){
            System.out.println("HashSet " +s1);
        }
//HashSet Lucknow
//HashSet Delhi
//HashSet Kanpur
//HashSet Gorakhpur
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Neelam" );
        map.put(2, "Neha");
        map.put(20, "Sadhana");

       for(Map.Entry<Integer, String> entry : map.entrySet() ){
           System.out.println(entry.getKey() +"-" +entry.getValue());
       }

       Map<Integer , String> map1 = new HashMap<>();
       map1.put(1, "aaa");
       map1.put(2, "bbb");
       map1.put(3, "ccc");
       map1.put(11, "ddd");

       for(Integer key : map1.keySet()){
           System.out.println("hhhhh"+key +"-" + map1.get(key));
       }




    }
}





