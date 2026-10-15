
package camundator.almehr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamundatorApplication {

    private static final Logger logger =
            LoggerFactory.getLogger(CamundatorApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CamundatorApplication.class, args);

        logger.info("Camundator is ready. Open http://localhost:8080 in your browser.");
    }
}
