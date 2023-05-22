package com.quest;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ResetServlet", value = "/reset")
public class RestartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession currentSession = req.getSession(true);

        currentSession.setAttribute("progress", false);

        int gamesCounter = (int) currentSession.getAttribute("gamesCounter");
        currentSession.setAttribute("gamesCounter", gamesCounter + 1);

        resp.sendRedirect("/start");
    }
}
