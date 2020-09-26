<%@page import="com.poalim.bo.LakoachService"%>
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
   		String idLakoach=request.getParameter("id");
   		LakoachService service = new LakoachService();
   		List<LakoachTnuaaVO> lakoachTnuaaList = service.fetchLakoachAccounts(idLakoach);
   		System.out.println("size of List:"+lakoachTnuaaList.size());
   
   %>
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