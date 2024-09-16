package org.example.mate_matcher.handlers;

import org.example.mate_matcher.model.api.FFloginRequest;
import org.example.mate_matcher.model.api.FFloginResponse;
import org.example.mate_matcher.repository.LoginStorageImpl;
import org.example.util.HashString;

public class SignupService {
    private final LoginStorageImpl loginStorage;

    public SignupService(LoginStorageImpl loginStorage) {
        this.loginStorage = loginStorage;
    }
    public FFloginResponse processLogin(FFloginRequest loginRequest){

        String userId = loginRequest.getUserId();
        String password = loginRequest.getPassword();

        if(userId != null && password != null){
            HashString hashString = new HashString();
            String hashedPassword = hashString.getHashString(password);

            return loginStorage.saveUser(userId, hashedPassword);

        }
        else{
            return new FFloginResponse(false, "Invalid request body");
        }

    }
}

