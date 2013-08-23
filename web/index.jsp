<%-- 
    Document   : index
    Created on : Sep 6, 2011, 3:21:37 PM
    Author     : rwandell
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<link title="commonstylesheet" href="css/common.css" type="text/css" rel="stylesheet">

<%
    String errorMessage=(String)session.getAttribute("errorMessage");
    String userName="";
    tools.utils.UserInfo userInfo = (tools.utils.UserInfo)session.getAttribute("userInfo");

    if(userInfo != null) { userName = userInfo.getUser(); }

    if(errorMessage == null) { errorMessage=""; }
%>
    <div id="loginPage" align="center">
        <div style="width: 400px; position: absolute; top: 30%; left: 20%; height: 10em; margin-top: -5em;">
            <div style="position: absolute; left: 0px;"><img src="appimages/login.jpg" height="50" alt="Application Logo" /></div>
                <div style="position: absolute; left: 5px; top: 55px;">
                <div id="loginPanel">
                    <form name="loginForm" method="post" action="CheckUser" >
                        <div style="position: relative; top: 5px;">
                            <div style="margin-left: 10px; width: 100px; float: left;"><label>User:</label></div><div style="width: 190px; float: left;"><input type="text" name="userName" id="userName" class="tBoxText" size="15" maxlength="25" value="<%= userName %>"></div><br />
                            <div style="margin-left: 10px; width: 100px; float: left;"><label>Password:</label></div><div style="width: 190px; float: left;"><input type="password" name="password" id="password" class="tBoxText" size="15" maxlength="25"></div><br />
                            <div style="margin-left: 10px; width: 300px; float: left;"><input type="submit" value="login"></div>
                        </div>
                    </form>
                </div>
            <div style="color: red; font-weight: bold; position: absolute; left: 5px; top: 180px; text-align: center;"><%= errorMessage %></div>
        </div>
    </div>
