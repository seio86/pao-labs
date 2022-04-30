package com.company.entities;

import java.util.List;

public abstract class User {
    private long customerId;
    private String password;
    private Role role;

    public User(String password, Role role, int customerId) {
        super();
        this.customerId = customerId;

        this.password = password;
        this.role = role;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User() {
        super();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public abstract List<String> csvValues();

    @Override
    public String toString() {
        return "User [userId=" + customerId + ", password=" + password + ", role=" + role + "]";
    }

}