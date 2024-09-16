package org.example.mate_matcher.model.api;


import lombok.Data;
import java.util.Date;

@Data
public class FFloginResponse {
    private boolean success;
    private String message;
    private Date timestamp;

    public FFloginResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.timestamp = new Date(); // Automatically set the response timestamp to the current time
    }
}
