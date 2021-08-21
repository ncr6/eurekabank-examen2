package datos;

import entidades.*;
import java.util.*;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author deerfox@debian
 */
public class EmpleadoDAL {

    private static Connection cn = null;
    private static PreparedStatement ps = null;
    private static Statement st = null;
    private static ResultSet rs = null;

    public static String insertarEmpleado(Empleado empleado) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "INSERT INTO empleado VALUES(?,?,?,?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, empleado.getCodigo());
            ps.setString(2, empleado.getPaterno());
            ps.setString(3, empleado.getMaterno());
            ps.setString(4, empleado.getNombre());
            ps.setString(6, empleado.getCiudad());
            ps.setString(7, empleado.getDireccion());
            ps.setString(8, empleado.getUsuario());
            ps.setString(9, empleado.getClave());
            ps.setString(10, empleado.getSucucodigo());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            mensaje = ex.getMessage();
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                mensaje = ex.getMessage();
            }
        }
        return mensaje;
    }

    public static Empleado buscarEmpleado(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            String sql = "SELECT * FROM empleado WHERE emplcodigo = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Empleado(rs.getString("emplcodigo"),
                        rs.getString("emplpaterno"),
                        rs.getString("emplmaterno"),
                        rs.getString("emplnombre"),
                        rs.getString("emplciudad"),
                        rs.getString("empldireccion"),
                        rs.getString("emplusuario"),
                        rs.getString("emplclave"),
                        rs.getString("sucucodigo")
                );
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            try {
                rs.close();
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
        return null;
    }

    public static ArrayList<Empleado> listarEmpleado() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "SELECT * FROM empleado";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                empleados.add(new Empleado(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9)));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            try {
                rs.close();
                st.close();
                cn.close();
            } catch (SQLException ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
        return empleados;
    }

    public static String actualizarEmpleado(Empleado empleado) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "UPDATE empleado SET emplpaterno = ?, "
                    + "emplmaterno = ?,  emplnombre = ?, "
                    + "emplciudad = ?, emplusuario = ?, emplclave = ?, "
                    + "sucucodigo = ? WHERE emplcodigo = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, empleado.getPaterno());
            ps.setString(2, empleado.getMaterno());
            ps.setString(3, empleado.getNombre());
            ps.setString(4, empleado.getCiudad());
            ps.setString(5, empleado.getUsuario());
            ps.setString(6, empleado.getClave());
            ps.setString(7, empleado.getSucucodigo());
            ps.setString(8, empleado.getCodigo());            
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            mensaje = ex.getMessage();
        } finally {
            try {
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                mensaje = ex.getMessage();
            }
        }
        return mensaje;
    }

    public static ArrayList<Empleado> obtenerEmpleado(String codigo) {
        ArrayList<Empleado> empleado = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            String sql = "SELECT * FROM empleado WHERE emplcodigo = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleado.add(new Empleado(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8),
                        rs.getString(9)));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(), "Error", 0);
        } finally {
            try {
                rs.close();
                ps.close();
                cn.close();
            } catch (SQLException ex) {
                showMessageDialog(null, ex.getMessage(), "Error", 0);
            }
        }
        return empleado;
    }
}
