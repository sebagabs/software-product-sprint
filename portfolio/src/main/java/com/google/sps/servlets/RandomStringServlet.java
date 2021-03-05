package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet("/fetch-hello-world-string")
public class RandomStringServlet extends HttpServlet {

    public String[] stringCollection = {
        "4 is the cosmic number.",
        "This is a random message",
        "I have no idea of what to write here."
    };

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(stringCollection);
        response.setContentType("application/json;");
        response.getWriter().println(json);
    }

}