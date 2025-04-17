package com.library.management.libraryManagementSystem.service.implementations;


import com.library.management.libraryManagementSystem.entity.LoggedInUser;
import com.library.management.libraryManagementSystem.entity.User;
import com.library.management.libraryManagementSystem.repository.LoggedInUserRepository;
import com.library.management.libraryManagementSystem.repository.UserRepository;
import com.library.management.libraryManagementSystem.service.interfaces.UserService;
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

