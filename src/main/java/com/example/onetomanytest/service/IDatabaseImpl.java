package com.example.onetomanytest.service;

import com.example.onetomanytest.domain.Category;
import com.example.onetomanytest.domain.Product;
import com.example.onetomanytest.repository.CategoryRepository;
import com.example.onetomanytest.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IDatabaseImpl implements  IDatabase {
    private final CategoryRepository categoryRepository;
    private  final ProductRepository productRepository;

    public IDatabaseImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    @Transactional
    public void createDatabase() {

        Category c1 = new Category();
        c1.setName("fruits");

        Category c2 = new Category();
        c2.setName("fruits");

        Product product1 = new Product("Apple",23,2000);
        Product product2 = new Product("Orange",23,2000);
        Product product3= new Product("Chicken",23,2000);
        Product product4 = new Product("Fish",23,2000);

        product1.setCategory(c1);
        product2.setCategory(c1);
        product3.setCategory(c2);
        product4.setCategory(c2);

        categoryRepository.save(c1);
        categoryRepository.save(c2);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);




    }
}
