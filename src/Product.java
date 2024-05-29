public class Product {
    Long id;
    String name;
    String category;
    double price;

    public Product ( Long id , String name , String category , double price){
        this.id=id;
        this.name=name;
        this.category=category;
        this.price=price;
    }
public Long getid(){
        return id;
}

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public String toString() {
        return "Prodotti :{id=" + id + " "  + "name=" + name + ""  + ", category='" + category + " " + ", price=" + price + '}';
    }
}
