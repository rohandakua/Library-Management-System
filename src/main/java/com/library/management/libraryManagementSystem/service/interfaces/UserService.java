package com.library.management.libraryManagementSystem.service.interfaces;

import com.library.management.libraryManagementSystem.entity.User;

public interface UserService {
    public boolean logIn (long userIdFB , String password);
    public boolean logOut (long userIdFB);
    public User getUserInfo (long userIdFB);


}
