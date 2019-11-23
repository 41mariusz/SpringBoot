package pl.xc.waw.firstspringproject;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductManager {

    private List<Product> productList;
    private List<Product> productListLimit;

    public ProductManager() {
        this.productList = new ArrayList<>();
        this.productListLimit = new ArrayList<>();
        productList.add(new Product("Telefon", "samsung s10e", 12.12));
        productList.add(new Product("Laptop", "acer", 31.99));
        productList.add(new Product("Monitor", "iiyama", 22.89));
        productList.add(new Product("Klawiatura", "logitech", 43.21));
    }

    public List<Product> getProductListLimit(int from, int to) {
        productListLimit.clear();
        for (int i = 0; i < to - from; i++) {
            productListLimit.add(productList.get(from + i));
        }
        return productListLimit;
    }

    public boolean addProduct(Product product) {
        return productList.add(product);
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product delProduct(int id) {
        return productList.remove(id);
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
