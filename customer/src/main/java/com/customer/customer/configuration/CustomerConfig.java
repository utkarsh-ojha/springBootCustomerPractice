package com.customer.customer.configuration;

import com.customer.customer.entity.Customer;
import com.customer.customer.repository.CustomerReposotory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {

    @Bean
    CommandLineRunner commandLineRunner(CustomerReposotory customerReposotory) {
        return args -> {
            Customer data1 = new Customer("Prem", "Ojha");
            Customer data2 = new Customer("Urmila", "Ojha");

            customerReposotory.saveAll(List.of(data1, data2));
        };
    }
}
