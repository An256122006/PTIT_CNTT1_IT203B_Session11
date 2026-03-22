package Bai6.entity;

public class Appointment {
    private int id;
    private String patient_name;
    private String doctor_name;
    private String appointment_date;
    private String status;
    public Appointment(){

    }

    public Appointment(int id, String patient_name, String doctor_name, String appointment_date, String status) {
        this.id = id;
        this.patient_name = patient_name;
        this.doctor_name = doctor_name;
        this.appointment_date = appointment_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patient_name='" + patient_name + '\'' +
                ", doctor_name='" + doctor_name + '\'' +
                ", appointment_date='" + appointment_date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
