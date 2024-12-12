package acc.br.sap_university;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SapUniversityApplication {
	public static void main(String[] args) {
		SpringApplication.run(SapUniversityApplication.class, args);
	}

}
