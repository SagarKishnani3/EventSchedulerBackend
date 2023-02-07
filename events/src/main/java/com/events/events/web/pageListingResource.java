package com.events.events.web;

import com.events.events.service.pageListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "http://localhost:4200",allowCredentials="true")
@RestController
@RequestMapping("/api")
public class pageListingResource {

    @Autowired
    private pageListingService pagelistingservice;

    @GetMapping("/pageListing")
    private List<Map<String,Object>> getpageListing(){
        return pagelistingservice.getpageListing();
    }
    @GetMapping("/user/{id}")
    private Map<String,Object> fetchUser(@PathVariable int id){
        return pagelistingservice.fetchUser(id);
    }
    @GetMapping("/validateUser/{user}")
    private Map<String ,Object> validateUSer(@PathVariable String user){
        return pagelistingservice.validateUser(user);
    }
    @PostMapping("/validateLogin")
    public Map<String,Object> validateLogin(@RequestBody Map<String,Object> userLogin){
        return pagelistingservice.validateLogin(userLogin);

    }
    @PostMapping("/validToken")
    public  Map<String,Object> validToken(@RequestBody Map<String,Object> tokendata){
       return this.pagelistingservice.validToken(tokendata);
    }
    @PostMapping("/register")
    public void registerUser(@RequestBody Map<String,Object> userData) {
         this.pagelistingservice.registerUser(userData);
    }
//    @PostMapping("/users/{id}")
//    public void deleteUser(@RequestBody Map<String,Object> data(@PathVariable int id)) {
//        this.pagelistingservice.deleteUser(data(id));
//    }
    @PostMapping("/donation")
    public void donation(@RequestBody Map<String,Object> userDonate) {
        this.pagelistingservice.donation(userDonate);
    }
//    @GetMapping("/email")
//    @EventListener(ApplicationReadyEvent.class)
//    public List<Map<String,Object>> sendEmail(){
//        return pagelistingservice.sendEmail();
//    }

}
