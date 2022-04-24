<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
	<c:when test="${!empty empsList}">
		<table border="1" bgcolor="cyan" align="center">
		<tr bgcolor="cyan">
		<th>empNo</th><th>empName</th><th>Job</th><th>sal</th><th>deptNo</th><th>Operations</th>
		</tr>
		<c:forEach var="emp" items="${empsList}">
		<tr>
			<td>${emp.empno}</td>
			<td>${emp.ename}</td>
			<td>${emp.job}</td>
			<td>${emp.sal}</td>
			<td>${emp.deptno}</td>
			<td><a href="edit_employee?eno=${emp.empno}">edit</a>&nbsp;&nbsp;
				<a href="delete_employee?eno=${emp.empno}" onclick="confirm('Do u want to delete?')">delete</a>&nbsp;&nbsp;
			</td>
		</tr>
		</c:forEach>
		</table>
	</c:when>
	<c:otherwise><h1 style="color: red;text-align: center;">Records Not Found</h1></c:otherwise>
</c:choose>
<br>
<h1 style="color: blue;text-align: center;"><a href="insert_employee">Add Employee</a></h1>
<br><br>
<h1 style="color: blue;text-align: center;"><a href="./">Home</a></h1>
<blink><h1 style="text-align: center;color: maroon;">${resultMsg}</h1></blink>

