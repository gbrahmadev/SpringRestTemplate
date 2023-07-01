package io.pratik.restclient.consumer;

import io.pratik.restclient.Model.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestConsumer {
    public void getProductAsJson() {
        RestTemplate restTemplate = new RestTemplate();

        String resourceUrl
                = "http://localhost:8080/products";

        // Fetch JSON response as String wrapped in ResponseEntity
        ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);

        String productsJson = response.getBody();

        System.out.println(productsJson);
    }

    public void getProducts() {
        RestTemplate restTemplate = new RestTemplate();

        String resourceUrl
                = "http://localhost:8080/products";

        // Fetch response as List wrapped in ResponseEntity
        ResponseEntity<List> response
                = restTemplate.getForEntity(resourceUrl, List.class);

        List<Product> products = response.getBody();
        System.out.println(products);
    }

    public void getProductObjects() {

        RestTemplate restTemplate = new RestTemplate();

        String resourceUrl
                = "http://localhost:8080/products";

        // Fetching response as Object
        List<?> products
                = restTemplate.getForObject(resourceUrl, List.class);

        System.out.println(products);
    }

    public void createProduct() {
        RestTemplate restTemplate = new RestTemplate();

        String resourceUrl
                = "http://localhost:8080/products";

        // Create the request body by wrapping
        // the object in HttpEntity
        HttpEntity<Product> request = new HttpEntity<Product>(
                new Product("Television", "Samsung",1145.67,"S001"));

        // Send the request body in HttpEntity for HTTP POST request
        String productCreateResponse = restTemplate
                .postForObject(resourceUrl, request, String.class);

        System.out.println(productCreateResponse);
    }
}
