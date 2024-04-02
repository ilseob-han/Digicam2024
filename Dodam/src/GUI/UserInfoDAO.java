package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInfoDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/miniproject1";
    private String jdbcUsername = "gangnam";
    private String jdbcPassword = "qwe123!@#";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (userID, userName, password, email, mobilePhone, signUpTime, userStatus) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?);";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // SQLException 처리
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // ClassNotFoundException 처리
            e.printStackTrace();
        }
        return connection;
    }
    
    
    // 중복ID 검증
    public boolean checkUserExists(String userID) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE userID = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, userID);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return false;
    }

    public void insertUser(UserInfo user) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getUserID());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getMobilePhone());
            preparedStatement.setTimestamp(6, user.getSignUpTime());
            preparedStatement.setString(7, user.getUserStatus());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
    

        private static final String UPDATE_USERS_SQL = "UPDATE users SET userName = ?, password = ?, email = ?, mobilePhone = ?, signUpTime = ?, userStatus = ? WHERE userID = ?;";

        public void updateUser(UserInfo user) throws SQLException {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
                preparedStatement.setString(1, user.getUserName());
                preparedStatement.setString(2, user.getPassword());
                preparedStatement.setString(3, user.getEmail());
                preparedStatement.setString(4, user.getMobilePhone());
                preparedStatement.setTimestamp(5, user.getSignUpTime());
                preparedStatement.setString(6, user.getUserStatus());
                preparedStatement.setString(7, user.getUserID());

                int result = preparedStatement.executeUpdate();
                System.out.println(result + " rows updated.");
            } catch (SQLException e) {
                printSQLException(e);
            }
        }
    

}

