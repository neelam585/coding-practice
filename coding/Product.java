import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.*;
import java.util.function.Function;
import java.util.Optional;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + '}';
    }



    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 1200.0),
            new Product("Smartphone", 800.0),
            new Product("Tablet", 400.0),
            new Product("Smartwatch", 250.0)
        );
//
        Map<Boolean, List<Product>> costlyPro = products.stream()
                .collect(Collectors.partitioningBy(a->a.getPrice()>400));
        System.out.println(costlyPro);

        Map<String, List<String>> highProductName = products.stream().collect(Collectors.groupingBy(
                n->n.getPrice()>400 ? "High": "Low" ,
                Collectors.mapping(Product::getName, Collectors.toList())));
        System.out.println(highProductName);

        // Find the product with the maximum price
        Optional<Product> maxPricedProduct = products.stream()
            .max(Comparator.comparing(Product::getPrice));
            
            System.out.println(maxPricedProduct);

        // Output the result
        maxPricedProduct.ifPresentOrElse(
            product -> System.out.println("Product with the highest price: " + product),
            () -> System.out.println("No products available.")
        );



    }
}