package com.quest;

import java.util.List;

import static java.util.Objects.isNull;

public class Question {
    private final List<AnswerOption> options;
    private final String description;

    public Question(String description, List<AnswerOption> options) {
        if (isNull(description)) {
            throw new IllegalArgumentException("description cannot be null.");
        } else if (isNull(options)) {
            throw new IllegalArgumentException("options cannot be null.");
        }
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
