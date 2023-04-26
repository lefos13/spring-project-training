package com.appsdeveloperblog.app.ws.mobileappws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// `@SpringBootApplication` is a combination of three annotations: `@Configuration`,
// `@EnableAutoConfiguration`, and `@ComponentScan`. It is used to indicate that this is the main class
// of a Spring Boot application and enables auto-configuration and component scanning. It also allows
// the class to define beans and configuration for the application.
@SpringBootApplication
public class MobileAppWsApplication {

  public static void main(String[] args) {
    SpringApplication.run(MobileAppWsApplication.class, args);
  }
}
