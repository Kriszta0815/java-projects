package springapps.asker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asker")
public class AskerEndpoint {
    private final AskerClient askerClient;

    public AskerEndpoint(AskerClient askerClient) {
        this.askerClient = askerClient;
    }

    @GetMapping("/{question}")
    String giveAnswer(@PathVariable String question) {
        return askerClient.getAnswer(question);
    }
}

