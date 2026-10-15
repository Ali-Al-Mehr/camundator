
package camundator.almehr;

import org.camunda.bpm.engine.ProcessEngine;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CamundatorApplicationTests {

    private static final Logger log =
            LoggerFactory.getLogger(CamundatorApplicationTests.class);

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
        log.info("Camundator Spring Boot context loaded successfully.");
    }

    @Test
    void camundaEngineIsAvailable() {
        assertNotNull(processEngine,
                "Camunda Engine failed to start");

        assertNotNull(processEngine.getRepositoryService(),
                "RepositoryService is unavailable");

        assertNotNull(processEngine.getRuntimeService(),
                "RuntimeService is unavailable");

        assertNotNull(processEngine.getTaskService(),
                "TaskService is unavailable");

        log.info("Camunda Engine is available.");
        log.info("Engine name: {}", processEngine.getName());
        log.info("RepositoryService: available");
        log.info("RuntimeService: available");
        log.info("TaskService: available");
    }

    @Test
    void camundaRestApiReturnsVersion() {
        String url = "http://localhost:" + port
                + "/engine-rest/version";

        ResponseEntity<String> response =
                restTemplate.getForEntity(
                        url, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contains("version"));

        log.info("Camunda REST API is available.");
        log.info("HTTP status: {}", response.getStatusCode());
        log.info("REST API response: {}", response.getBody());
    }
}
