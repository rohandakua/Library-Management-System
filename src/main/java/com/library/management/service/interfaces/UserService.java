package com.library.management.service.interfaces;

import com.library.management.entity.User;

public interface UserService {
    public boolean logIn (long userIdFB , String password);
    public boolean logOut (long userIdFB);
    public User getUserInfo (long userIdFB);


}
