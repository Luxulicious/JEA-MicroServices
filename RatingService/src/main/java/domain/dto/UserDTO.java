/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.dto;

import domain.User;

/**
 *
 * @author Tomt
 */
public class UserDTO {
    public String email;
    public String name;

    public UserDTO(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
    }
    
}
