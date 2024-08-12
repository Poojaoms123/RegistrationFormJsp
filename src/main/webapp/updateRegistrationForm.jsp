<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.PreRegi" %>
<%@ page import="model.PreRegiDAO" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<jsp:include page="master.jsp"/>

<%
    String idStr = request.getParameter("id");
    if (idStr == null || idStr.isEmpty()) {
        response.sendRedirect("error.html?error=Invalid ID");
        return;
    }

    int id = Integer.parseInt(idStr);
    PreRegi preRegi = null;

    try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration", "root", "oms123")) {
        PreRegiDAO preRegiDAO = new PreRegiDAO();
        preRegi = preRegiDAO.getPlayerById(id);
        if (preRegi == null) {
            System.out.println("Debug: PreRegi object is null for ID: " + id);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Player</title>
</head>
<body>
<h2>Update Player</h2>
<% if (message != null) { %>
<p style="color: green;"><%= message %></p>
<% } %>

<% if (preRegi != null) { %>
<form action="updatePlayer" method="post">
    <input type="hidden" name="id" value="<%= preRegi.getId() %>"/>

    <label for="fullName">FullName:</label>
    <input type="text" id="fullName" name="fullName" value="<%= preRegi.getFullName() %>" required/><br/>

    <label for="gender">Gender:</label>
    <input type="text" id="gender" name="gender" value="<%= preRegi.getGender() %>" required/><br/>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="<%= preRegi.getEmail() %>" required/><br/>

    <label for="whichTrainingProgram">WhichTrainingProgram:</label>
    <input type="text" id="whichTrainingProgram" name="whichTrainingProgram" value="<%= preRegi.getWhichTrainingProgram() %>" required/><br/>

    <label for="whichDateAndBatch">WhichDateAndBatch:</label>
    <input type="datetime-local" id="whichDateAndBatch" name="whichDateAndBatch" value="<%= preRegi.getWhichDateAndBatch() %>" required/><br/>

    <label for="phoneNo">PhoneNo:</label>
    <input type="text" id="phoneNo" name="phoneNo" value="<%= preRegi.getPhoneNo() %>" required/><br/>

    <label for="currentlyUndergoingTraining">CurrentlyUndergoingTraining:</label>
    <input type="text" id="currentlyUndergoingTraining" name="currentlyUndergoingTraining" value="<%= preRegi.getCurrentlyUndergoingTraining() %>" required/><br/>

    <label for="age">Age:</label>
    <input type="text" id="age" name="age" value="<%= preRegi.getAge() %>" required/><br/>

    <label for="other">Other:</label>
    <input type="text" id="other" name="other" value="<%= preRegi.getOther() %>" required/><br/>

    <label for="pleaseProveThatYouAreHumanBySolvingTheEquation">PleaseProveThatYouAreHumanBySolvingTheEquation:</label>
    <input type="text" id="pleaseProveThatYouAreHumanBySolvingTheEquation" name="pleaseProveThatYouAreHumanBySolvingTheEquation" value="<%= preRegi.getPleaseProveThatYouAreHumanBySolvingTheEquation() %>" required/><br/>

    <input type="submit" value="Update Player"/>
</form>
<% } else { %>
<p style="color: red;">Error: Player not found or could not be loaded.</p>
<% } %>
</body>
</html>