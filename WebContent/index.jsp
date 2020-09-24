<%@page import="com.poalim.bean.LakoachTnuaaVO" %>
<%@page import="com.poalim.dao.LakoachDao" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
 
<html>
   <head>
      <title>SELECT Operation</title>
   </head>

   <body>
   
   <%
   		LakoachDao dao = new LakoachDao();
   		List<LakoachTnuaaVO> lakoachTnuaaList = dao.fetchLakoachAccounts();
   		System.out.println(lakoachTnuaaList.size());
   
   %>
<%-- 
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/TEST"
         user = "root"  password = "pass123"/>
 
      <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from Employees;
      </sql:query>
--%> 
      <table border = "1" width = "100%">
         <tr>
            <th>Lakoach ID</th>
            <th>Lakoach Name</th>
            <th>total Amount</th>
            <th>Esek</th>
            <th>Credit Card Num</th>
         </tr>
         
         <c:forEach var = "row" items = "<%= lakoachTnuaaList %>">
            <tr>
               <td><c:out value = "${row.id}"/></td>
               <td><c:out value = "${row.name}"/></td>
               <td><c:out value = "${row.amount}"/></td>
               <td><c:out value = "${row.esek}"/></td>
               <td><c:out value = "${row.ccno}"/></td>
            </tr>
         </c:forEach>
      </table>
 
   </body>
</html>