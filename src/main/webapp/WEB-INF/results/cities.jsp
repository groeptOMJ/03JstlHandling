<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="center">
	<table border="5">
	  <tr><th class="title">Ajax: Handling Server Data with JSTL</th></tr>
	</table>
	<p/>
	<fieldset>
	  <legend>Cities</legend>
	  <div id="string-city-table">
	  <table border='1' class='ajaxTable'>
		  <c:forEach var="city" items="${cities}" varStatus="status"> 
			    <c:if test="${status.first}"> 
			    	<tr><th>City</th><th>Time</th><th>Population</th></tr>
			    </c:if>
			<tr>
			    <td>${city.name}</td><td>${city.time}</td><td>${city.population}</td>
		    </tr>
		  </c:forEach>
	  </table>
	  </div>
	</fieldset>
	<p/>
</div>