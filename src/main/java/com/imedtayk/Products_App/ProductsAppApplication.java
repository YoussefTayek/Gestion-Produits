package com.imedtayk.Products_App;

import com.imedtayk.Products_App.entities.Product;
import com.imedtayk.Products_App.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class ProductsAppApplication implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProductsAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//productRepository.save(new Product(null,"Computer",4300,3));
		//productRepository.save(new Product(null,"Printer",1200,4));
		//productRepository.save(new Product(null,"Smart Phone",3200,32));
		productRepository.findAll().forEach(System.out::println);

		Product product = productRepository.findById(Long.valueOf(1)).get();
		System.out.println(product.getId());
		System.out.println(product.getName());
		System.out.println(product.getPrice());

		System.out.println("********************************");
		List<Product> products = productRepository.findByNameContains("C");
		products.forEach(System.out::println);
		System.out.println("----------------------------------");

		List<Product> products2 = productRepository.search("%S%");
		products2.forEach(System.out::println);
		System.out.println("----------------------------------");
		System.out.println("======================By Price=============================");
		List<Product> products3 = productRepository.findByPriceGreaterThan(3000);
		products3.forEach(System.out::println);
		System.out.println("===========================================================");
		System.out.println("======================By Price 2=============================");
		List<Product> products4 = productRepository.searchByPrice(4300);
		products4.forEach(System.out::println);
		System.out.println("===========================================================");

	}
}
