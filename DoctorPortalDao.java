
//DoctorPortalDao
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorPortalDao {
    private Connection connection;

    public DoctorPortalDao(Connection connection) {
        this.connection = connection;
    }

    public List<User> getPatientsForDoctor(int doctorId) throws SQLException {
        List<User> patients = new ArrayList<>();
        String doctorQuery = "SELECT * FROM users WHERE id = ?";
        String patientQuery = "SELECT u.id, u.first_name, u.last_name, u.email, u.password, u.is_doctor " +
                              "FROM users u " +
                              "INNER JOIN doctor_patient dp ON u.id = dp.patient_id " +
                              "WHERE dp.doctor_id = ?";
        PreparedStatement doctorStatement = null;
        PreparedStatement patientStatement = null;
        ResultSet doctorResultSet = null;
        ResultSet patientResultSet = null;
        try {
            // Retrieve doctor information
            doctorStatement = connection.prepareStatement(doctorQuery);
            doctorStatement.setInt(1, doctorId);
            doctorResultSet = doctorStatement.executeQuery();
            while (doctorResultSet.next()) {
                int id = doctorResultSet.getInt("id");
                String firstName = doctorResultSet.getString("first_name");
                String lastName = doctorResultSet.getString("last_name");
                String email = doctorResultSet.getString("email");
                String password = doctorResultSet.getString("password");
                boolean isDoctor = doctorResultSet.getBoolean("is_doctor");
                User doctor = new User(id, firstName, lastName, email, password, isDoctor);
                patients.add(doctor);
            }
    
            // Retrieve all patients associated with the doctor
            patientStatement = connection.prepareStatement(patientQuery);
            patientStatement.setInt(1, doctorId);
            patientResultSet = patientStatement.executeQuery();
            while (patientResultSet.next()) {
                int id = patientResultSet.getInt("id");
                String firstName = patientResultSet.getString("first_name");
                String lastName = patientResultSet.getString("last_name");
                String email = patientResultSet.getString("email");
                String password = patientResultSet.getString("password");
                boolean isDoctor = patientResultSet.getBoolean("is_doctor");
                User patient = new User(id, firstName, lastName, email, password, isDoctor);
                patients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (doctorResultSet != null) {
                    doctorResultSet.close();
                }
                if (doctorStatement != null) {
                    doctorStatement.close();
                }
                if (patientResultSet != null) {
                    patientResultSet.close();
                }
                if (patientStatement != null) {
                    patientStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return patients;
    }

    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            DoctorPortalDao doctorPortalDao = new DoctorPortalDao(connection);
            int doctorId = 1; // Replace with the actual doctor's ID
            List<User> patients = doctorPortalDao.getPatientsForDoctor(doctorId);
            for (User patient : patients) {
                System.out.println("Patient ID: " + patient.getId());
                System.out.println("Name: " + patient.getFirstName() + " " + patient.getLastName());
                System.out.println("Email: " + patient.getEmail());
                System.out.println();
            }
            DatabaseConnection.closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

