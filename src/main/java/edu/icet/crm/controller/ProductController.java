package edu.icet.crm.controller;

import edu.icet.crm.Service.ProductService;
import edu.icet.crm.util.LogOperationTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    /*
    Dependency Injection Types
        -Field Injection
        -Constructor Injection
        -Setter Injection

        What is Dependency Injection
        Explain Dependency Injection with Spring Boot -IOC Container
        Explain Dependency Injection with Angular-Constructor Injection Only / React
    */


    /*
    //Field Injection -Maintainability is low not recommended
    //this is a dependency
    //By default this follows singleton design pattern
    //First request will be slow and from second one it will be fast in @Lazy loading
    //@Laszy ->ProductServiceImpl Object Won't be creating untill api request come and 70th code line starting to run- by default this is Eager Loading

    @Autowired
    @Lazy
    ProductService productService;
    */


    // Constructor Injection -Recommended way-convinient for unit testing
    ProductService productService; //this is a dependency

    public ProductController(ProductService productService) {
        log.info("ProductController Object Loaded");
        this.productService = productService;
    }


    /*
    //this is for explain @Scope annotation
    @Autowired
    ProductService productServiceOne;

    @Autowired
    ProductService productServiceTwo;
    */


    //REST API
    //URL : http://localhost:8080/products/all
    //METHOD : GET
    @GetMapping("/all/{transactionAmount}/{transactionType}")
    @LogOperationTime //our oun define annotation to calculate api execution time
    public Map<String, String> getProducts(@PathVariable String transactionAmount, @PathVariable String transactionType) {
        //System.out.println(transactionAmount); //traditional way
        //we use logs for auditing purposes
        log.info("Transaction Received. Payment Amount {} and Transaction Type {} ", transactionAmount, transactionType); //Recommended way
        return productService.getStudent();

    }

    @PostMapping("/create")
    public Map<String, String> createProducts() {
        return productService.getStudent();
    }

    @DeleteMapping("/delete")
    public Map<String, String> delete() {
        return productService.getStudent();
    }
}


