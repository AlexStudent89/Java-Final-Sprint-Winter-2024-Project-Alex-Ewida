
//MedicineReminder
import java.time.LocalDateTime;

public class MedicineReminder {
    private int reminderId;
    private int user_id;
    private String medicine_name;
    private String dosage;
    private String schedule;
    private Date start_date;
    private Date end_date;

    public MedicineReminder(int reminderId, int user_id, String medicine_name, String dosage, String schedule, Date startDate, Date endDate) {
        this.reminderId = reminderId;
        this.user_id = user_id;
        this.medicine_name = medicine_name;
        this.dosage = dosage;
        this.schedule = schedule;
        this.start_date = startDate;
        this.end_date = endDate;
    }

    public MedicineReminder(int id, int userId, String medicineName, String dosage2, String schedule2,
            java.sql.Date startDate, java.sql.Date endDate) {
        //TODO Auto-generated constructor stub
    }

    public int getReminderId() {
        return reminderId;
    }

    public void setReminderId(int reminderId) {
        this.reminderId = reminderId;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
