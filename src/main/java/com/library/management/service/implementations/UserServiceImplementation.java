package com.library.management.service.implementations;


import com.library.management.entity.Admin;
import com.library.management.entity.LoggedInAdmin;
import com.library.management.entity.LoggedInUser;
import com.library.management.entity.User;
import com.library.management.repository.AdminRepository;
import com.library.management.repository.LoggedInAdminRepository;
import com.library.management.repository.LoggedInUserRepository;
import com.library.management.repository.UserRepository;
import com.library.management.service.interfaces.AdminService;
import com.library.management.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository = null;
    @Autowired
    LoggedInUserRepository loggedInUserRepository = null;


    public UserServiceImplementation(UserRepository adm , LoggedInUserRepository liur){
        userRepository = adm;
        loggedInUserRepository = liur;
    }

    @Override
    public boolean logIn(long userIdFB , String password) {
        User temp = userRepository.findById(userIdFB).orElse(null);
        if(temp!=null){
            boolean b = temp.getPassword() == password;
            if(b){
                loggedInUserRepository.save(new LoggedInUser(userIdFB,"jwt",temp));
            }
            return b;
        }
        return false;
    }

    @Override
    public boolean logOut(long userIdFB) {
        loggedInUserRepository.deleteById(userIdFB);
        return false;
    }

    @Override
    public User getUserInfo(long userIdFB) {
        return userRepository.findById(userIdFB).orElse(null);
    }
}

