package com.quest;

import java.util.List;

public class Question {
    private final List<AnswerOption> options;
    private final String description;

    public Question(String description, List<AnswerOption> options) {
        this.description = description;
        this.options = options;
    }

    public List<AnswerOption> getOptions() {
        return options;
    }

    public String getDescription() {
        return description;
    }
}
