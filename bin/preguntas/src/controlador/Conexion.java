package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private Connection conexion;
    private static Conexion instancia = new Conexion();

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String db = "jdbc:mysql://localhost/preguntas";

            conexion = DriverManager.getConnection(db, "root", "admin");
        } catch (Exception ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Conexion getInstancia() {
        return instancia;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return conexion.prepareStatement(sql);
    }

    public Statement createStatement() throws SQLException {
        return conexion.createStatement();
    }

}
