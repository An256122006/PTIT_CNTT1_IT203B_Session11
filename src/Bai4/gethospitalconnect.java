package Bai4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import Bai4.Dao.patientDao;
import Bai4.entity.patient;
public class gethospitalconnect {
    static final String url="jdbc:mysql://localhost:3306/hospital";
    static final String user="root";
    static final String password="123456789";
    public static Connection getconnection(){
        try {
            Connection connection= DriverManager.getConnection(url,user,password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Connection connection =getconnection();
        if(connection!=null){
            System.out.println("ket noi thanh cong");
        }else{
            System.out.println("ket noi that bai");
        }
        patientDao patientDao=new patientDao();
        List<patient> patients=patientDao.Searchpatient("%van%");
        for(patient patient:patients){
            System.out.println(patient);
        }
    }
}
