/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.UserDao;
import domain.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Tomt
 */
@Stateless
public class UserService {
    @Inject
    private UserDao userDao;
    
    public List<User> getAll(){
        return userDao.getAll();
    }
    
    public User find(String email){
        return userDao.find(email);
    }
}
