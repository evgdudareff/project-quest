package com.quest;

import java.util.Arrays;
import java.util.HashMap;

public class StepsConfig {

    private final HashMap<Integer, Step> stepsConfig = new HashMap<>() {{
        put(1, new Step(
                1,
                "Ты потерял память. Принять вызов НЛО?",
                Arrays.asList(
                        new AnswerOption("Принять вызов", true),
                        new AnswerOption("Отклонить вызов", false, "Ты отклонил вызов. Поражение.")),
                2
        ));
        put(2, new Step(
                2,
                "Ты принял вызов. Поднимаешься на мостик к капитану?",
                Arrays.asList(
                        new AnswerOption("Подняться на мостик", true),
                        new AnswerOption("Отказаться подниматься на мостик", false, "Ты не пошёл на переговоры. Поражение.")),
                3
        ));
        put(3, new Step(
                3,
                "Ты поднялся на мостик. Ты кто?",
                Arrays.asList(
                        new AnswerOption("Рассказать правду о себе", true),
                        new AnswerOption("Солгать о себе", false, "Твою ложь разоблачили. Поражение.")),
                0
        ));
    }};

    public HashMap<Integer, Step> getStepsConfig() {
        return stepsConfig;
    }

    public int getInitialStepId() {
        return 1;
    }
}
