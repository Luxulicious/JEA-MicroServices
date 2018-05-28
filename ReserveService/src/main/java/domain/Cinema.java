/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Tom
 * @email
 * @version 0.0.1
 */
@Entity
public class Cinema {

    @Id
    private Long id;
    private String name;
    private String adress;
    @OneToMany(mappedBy = "cinema")
    private List<Screening> screening;

    public Cinema(String name, String adress, List<Screening> screening) {
        this.name = name;
        this.adress = adress;
        this.screening = screening;
    }

    public Cinema() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public List<Screening> getScreening() {
        return screening;
    }

    public void setScreening(List<Screening> screening) {
        this.screening = screening;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
