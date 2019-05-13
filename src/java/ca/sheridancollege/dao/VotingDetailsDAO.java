/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.dao;

import ca.sheridancollege.beans.Results;
import com.prog32758.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Creates and executes Query to get number of votes received by all candidates
 *
 * @author Harleen Kaur
 */
public class VotingDetailsDAO {

    /**
     * method to show details of voting results
     * @return ArrayList of results containing all
     * candidates names and number of votes received
     */
    public static ArrayList<Results> getVotingDetails() {

        Connection conn = DBConnector.getConnection();
        String sqlQuery = "select C.First_Name, C.Last_Name, COUNT(V.Cand_ID) AS 'Votes' \n"
                + "FROM VotingDetails V INNER JOIN CandidateInfo C \n"
                + "ON V.Cand_ID = C.Cand_ID \n"
                + " GROUP BY V.Cand_ID  ORDER BY count(V.Cand_ID) desc";
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Results> resultList = new ArrayList();

        try {
            ps = conn.prepareStatement(sqlQuery);
            rs = ps.executeQuery();

            while (rs.next()) {
                Results result = new Results();

                result.setFirst_Name(rs.getString("first_Name"));
                result.setLast_Name(rs.getString("last_Name"));
                result.setCount(rs.getInt("votes"));

                resultList.add(result);
            }
        } catch (SQLException ex) {
            System.err.println("SQL Error code: " + ex.getErrorCode());
            System.err.println("SQL State: " + ex.getSQLState());
        }

        return resultList;
    }

}
