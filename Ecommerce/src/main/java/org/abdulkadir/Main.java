package org.abdulkadir;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Kategori oluşturma
        Category elektronik = new Category(1, "Elektronik");
        Category giysi = new Category(2, "Giysi");


        // Ürün oluşturma
        Product laptop = new Product(1, "Laptop", 19999, elektronik);
        Product tshirt = new Product(2, "TShirt", 99, giysi);

        // Kullanıcı oluşturma
        User user1 = new User(1, "Homunculum", "a.kadir.e.91@gmail.com");
        User user2 = new User(2, "Ahmet3552", "ahmet3552@hotmail.com");
        User user3 = new User(3, "CrayzyBoy", "hatasiz_cool_olmaz@msn.com");

        // Sipariş oluşturma
        Order order1 = new Order(1, user1);
        order1.addProduct(laptop);
        order1.addProduct(tshirt);
        Order order2 = new Order(2, user2);
        order2.addProduct(laptop);
        Order order3 = new Order(3, user3);
        order3.addProduct(tshirt);

        // Kullanıcının sipariş geçmişini tutmak için bir liste oluşturdum
        List<Order> orderHistory = new ArrayList<>();
        orderHistory.add(order1);
        orderHistory.add(order2);
        orderHistory.add(order3);

        // Kullanıcının sipariş geçmişini görüntüleme
        System.out.println("Kullanıcının Sipariş Geçmişi:");
        for (Order userOrder : orderHistory) {
            System.out.println("Sipariş ID: " + userOrder.getId());
            System.out.println("User: " + userOrder.getUser().getUsername());
            System.out.println("Satın alınan ürünler:");
            double toplamFiyat = 0.0;
            for (Product product : userOrder.getProducts()) {
                double fiyat = product.getPrice();
                toplamFiyat += fiyat;
                System.out.println("Ürün: " +product.getCategory().getName()+ " | "+ product.getName()+  " | Fiyat: " + product.getPrice() + " TL");
            }
            System.out.println("Toplam Fiyat: " + toplamFiyat + " TL");
            System.out.println();
        }
    }
}