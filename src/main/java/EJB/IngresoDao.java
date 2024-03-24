package EJB;

import Model.Inventarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IngresoDao {
    public List<Inventarios> listar() throws SQLException, ClassNotFoundException {
        List<Inventarios> lista = null;
        Connection cn = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // Cambiado a "com.mysql.cj.jdbc.Driver" para versiones más recientes de MySQL
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/owlsys", "July", "1234");
            PreparedStatement st = cn.prepareStatement("SELECT Id_inventarios, Fecha_registro, Cantidad FROM inventarios");
            rs = st.executeQuery();
            lista = new ArrayList();

            while (rs.next()) {
                Inventarios pro = new Inventarios();
                pro.setIdinventarios(rs.getInt("Id_inventarios"));  // Cambiado a "Id_inventarios"
                pro.setFecharegistro(rs.getDate("Fecha_registro"));  // Cambiado a "Fecha_registro"
                pro.setCantidad(rs.getShort("Cantidad")); 
                lista.add(pro);
            }

        } catch (Exception e) {
            e.printStackTrace(); 
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cn != null) {
                cn.close();
            }
        }

        return lista;
    }
}