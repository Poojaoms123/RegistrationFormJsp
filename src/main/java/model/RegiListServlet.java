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

@WebServlet("/RegiList")
public class RegiListServlet extends HttpServlet {
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = getConnection()) {
            PreRegiDAO preRegiDAO = new PreRegiDAO();
            List<PreRegi> preRegis = preRegiDAO.getAllRegi();

            request.setAttribute("preRegis", preRegis);
            request.getRequestDispatcher("viewPlayers.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("error.html?error=Database error: " + e.getMessage());
        }
    }

   /* private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("JDBC Driver not found");
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/registration?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true", "root", "oms123");
    }

*/


}
