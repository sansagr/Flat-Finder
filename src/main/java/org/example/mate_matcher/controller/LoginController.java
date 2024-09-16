package org.example.mate_matcher.controller;

import com.google.gson.Gson;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;

import org.example.mate_matcher.handlers.LoginService;
import org.example.mate_matcher.model.api.FFloginRequest;
import org.example.mate_matcher.model.api.FFloginResponse;

public class LoginController extends HttpServlet {
    private final LoginService loginService;
    private final Gson gson = new Gson();

    public LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        FFloginRequest loginRequest = gson.fromJson(new InputStreamReader(req.getInputStream()), FFloginRequest.class);

        FFloginResponse result = loginService.processLogin(loginRequest);

        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);

        String jsonResponse = gson.toJson(result);
        resp.getWriter().println(jsonResponse);
    }

}

