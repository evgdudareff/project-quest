import com.quest.AnswerOption;
import com.quest.Question;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class QuestionTest {

    private final List<AnswerOption> options = Arrays.asList(
            new AnswerOption("Принять вызов", true),
            new AnswerOption("Отклонить вызов", false, "Ты отклонил вызов. Поражение.")
    );
    private final String description = "Ты потерял память. Принять вызов НЛО?";

    @Test
    @DisplayName("Question creation with null description fails")
    void constructorFailsWithNullDescription() {
        assertThrows(IllegalArgumentException.class, () ->
                new Question(
                        null,
                        options
                ));
    }

    @Test
    @DisplayName("Question creation with null options fails")
    void constructorFailsWithNullOptions() {
        assertThrows(IllegalArgumentException.class, () ->
                new Question(
                        description,
                        null
                ));
    }
}
