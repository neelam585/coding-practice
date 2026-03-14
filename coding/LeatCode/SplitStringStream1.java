package LeatCode;

import java.util.*;

public class SplitStringStream1 {
    public static void main(String[] args) {
        String s = "hasgsddgsbabaffa"; //[h, as, gsd, dgsb, abaff, a]
        List<String> list = new ArrayList<>();
        int index = 0;

        int l = 1;
        while (index<s.length()){
          int end =  Math.min(index+l, s.length()); //1, 2, 3, 4, 5, 1
            list.add(s.substring(index,end));  //(0,1),(1, 1+2),(3,3+3)
            index = end;
            l++;
        }
        System.out.println(list);
    }
}
//Time: O(n) → each character processed once
//
//Space: O(n) → result list