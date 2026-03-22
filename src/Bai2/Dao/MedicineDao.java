package Bai2.Dao;
import Bai2.entity.medicine;
import Bai2.gethopitalconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicineDao {
    public List<medicine> getmedicines(){
        List<medicine> medicines=new ArrayList<>();
        String sql="SELECT * FROM medicine";
        try(Connection connection=gethopitalconn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()){
                medicine medicine=new medicine();
                medicine.setId(resultSet.getInt("id"));
                medicine.setMedicine_name(resultSet.getString("medicine_name"));
                medicine.setStock(resultSet.getInt("stock"));
                medicines.add(medicine);
            }
            return medicines;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            gethopitalconn.close(null, null, null);
        }
    }

}
