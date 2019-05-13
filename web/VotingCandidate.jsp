<%-- 
    Document   : Voting
    Created on : 31 Oct, 2018, 6:50:03 PM
    Author     : Harleen Kaur 
--%>


<%@page import="ca.sheridancollege.beans.Candidates"%>
<%@page import="java.util.ArrayList"%>
<%--@page import="ca.sheridansports.business.Product"--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vote Candidates</title>
        <link rel="stylesheet" type="text/css" href="Vote.css" media="all" >
    </head>
    <body>
        <h1>Vote The Candidate</h1>
        <form method="POST" action="CastVote.do">
            <% ArrayList<Candidates> candList = (ArrayList<Candidates>) request.getAttribute("candList");

                for (Candidates candidate : candList) {
            %>
            <h2><input type="radio" name="cand_ID" checked="checked" value="<%=candidate.getCand_ID()%>"/><%=candidate.getFirst_Name()%> <%=candidate.getLast_Name()%></h2>
                <% }
                %>
            <input type="submit" name="cast ballot" value="VOTE" class="button"/>
        </form>
        <br>
        <br>
        <a href="index.html" class="button" >HOME </a>


    </body>
</html>

