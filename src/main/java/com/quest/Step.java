package com.quest;

import java.util.List;

public class Step {
    private final int id;
    private final String description;
    private final List<AnswerOption> options;
    private final int nextStepId;

    public Step(int id, String description, List<AnswerOption> options, int nextStepId) {
        this.id = id;
        this.description = description;
        this.options = options;
        this.nextStepId = nextStepId;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public List<AnswerOption> getOptions() {
        return options;
    }

    public int getNextStepId() {
        return nextStepId;
    }

    public AnswerOption getAnswerOptionById(int optionId) {
        return this.options.stream()
                .filter(option -> option.getId() == optionId)
                .findFirst()
                .orElseGet(null);
    }

}
