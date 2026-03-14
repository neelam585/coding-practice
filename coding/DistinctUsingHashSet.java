/*import java.util.Arrays;
import java.util.HashSet;
import java.util.List;*/
import java.util.*;
public class DistinctUsingHashSet {
    public static void main(String[] args){
        int[] nums = {1, 2, 2, 3, 4, 4, 5};
        List<Integer> unique = Arrays.stream(nums).boxed().distinct().toList();
        System.out.println(unique);
        HashSet<Integer> distinct = new HashSet<>();
        for(int num: nums){
            distinct.add(num);
        }
        System.out.println(distinct);
    }
}
