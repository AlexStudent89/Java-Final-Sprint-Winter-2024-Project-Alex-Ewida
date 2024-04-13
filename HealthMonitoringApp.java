
//HealthMonitoringApp
import java.sql.Connection;
import java.util.List;

public class HealthMonitoringApp {
    public static void main(String[] args) {
        // Establish database connection
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();

        // Fetch and display health data
        HealthDataDaoImpl healthDataDaoImpl = new HealthDataDaoImpl(connection);
        for (int i = 1; i <= 20; i++) {
            healthDataDaoImpl.getHealthData(i);
        }

        MedicineReminderManager medicineReminderManager = new MedicineReminderManager(DatabaseConnection.getConnection());
        medicineReminderManager.displayAllReminders();

        
    //     // Fetch and display medicine reminders
    //     MedicineReminderManager medicineReminderManager = new MedicineReminderManager(connection);
    //     for (int i = 1; i <= 20; i++) {
    //         List<MedicineReminder> reminders = medicineReminderManager.getRemindersForUser(i);
    //         System.out.println("Medicine Reminders for User " + i + ":");
    //         for (MedicineReminder reminder : reminders) {
    //             System.out.println("Medicine Name: " + reminder.getMedicine_name());
    //             System.out.println("Dosage: " + reminder.getDosage());
    //             System.out.println("Schedule: " + reminder.getSchedule());
    //             System.out.println("Start Date: " + reminder.getStart_date());
    //             System.out.println("End Date: " + reminder.getEnd_date());
    //             System.out.println();
    //         }
    //     }

    //     // Close database connection
    //     databaseConnection.closeConnection(connection);
    // }
        // Fetch and display medicine data
        
}
}

