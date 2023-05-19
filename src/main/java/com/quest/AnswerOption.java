package com.quest;

import static java.util.Objects.isNull;

public class AnswerOption {
    private final String description;
    private static int globalId = 1;
    private final int id;
    private transient final boolean isTrueAnswer;
    private transient String failedMessage;

    public AnswerOption(String description, boolean isTrueAnswer){
        if (isNull(description)) {
            throw new IllegalArgumentException("description cannot be null.");
        }

        globalId++;
        this.id = globalId;
        this.description = description;
        this.isTrueAnswer = isTrueAnswer;

    }

    public AnswerOption(String description,boolean isTrueAnswer, String failedMessage){
        this(description, isTrueAnswer);
        this.failedMessage = failedMessage;
    }

    public int getId() {
        return id;
    }

    public String getDescription(){
        return description;
    }

    public boolean isTrueAnswer() {
        return isTrueAnswer;
    }

    public String getFailedMessage(){
        return failedMessage;
    }
}
