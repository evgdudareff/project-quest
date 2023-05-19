import com.quest.AnswerOption;
import com.quest.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class StepTest {

    private final List<AnswerOption> options = Arrays.asList(
            new AnswerOption("Принять вызов", true),
            new AnswerOption("Отклонить вызов", false, "Ты отклонил вызов. Поражение.")
    );
    private final int firstStepId = 1;
    private final int secondStepId = 2;
    private final String description = "Ты потерял память. Принять вызов НЛО?";

    @Test
    @DisplayName("Step creation with null description fails")
    void constructorFailsWithNullDescription() {
        assertThrows(IllegalArgumentException.class, () ->
                new Step(
                        firstStepId,
                        null,
                        options,
                        secondStepId
                ));
    }

    @Test
    @DisplayName("Step creation with null options fails")
    void constructorFailsWithNullOptions() {
        assertThrows(IllegalArgumentException.class, () ->
                new Step(
                        firstStepId,
                        description,
                        null,
                        secondStepId
                ));
    }

    @Test
    @DisplayName("First step linked to next step")
    void firstStepIdPointsToSecondStepId() {
        Step firstStep = new Step(
                firstStepId,
                description,
                options,
                secondStepId
        );

        assertEquals(firstStep.getNextStepId(), secondStepId);
    }
}
