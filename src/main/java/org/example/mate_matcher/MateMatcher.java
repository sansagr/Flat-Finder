package org.example.mate_matcher;

import com.mongodb.client.MongoDatabase;
import org.example.mate_matcher.controller.LoginController;
import org.example.configs.MongoConfig;
import com.mongodb.client.MongoClient;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.example.mate_matcher.controller.SignupController;
import org.example.mate_matcher.handlers.LoginService;

import org.example.mate_matcher.handlers.SignupService;
import org.example.mate_matcher.repository.LoginStorageImpl;


public class MateMatcher{

    public static void main(String[] args) throws Exception {

        System.out.println("Hello, Gradle!");

        Server server = new Server(8000);
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        handler.setContextPath("/");
        server.setHandler(handler);

        MongoClient mongoClient = MongoConfig.getMongoClient();
        MongoDatabase database = mongoClient.getDatabase("downToFlat");

        LoginStorageImpl loginStorage = new LoginStorageImpl(database);

        LoginService loginService = new LoginService(loginStorage);
        SignupService signupService = new SignupService(loginStorage);

        handler.addServlet(new ServletHolder(new LoginController(loginService)), "/login");
        handler.addServlet(new ServletHolder(new SignupController(signupService)), "/signup");

        server.start();
        server.join();
    }

}
