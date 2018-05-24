/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.List;

/**
 *
 * @author Tom
 * @email
 * @version 0.0.1
 */
public class Cinema {

    private String name;
    private String adress;
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
}
