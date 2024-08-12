package model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/deletePlayer")
public class DeleteRegiServlet extends HttpServlet {
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

        if (idStr == null || idStr.isEmpty()) {
            response.sendRedirect("error.html?error=User ID is required");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            response.sendRedirect("error.html?error=Invalid User ID format");
            return;
        }

        try (Connection connection = getConnection()) {
            PreRegiDAO preRegiDAO = new PreRegiDAO();
            boolean success = preRegiDAO.deletePlayer(id);

            if (success) {
                request.setAttribute("message", "User deleted successfully!");
            } else {
                request.setAttribute("error", "Failed to delete user");
            }

            // Fetch all users again to update the list after deletion
            //List<PreRegi> preRegis = PreRegiDAO.getAllRegi();
            List<PreRegi> preRegis = (List<PreRegi>) request.getAttribute("preRegis");
            //request.setAttribute("users", users);
            request.getRequestDispatcher("viewPlayers.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Database error: " + e.getMessage());
            request.getRequestDispatcher("viewPlayers.jsp").forward(request, response);
        }
    }

    /*private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("JDBC Driver not found");
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "oms123");
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("viewPlayers.jsp");
    }
}
