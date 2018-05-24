/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

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
    @ManyToMany
    private List<Rating> allRatings;
    private boolean liked;

    public User(String email, String name, List<Rating> allRatings, boolean liked) {
        this.email = email;
        this.name = name;
        this.allRatings = allRatings;
        this.liked = liked;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
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

    public List<Rating> getAllRatings() {
        return allRatings;
    }

    public void setAllRatings(List<Rating> allRatings) {
        this.allRatings = allRatings;
    }

}
