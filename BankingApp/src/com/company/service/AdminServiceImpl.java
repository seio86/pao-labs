package com.company.service;

import com.company.entities.Admin;

import java.util.List;

public class AdminServiceImpl implements AdminService{

    private static AdminService INSTANCE;

    private AdminServiceImpl() {
    }

    private static AdminService getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new AdminServiceImpl();
        }
        return INSTANCE;
    }


    @Override
    public List<Admin> addAdmin(Admin admin) {
        return null;
    }

    @Override
    public List<Admin> updateAdmin(Admin admin) {
        return null;
    }

    @Override
    public List<Admin> deleteAdmin(long adminId) {
        return null;
    }

    @Override
    public Admin findAdminById(long adminId) {
        return null;
    }

    @Override
    public List<Admin> listAllAdmin() {
        return null;
    }
}
