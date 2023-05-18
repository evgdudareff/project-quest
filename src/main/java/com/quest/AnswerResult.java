package com.quest;

public class AnswerResult {
    private boolean success;
    private transient int nextStepId;
    private String message;

    public AnswerResult(boolean success, int nextStepId, String message){
        this.success = success;
        this.nextStepId = nextStepId;
        this.message = message;
    }
}
