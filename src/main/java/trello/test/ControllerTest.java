package trello.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import trello.SkyTrelloApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SkyTrelloApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class ControllerTest extends WebIntegrationTest {
	@Value("${local.server.port}")
	private int port;

//	@Test
//	public void getHome() {
//		RestTemplate rt = new TestRestTemplate();
//		String result = rt.getForObject("http://localhost:" + port, String.class);
//		System.out.println(result);
//	}

	@Test
	public void getHome() {
		RestTemplate rt = new TestRestTemplate();
		String result = rt.getForObject(baseUrl(), String.class);
		System.out.println(result + "chiho");
	}
}