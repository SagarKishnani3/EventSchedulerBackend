package com.events.events.service;

import com.events.events.repository.pageListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@Service
public class pageListingService {
    @Autowired
    private pageListingRepository pagelistingrepository;


    public List<Map<String,Object>> getpageListing(){
        return pagelistingrepository.getpageListing();
    }
    public Map<String , Object> fetchUser(int id){
        return pagelistingrepository.fetchUSer(id);
    }
    public Map<String ,Object> validateUser(String user){
        return pagelistingrepository.validateUser(user);
    }
    public Map<String,Object> validateLogin(Map<String,Object> userLogin){
        String name=(String)userLogin.get("name");
        String password=(String)userLogin.get("password");
        return pagelistingrepository.validateLogin(name,password);

    }
    public  Map<String,Object> validToken(Map<String,Object> tokendata){
        Integer userid=(Integer)tokendata.get("userid");
        String token=(String)tokendata.get("token");
       return  this.pagelistingrepository.validToken(userid,token);

    }
    public void registerUser(Map<String,Object> userData){
        String name=(String)userData.get("name");
        Integer phoneno=(Integer)userData.get("phoneno");
        String email=(String)userData.get("email");
        String password=(String)userData.get("password");
        Integer activeyn=(Integer)userData.get("activeyn");
        this.pagelistingrepository.registerUSer(name,phoneno,email,password,activeyn);
    }
//    public void deleteUser(Map<String,Object> id){

   // }

    public void donation(Map<String,Object>userDonate){
        Integer donationamount=(Integer)userDonate.get("donationamount");
        Integer userid=(Integer)userDonate.get("userid");
        this.pagelistingrepository.donation(donationamount,userid);
    }
//    public List<Map<String,Object>> sendEmail(){
//        return pagelistingrepository.sendEmail();
//    }
}
