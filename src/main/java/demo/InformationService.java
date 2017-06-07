package demo;

import demo.domain.Information;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by vagrant on 6/7/17.
 */

@SpringBootApplication
public class InformationService {

    public static void main(String[] args) {
        SpringApplication.run(Information.class, args);
    }
}
