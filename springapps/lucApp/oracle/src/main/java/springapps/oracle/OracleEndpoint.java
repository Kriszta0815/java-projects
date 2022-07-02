package springapps.oracle;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answer")
public class OracleEndpoint {
    private final AnswerGiver answerGiver;

    public OracleEndpoint(AnswerGiver answerGiver) {
        this.answerGiver = answerGiver;
    }
    @PostMapping
    String post() {
        return answerGiver.giveAnswer();
    }
}
