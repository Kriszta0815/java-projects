package springapps.asker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class AskerClient {
    private final RestTemplate restTemplate;
    private final String url;

    public AskerClient(RestTemplate restTemplate,
                       @Value("${asker.oracleUrl}") String url) {
        this.restTemplate = restTemplate;
        this.url = url;
    }
    public String getAnswer(String input) {
        return restTemplate.postForObject(url,input, String.class);
    }
}

