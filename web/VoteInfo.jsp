<%-- 
    Document   : VoteInfo
    Created on : 3 Nov, 2018, 12:53:14 AM
    Author     : Harleen Kaur 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Municipal Elections</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="Vote.css" media="all" >
    </head>
    <body>
        <div>
            <h1>Welcome to Municipal Elections!!</h1>
            <h2>What do you want to do? </h2>
        </div>
        <div class="flex">
            <form method="POST" action="ListAllCanditates.do" class="flex-item">
                <input type="submit" name="vote" value="Vote" class="button">
            </form>

            <form method="POST" action="ViewResults.do" class="flex-item">
                <input type="submit" name="Election Results" value="Results" class="button">
            </form>
        </div>

        <% String msg = (String) request.getAttribute("message");%>
        <h1><%= msg%></h1>


    </body>
</html>