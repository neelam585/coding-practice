package oops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestImmutableString {
    public static void main(String[] args){
        String password = "admin";
        password.concat("123");
        System.out.println(password);

        StringBuffer sb = new StringBuffer("Java");
        sb.append("tech");
        System.out.println(sb);

    final List<String> list = new ArrayList<>();

        list.add("a");
    list.add("b");
    System.out.println(list);
    //-------------------------------------------------------------------------------
        Map<String, String> map = new HashMap<>();
        map.put(null, null);
        System.out.println(map);
        Map<String, String> mapA = new ConcurrentHashMap<>();
        mapA.put(null, null);
        System.out.println(mapA);

    }
}
