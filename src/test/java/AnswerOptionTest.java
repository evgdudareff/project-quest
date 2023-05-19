import com.quest.AnswerOption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AnswerOptionTest {
    private final String description = "Принять вызов";
    private final int id = 1;
    private String failedMessage = "Поражение";

    @Test
    @DisplayName("AnswerOption creation increments globalId")
    void answerOptionCreationIncrementsGlobalId(){
        AnswerOption answerOption1 = new AnswerOption(description, true);
        int currId = answerOption1.getId();
        AnswerOption answerOption2 = new AnswerOption(description, false);
        AnswerOption answerOption3 = new AnswerOption(description, true, failedMessage);

        assertEquals(answerOption3.getId(), currId + 2);
    }

    @Test
    @DisplayName("AnswerOption creation with isTrueAnswer returns True")
    void answerOptionCreationWithTrueAnswerFlagReturnsTrue(){
        AnswerOption answerOption = new AnswerOption(description, true);

        assertTrue(answerOption.isTrueAnswer());
    }

    @Test
    @DisplayName("AnswerOption creation without failedMessage is OK")
    void answerOptionCreationWithWithoutFailedMessageDoesNotFail(){
        AnswerOption answerOption = new AnswerOption(description, true);

        assertNull(answerOption.getFailedMessage());
    }

}
