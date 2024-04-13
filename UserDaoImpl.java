
// // UserDaoImpl.java
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.List;

// public class UserDaoImpl implements UserDao {

//     private Connection connection;

//     // Constructor

//     public UserDaoImpl(Connection connection) {
//         this.connection = connection;
//     }

//     @Override
//     public void registerUser(User user) {
//         // Logic to register a new user
//         try {
//             String sql = "INSERT INTO users (first_name, last_name, email, password, is_doctor) VALUES (?, ?, ?, ?, ?)";
//             PreparedStatement preparedStatement = connection.prepareStatement(sql);
//             preparedStatement.setString(1, user.getFirstName());
//             preparedStatement.setString(2, user.getLastName());
//             preparedStatement.setString(3, user.getEmail());
//             preparedStatement.setString(4, user.getPassword());
//             preparedStatement.setBoolean(5, user.isDoctor());
//             preparedStatement.executeUpdate();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }

//     @Override
//     public User loginUser(String email, String password) {
//         // Logic to show user login
//         try {
//             String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
//             PreparedStatement preparedStatement = connection.prepareStatement(sql);
//             preparedStatement.setString(1, email);
//             preparedStatement.setString(2, password);
//             ResultSet resultSet = preparedStatement.executeQuery();
//             if (resultSet.next()) {
//                 User user = new User();
//                 user.setId(resultSet.getInt("id"));
//                 user.setFirstName(resultSet.getString("first_name"));
//                 user.setLastName(resultSet.getString("last_name"));
//                 user.setEmail(resultSet.getString("email"));
//                 user.setPassword(resultSet.getString("password"));
//                 user.setDoctor(resultSet.getBoolean("is_doctor"));
//                 return user;
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return null;
//     }

//     @Override
//     public List<User> getAllUsers() {
//         // Logic to get all users from the database
//         List<User> userList = new ArrayList<>();
//         try {
//             String sql = "SELECT * FROM users";
//             PreparedStatement preparedStatement = connection.prepareStatement(sql);
//             ResultSet resultSet = preparedStatement.executeQuery();
//             while (resultSet.next()) {
//                 User user = new User();
//                 user.setId(resultSet.getInt("id"));
//                 user.setFirstName(resultSet.getString("first_name"));
//                 user.setLastName(resultSet.getString("last_name"));
//                 user.setEmail(resultSet.getString("email"));
//                 user.setPassword(resultSet.getString("password"));
//                 user.setDoctor(resultSet.getBoolean("is_doctor"));
//                 userList.add(user);
//             }
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//         return userList;
//     }

   
// }
