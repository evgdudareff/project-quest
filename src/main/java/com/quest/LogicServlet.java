package com.quest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet(name = "LogicServlet", value = "/play")
public class LogicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession currentSession = req.getSession(true);

        currentSession.setAttribute("progress", true);

        Step currStep = getCurrStep(req);

        Question question = new Question(currStep.getDescription(), currStep.getOptions());

        sendJson(question, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String answerOptionId = req.getParameter("answerOptionId");

        HttpSession currentSession = req.getSession();
        Step currStep = getCurrStep(req);

        AnswerOption answerOption = currStep.getAnswerOptionById(Integer.parseInt(answerOptionId));

        AnswerResult answerResult;

        if (answerOption.isTrueAnswer()) {
            int nextStepId = currStep.getNextStepId();
            currentSession.setAttribute("currStepId", nextStepId);

            if (nextStepId != 0) {
                answerResult = new AnswerResult(true, nextStepId, null);
            } else {
                String victoryMessage = "Тебя вернули домой. Победа!";
                answerResult = new AnswerResult(true, nextStepId, victoryMessage);
            }
        } else {
            answerResult = new AnswerResult(false, 0, answerOption.getFailedMessage());
        }

        sendJson(answerResult, resp);
    }

    private void sendJson(Object data, HttpServletResponse resp) throws IOException {
        resp.setCharacterEncoding("UTF8");
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();

        Gson gson = new GsonBuilder().create();
        gson.toJson(data, writer);
    }

    private Step getCurrStep(HttpServletRequest req) {
        HttpSession currentSession = req.getSession();

        HashMap<Integer, Step> stepsConfig = (HashMap<Integer, Step>) currentSession.getAttribute("stepsConfig");
        int currStepId = (Integer) currentSession.getAttribute("currStepId");

        return stepsConfig.get(currStepId);
    }
}
