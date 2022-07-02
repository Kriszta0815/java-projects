package springapps.oracle;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AnswerGiver {
    private final Random random = new Random();
    private final List<String> emojis;
    private final int numberOfEmoji;

    public AnswerGiver(
            @Value("${oracle.emojis}") List<String> emojis,
            @Value("${oracle.numberOfEmoji}") int numberOfEmoji) {
        this.emojis = emojis;
        this.numberOfEmoji = numberOfEmoji;
    }
    public String giveAnswer() {
        StringBuilder result = new StringBuilder();
        for(int i= 0; i < numberOfEmoji; i++) {
            result.append(emojis.get(random.nextInt(emojis.size())));
        }
        return result.toString();
    }
}
