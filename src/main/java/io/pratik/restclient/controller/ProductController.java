package io.pratik.restclient.controller;

import io.pratik.restclient.Model.Product;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    private List<Product> products = List.of(
            new Product("Television", "Samsung", 1145.67, "S001"),
            new Product("Washing Machine", "LG", 114.67, "L001"),
            new Product("Laptop", "Apple", 11453.67, "A001"));

    @GetMapping(value = "/products/{id}",
            produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody Product fetchProducts(
            @PathParam("id") String productId) {
        System.out.println("Provided Id : " + productId);
        return products.get(1);
    }

    @GetMapping("/products")
    public List<Product> fetchProducts() {

        return products;
    }

    @PostMapping("/products")
    public ResponseEntity<String> createProduct(
            @RequestBody Product product) {

        // Create product with ID;
        String productID = UUID.randomUUID().toString();
        product.setId(productID);
        products.add(product);

        return ResponseEntity.ok().body(
                "{\"productID\":\"" + productID + "\"}");
    }

    @PutMapping("/products")
    public ResponseEntity<String> updateProduct(
            @RequestBody Product product) {

        products.set(1, product);
        // Update product. Return success or failure without response body
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/products")
    public ResponseEntity<String> patchProduct(
            @RequestBody Product product) {
       /* Product tempProduct;

        for (Product product1 : products) {
            if (product1.getName().trim().equals(product.getName().trim())) {
                tempProduct = product1;
                break;
            }
        }*/

        System.out.println("Call has been made to the PATCH Http Verb");


        // Update product. Return success or failure without response body
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/products")
    public ResponseEntity<String> deleteProduct(
            @RequestBody Product product) {

        products.remove(1);
        // Update product. Return success or failure without response body
        return ResponseEntity.ok().build();
    }

}
