package com.company.entities;

import java.util.List;

public class Admin extends User {
    private String adminName;
    private String adminContact;

    public Admin() {
    }

    public Admin(String adminName, String adminContact) {
        super();

        this.adminName = adminName;
        this.adminContact = adminContact;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminContact() {
        return adminContact;
    }

    public void setAdminContact(String adminContact) {
        this.adminContact = adminContact;
    }

    public List<String> csvValues() {
        return null;
    }

}