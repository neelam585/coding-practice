import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalCheck {
    private static String s= "";
   public static void main(String[] args){
       final  List<String> str = new ArrayList<>();
       str.add("Hello");
       str.add("World");
       str.add(null);
       str.add("");
       str.add("patel");
       Optional.ofNullable(str).orElseGet(ArrayList::new).forEach(System.out::println);
       boolean result = Optional.ofNullable(s).isEmpty();
       System.out.println(result);
   }
}
