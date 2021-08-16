/*CustomerApplication.java
Application for the Customer
Author:Andy William Hine (219259038)
Date:02 August 2021
 */

package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CustomerApplication
{
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
