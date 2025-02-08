package uz.pdp.service_registr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistrApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistrApplication.class, args);
	}

}
