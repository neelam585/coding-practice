import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<String> products = new ArrayList<>(List.of("Laptop", "Phone", "Tablat"));
        //List<String> products = new ArrayList<>("Laptop", "Phone", "Tablat");
        Iterator<String> iterator = products.iterator();

        while (iterator.hasNext()) {
            String product = iterator.next();
            if (product.equals("Phone")) {
                iterator.remove(); //safe removel
                //products.remove(product); // unsafe removel
            }
        }
        System.out.println(products); // Output: [Laptop, Tablat]
    }
}
//ArrayList is mutable, List.of() is fixed size and immutable