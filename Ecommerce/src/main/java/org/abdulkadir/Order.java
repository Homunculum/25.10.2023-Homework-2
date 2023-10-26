package org.abdulkadir;
import java.util.List;
import java.util.ArrayList;
public class Order {
    private int id;
    private List<Product> products;
    private User user;

    public Order(int id, User user) {
        this.id = id;
        this.user = user;
        this.products = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public User getUser() {
        return user;
    }
}
