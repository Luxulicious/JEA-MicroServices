/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Tomt
 */
@Entity
@NamedQueries({
@NamedQuery(name = "User.getAll", query = "SELECT u FROM User u"),
@NamedQuery(name = "User.find", query = "SELECT u FROM User u WHERE u.email = :email")
})
public class User {
    @Id
    private String email;
    private String name;
    @OneToMany
    private List<Ticket> tickets;

    public User() {
    }

    public User(String email, String name, List<Ticket> tickets) {
        this.email = email;
        this.name = name;
        this.tickets = tickets;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
    
    
}
