package trello.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.IntegrationTest;

import trello.SkyTrelloApplication;

@SpringApplicationConfiguration(classes = SkyTrelloApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public abstract class WebIntegrationTest {
 @Value("${local.server.port}")
 private int port;

 protected String baseUrl() {
 return String.format("http://localhost:%d", port);
 }
}
