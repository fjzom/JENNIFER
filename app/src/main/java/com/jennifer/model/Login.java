package com.jennifer.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Alex on 14/01/2016.
 */
public class Login {

    private final String EMAIL = "email";
    private final String PASSWORD = "password";
    private String email;
    private String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Login(JSONObject json) {
        try {
            this.email = json.getString(EMAIL);
            this.password = json.getString(PASSWORD);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
