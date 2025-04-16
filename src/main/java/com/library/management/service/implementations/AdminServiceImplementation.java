package com.library.management.service.implementations;

import com.library.management.entity.Admin;
import com.library.management.entity.LoggedInAdmin;
import com.library.management.repository.AdminRepository;
import com.library.management.repository.LoggedInAdminRepository;
import com.library.management.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImplementation implements AdminService {
    @Autowired
    AdminRepository adminRepository = null;
    @Autowired
    LoggedInAdminRepository loggedInAdminRepository = null;


    public AdminServiceImplementation(AdminRepository adm , LoggedInAdminRepository liar){
        adminRepository = adm;
        loggedInAdminRepository = liar;
    }

    @Override
    public boolean logIn(long adminIdFB , String password) {
        Admin temp = adminRepository.findById(adminIdFB).orElse(null);
        if(temp!=null){
            boolean b = temp.getPassword() == password;
            if(b){
                loggedInAdminRepository.save(new LoggedInAdmin(adminIdFB,"jwt",temp));
            }
            return b;
        }
        return false;
    }

    @Override
    public boolean logOut(long adminIdFB) {
        loggedInAdminRepository.deleteById(adminIdFB);
        return false;
    }

    @Override
    public Admin getAdminInfo(long adminIdFB) {
        return adminRepository.findById(adminIdFB).orElse(null);
    }
}
