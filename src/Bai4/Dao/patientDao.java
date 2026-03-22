package Bai4.Dao;
import Bai4.entity.patient;
import Bai4.gethospitalconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//'1'='1' → luôn đúng (true)
//Khi có OR:
//điều kiện A OR điều kiện B
//
//→ chỉ cần 1 trong 2 đúng là cả WHERE đúng
public class patientDao {
    public List<patient> Searchpatient(String name){
        List <patient>patients=new ArrayList<>();
        String sql="SELECT * FROM patient WHERE name LIKE '%"+name+"%'";
//        dung like an toan hon
        try(Connection connection=gethospitalconnect.getconnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery()) {
            while (resultSet.next()){
                patient patient=new patient();
                patient.setId(resultSet.getInt("id"));
                patient.setName(resultSet.getString("name"));
                patients.add(patient);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patients;
    }
}
