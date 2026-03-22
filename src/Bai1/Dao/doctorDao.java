package Bai1.Dao;
import Bai1.entity.doctor;
import Bai1.gethopitalconn;

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
        }finally {
            gethopitalconn.closeAll(null, null, null);
        }
        return doctors;
    }

}
