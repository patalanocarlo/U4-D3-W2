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
                new Product(4566L, "Tolkien", "Books", 200.0),
                new Product(23254L, " Libro per Bambini" , "Baby" ,50),
                new Product(2864L, " Libro per Bambini2" , "Baby" ,60.32),
                new Product(2474L, " Libro per Bambini3" , "Baby" ,90.85)
        );


        List<Product> filteredProducts = products.stream()
                .filter(p -> "Books".equals(p.getCategory()) && p.getPrice() > 100)
                .collect(Collectors.toList());
        System.out.println("Questi sono i libri che ho filtrato per ottenere solo quelli con il prezzo maggiore di 100 e la categoria books:");
        filteredProducts.forEach(System.out::println);

        List<Product> ProdottiPerBambini = products.stream()
                .filter(p -> "Baby".equals(p.getCategory()))
                .collect(Collectors.toList());
        System.out.println("Ecco i prodotti filtrati per bambini:");
        ProdottiPerBambini.forEach(System.out::println);


        List<Order> orders = new ArrayList<>();
        Customer customer = new Customer(19049L, "Carlo Patalano", 1);
        orders.add(new Order(19049L, "In spedizione", LocalDate.now(), LocalDate.now().plusDays(2), products, customer));


        List<Order> ordineDeiProdottiPerBambini= orders.stream()
                .filter(order -> order.getProducts().stream().anyMatch(product -> "Baby".equals(product.getCategory())))
                .collect(Collectors.toList());
        ordineDeiProdottiPerBambini.forEach(System.out::println);



    }
}