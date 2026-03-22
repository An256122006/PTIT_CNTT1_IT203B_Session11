create database MedicalAppointmentDB;
use MedicalAppointmentDB;
create table appointments (
    id int primary key auto_increment,
    patient_name varchar(255),
    appointment_date date,
    doctor_name varchar(255),
    status varchar(255)
)