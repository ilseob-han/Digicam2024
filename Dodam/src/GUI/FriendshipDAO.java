package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendshipDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/miniproject1";
    private String jdbcUsername = "gangnam";
    private String jdbcPassword = "qwe123!@#";

    // 친구 관계를 데이터베이스에 추가하는 SQL
    private static final String INSERT_FRIENDSHIP_SQL = 
        "INSERT INTO friendships (user_id_1, user_id_2) VALUES (?, ?);";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
    public List<String> getFriendsForUser(String userId) {
        List<String> friends = new ArrayList<>();
        String GET_FRIENDS_SQL = "SELECT user_id_1, user_id_2 FROM friendships WHERE user_id_1 = ? OR user_id_2 = ?";
        
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_FRIENDS_SQL)) {
            preparedStatement.setString(1, userId);
            preparedStatement.setString(2, userId);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String friendId = userId.equals(resultSet.getString("user_id_1")) ? resultSet.getString("user_id_2") : resultSet.getString("user_id_1");
                    friends.add(friendId);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return friends;
    }

    

    public void addFriendship(String userId1, String userId2) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FRIENDSHIP_SQL)) {
            preparedStatement.setString(1, userId1);
            preparedStatement.setString(2, userId2);
            
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
}