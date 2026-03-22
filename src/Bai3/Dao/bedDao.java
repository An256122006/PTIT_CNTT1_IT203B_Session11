package Bai3.Dao;
import Bai3.entity.bed;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Bai3.gethopitalconn;
public class bedDao {
    public List<bed> getbeds(){
        List<bed>beds=new ArrayList<>();
        String sql="SELECT * FROM bed";
        try(Connection connection=gethopitalconn.getconnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery()) {
            while (resultSet.next()){
                bed bed=new bed();
                bed.setId(resultSet.getInt("id"));
                bed.setBed_status(resultSet.getBoolean("bed_status"));
                beds.add(bed);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return beds;
    }
    public boolean Updatebed(bed bed){
        boolean bl=false;
        String sql="UPDATE bed SET bed_status = " +bed.isBed_status() +" WHERE id = "+bed.getId();
        try(Connection connection=gethopitalconn.getconnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            int i=preparedStatement.executeUpdate(sql);
            if(i>0){
                bl=true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bl;

    }
}
