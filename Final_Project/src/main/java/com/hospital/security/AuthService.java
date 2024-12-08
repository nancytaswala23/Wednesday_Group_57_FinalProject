package com.hospital.security;

import com.hospital.models.User;
import com.hospital.data.DataStore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;
import java.util.Map;

public class AuthService {
    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
    private final DataStore dataStore;
    private final Map<String, String> userPasswords;

    public AuthService() {
        this.dataStore = DataStore.getInstance();
        this.userPasswords = new HashMap<>();
        initializeDefaultPasswords();
    }

    private void initializeDefaultPasswords() {
        // Initialize default passwords for each user
        userPasswords.put("admin", "admin123");
        userPasswords.put("doctor", "doc123");
        userPasswords.put("patient", "pat123");
        userPasswords.put("dietician", "diet123");
        userPasswords.put("pharmacist", "pharm123");
        userPasswords.put("itsupport", "it123");
        userPasswords.put("community", "comm123");
        userPasswords.put("reception", "rec123");
        userPasswords.put("staffmgr", "staff123");
    }

    public User login(String username, String password) {
        logger.info("Attempting login for user: {}", username);
        
        // Get user from DataStore
        User user = dataStore.getUserByUsername(username);
        
        if (user != null) {
            // Validate password
            String correctPassword = userPasswords.get(username);
            if (correctPassword != null && correctPassword.equals(password)) {
                return user;
            }
            logger.warn("Invalid password attempt for user: {}", username);
        }
        
        return null;
    }

    public void logout() {
        logger.info("User logged out");
    }

    public boolean changePassword(String username, String oldPassword, String newPassword) {
        if (userPasswords.containsKey(username)) {
            String currentPassword = userPasswords.get(username);
            if (currentPassword.equals(oldPassword)) {
                userPasswords.put(username, newPassword);
                logger.info("Password changed successfully for user: {}", username);
                return true;
            }
        }
        logger.warn("Password change failed for user: {}", username);
        return false;
    }
} 