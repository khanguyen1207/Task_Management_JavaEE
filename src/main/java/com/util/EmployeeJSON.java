package com.util;

public class EmployeeJSON {
    private String username;
    private String role;
    private String avatar_url;
    private String email;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public EmployeeJSON(String username, String role, String avatar_url, String email) {

        this.username = username;
        this.role = role;
        this.avatar_url = avatar_url;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
