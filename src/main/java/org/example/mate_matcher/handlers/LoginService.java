package org.example.mate_matcher.handlers;

import org.example.mate_matcher.model.api.FFloginRequest;
import org.example.mate_matcher.model.api.FFloginResponse;
import org.example.mate_matcher.repository.LoginStorageImpl;
import org.example.util.HashString;

public class LoginService {
    private final LoginStorageImpl loginStorage;

    public LoginService(LoginStorageImpl loginStorage) {
        this.loginStorage = loginStorage;
    }

    public FFloginResponse processLogin(FFloginRequest loginRequest){

        String userId = loginRequest.getUserId();
        String password = loginRequest.getPassword();

        if(userId != null && password != null){
            HashString hashString = new HashString();
            String hashedPassword = hashString.getHashString(password);

            return loginStorage.verifyUser(userId, hashedPassword);

        }
        else{
            return new FFloginResponse(false, "Invalid request body");
        }

    }
}
