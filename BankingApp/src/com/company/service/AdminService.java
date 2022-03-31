package com.company.service;
import com.company.entities.Admin;

import java.util.List;
public interface AdminService
{
    List<Admin> addAdmin(Admin admin);
    List<Admin>updateAdmin(Admin admin);
    List<Admin>deleteAdmin(long adminId);
    Admin findAdminById(long adminId);
    List<Admin>listAllAdmin();
}
