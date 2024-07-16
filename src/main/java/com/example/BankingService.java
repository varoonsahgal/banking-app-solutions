package com.example;

import java.util.HashMap;
import java.util.Map;

public class BankingService {
    private Map<String, User> users;

    public BankingService() {
        users = new HashMap<>();
    }

    public void register(String username) {
        users.put(username, new User(username));
    }

    public boolean isUsernameTaken(String username) {
        return users.containsKey(username);
    }

    public User getUser(String username) {
        return users.get(username);
    }
}
