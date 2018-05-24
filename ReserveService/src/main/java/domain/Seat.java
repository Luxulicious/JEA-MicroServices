/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Tom
 * @email
 * @version 0.0.1
 */
public class Seat {

    private long seatId;
    private Screening screening;
    private boolean reserved;
    private String reservedBy;
    private boolean payed;
    private int seatNumber;

    public Seat() {
    }

    public Seat(long seatId, boolean reserved, String reservedBy, boolean payed, int seatNumber) {
        this.seatId = seatId;
        this.reserved = reserved;
        this.reservedBy = reservedBy;
        this.payed = payed;
        this.seatNumber = seatNumber;
    }

    public long getSeatId() {
        return seatId;
    }

    public void setSeatId(long seatId) {
        this.seatId = seatId;
    }

    public String getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

}
