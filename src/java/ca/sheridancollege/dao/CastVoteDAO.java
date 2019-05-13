/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.dao;

import com.prog32758.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Creates and executes Query to Cast vote for different Candidates based on
 * their ID
 *
 * @author Harleen Kaur
 */
public class CastVoteDAO {

    /**
     * method to cast vote based on candidate id
     *
     * @param cand_id - Unique ID of all candidates
     * @return String message to notify user of successful vote casting
     */
    public static String castVote(int cand_id) {
        Connection conn = DBConnector.getConnection();

        String sqlQuery = "";
        PreparedStatement ps = null;
        int number = 0;

        String msg = "";
        sqlQuery = "INSERT INTO VotingDetails(Cand_ID) VALUES(cand_id)";
        
        try {
            ps = conn.prepareStatement(sqlQuery);
            number = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CastVoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (number > 0) {
            msg = "Vote casted successfully!";
        } else {
            msg = "Sorry your vote couldn't be casted. Try Again!";
        }

        return msg;
    }

}
