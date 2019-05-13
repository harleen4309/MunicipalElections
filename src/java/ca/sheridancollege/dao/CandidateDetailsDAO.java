/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.dao;

import ca.sheridancollege.beans.Candidates;
import com.prog32758.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Creates and executes Query to get all candidates information
 * @author Harleen Kaur
 */
public class CandidateDetailsDAO {

    /**
     * Gets the connection, creates and executes Query
     * @return ArrayList of Candidates made from data
     * retrieved in resultSet
     */
    public static ArrayList<Candidates> getCandidateInfo() {
        Connection conn = DBConnector.getConnection();
        String sqlQuery = "SELECT * FROM CandidateInfo";
        ResultSet rs = null;
        PreparedStatement ps = null;

        ArrayList<Candidates> candInfo = new ArrayList();

        try {

            ps = conn.prepareStatement(sqlQuery);
            rs = ps.executeQuery();

            while (rs.next()) {
                Candidates candidate = new Candidates();
                candidate.setCand_ID(rs.getInt("cand_ID"));
                candidate.setFirst_Name(rs.getString("first_Name"));
                candidate.setLast_Name(rs.getString("last_Name"));
                candidate.setAddress(rs.getString("address"));
                candidate.setEmail(rs.getString("email"));
                candidate.setPhone(rs.getString("phone"));
                candInfo.add(candidate);

            }
        } catch (SQLException ex) {
            System.err.println("SQL Error code: " + ex.getErrorCode());
            System.err.println("SQL State: " + ex.getSQLState());
        }
        return candInfo;

    }

}
