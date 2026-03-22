package Bai5.Dao;
import Bai5.entity.doctor;
import Bai5.gethopitalconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class doctorDao {
    public List<doctor> getdoctors(){
        List<doctor> doctors = new ArrayList<>();
        String sql="select *from doctor";
        try(Connection connection = gethopitalconn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery()) {
            while (resultSet.next()){
                doctor doctor=new doctor();
                doctor.setId(resultSet.getInt("id"));
                doctor.setName(resultSet.getString("name"));
                doctor.setSpeciality(resultSet.getString("specialty"));
                doctors.add(doctor);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return doctors;
    }
    public boolean insertDoctor(doctor doctor){
        boolean bl=false;
        String sql="insert into doctor(name,specialty) values(?,?)";
        try (Connection connection = gethopitalconn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,doctor.getName());
            preparedStatement.setString(2,doctor.getSpeciality());
            bl=preparedStatement.executeUpdate()>0;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return bl;
    }
    public void thongke(){
        String sql="select specialty ,count(*) as count from doctor group by specialty";
        try (Connection connection = gethopitalconn.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet=preparedStatement.executeQuery()){
             while (resultSet.next()){
                 int total=resultSet.getInt("count");
                 String speciality=resultSet.getString("specialty");
                 System.out.println("Speciality: " + speciality + ", Total: " + total);
             }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
