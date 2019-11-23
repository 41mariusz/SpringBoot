package pl.xc.waw.firstspringproject;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private String name;
    private String description;
    private double price;

    public Product() {
    }

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

}
