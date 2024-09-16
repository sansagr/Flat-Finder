package org.example.mate_matcher.model.storage;

import lombok.Data;
import java.util.Date;

@Data
public class FFlogin {
    private String userId;
    private String password;
    private Date createdAt;
    private Date updatedAt;

    // No-argument constructor required by MongoDB
    public FFlogin() {
    }

    // Constructor with parameters
    public FFlogin(String userId, String password) {
        this.userId = userId;
        this.password = password;
        this.createdAt = new Date();  // Set creation date to current date
        this.updatedAt = new Date();  // Set update date to current date
    }

    // Method to update the password
    public void updatePassword(String newPassword) {
        this.password = newPassword;
        this.updatedAt = new Date();  // Update the timestamp when the password is changed
    }
}
