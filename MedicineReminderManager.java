
//MedicineReminderManager
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineReminderManager {
    private Connection connection;

    public MedicineReminderManager(Connection connection) {
        this.connection = connection;
    }

    public List<MedicineReminder> getRemindersForUser(int userId) {
        List<MedicineReminder> userReminders = new ArrayList<>();
        try {
            String sql = "SELECT * FROM medicine_reminders WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String medicineName = resultSet.getString("medicine_name");
                String dosage = resultSet.getString("dosage");
                String schedule = resultSet.getString("schedule");
                java.sql.Date startDate = resultSet.getDate("start_date");
                java.sql.Date endDate = resultSet.getDate("end_date");
                userReminders.add(new MedicineReminder(id, userId, medicineName, dosage, schedule, startDate, endDate));
                System.out.println(medicineName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userReminders;
    }

    public void displayAllReminders() {
        try {
            String sql = "SELECT * FROM medicine_reminders";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("Medicine Reminders:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int userId = resultSet.getInt("user_id");
                String medicineName = resultSet.getString("medicine_name");
                String dosage = resultSet.getString("dosage");
                String schedule = resultSet.getString("schedule");
                java.sql.Date startDate =  resultSet.getDate("start_date");
                java.sql.Date endDate =  resultSet.getDate("end_date");
                System.out.println("ID: " + id);
                System.out.println("User ID: " + userId);
                System.out.println("Medicine Name: " + medicineName);
                System.out.println("Dosage: " + dosage);
                System.out.println("Schedule: " + schedule);
                System.out.println("Start Date: " + startDate);
                System.out.println("End Date: " + endDate);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
