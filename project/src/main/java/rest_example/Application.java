
package rest_example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jelena.nikolic
 *
 */
@SpringBootApplication
public class Application {
	
	@Autowired
	DataSource dataSource;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
