package Bai2;

import java.sql.*;
import java.util.List;

import Bai2.entity.medicine;
import Bai2.Dao.MedicineDao;
public class gethopitalconn {
    static final String url="jdbc:mysql://localhost:3306/hospital";
    static final String user="root";
    static final String password="123456789";
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if(connection!=null){
            System.out.println("ket noi thanh cong");
        }else {
            System.out.println("ket noi that bai");
        }
        MedicineDao medicineDao= new MedicineDao();
        List<medicine> medicines=medicineDao.getmedicines();
        for(medicine medicine:medicines){
            System.out.println(medicine);
        }

    }
    public static void close(Connection connection, Statement stm, ResultSet rs){
        if(connection!= null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(stm!=null){
            try {
                stm.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
