package Bai6.presentation;
import Bai6.entity.Appointment;
import Bai6.Repository.AppointmentRepository;

import java.util.List;

public class main {
    public static void main(String[] args) {
        AppointmentRepository appointmentRepository = new AppointmentRepository();
        appointmentRepository.addAppointment(new Appointment(1,"Tran Thi B","Le Van C","2023-01-01","checkin"));
        appointmentRepository.addAppointment(new Appointment(2,"Tran Thi q","Le Van C","2023-01-01","checkin"));
        appointmentRepository.addAppointment(new Appointment(3,"Tran Thi k","Le Van C","2023-01-01","checkin"));
        appointmentRepository.addAppointment(new Appointment(4,"Tran Thi y","Le Van C","2023-01-01","checkin"));
        appointmentRepository.addAppointment(new Appointment(5,"Tran Thi M","Le Van C","2023-01-01","checkin"));
        List<Appointment> appointments = appointmentRepository.getAllAppointments();
        for (Appointment appointment:appointments){
            System.out.println(appointment);
        }
        appointmentRepository.getAppointmentById(1);
        appointmentRepository.deleteAppointment(1);
        appointmentRepository.getAllAppointments();
        appointmentRepository.updateAppointment(new Appointment(2,"Tran Thi Q","Le Van B","2023-01-01","checkin"));
        appointments = appointmentRepository.getAllAppointments();
        for (Appointment appointment:appointments){
            System.out.println(appointment);
        }
    }
}
