
//To interact with the database table health_data
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HealthDataDaoImpl  {

    private Connection connection;

    public HealthDataDaoImpl(Connection connection) {
        this.connection = connection;
    }

    
    public void insertHealthData(HealthData healthData) {
        try {
            String sql = "INSERT INTO health_data (user_id, weight, height, steps, heart_rate, date) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, healthData.getUserId());
            preparedStatement.setDouble(2, healthData.getWeight());
            preparedStatement.setDouble(3, healthData.getHeight());
            preparedStatement.setInt(4, healthData.getSteps());
            preparedStatement.setInt(5, healthData.getHeartRate());
            java.sql.Date sqlDate = new java.sql.Date(healthData.getDate().getTime());
            preparedStatement.setDate(6, sqlDate);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public List<HealthData> getHealthData(int userId) {
        List<HealthData> healthDataList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM health_data WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double weight = resultSet.getDouble("weight");
                double height = resultSet.getDouble("height");
                int steps = resultSet.getInt("steps");
                int heartRate = resultSet.getInt("heart_rate");
                Date date = resultSet.getDate("date");
                HealthData healthData = new HealthData(id, userId, weight, height, steps, heartRate, date);
                healthDataList.add(healthData);
                System.out.println(id);
                System.out.println(weight);
                System.out.println(height);
                System.out.println(steps);
                System.out.println(heartRate);
                System.out.println(date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return healthDataList;
    }
}
