/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Tom
 * @email
 * @version 0.0.1
 */
public class Screening {

    private long id;
    private String movieTitle;
    private Date startTime;
    private Date endTime;
    private double price;
    private List<Seat> seats;
}
