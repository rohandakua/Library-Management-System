package com.library.management.service.interfaces;

import com.library.management.entity.Admin;

public interface AdminService {
    public boolean logIn (long adminIdFB , String password);
    public boolean logOut (long adminIdFB);
    public Admin getAdminInfo (long adminIdFB);
}
