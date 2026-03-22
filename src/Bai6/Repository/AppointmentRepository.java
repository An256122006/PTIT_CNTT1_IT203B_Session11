package Bai6.Repository;

import Bai6.entity.Appointment;
import Bai6.Connect.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {
    public List<Appointment> getAllAppointments() {
        String sql = "select * from appointments";
        List<Appointment> appointments = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.setId(resultSet.getInt("id"));
                appointment.setPatient_name(resultSet.getString("patient_name"));
                appointment.setDoctor_name(resultSet.getString("doctor_name"));
                appointment.setAppointment_date(resultSet.getString("appointment_date"));
                appointment.setStatus(resultSet.getString("status"));
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return appointments;
    }

    public boolean updateAppointment(Appointment appointment) {
        boolean bl = false;
        String sql = "UPDATE appointments SET patient_name=?, doctor_name=?, appointment_date=?, status=? WHERE id=?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, appointment.getPatient_name());
            ps.setString(2, appointment.getDoctor_name());
            ps.setString(3, appointment.getAppointment_date());
            ps.setString(4, appointment.getStatus());
            ps.setInt(5, appointment.getId());

            bl = ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bl;
    }
    public void addAppointment(Appointment appointment){
        String sql = "insert into appointments(patient_name,doctor_name,appointment_date,status) values(?,?,?,?)";
        try(Connection connection=DatabaseConnection.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(sql)) {
            preparedStatement.setString(1,appointment.getPatient_name());
            preparedStatement.setString(2,appointment.getDoctor_name());
            preparedStatement.setString(3,appointment.getAppointment_date());
            preparedStatement.setString(4,appointment.getStatus());
            preparedStatement.executeUpdate();
            System.out.println("them thanh cong");
        } catch (SQLException e) {
            System.out.println("them that bai");
            throw new RuntimeException(e);
        }
    }
    public boolean deleteAppointment(int id){
        boolean bl = false;
        String sql = "delete from appointments where id=" + id;
        try (Connection connection=DatabaseConnection.getConnection();
             PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            if(preparedStatement.executeUpdate()>0){
                bl=true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         return bl;
    }
    public void getAppointmentById(int id){
        String sql = "select * from appointments where id="+id;
        List<Appointment> appointments = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Appointment appointment = new Appointment();
                appointment.setId(resultSet.getInt("id"));
                appointment.setPatient_name(resultSet.getString("patient_name"));
                appointment.setDoctor_name(resultSet.getString("doctor_name"));
                appointment.setAppointment_date(resultSet.getString("appointment_date"));
                appointment.setStatus(resultSet.getString("status"));
                System.out.println(appointment);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
