package datos;

import entidades.*;
import java.util.*;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author deerfox@debian
 */
public class SucursalDAL {

    private static Connection cn = null;
    private static PreparedStatement ps = null;
    private static Statement st = null;
    private static ResultSet rs = null;

    public static String insertarSucursal(Sucursal sucursal) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "INSERT INTO sucursal VALUES(?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, sucursal.getCodigo());
            ps.setString(2, sucursal.getNombre());
            ps.setString(3, sucursal.getCiudad());
            ps.setString(4, sucursal.getDireccion());
            ps.setString(5, Integer.toString(sucursal.getContcuenta()));
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

    public static Sucursal buscarSucursal(String codigo) {
        try {
            cn = Conexion.realizarConexion();
            String sql = "SELECT * FROM sucursal WHERE sucucodigo = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Sucursal(rs.getString("sucucodigo"),
                        rs.getString("sucunombre"),
                        rs.getString("sucuciudad"),
                        rs.getString("sucudireccion"),
                        rs.getInt("sucucontcuenta"),
                        0
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

    public static ArrayList<Sucursal> listarSucursal() {
        ArrayList<Sucursal> sucursals = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            st = cn.createStatement();
            String sql = "SELECT sucursal.*, empleado.sucucodigo, COUNT(empleado.sucucodigo)"
                    + " AS sucuempl FROM sucursal LEFT JOIN empleado"
                    + " ON sucursal.sucucodigo = empleado.sucucodigo GROUP BY sucursal.sucucodigo;";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                sucursals.add(new Sucursal(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(7)));
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
        return sucursals;
    }

    public static String actualizarSucursal(Sucursal sucursal) {
        String mensaje = null;
        try {
            cn = Conexion.realizarConexion();
            String sql = "UPDATE sucursal SET sucunombre = ?, "
                    + "sucuciudad = ?,  sucudireccion = ? "
                    + "WHERE sucucodigo = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, sucursal.getNombre());
            ps.setString(2, sucursal.getCiudad());
            ps.setString(3, sucursal.getDireccion());
            ps.setString(4, sucursal.getCodigo());
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

    public static ArrayList<Sucursal> obtenerSucursal(String codigo) {
        ArrayList<Sucursal> sucursal = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            String sql = "SELECT * FROM sucursal WHERE sucucodigo = ?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, codigo);
            rs = ps.executeQuery();
            while (rs.next()) {
                sucursal.add(new Sucursal(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(7)));
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
        return sucursal;
    }
    
    public static ArrayList<String> obtenerSucucodigos() {
        ArrayList<String> sucucodigos = new ArrayList<>();
        try {
            cn = Conexion.realizarConexion();
            String sql = "SELECT sucucodigo FROM sucursal";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                sucucodigos.add(rs.getString(1));
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
        return sucucodigos;
    }
}
