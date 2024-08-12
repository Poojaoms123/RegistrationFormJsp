<%@ page import="java.util.List" %>
<%@ page import="model.PreRegi" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Player List</title>
</head>
<body>
<h1>Player List</h1>
<a href="form.html">Add New Player</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>FullName</th>
        <th>Age</th>
        <th>Gender</th>
        <th>PhoneNo</th>
        <th>Email</th>
        <th>CurrentlyUndergoingTraining</th>
        <th>WhichTrainingProgram</th>
        <th>Other</th>
        <th>WhichDateAndBatch</th>
        <th>PleaseProveThatYouAreHumanBySolvingTheEquation</th>
        <th>Actions</th>
    </tr>
    <%
        List<PreRegi> preRegis = (List<PreRegi>) request.getAttribute("preRegis");
        if (preRegis != null && !preRegis.isEmpty()) {
            for (PreRegi pre : preRegis) {
    %>
    <tr>
        <td><%= pre.getId() %></td>
        <td><%= pre.getFullName() %></td>
        <td><%= pre.getAge() %></td>
        <td><%= pre.getGender() %></td>
        <td><%= pre.getPhoneNo() %></td>
        <td><%= pre.getEmail() %></td>
        <td><%= pre.getCurrentlyUndergoingTraining() %></td>
        <td><%= pre.getWhichTrainingProgram() %></td>
        <td><%= pre.getOther() %></td>
        <td><%= pre.getWhichDateAndBatch() %></td>
        <td><%= pre.getPleaseProveThatYouAreHumanBySolvingTheEquation() %></td>
        <td>
            <a href="updateRegistrationForm.jsp?id=<%= pre.getId() %>">Update</a>
            <form action="deletePlayer" method="post" style="display:inline;">
                <input type="hidden" name="id" value="<%= pre.getId() %>">
                <input type="submit" value="Delete" onclick="return confirm('Are you sure you want to delete this user?');">
            </form>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="11">No users found.</td>
    </tr>
    <% } %>
</table>
<a href="/RegiList">View Users</a>
</body>
</html>