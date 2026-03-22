package Bai3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import Bai3.Dao.bedDao;
import Bai3.entity.bed;
public class gethopitalconn {
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
        Connection connection=getconnection();
        if(connection!=null){
            System.out.println("ket noi thanh cong");
        }else{
            System.out.println("ket noi that bai");
        }
        bedDao bedDao=new bedDao();
        List<bed>beds=bedDao.getbeds();
        for(bed bed:beds){
            System.out.println(bed);
        }
        boolean update=bedDao.Updatebed(new bed(1,false));
        if(update){
            System.out.println("cap nhat thanh cong");
        }else{
            System.out.println("cap nhat that bai");
        }

    }
}
