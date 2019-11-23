package pl.xc.waw.firstspringproject;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
public class ProductApi {

    private ProductManager productManager;

    @Autowired
    public ProductApi(ProductManager productManager) {
        this.productManager = productManager;
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        log.info("[GET] /getProducts");
        return productManager.getProductList();
    }

    @GetMapping("/getProducts/limit/{from}/{to}")
    public List<Product> getProductsLimit(@PathVariable int from, @PathVariable int to) {
        log.info("[GET] /getProducts/limit/" + from + "/" + to);
        return productManager.getProductListLimit(from, to);
    }

    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable int id) {
        log.info("[GET] /getProduct/" + id);
        return productManager.getProductList().get(id);
    }

    @DeleteMapping("/delProduct/{id}")
    public Product delProduct(@PathVariable int id) {
        log.info("[DELETE] /delProduct");
        return productManager.delProduct(id);
    }

    @PostMapping("/addProduct")
    public boolean addProduct(@RequestBody Product product) {
        log.info("[POST] /addProduct :: name [" + product.getName() + "], description ["
                + product.getDescription() + "], price [" + product.getPrice() + "]");
        return productManager.addProduct(product);
    }
}
