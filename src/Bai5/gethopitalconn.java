package Bai5;

import java.sql.*;
import java.util.List;

import Bai5.entity.doctor;
import Bai5.Dao.doctorDao;
public class gethopitalconn {
    final static String url="jdbc:mysql://localhost:3306/hospital";
    final static String user="root";
    final static String password="123456789";
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("ket noi thanh cong");
            return connection;
        } catch (Exception e) {
            System.out.println("ket noi that bai");
            return null;
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("ket noi thanh cong");
        }else{
            System.out.println("ket noi that bai");
        }
        doctorDao doctorDao = new doctorDao();
        List<doctor> doctors = doctorDao.getdoctors();
        for (doctor doctor : doctors) {
            System.out.println(doctor);
        }
        boolean insert=doctorDao.insertDoctor(new doctor(100,"Nguyen Van A","Cardiology"));
        if(insert){
            System.out.println("Insert thanh cong");
        }else{
            System.out.println("Insert that bai");
        }
        doctorDao thongke= new doctorDao();
        thongke.thongke();

    }
    public static void closeAll(Connection connection, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
