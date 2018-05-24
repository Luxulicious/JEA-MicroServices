/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.exceptions;

/**
 *
 * @author Tomt
 */
public class NonExistingRatingException extends Exception {

    public NonExistingRatingException() {
    }

    public NonExistingRatingException(String string) {
        super(string);
    }
}
