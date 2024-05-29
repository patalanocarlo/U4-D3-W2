import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Product> products = List.of(
                new Product(134L, "Harry Potter", "Books", 120.0),
                new Product(243L, "Il signore degli Anelli", "Books", 90.0),
                new Product(35634L, "JoJo", "Manga", 150.0),
                new Product(4566L, "Tolkien", "Books", 200.0)
        );


        List<Product> filteredProducts = products.stream()
                .filter(p -> "Books".equals(p.getCategory()) && p.getPrice() > 100)
                .collect(Collectors.toList());


        filteredProducts.forEach(System.out::println);


        List<Order> orders = new ArrayList<>();
        Customer customer = new Customer(1L, "John Doe", 1);
        orders.add(new Order(1L, "Shipped", LocalDate.now(), LocalDate.now().plusDays(2), products, customer));


    }
}