package ru.koleson.photoappaccmanag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppAccManagApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoAppAccManagApplication.class, args);
    }

}
