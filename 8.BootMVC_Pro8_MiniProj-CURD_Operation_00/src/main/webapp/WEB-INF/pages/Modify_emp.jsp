<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1 style="color: red;text-align: center;">Edit Employee</h1>
<form:form modelAttribute="emp">
<table border="0" bgcolor="cyan" align="center">
<tr>
<td>Employee Name</td>
<td><form:input path="ename"/></td>
</tr>
<tr>
<td>Employee Desg</td>
<td><form:input path="job"/></td>
</tr>
<tr>
<td>Employee Salary</td>
<td><form:input path="sal"/></td>
</tr>
<tr>
<td>Employee Deptno</td>
<td><form:input path="deptno"/></td>
</tr>
<tr>
<td><input type="submit" value="Edit Employee"/></td>
<td><input type="reset" value="cancel"/></td>
</tr>
</table>

</form:form>>
