import java.lang.Integer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Practice2 {
    public static void manin(String[] args) {
        List<Integer> num = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> desc = num.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(desc);

        List<Integer> AsceNum = num.stream().sorted().toList();
        System.out.println(AsceNum);


        Integer first = num.stream().findFirst().orElse(Integer.valueOf("0"));
        System.out.println(first);

        Long count = num.stream().count();
        System.out.println(count);

        List<Integer> even = num.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(even);

        List<Integer> odd = num.stream().filter(n -> n % 2 == 1).collect(Collectors.toList());
        System.out.println(odd);

        List<Integer> squire = num.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println(squire);

        Integer sum = num.stream().reduce(0, (a, b) -> (a + b));
        System.out.println(squire);

        Integer squireSum = num.stream().map(n -> n * n).reduce(0, (a, b) -> (a + b));
        System.out.println(squireSum);


        List<Integer> num2 = Arrays.asList(1, 2, 3, 4, 5, 5);

        /*Set<Integer> unique = new.HashSet<>(num2);
        System.out.println(unique);*/

        List<Integer> num3 = Arrays.asList(1, 2, 3, 4, 5, 5, 3);
        List<Integer> unique2 = num3.stream().distinct().toList();

        System.out.println(unique2);
        List<Integer> num4 = Arrays.asList(1, 2, 3, 4, 5, 5, 3);
    }
}









