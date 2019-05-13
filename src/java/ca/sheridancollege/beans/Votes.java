/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.beans;

import java.io.Serializable;

/**
 * Class to map Votes table
 *
 * @author Harleen Kaur
 */
public class Votes implements Serializable {

    private int ballot_id;
    private int cand_ID;

    public Votes(int ballot_id, int cand_ID) {
        this.ballot_id = ballot_id;
        this.cand_ID = cand_ID;
    }

    public Votes() {
        ballot_id = 0;
        cand_ID = 0;
    }

    public int getBallot_id() {
        return ballot_id;
    }

    public void setBallot_id(int ballot_id) {
        this.ballot_id = ballot_id;
    }

    public int getCand_ID() {
        return cand_ID;
    }

    public void setCand_ID(int cand_ID) {
        this.cand_ID = cand_ID;
    }

}
