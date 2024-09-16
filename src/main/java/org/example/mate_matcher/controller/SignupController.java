package org.example.mate_matcher.controller;

import com.google.gson.Gson;
import org.example.mate_matcher.handlers.SignupService;
import org.example.mate_matcher.model.api.FFloginRequest;
import org.example.mate_matcher.model.api.FFloginResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;

public class SignupController extends HttpServlet {
    private final SignupService signupService;
    private final Gson gson = new Gson();
    public SignupController(SignupService signupService){
        this.signupService = signupService;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        FFloginRequest signupRequest = gson.fromJson(new InputStreamReader(req.getInputStream()), FFloginRequest.class);

        FFloginResponse result = signupService.processLogin(signupRequest);

        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);

        String jsonResponse = gson.toJson(result);
        resp.getWriter().println(jsonResponse);
    }

}

