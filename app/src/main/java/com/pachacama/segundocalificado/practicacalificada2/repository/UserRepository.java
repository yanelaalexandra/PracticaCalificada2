package com.pachacama.segundocalificado.practicacalificada2.repository;

import com.orm.SugarRecord;
import com.pachacama.segundocalificado.practicacalificada2.models.User;

import java.util.ArrayList;
import java.util.List;


public class UserRepository {


    /*public static List<User> list(){
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }*/

    public static void create(String username, String fullname, String email, String password){
        User user = new User(username, fullname, email, password);
        SugarRecord.save(user);
    }


    public static User login(String username, String password){
        List<User> users = SugarRecord.listAll(User.class);
        for (User user : users){
            if(user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public static User getUser(String username){
        List<User> users = SugarRecord.listAll(User.class);
        for (User user : users){
            if(user.getUsername().equalsIgnoreCase(username)){
                return user;
            }
        }
        return null;
    }

}