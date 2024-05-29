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
                new Product(2474L, " Libro per Bambini3" , "Baby" ,90.85),
                new Product(1990L," Elicottero Giocattolo" , "Boys" , 34.21),
                new Product(17546L, "Mongolfiera Giocattolo" , "Boys" , 120.32)
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

        List<Product>ProdottiPerRagazzi = products.stream()
                .filter(p -> "Boys".equals(p.getCategory()) )
                .map(p -> new Product(p.getid() , p.getName(), p.getCategory(),p.getPrice() * 0.9))
                .collect(Collectors.toList());
        System.out.println("Ecco i prodotti per i Ragazzi con il 10% di sconto:");

        ProdottiPerRagazzi.forEach(System.out::println);


        List<Order> orders = new ArrayList<>();
        Customer customer = new Customer(19049L, "Carlo Patalano", 2);
        orders.add(new Order(19049L, "In spedizione", LocalDate.now(), LocalDate.now().plusDays(2), products, customer));

        List<Order> ordiniClientiLivello2 = orders.stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> order.getOrderDate().isAfter(LocalDate.of(2024, 5, 20)))
                .filter(order -> order.getOrderDate().isBefore(LocalDate.of(2024, 6, 1)))
                .collect(Collectors.toList());

        System.out.println("Ordini da clienti di livello 2 tra il 20 Maggio 2024 e il 1 giugno 2024:");
        ordiniClientiLivello2.forEach(System.out::println);






    }
}