package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreRegiDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/registration";
    private String jdbcUsername = "root";
    private String jdbcPassword = "oms123";

    private static final String INSERT_INQUIRY_SQL = "INSERT INTO registrationform (fullName, age, gender, phoneNo, email, currentlyUndergoingTraining, whichTrainingProgram, other, whichDateAndBatch, pleaseProveThatYouAreHumanBySolvingTheEquation) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";



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

    public boolean saveRegi(PreRegi preRegi) {
        boolean rowInserted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INQUIRY_SQL)) {
            preparedStatement.setString(1, preRegi.getFullName());
            preparedStatement.setString(2, preRegi.getAge());
            preparedStatement.setString(3, preRegi.getGender());
            preparedStatement.setString(4, preRegi.getPhoneNo());
            preparedStatement.setString(5, preRegi.getEmail());
            preparedStatement.setString(6, preRegi.getCurrentlyUndergoingTraining());
            preparedStatement.setString(7, preRegi.getWhichTrainingProgram());
            preparedStatement.setString(8, preRegi.getOther());
            preparedStatement.setString(9, preRegi.getWhichDateAndBatch());
            preparedStatement.setString(10, preRegi.getPleaseProveThatYouAreHumanBySolvingTheEquation());

            rowInserted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowInserted;
    }

    public List<PreRegi> getAllRegi() throws SQLException {
        List<PreRegi> preRegis = new ArrayList<>();
        String query = "SELECT * FROM registrationform";
       /* try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {*/

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet rs= statement.executeQuery()) {
            while (rs.next()) {
                PreRegi preRegi = new PreRegi();
                preRegi.setId(rs.getInt("id"));
                preRegi.setFullName(rs.getString("fullName"));
                preRegi.setGender(rs.getString("gender"));
                preRegi.setEmail(rs.getString("email"));
                preRegi.setWhichTrainingProgram(rs.getString("whichTrainingProgram"));
                preRegi.setWhichDateAndBatch(rs.getString("whichDateAndBatch"));
                preRegi.setAge(rs.getString("age"));
                preRegi.setPhoneNo(rs.getString("phoneNo"));
                preRegi.setCurrentlyUndergoingTraining(rs.getString("currentlyUndergoingTraining"));
                preRegi.setOther(rs.getString("other"));
                preRegi.setPleaseProveThatYouAreHumanBySolvingTheEquation(rs.getString("pleaseProveThatYouAreHumanBySolvingTheEquation"));
                preRegis.add(preRegi);
                }

        }
        return preRegis;
    }

    public boolean deletePlayer(int id) throws SQLException {
        String query = "DELETE FROM registrationform WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement(query)){
                 statement.setInt(1, id);
                 int rowsAffected = statement.executeUpdate();
                 return rowsAffected > 0;
        }
    }

    public boolean updatePlayer(PreRegi preRegi) throws SQLException {
        String query = "UPDATE users SET fullName = ?, age = ?, gender = ?, phoneNo = ?, email = ?, currentlyUndergoingTraining = ?, whichTrainingProgram = ?, other = ?, whichDateAndBatch = ?, pleaseProveThatYouAreHumanBySolvingTheEquation = ? WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, preRegi.getFullName());
            statement.setString(2, preRegi.getAge());
            statement.setString(3, preRegi.getGender());
            statement.setString(4, preRegi.getPhoneNo());
            statement.setString(5, preRegi.getEmail());
            statement.setString(6, preRegi.getCurrentlyUndergoingTraining());
            statement.setString(7, preRegi.getWhichTrainingProgram());
            statement.setString(8, preRegi.getOther());
            statement.setString(9, preRegi.getWhichDateAndBatch());
            statement.setString(10, preRegi.getPleaseProveThatYouAreHumanBySolvingTheEquation());
            statement.setInt(11, preRegi.getId());

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    public PreRegi getPlayerById(int id) {
        PreRegi preRegi = null;
        String query = "SELECT * FROM users WHERE id = ?";
        System.out.println("Debug: Executing query: " + query + " with ID: " + id);
        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                preRegi = new PreRegi();
                preRegi.setId(resultSet.getInt("id"));
                preRegi.setFullName(resultSet.getString("fullName"));
                preRegi.setAge(resultSet.getString("age"));
                preRegi.setGender(resultSet.getString("gender"));
                preRegi.setPhoneNo(resultSet.getString("phoneNo"));
                preRegi.setEmail(resultSet.getString("email"));
                preRegi.setCurrentlyUndergoingTraining(resultSet.getString("currentlyUndergoingTraining"));
                preRegi.setWhichTrainingProgram(resultSet.getString("whichTrainingProgram"));
                preRegi.setOther(resultSet.getString("other"));
                preRegi.setWhichDateAndBatch(resultSet.getString("whichDateAndBatch"));
                preRegi.setPleaseProveThatYouAreHumanBySolvingTheEquation(resultSet.getString("pleaseProveThatYouAreHumanBySolvingTheEquation"));
            } else {
                System.out.println("Debug: No record found for ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preRegi;
    }

}
