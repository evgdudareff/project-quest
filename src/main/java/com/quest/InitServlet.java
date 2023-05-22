package com.quest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession currentSession = req.getSession(true);

        if (!hasGameSession(currentSession)) {
            StepsConfig stepsConfig = new StepsConfig();

            currentSession.setAttribute("stepsConfig", stepsConfig.getStepsConfig());
            currentSession.setAttribute("currStepId", stepsConfig.getInitialStepId());

            Object gamesCounter = currentSession.getAttribute("gamesCounter");
            if (gamesCounter == null) {
                currentSession.setAttribute("gamesCounter", 1);
            }
        }

        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    private boolean hasGameSession(HttpSession currentSession) {
        if (currentSession == null) {
            return false;
        }

        Object progressSession = currentSession.getAttribute("progress");
        if (progressSession == null) {
            return false;
        }

        boolean progress = (boolean) progressSession;
        return progress;

    }
}
