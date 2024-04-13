
// User.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isDoctor;

    // Constructors
    public User() {
    }

    public User(int id, String firstName, String lastName, String email, String password, boolean isDoctor) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isDoctor = isDoctor;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isDoctor() {
        return isDoctor;
    }

    public void setDoctor(boolean doctor) {
        isDoctor = doctor;
    }

    // Method to display user information
    public void displayUserInfo() {
        System.out.println("User ID: " + id);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Is Doctor: " + (isDoctor ? "Yes" : "No"));
    }

    // Method to display information for all users
public static void displayAllUsersInfo() {
    try {
        // Establish database connection
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id <> ?");
        statement.setInt(1, 21); // Exclude user with ID 21 (Ainee Malik)
        ResultSet resultSet = statement.executeQuery();

        // Display user information
        System.out.println("All Users Information:");
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("first_name");
            String lastName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            boolean isDoctor = resultSet.getBoolean("is_doctor");

            System.out.println("User ID: " + id);
            System.out.println("First Name: " + firstName);
            System.out.println("Last Name: " + lastName);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
            System.out.println("Is Doctor: " + (isDoctor ? "Yes" : "No"));
            System.out.println();
        }

        // Display user information for Ainee Malik (User ID 21)
        displayAineeUserInfo(connection);

        // Close resources
        resultSet.close();
        statement.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Method to display user information for Ainee Malik
private static void displayAineeUserInfo(Connection connection) throws SQLException {
    PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
    statement.setInt(1, 21); // Retrieve user with ID 21 (Ainee Malik)
    ResultSet resultSet = statement.executeQuery();
    while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        boolean isDoctor = resultSet.getBoolean("is_doctor");

        System.out.println("User ID: " + id);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        System.out.println("Is Doctor: " + (isDoctor ? "Yes" : "No"));
        System.out.println();
    }
    resultSet.close();
    statement.close();
    System.err.println();
}

    // Main method for testing
    public static void main(String[] args) {
        // Display a specific user's information
        User user1 = new User(33, "Sam", "Orange", "sorange@gmail.com", "forest87", false);
        System.out.println("User Information:");
        // user1.displayUserInfo();

        System.out.println();

        // Display information for all users
        User.displayAllUsersInfo();
    }
}
