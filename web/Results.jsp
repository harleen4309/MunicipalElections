<%-- 
    Document   : Results
    Created on : 3 Nov, 2018, 2:10:26 AM
    Author     : Harleen Kaur 
--%>

<%@page import="ca.sheridancollege.beans.Results"%>
<%@page import="ca.sheridancollege.beans.Candidates"%>
<%@page import="ca.sheridancollege.beans.Votes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
        <link rel="stylesheet" type="text/css" href="Vote.css" media="all" >

    </head>
    <body>
        <h1>Results</h1>

        <% ArrayList<Results> resultList = (ArrayList<Results>) request.getAttribute("resultList");%>
        <table cellspacing="18" align="center" style="width:400px" id="product">
            <tr>
                <th>First Name</th>
                <th>Last Name</th> 
                <th>Votes</th>
            </tr>
            <%   for (Results result : resultList) {
            %>
            <tr>
                <td> <%=result.getFirst_Name()%></td>
                <td><%=result.getLast_Name()%></td>
                <td><%=result.getCount()%></td>
            </tr>

            <% }
            %>
        </table>
        <a href="index.html" class="button">HOME </a>

    </body>
</html>
