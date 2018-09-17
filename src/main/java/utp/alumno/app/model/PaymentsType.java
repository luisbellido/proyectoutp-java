package utp.alumno.app.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentsType {

    private int id;
    private String name;

    public String getIdAsString()
    {
        return String.valueOf(getId());
    }

    public String getNameAsValue() {
        return "'" + getName() + "'";
    }


    /*public static PaymentsType build(ResultSet rs) {
        try {
            return (new PaymentsType())
                    .setId(rs.getInt("id"))
                    .setName(rs.getString("payment_type_name"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/
    
}
