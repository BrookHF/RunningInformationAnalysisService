package demo;

import demo.domain.RunningInformation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by vagrant on 6/7/17.
 */

@SpringBootApplication
public class RunningInformationService {

    public static void main(String[] args) {
        SpringApplication.run(RunningInformation.class, args);
    }
}
