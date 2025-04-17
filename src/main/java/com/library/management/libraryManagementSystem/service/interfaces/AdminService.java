package com.library.management.libraryManagementSystem.service.interfaces;

import com.library.management.libraryManagementSystem.entity.Admin;

public interface AdminService {
    public boolean logIn (long adminIdFB , String password);
    public boolean logOut (long adminIdFB);
    public Admin getAdminInfo (long adminIdFB);
}
