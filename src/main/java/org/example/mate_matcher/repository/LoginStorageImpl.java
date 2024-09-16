package org.example.mate_matcher.repository;

import com.mongodb.client.MongoCollection;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lombok.extern.log4j.Log4j2;
import org.example.mate_matcher.model.storage.FFlogin;
import org.example.mate_matcher.model.api.FFloginResponse;


@Log4j2
public class LoginStorageImpl {
    private final MongoCollection<FFlogin> collection;

    public LoginStorageImpl(MongoDatabase database){
        this.collection = database.getCollection("userLogin", FFlogin.class);
    }

    public FFloginResponse verifyUser(String userId, String password){

        FFlogin login = collection.find(Filters.eq("userId", userId)).first();
        if (login != null){
            if (!password.equals(login.getPassword())){
                log.info("The username or password you entered is incorrect");
                return new FFloginResponse(false, "Password incorrect");
            }
            else{
                log.info("Login was a success");
                return new FFloginResponse(true, "login success");
            }
        }
        return new FFloginResponse(false, "user not found");
    }

    public FFloginResponse saveUser(String userId, String password) {
        FFlogin existingUser = collection.find(Filters.eq("userId", userId)).first();
        if (existingUser != null) {
            return new FFloginResponse(false, "Username is taken");
        } else {
            FFlogin newUser = new FFlogin(userId, password);
            collection.insertOne(newUser);

            log.info("User with userId {} created successfully", userId);
            return new FFloginResponse(true, "User created successfully");
        }
    }
}
