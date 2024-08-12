package model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/updatePlayer")
public class UpdateRegiServlet extends HttpServlet {
    private String jdbcURL = "jdbc:mysql://localhost:3306/registration";
    private String jdbcUsername = "root";
    private String jdbcPassword = "oms123";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String fullName = request.getParameter("fullName");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String phoneNo = request.getParameter("phoneNo");
        String email = request.getParameter("email");
        String currentlyUndergoingTraining = request.getParameter("currentlyUndergoingTraining");
        String whichTrainingProgram = request.getParameter("whichTrainingProgram");
        String other = request.getParameter("other");
        String whichDateAndBatch = request.getParameter("whichDateAndBatch");
        String pleaseProveThatYouAreHumanBySolvingTheEquation = request.getParameter("pleaseProveThatYouAreHumanBySolvingTheEquation");

        if (idStr == null || fullName == null || age == null || gender == null || phoneNo == null || currentlyUndergoingTraining == null || whichTrainingProgram == null || other == null || whichDateAndBatch == null || pleaseProveThatYouAreHumanBySolvingTheEquation == null) {
            response.sendRedirect("error.html?error=All fields are required");
            return;
        }

        int id = Integer.parseInt(idStr);
        PreRegi preRegi = new PreRegi();
        preRegi.setId(id)
        ;
        preRegi.setFullName(fullName);
        preRegi.setAge(age);
        preRegi.setGender(gender);
        preRegi.setEmail(email)
        ;
        preRegi.setPhoneNo(phoneNo);
        preRegi.setCurrentlyUndergoingTraining(currentlyUndergoingTraining);
        preRegi.setWhichTrainingProgram(whichTrainingProgram);
        preRegi.setOther(other);
        preRegi.setWhichDateAndBatch(whichDateAndBatch);
        preRegi.setPleaseProveThatYouAreHumanBySolvingTheEquation(pleaseProveThatYouAreHumanBySolvingTheEquation);

        try (Connection connection = getConnection()) {
            PreRegiDAO preRegiDAO = new PreRegiDAO();
            boolean success = preRegiDAO.updatePlayer(preRegi);

            if (success) {
                request.setAttribute("message", "User updated successfully!");
                request.getRequestDispatcher("updateRegistrationForm.jsp").forward(request, response);
            } else {
                response.sendRedirect("error.html?error=Failed to update user");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.html?error=Database error: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("viewUsers.jsp");
    }
}