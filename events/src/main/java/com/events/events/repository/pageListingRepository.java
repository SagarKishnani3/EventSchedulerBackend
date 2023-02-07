package com.events.events.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorCompletionService;

@Repository
public class pageListingRepository {
    @Autowired
    JdbcTemplate JdbcTemplate;
//    @Autowired
//    private JavaMailSender javaMailSender;
    List<Map<String,Object>> l1=new ArrayList<>();
    List<String> l2=new ArrayList<>();


    public List<Map<String,Object>> getpageListing(){
        return JdbcTemplate.queryForList("EXEC shows.spfetchEvents");
    }
    public Map<String,Object> fetchUSer(int id){
        return JdbcTemplate.queryForMap("EXEC dbo.spfetchUser ?",id);
    }
    public Map<String,Object> validateUser(String user){
        return JdbcTemplate.queryForMap("EXEC dbo.spvalidateUser ?",user);
    }
    public Map<String,Object> validateLogin(String name,String password){
        return JdbcTemplate.queryForMap("EXEC dbo.authenticateUser ?,?",name,password);
    }
    public  Map<String,Object> validToken(Integer userid,String token){

      return  this.JdbcTemplate.queryForMap("EXEC dbo.spvalidToken ?,?",userid,token);
    }

    public void registerUSer(String name,Integer phoneno,String email,String password,Integer activeyn){
        this.JdbcTemplate.update("EXEC  dbo.spregisterUser ?,?,?,?,?",name,phoneno,email,password,activeyn);
    }
    public void donation(Integer donationamount,Integer userid){
        this.JdbcTemplate.update("Exec booksmile.sp_donatingForEvent ?,?",donationamount,userid);
  }
//    public List<Map<String,Object>> sendEmail(){
//
//        this.l1.addAll(this.JdbcTemplate.queryForList("EXEC dbo.spsenduserEmail"));
//        for(int i=0;i<l1.size();i++){
//            for(Object val:l1.get(i).values()){
//                //System.out.println(val);
//                l2.add(val.toString());
//            }
//        }
//        //System.out.println(l2);
//        SimpleMailMessage mail = new SimpleMailMessage();
//       for(int i=0;i<l2.size();i++) {
//           mail.setFrom("sagarkishnani3@gmail.com");
//           mail.setTo(l2.get(i));
//           mail.setSubject("regarding confirmation of mail");
//           mail.setText("your id is succesfully selected congrats");
//           javaMailSender.send(mail);
//
//       }
//        System.out.println("succesfully send");
//        return this.JdbcTemplate.queryForList("EXEC dbo.spsenduserEmail");
//
//    }


}
